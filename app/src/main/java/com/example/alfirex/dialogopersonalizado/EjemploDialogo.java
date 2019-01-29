package com.example.alfirex.dialogopersonalizado;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class EjemploDialogo extends AppCompatDialogFragment {
    // Inicializamos Los Editext para despues recogerlos
    private EditText edUsuario, edContraseña;

    //Inicializamos la variable de la interfaz
    private EjemploDialogoListener interfazListener;

    /**
     * Metodo para que aparezca el Dialogo
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_custom_deesign,null);//Obtenemos el diseño de Dialog XML

        builder.setView(view)
                .setTitle("Titulo")// Damos un nombre del Titular
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Vale", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sUsuario = edUsuario.getText().toString();
                        String sContraseña = edContraseña.getText().toString();

                        // Llamamos la funcion de la interfaz para mandarle los parametros de Usuario y Contraseña
                        interfazListener.aplicarTexto(sUsuario,sContraseña);
                    }
                });
        //Obtenemos las referencias de Los Editext
        edUsuario = view.findViewById(R.id.edUsername);
        edContraseña = view.findViewById(R.id.edPassword);

        return builder.create();
    }

    /**
     * Comprobamos de que este implementado la Interfaz en la Actividad
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            interfazListener = (EjemploDialogoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Debes implementar la interfaz del Dialogo");
        }
    }

    /**
     * Interfaz para comunicar Activity
     */
    public interface EjemploDialogoListener{
        void aplicarTexto(String textoUsuario, String textoPasword);
    }
}
