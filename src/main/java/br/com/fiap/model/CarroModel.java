package br.com.fiap.model;

public class CarroModel {
    private String placa;
    private String modelo;
    private String fabricante;
    private String cor;

    public CarroModel() {}

    public CarroModel(String placa, String modelo, String fabricante, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
