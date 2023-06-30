package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void tesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }
    public void papel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void opcaoSelecionada(String usuario) {

        ImageView app = findViewById(R.id.escolhaApp);
        TextView resultado = findViewById(R.id.ganhador);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcoesApp = opcoes[numero];
        switch (opcoesApp) {
            case"Pedra" :
                app.setImageResource(R.drawable.pedra);
                    break;
            case"Papel" :
                app.setImageResource(R.drawable.papel);
                break;
            case"Tesoura" :
                app.setImageResource(R.drawable.tesoura);
                break;
        }
        if(
                        (opcoesApp == "Tesoura" && usuario == "Papel") ||
                        (opcoesApp == "Papel" && usuario == "Pedra") ||
                        (opcoesApp == "Pedra" && usuario == "Tesoura")
        ){//App ganhou
            resultado.setText("Você perdeu!");
        }
        else if (
                        (usuario == "Tesoura" && opcoesApp == "Papel") ||
                        (usuario == "Papel" && opcoesApp == "Pedra") ||
                        (usuario == "Pedra" && opcoesApp == "Tesoura")
        ) {//usuario ganhador
            resultado.setText("Você ganhou!");
        }
        else {//empate
            resultado.setText("Empate!");
            }
    }
}