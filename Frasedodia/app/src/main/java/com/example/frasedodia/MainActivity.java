package com.example.frasedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){
        String[] frases = {"Os desafios são o tempero da vida!",
                "Escolha as suas batalhas e não desista até vencê-las",
                "As grandes conquistas começam com pequenos sonhos.",
                "Não deixe que seus sonhos percam a força de voar!",
                "Valorize suas conquistas, não espere que alguém as note",
                "Você se torna aquilo que você acredita"
        };
        int numero = new Random().nextInt(5);
        TextView texto = findViewById(R.id.frase);
        texto.setText(frases [numero]);
    }
}