package br.com.fiap.dao;

import br.com.fiap.exception.NotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.CarroModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {
    private final Connection connection;

    public CarroDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public void create(CarroModel carroModel) throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO CARROS (id, placa, modelo, fabricante, cor) VALUES ( SEQ_CARROS.nextval, ?, ?, ?, ?)"
        );

        preparedStatement.setString(1, carroModel.getPlaca());
        preparedStatement.setString(2, carroModel.getModelo());
        preparedStatement.setString(3, carroModel.getFabricante());
        preparedStatement.setString(4, carroModel.getCor());

        preparedStatement.executeUpdate();
    }

    public List<CarroModel> list() throws SQLException {
        List<CarroModel> carroModels = new ArrayList<CarroModel>();

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM CARROS");

        while (resultSet.next()) {
            CarroModel carroModel = new CarroModel(
                resultSet.getString("placa"),
                resultSet.getString("modelo"),
                resultSet.getString("fabricante"),
                resultSet.getString("cor")
            );

            carroModels.add(carroModel);
        }

        return carroModels;
    }

    public CarroModel getByPlaca(String placa) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
            "SELECT * FROM CARROS WHERE placa = ?"
        );

        statement.setString(1, placa);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            CarroModel carro = new CarroModel();

            carro.setPlaca(resultSet.getString("placa"));
            carro.setModelo(resultSet.getString("modelo"));
            carro.setFabricante(resultSet.getString("fabricante"));
            carro.setCor(resultSet.getString("cor"));

            return carro;
        }

        return null;
    }

    public void delete(String placa) throws java.sql.SQLException, NotFoundException {
        PreparedStatement stm = this.connection.prepareStatement("DELETE FROM CARROS WHERE placa = ?");

        stm.setString(1, placa);

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new NotFoundException("Carro não encontrado para ser deletado!");
        }
    }

    public void update(CarroModel carroModel) throws SQLException, NotFoundException {
        PreparedStatement stm = this.connection.prepareStatement(
            "UPDATE CARROS SET modelo = ?, fabricante = ?,cor = ? WHERE placa = ?"
        );

        stm.setString(1, carroModel.getModelo());
        stm.setString(2, carroModel.getFabricante());
        stm.setString(3, carroModel.getCor());

        stm.setString(4, carroModel.getPlaca());

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new NotFoundException("Carro não encontrado para ser deletado!");
        }
    }
}
