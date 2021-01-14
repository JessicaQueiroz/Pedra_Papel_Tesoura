package com.example.pedra_papel_tesoura;

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
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[ numero ];
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView txtResultado = findViewById(R.id.tx_resultado);

        switch (escolhaApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
        }
        if(
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) { //app ganhador
            txtResultado.setText("Você perdeu :(");
        }
        else if(
                (escolhaApp == "tesoura" && escolhaApp == "papel") ||
                (escolhaApp == "papel" && escolhaApp == "pedra") ||
                (escolhaApp == "pedra" && escolhaApp == "tesoura")
        ) { //usuario ganhador
            txtResultado.setText("Você ganhou :)");
        }
        else { //empate
            txtResultado.setText("Houve empate :D");
        }

        System.out.println("item clicado: " + escolhaApp);
    }
}
