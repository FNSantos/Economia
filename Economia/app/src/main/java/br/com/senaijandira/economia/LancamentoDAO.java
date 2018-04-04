package br.com.senaijandira.economia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 17170084 on 27/03/2018.
 */

public class LancamentoDAO {

    private static LancamentoDAO instance;

    public static LancamentoDAO getInstance(){

        if(instance == null) {
            instance = new LancamentoDAO();
        }

        return instance;
    }

    public Boolean inserir(Context context, Lancamento l){

        //acessar o banco em modo escrita
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("valor", l.getValor());
        valores.put("tipo", l.getTipo());
        valores.put("descricao", l.getDescricao());
        valores.put("dtGasto", l.getDtGasto());

        Long id = db.insert("tbl_lancamento",
                null, valores);

        if(id != -1)
            return true;
        else
            return false;

    }

    public Lancamento selecionarUm(Context context, int id){

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_lancamento WHERE _id = " + id;

        Cursor cursor = db.rawQuery(sql , null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            Lancamento l = new Lancamento();
            l.setId(cursor.getInt(0));
            l.setValor(cursor.getDouble(1));
            l.setTipo(cursor.getString(2));
            l.setDescricao(cursor.getString(3));
            l.setDtGasto(cursor.getString(4));

            cursor.close();
            return l;
        }

        return null;
    }

    public ArrayList<Lancamento> selecionarTodos(Context context){

        //banco  de dados de leitura
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql = "SELECT * FROM tbl_lancamento;";

        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<Lancamento> retorno = new ArrayList<>();

        while (cursor.moveToNext()){
            Lancamento l = new Lancamento();
            l.setId(cursor.getInt(0)/*acesssando a coluna o do ID*/);
            l.setValor(cursor.getDouble(1));
            l.setTipo(cursor.getString(2));
            l.setDescricao(cursor.getString(3));
            l.setDtGasto(cursor.getString(4));

            retorno.add(l);
        }
        return retorno;
    }
}
