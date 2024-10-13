/*
 *@author:<Camila Gagleote, 1110482312050>
 */

package br.edu.fateczl.combustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etEtanol;

    private EditText etGasolina;

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEtanol = findViewById(R.id.etEtanol);
        etEtanol.setText(TextView.TEXT_ALIGNMENT_CENTER);

        etGasolina = findViewById(R.id.etGasolina);
        etGasolina.setText(TextView.TEXT_ALIGNMENT_CENTER);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnComparar = findViewById(R.id.btnComparar);

        btnComparar.setOnClickListener(op -> comparar());
    }

    private void comparar (){
       double etanol = Double.parseDouble(etEtanol.getText().toString());
       double gasolina = Double.parseDouble(etGasolina.getText().toString());
       double calc;
       String resp1 = "Etanol está compensando";
       String resp2 = "Gasolina está compensando";

       calc = ((etanol/gasolina) * 100);

       if(calc <= 70){
            tvResultado.setText(resp1);
       }else{
           tvResultado.setText(resp2);
       }

    }

}