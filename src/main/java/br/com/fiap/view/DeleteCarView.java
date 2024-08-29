package br.com.fiap.view;

import br.com.fiap.dao.CarroDao;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.model.CarroModel;

import java.sql.SQLException;

public class DeleteCarView {
    public static void main(String[] args) {
        CarroModel car = new CarroModel("JZN0239", "c7", "Citroen", "branco");

        try {
            System.out.println("Removendo carro...");

            CarroDao dao = new CarroDao();
            dao.delete(car.getPlaca());

            System.out.println("Carro removido com sucesso.");
        } catch (SQLException | NotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
