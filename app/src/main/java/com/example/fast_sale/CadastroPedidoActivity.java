package com.example.fast_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fast_sale.model.Cliente;
import com.example.fast_sale.model.Produto;

import java.util.ArrayList;

public class CadastroPedidoActivity extends AppCompatActivity {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;
    private AutoCompleteTextView acClientes;
    private Spinner spProdutos;
    private ImageButton btAddProduto;
    private TextView tvListaProdutos, tvErroProduto;
    private EditText edQuantidadeProduto, edValorProduto;
    private int posicaoSelecionada = 0;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        acClientes = findViewById(R.id.acClientes);
        spProdutos = findViewById(R.id.spProdutos);
        btAddProduto = findViewById(R.id.btAddProduto);
        tvListaProdutos = findViewById(R.id.tvListaProdutos);
        edQuantidadeProduto = findViewById(R.id.edQuantidadeProduto);
        edValorProduto = findViewById(R.id.edValorProduto);
        tvErroProduto = findViewById(R.id.tvErroProduto);
        getClientes();
        getProdutos();

        btAddProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { adicionarProduto(); }
        });

        spProdutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0){
                    posicaoSelecionada = i;
                    tvErroProduto.setVisibility(View.GONE);
                }
                if (l >  0 && listaProdutos.size() > 0) {
                    edValorProduto.setText(Double.toString(listaProdutos.get(i - 1).getValorProduto()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void getClientes() {
        listaClientes = DataManagerSingleton.getInstance().getListaClientes();
        String[]vetClientes = new String[listaClientes.size() + 1];
        vetClientes[0] = "Selecione o produto";
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
        vetProdutos[0] = "Selecione o produto";
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto prod = listaProdutos.get(i);
            vetProdutos[i+1] = prod.getDescProduto();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                CadastroPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetProdutos);

        spProdutos.setAdapter(adapter);
    }

    private void adicionarProduto() {

        if (posicaoSelecionada <=0) {
            tvErroProduto.setVisibility(View.VISIBLE);
            return;
        }

        if (edQuantidadeProduto.getText().toString().isEmpty()) {
            edQuantidadeProduto.setError("Quantidade do produto deve ser informada!");
            edQuantidadeProduto.requestFocus();
            return;
        }

        if (edValorProduto.getText().toString().isEmpty()) {
            edValorProduto.setError("Valor do produto deve ser informado!");
            edValorProduto.requestFocus();
            return;
        }

        Produto produto = listaProdutos.get(posicaoSelecionada-1);
        texto += "Produto: " + produto.getDescProduto() + "\n" +
                "Valor Un: " + "R$ "+ produto.getValorProduto() + "\n" +
                "Quantidade: " + edQuantidadeProduto.getText().toString() + "\n" +
                "_____________________________________\n";

        tvListaProdutos.setText(texto);
        spProdutos.setSelection(0);
        posicaoSelecionada = 0;
        edQuantidadeProduto.setText("");
        edValorProduto.setText("");
    }

}