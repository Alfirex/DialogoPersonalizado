package com.example.alfirex.dialogopersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements EjemploDialogo.EjemploDialogoListener {
    // Creamos Las Variables de la Actividad:
    private TextView tvUsuario, tvContraseña;
    Button btnAbrirDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemoso las referencias del XML
        btnAbrirDialogo = findViewById(R.id.button);
        tvUsuario = findViewById(R.id.tvUser);
        tvContraseña = findViewById(R.id.tvPass);

        // Hacemos un OnClickListener para llamar al Dialogo
        btnAbrirDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // LLamamos al metodo para que nos abra el dialogo
                abridDialogo();

            }
        });
    }

    /**
     * Metodo que utilizaremos para llamar al dialogo
     */
    public void  abridDialogo(){
        // Hacemos un objeto del metodo
        EjemploDialogo ejemploDialogo = new EjemploDialogo();
        //Le decimos que que muestre el Dialogo
        ejemploDialogo.show(getSupportFragmentManager(), "Ejemplo Dialogo");
    }

    /**
     * Este Metodo es lo que le implementamos de la Interfaz del DialogFragment(EjemploDialogo)
     * @param textoUsuario Contendra el String Usuario que le añdamos los EditText
     * @param textoPasword Contendra el String Contraseña que le añdamos los EditText
     */
    @Override
    public void aplicarTexto(String textoUsuario, String textoPasword) {
        // Setteamos los TextView con la Informacion Revicida Del Dialog
        tvUsuario.setText(textoUsuario);
        tvContraseña.setText(textoPasword);
    }
}
