package mx.ipn.cic.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Operaciones operacion = new Operaciones();
    private String expresion="";
    TextView textView;


    public void construyeExpresion(String texto){
        if(texto.equals(".") || !operacion.isOperador(texto))
            expresion += texto;
        else
            expresion += " "+texto +" ";
    }

    @Override
    public void onClick(View v) {
        String texto = ((Button) v).getText().toString();
        if (texto.equals("=")) {
            StringTokenizer st = new StringTokenizer(expresion);
            String cadenaPostFija = operacion.convertirPostFijo(st);
            st = new StringTokenizer(cadenaPostFija);
            String resultado = operacion.expresionFinal(st);
            textView.setText(resultado);
        }else if(texto.equals("C")){
            textView.setText("");
            expresion="";
        }
        else{
            construyeExpresion(texto);
            textView.setText(expresion);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = this.findViewById(R.id.textViewExpresion);
    }
}
