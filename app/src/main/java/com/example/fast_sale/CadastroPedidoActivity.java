package com.example.fast_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.fast_sale.model.Cliente;

import java.util.ArrayList;

public class CadastroPedidoActivity extends AppCompatActivity {

    private ArrayList<Cliente> listaClientes;
    private Spinner spClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        spClientes = findViewById(R.id.spClientes);
        getClientes();
    }

    private void getClientes() {
        listaClientes = DataManagerSingleton.getInstance().getListaClientes();
        String[]vetClientes = new String[listaClientes.size() + 1];
        vetClientes[0] = "Selecione o cliente";
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetClientes[i+1] = cliente.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                CadastroPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetClientes);

        spClientes.setAdapter(adapter);
    }
}