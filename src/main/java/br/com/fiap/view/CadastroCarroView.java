package br.com.fiap.view;

import br.com.fiap.dao.CarroDao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.CarroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CadastroCarroView {
    public static void main(String[] args) {
        //        CarroModel carro = new CarroModel(
        //                "JZN0239",
        //                "c7",
        //                "Citroen",
        //                "branco"
        //        );

        try {
            CarroDao carroDao = new CarroDao();

            List<CarroModel> carros = carroDao.list();

            for (CarroModel carroModel:carros) {
                System.out.println(carroModel.getModelo());
            }

            carroDao.closeConnection();
        } catch (SQLException e) {
            System.out.printf("Database error: %s\n", e.getMessage());
        }
    }
}
