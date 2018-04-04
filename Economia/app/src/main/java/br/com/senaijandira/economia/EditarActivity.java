package br.com.senaijandira.economia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class EditarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String []  lista = {"lazer", "Transporte", "saude" , "moradia" , "salario", " Outros"};
    Integer id;
    Spinner spinner_editar;
    TextView txt_valor_editar, txt_data_editar, txt_descricao_editar;
    Button btn_editar, btn_excluir;

    Lancamento lancamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner_editar = (Spinner) findViewById(R.id.spinner_editar);

        btn_editar = (Button) findViewById(R.id.btn_editar);
        btn_excluir = (Button) findViewById(R.id.btn_excluir);

        txt_data_editar = (TextView) findViewById(R.id.txt_data_editar);
        txt_valor_editar = (TextView) findViewById(R.id.txt_valor_editar);
        txt_descricao_editar = (TextView) findViewById(R.id.txt_descricao_editar);

        spinner_editar.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_editar.setAdapter(adapter);

        Intent intent = getIntent();
        id = intent.getIntExtra("_id", 0);
    }

    public void mostrarLancamento(){
        lancamento = LancamentoDAO.getInstance().selecionarUm(this, id);
        txt_data_editar.setText(lancamento.getDtGasto());

        double valor = lancamento.getValor();

        NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));

        txt_valor_editar.setText(f.format(valor));
        txt_descricao_editar.setText(lancamento.getDescricao());


    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarLancamento();
    }

    public void Excluir(View view) {

    }

    public void Editar(View view) {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
