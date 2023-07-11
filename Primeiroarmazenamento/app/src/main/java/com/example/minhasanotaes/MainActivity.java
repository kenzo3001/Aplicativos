package com.example.minhasanotaes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button buttonSalvar;
    private TextInputEditText editText;
    private TextView textoResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        editText = findViewById(R.id.editText);
        textoResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0 );
                SharedPreferences.Editor editor = preferences.edit();
                //validar nome
                if (editText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_SHORT).show();
                }else {
                    String nome = editText.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textoResultado.setText("Óla " + nome);
                }
            }
        });
        //Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0 );
        //validar dados
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome", "Usuario não definido");
            textoResultado.setText("Óla " + nome);

        }else {textoResultado.setText("Óla, usuario não definido");}
    }
}