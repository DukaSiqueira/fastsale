package com.example.fast_sale;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fast_sale.model.Cliente;

import java.util.ArrayList;

public class CadastroClienteActivity extends AppCompatActivity {

    private Button btSalvarCliente;
    private EditText edNomeCliente, edCPFCliente;
    private TextView tvListaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btSalvarCliente = findViewById(R.id.btSalvarCliente);
        tvListaClientes = findViewById(R.id.tvListaClientes);
        edNomeCliente = findViewById(R.id.edNomeCliente);
        edCPFCliente = findViewById(R.id.edCPFCliente);

        btSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { salvarCliente(); }
        });

        atualizarListaCliente();
    }

    private void salvarCliente() {
        if (edNomeCliente.getText().toString().isEmpty()) {
            edNomeCliente.setError("Informe o nome do cliente!");
            edNomeCliente.requestFocus();
            return;
        }

        if (edCPFCliente.getText().toString().isEmpty()) {
            edCPFCliente.setError("Informe o CPF do cliente!");
            edCPFCliente.requestFocus();
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(edNomeCliente.getText().toString());
        cliente.setCpf(edCPFCliente.getText().toString());

        DataManagerSingleton.getInstance().salvarCliente(cliente);

        Toast.makeText(this, "Cliente salvo com sucesso!", Toast.LENGTH_LONG).show();

        this.finish();
    }

    private void atualizarListaCliente() {
        ArrayList<Cliente> lista = DataManagerSingleton.getInstance().getListaClientes();
        String texto = "";
        for (Cliente cli : lista) {
            texto += "Nome: " + cli.getNome() + "\n" +
                    "CPF: " + cli.getCpf() + "\n" +
                    "---------------------------------------------\n";
        }
        tvListaClientes.setText(texto);
    }
}