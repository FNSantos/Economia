package br.com.senaijandira.economia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list_view_lancamentos;
    LancamentoAdpter adapter;
    LancamentoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = LancamentoDAO.getInstance();
        Lancamento l = new Lancamento();
        l.setId(0);

        list_view_lancamentos = (ListView) findViewById(R.id.list_view);

        adapter = new LancamentoAdpter(this, new ArrayList<Lancamento>());

        list_view_lancamentos.setAdapter(adapter);

        list_view_lancamentos.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Lancamento lancamento = adapter.getItem(i);

        Intent intent = new Intent(this, EditarActivity.class);

        intent.putExtra("_id", lancamento.getId());

        startActivity(intent);



    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Lancamento>  lancamentos;
        lancamentos = dao.selecionarTodos(this);

        adapter.clear();

        adapter.addAll(lancamentos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abrirActivityGasto(View v){

        Intent intent = new Intent(getApplicationContext(), LancamentoActivity.class);
        startActivity(intent);
    }


}
