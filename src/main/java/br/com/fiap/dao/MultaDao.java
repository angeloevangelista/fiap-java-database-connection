package br.com.fiap.dao;

import br.com.fiap.exception.NotFoundException;
import br.com.fiap.exception.ValidationException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.CarroModel;
import br.com.fiap.model.MultaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MultaDao {
    private final Connection connection;

    public MultaDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public void create(MultaModel multaModel) throws SQLException, ValidationException {
        PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO MULTAS (id, id_carro, data, valor, descricao, paga) VALUES (SEQ_MULTAS.nextval, ?, ?, ?, ?, ?)"
        );

        if (multaModel.getCarroModel() == null) {
            throw new ValidationException("A multa precisa estar vinculada a um carro");
        }

        preparedStatement.setInt(1, multaModel.getCarroModel().getId());
        preparedStatement.setTimestamp(2, Timestamp.from(multaModel.getData()));
        preparedStatement.setInt(3, multaModel.getValor());
        preparedStatement.setString(4, multaModel.getDescricao());
        preparedStatement.setString(5, multaModel.getPaga());

        preparedStatement.executeUpdate();
    }

    public List<MultaModel> list(CarroModel carroModel) throws SQLException {
        List<MultaModel> multaModels = new ArrayList<MultaModel>();

        PreparedStatement statement = this.connection.prepareStatement(
            "SELECT * FROM MULTAS WHERE ID_CARRO = ?"
        );

        statement.setInt(1, carroModel.getId());

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            MultaModel multaModel = new MultaModel(
                resultSet.getString("descricao"),
                resultSet.getInt("valor"),
                    resultSet.getTimestamp("data").toInstant(),
                resultSet.getString("paga")
            );

            multaModels.add(multaModel);
        }

        return multaModels;
    }
}
