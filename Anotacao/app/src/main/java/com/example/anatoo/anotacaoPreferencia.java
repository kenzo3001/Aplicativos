package com.example.anatoo;

import android.content.Context;
import android.content.SharedPreferences;

public class anotacaoPreferencia {
    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "anotacao.preferencia";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME = "nome";
    public anotacaoPreferencia(Context C) {
        this.context = C;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
    editor.putString(CHAVE_NOME, anotacao);
    editor.commit();
    }

    public String recuperarAnotacao(){

        return preferences.getString(CHAVE_NOME, "");
    }
}
