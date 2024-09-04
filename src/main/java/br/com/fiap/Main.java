package br.com.fiap;

import br.com.fiap.dao.CarroDao;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.model.CarroModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner myScanner = new Scanner(System.in);

        do {
            System.out.println("1 - Cadastrar novo carro");
            System.out.println("2 - Atualizar um carro");
            System.out.println("3 - Listar carros");
            System.out.println("4 - Excluir um carro");
            System.out.println("5 - Sair");

            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = myScanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCarro(myScanner);
                    break;
                case 2:
                    atualizarCarro(myScanner);
                    break;
                case 3:
                    listarCarros();
                    break;
                case 4:
                    excluirCarro(myScanner);
                    break;
                default:
                    break;
            }
        }
        while (opcao != 5);
    }

    public static void atualizarCarro(Scanner myScanner) {
        try {
            CarroDao carroDao = new CarroDao();
            CarroModel carro = new CarroModel();

            System.out.print("Qual a placa? ");
            carro.setPlaca(myScanner.next());

            carro = carroDao.getByPlaca(carro.getPlaca());

            if (carro == null) {
                System.out.print("Opa! Esse carro não está cadastrado!");
                return;
            }

            System.out.print("Qual a nova cor? ");
            carro.setCor(myScanner.next());

            carroDao.update(carro);
            carroDao.closeConnection();
        } catch (SQLException e) {
            System.out.println("Ooops, erro no banco: " + e.getMessage());
        } catch (NotFoundException e) {
            System.out.println("Opa! O carro não foi encontrado: " + e.getMessage());
        }
    }

    public static void listarCarros() {
        try {
            CarroDao carroDao = new CarroDao();

            List<CarroModel> carros = carroDao.list();

            for (CarroModel carroModel:carros) {
                carroModel.exibirCarro();
                System.out.println();
            }

            carroDao.closeConnection();
        } catch (SQLException e) {
            System.out.printf("Database error: %s\n", e.getMessage());
        }
    }

    public static void excluirCarro(Scanner myScanner) {
        try {
            CarroDao carroDao = new CarroDao();

            System.out.print("Qual a placa? ");
            String placa = myScanner.next();

            carroDao.delete(placa);
            carroDao.closeConnection();
        } catch (SQLException e) {
            System.out.println("Ooops, erro no banco: " + e.getMessage());
        } catch (NotFoundException e) {
            System.out.println("Opa! O carro não foi encontrado: " + e.getMessage());
        }
    }

    public static void cadastrarCarro(Scanner myScanner) {
        try {
            CarroDao carroDao = new CarroDao();
            CarroModel carro = new CarroModel();

            System.out.print("Qual a placa? ");
            carro.setPlaca(myScanner.next());

            CarroModel carroEncontrado = carroDao.getByPlaca(carro.getPlaca());

            if (carroEncontrado != null) {
                System.out.print("Opa! Esse carro já está cadastrado!");
                return;
            }

            System.out.print("Qual o fabricante? ");
            carro.setFabricante(myScanner.next());

            System.out.print("Qual o modelo? ");
            carro.setModelo(myScanner.next());

            System.out.print("Qual a cor? ");
            carro.setCor(myScanner.next());

            carroDao.create(carro);
            carroDao.closeConnection();
        } catch (SQLException e) {
            System.out.println("Ooops, erro no banco: " + e.getMessage());
        }
    }
}