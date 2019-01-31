package mx.ipn.cic.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    @Override
    public void onClick(View v){
        String texto = textView.getText().toString() + ((Button) v).getText().toString();
        textView.setText(texto);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = this.findViewById(R.id.textViewExpresion);
    }
}
