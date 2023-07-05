package com.example.cardview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.Adapter.PostagemAdaptador;
import com.example.cardview.Model.Postagem;
import com.example.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPostagem;
    private List<Postagem> postagem = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //definir layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerPostagem.setLayoutManager(layoutManager);

        //definir adapter
        this.prepararPostagem();
        PostagemAdaptador adaptador = new PostagemAdaptador(postagem);
        recyclerPostagem.setAdapter(adaptador);
    }
    public void prepararPostagem(){
        Postagem p = new Postagem("Victor Watanabe", "viagem legal", R.drawable.imagem1);
        this.postagem.add( p );
        p = new Postagem("Hotel VW", "Viaje, aproveite nossos descontos", R.drawable.imagem2);
        this.postagem.add( p );
        p = new Postagem("Maria Clara", "#Paris", R.drawable.imagem3);
        this.postagem.add( p );
        p = new Postagem("Carlos", "Que foto linda", R.drawable.imagem4);
        this.postagem.add( p );
    }
}