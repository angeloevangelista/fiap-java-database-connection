package br.com.fiap.model;

import java.time.Instant;

public class MultaModel {
    private java.time.Instant data;
    private int valor;
    private String descricao;
    private String paga;
    private CarroModel carroModel;

    public MultaModel() {

    }

    public MultaModel(String descricao, int valor, Instant data, String paga) {
        this.paga = paga;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public MultaModel(String descricao, int valor, Instant data, String paga, CarroModel carroModel) {
        this.paga = paga;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.carroModel = carroModel;
    }

    public CarroModel getCarroModel() {
        return this.carroModel;
    }

    public void setCarroModel(CarroModel carroModel) {
        this.carroModel = carroModel;
    }

    public String getPaga() {
        return paga;
    }

    public void setPaga(String paga) {
        this.paga = paga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public void exibirMulta() {
        System.out.println("Data: " + this.getData());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Descricao: " + this.getDescricao());
        System.out.println("Está paga? " + this.getPaga());
    }
}
