package br.com.fiap.view;

import br.com.fiap.dao.CarroDao;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.model.CarroModel;

import java.sql.SQLException;

public class UpdateCarView {
    public static void main(String[] args) {
        CarroModel car= new CarroModel("JZN0239", "A3", "Audi", "preto");
        try {
            CarroDao dao = new CarroDao();

            System.out.println("Atualizando carro...");
            dao.update(car);
            System.out.println("Carro atualizado com sucesso.");
        }  catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (NotFoundException e) {
            System.out.println("Carro não encontrado.");
        }
    }
}
