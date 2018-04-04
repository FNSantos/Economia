package br.com.senaijandira.economia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LancamentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String []  lista = {"lazer", "Transporte", "saude" , "moradia" , "salario", " Outros"};
    EditText txt_valor, txt_descricao, txt_data;
    Button btn_salvar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_receita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner = (Spinner) findViewById(R.id.spinner);
        txt_valor = (EditText) findViewById(R.id.txt_valor);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        txt_data = (EditText) findViewById(R.id.txt_data);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void salvar(View view) {

        String text = spinner.getSelectedItem().toString();

//                if(text.getText().toString().isEmpty()){
//                    Toast.makeText(null, "Preencha o nome", Toast.LENGTH_SHORT);
//                    return;
//                }

        Lancamento l = new Lancamento();

        Double valor = Double.parseDouble(txt_valor.getText().toString());

        l.setValor(valor);
        l.setDescricao(txt_descricao.getText().toString());
        l.setDtGasto(txt_data.getText().toString());
        l.setTipo(spinner.getSelectedItem().toString());


        //inserir no banco de dados
        LancamentoDAO.getInstance().inserir(this, l);


        finish();

    }
}
