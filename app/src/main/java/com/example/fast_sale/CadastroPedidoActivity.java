package com.example.fast_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.fast_sale.model.Cliente;
import com.example.fast_sale.model.Produto;

import java.util.ArrayList;

public class CadastroPedidoActivity extends AppCompatActivity {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;
    private AutoCompleteTextView acProdutos, acClientes;
    private ImageButton btAddProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        acClientes = findViewById(R.id.acClientes);
        acProdutos = findViewById(R.id.acProdutos);
        getClientes();
        getProdutos();
    }

    private void getClientes() {
        listaClientes = DataManagerSingleton.getInstance().getListaClientes();
        String[]vetClientes = new String[listaClientes.size() + 1];
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetClientes[i+1] = cliente.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                CadastroPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetClientes);

        acClientes.setAdapter(adapter);
    }

    private void getProdutos() {
        listaProdutos = DataManagerSingleton.getInstance().getListaProdutos();
        String[]vetProdutos = new String[listaProdutos.size() + 1];
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto prod = listaProdutos.get(i);
            vetProdutos[i+1] = prod.getDescProduto() + " - R$ " + prod.getValorProduto();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                CadastroPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetProdutos);

        acProdutos.setAdapter(adapter);
    }
}