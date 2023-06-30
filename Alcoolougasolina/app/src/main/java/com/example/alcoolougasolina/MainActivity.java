package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText precoAlcool, precoGasolina;
    private TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        resultado = findViewById(R.id.textoPreco);
    }
    public void calcularPreco(View view){
        //validar preços
        String alcool = precoAlcool.getText().toString();
        String gasolina = precoGasolina.getText().toString();

        //validar campo digitado
        Boolean camposValidos = validarCampos(alcool, gasolina);
        if (camposValidos){
            //convertendo
            Double valorAlcool = Double.parseDouble(alcool);
            Double valorGasolina = Double.parseDouble(gasolina);

            Double resultadoConta = valorAlcool/valorGasolina;
            if ( resultadoConta >= 0.7){
                resultado.setText("Melhor usar gasolina");
            }else {
                resultado.setText("Melhor usar alcool");
            }
        }else {
            resultado.setText("Preencha os campos corretamente");
        }
    }
    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}