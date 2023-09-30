package com.example.fast_sale.model;

public class Produto {

    private String codProduto;
    private String descProduto;
    private double valorProduto;

    public Produto() { }

    public Produto(String codProduto, String descProduto, double valorProduto) {
        this.codProduto = codProduto;
        this.descProduto = descProduto;
        this.valorProduto = valorProduto;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codProduto='" + codProduto + '\'' +
                ", descProduto='" + descProduto + '\'' +
                ", valorProduto=" + valorProduto +
                '}';
    }
}
