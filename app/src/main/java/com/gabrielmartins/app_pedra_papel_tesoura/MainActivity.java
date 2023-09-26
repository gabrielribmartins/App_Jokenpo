package com.gabrielmartins.app_pedra_papel_tesoura;

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

    public void selecionarPedra( View view ){
        verificarGanhador("pedra");
    }

    public void selecionarPapel( View view ){
        verificarGanhador("papel");
    }

    public void selecionarTesoura( View view ){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoria() {

        String[] opcoes = {"pedra" , "papel" , "tesoura"};
        int numeroAleatorio = new Random().nextInt();

        ImageView imagemApp = findViewById( R.id.Image_app );
        String escolhaApp = opcoes[numeroAleatorio];
        switch ( escolhaApp ){
            case "pedra" :
                imagemApp.setImageResource( R.drawable.pedra );
                break;
            case "papel" :
                imagemApp.setImageResource( R.drawable.papel );
                break;
            case "tesoura" :
                imagemApp.setImageResource( R.drawable.tesoura );
                break;
        }

        return escolhaApp;

    }

    private void verificarGanhador( String escolhaUsuario ){

        String escolhaApp = gerarEscolhaAleatoria();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ) {
            textoResultado.setText("Você perdeu :(");
        } else if (
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){
            textoResultado.setText("Você Ganhou!! :)");

    } else {
            textoResultado.setText("Você Empatou!!");
        }
    }

}