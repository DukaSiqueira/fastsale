package com.example.fast_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fast_sale.model.Produto;

import java.util.ArrayList;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText edCodProduto, edDescProduto, edValorProduto;
    private Button btSalvarProduto;
    private TextView tvListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edCodProduto = findViewById(R.id.edCodProduto);
        edDescProduto = findViewById(R.id.edDescProduto);
        edValorProduto = findViewById(R.id.edValorProduto);
        btSalvarProduto = findViewById(R.id.btSalvarProduto);
        tvListaProdutos = findViewById(R.id.tvListaProdutos);

        btSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { salvarProduto(); }
        });

        atualizarListaProduto();

    }

    private void salvarProduto() {
        if (edCodProduto.getText().toString().isEmpty()) {
            edCodProduto.setError("Informe o código do produto!");
            edCodProduto.requestFocus();
            return;
        }

        if (edDescProduto.getText().toString().isEmpty()) {
            edDescProduto.setError("Informe a descrição do produto!");
            edDescProduto.requestFocus();
            return;
        }

        if (edValorProduto.getText().toString().isEmpty()) {
            edValorProduto.setError("Informe o valor do produto!");
            edValorProduto.requestFocus();
            return;
        }

        Produto produto = new Produto();
        produto.setCodProduto(edCodProduto.getText().toString());
        produto.setDescProduto(edDescProduto.getText().toString());
        produto.setValorProduto(Double.parseDouble(edValorProduto.getText().toString()));

        DataManagerSingleton.getInstance().salvarProduto(produto);

        Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();

        this.finish();

    }

    private void atualizarListaProduto() {
        ArrayList<Produto> lista = DataManagerSingleton.getInstance().getListaProdutos();
        String texto = "";
        for (Produto prod : lista) {
            texto += "cod: " + prod.getCodProduto() + "\n" +
                    "Desc: " + prod.getDescProduto() + "\n" +
                    "Valor UN.: " + prod.getValorProduto() + "\n" +
                    "---------------------------------------------\n";
        }
        tvListaProdutos.setText(texto);
    }
}