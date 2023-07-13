package com.example.anatoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private anotacaoPreferencia preferencia;
    private EditText editAnotacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAnotacao = findViewById(R.id.editAnotacao);
        preferencia = new anotacaoPreferencia(getApplicationContext());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validar se tem algo escrito
                String textoRecuperado = editAnotacao.getText().toString();
                if (textoRecuperado.equals("")){
                    Snackbar.make(v, "Preencha a anotação", Snackbar.LENGTH_SHORT ).show();

                }else {
                    preferencia.salvarAnotacao(textoRecuperado);
                    Snackbar.make(v, "Anotação salva com sucesso!", Snackbar.LENGTH_SHORT ).show();

                }

            }
        });
        //recuperar anotação
        String anotacao = preferencia.recuperarAnotacao();
        if (!anotacao.equals("")){
              editAnotacao.setText(anotacao);
        }
    }
}