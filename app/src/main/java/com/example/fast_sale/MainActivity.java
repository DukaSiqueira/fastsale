package com.example.fast_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrarCliente, btCadastrarProduto, btCadastarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarCliente = findViewById(R.id.btCadastarCliente);
        btCadastrarProduto = findViewById(R.id.btCadastarProduto);
        btCadastarPedido = findViewById(R.id.btCadastarPedido);

        btCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirCadastroCliente(); }
        });
        btCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirCadastroProduto(); }
        });
        btCadastarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirCadastroPedido(); }
        });
    }

    private void abrirCadastroCliente() {
        Intent intent = new Intent(this, CadastroClienteActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroProduto() {
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroPedido() {
        Intent intent = new Intent(this, CadastroPedidoActivity.class);
        startActivity(intent);
    }
}