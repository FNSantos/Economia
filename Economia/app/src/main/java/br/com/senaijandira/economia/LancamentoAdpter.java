package br.com.senaijandira.economia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class LancamentoAdpter extends ArrayAdapter<Lancamento> {

    public LancamentoAdpter(Context ctx, ArrayList<Lancamento> lst){
        super(ctx,0, lst);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, null);
        }

        //pegar o lancamento que esta sendo montado
        Lancamento lancamento = getItem(position);

        TextView txt_nome_final = v.findViewById(R.id.txt_nome_final);
        TextView txt_valor_final = v.findViewById(R.id.txt_valor_final);

        NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));

        double valor = lancamento.getValor();

        txt_nome_final.setText(lancamento.getDescricao());
        txt_valor_final.setText(f.format(valor));


        return v;

    }

}
