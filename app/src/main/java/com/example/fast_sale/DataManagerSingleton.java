package com.example.fast_sale;

import com.example.fast_sale.model.Cliente;
import com.example.fast_sale.model.Produto;

import java.util.ArrayList;

public class DataManagerSingleton {

    private static DataManagerSingleton instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;

    public static DataManagerSingleton getInstance() {
        if (instancia == null) {
            return instancia = new DataManagerSingleton();
        }
        return instancia;
    }

    private DataManagerSingleton() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> getListaProdutos() { return listaProdutos; }
}
