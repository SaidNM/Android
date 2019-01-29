package mx.ipn.cic.aplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonDigitoCero;
    Button buttonDigitoUno;
    Button buttonDigitoDos;
    Button buttonDigitoTres;
    Button buttonDigitoCuatro;
    Button buttonDigitoCinco;
    Button buttonDigitoSeis;
    Button buttonDigitoSiete;
    Button buttonDigitoOcho;
    Button buttonDigitoNueve;
    Button buttonDigitoPunto;
    Button buttonDigitoDivision;
    Button buttonDigitoMultiplicacion;
    Button buttonDigitoSumar;
    Button buttonDigitoRestar;

    //Definir los digitos
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Recuperar las referencias a los widgets y asignar el codigo necesario
        buttonDigitoCero = this.findViewById(R.id.buttonDigito0);
        textView = this.findViewById(R.id.textViewExpresion);
            // Hacerlo para todos los demas

        // Metodo 1. Definir una inner class por cada objeto del layout

        buttonDigitoCero.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v){
            String texto = textView.getText().toString()+"0";
             textView.setText(texto);
        }
        });
    }

}
