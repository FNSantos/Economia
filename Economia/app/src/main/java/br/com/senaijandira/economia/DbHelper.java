package br.com.senaijandira.economia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by 17170084 on 27/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper{


    //nome do banco
    private static String DB_NAME = "lancamentos.db";

    //versão do banco
    private static int DB_VERSION = 1;

    public DbHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String sql = " create table tbl_lancamento(" +
                "_id INTEGER primary key autoincrement," +
                "valor DOUBLE," +
                "tipo TEXT," +
                "descricao TEXT," +
                "dtGasto TEXT);";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {

        db.execSQL("drop table tbl_lancamento;");
        onCreate(db);
    }
}
