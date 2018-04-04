package br.com.senaijandira.economia;

import java.util.Date;

/**
 * Created by 17170084 on 21/03/2018.
 */

public class Lancamento {

    private int id;
    private Double valor;
    private String tipo;
    private String descricao;
    private String dtGasto;



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDtGasto() {
        return dtGasto;
    }

    public void setDtGasto(String dtGasto) {
        this.dtGasto = dtGasto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
