package com.example.gasoliaoualcool;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText litrosKm, editPrecoGasolina, editPrecoAlcool, litrosAlcool, kmpretendidoss;
    private TextView resultado;


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

        litrosAlcool = findViewById(R.id.alcoolPorKm);
        litrosKm = findViewById(R.id.litrosKm); // Correção aqui
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina); // Remoção da linha duplicada
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        resultado = findViewById(R.id.textResultado);
        kmpretendidoss = findViewById(R.id.kmPretendidos);
    }

      public void calcularPreco(View view){

        //recuperar valores digitados
          String litroAlcool = litrosAlcool.getText().toString();
          String litros = litrosKm.getText().toString();
          String precoGas = editPrecoGasolina.getText().toString();
          String precoAlcool = editPrecoAlcool.getText().toString();
          String kmprete = kmpretendidoss.getText().toString();

          Boolean camposValidados = validarCampos(litros, precoGas, precoAlcool, litroAlcool, kmprete);
          if(camposValidados){

              //Convertendo string para numeros
              Double vlGasolina = Double.parseDouble(precoGas);
              Double vlAlcool = Double.parseDouble(precoAlcool);
              Double vlLitros = Double.parseDouble(litros);
              Double vllitrosAlcool = Double.parseDouble(litroAlcool);
              Double pretendidosKm = Double.parseDouble(kmprete);

              // Custo por KM Gasolina
              Double vlResultOne = vlGasolina/vlLitros;
              //Custo por KM Álcool
              Double vlResultTwo = vlAlcool/vllitrosAlcool;

              Double totalGasolina = vlResultOne * pretendidosKm;
              Double totalAlcool = vlResultTwo * pretendidosKm;

              if(totalGasolina<totalAlcool){
                  resultado.setText("É melhor utilizar Gasolina");
              } else{
                  resultado.setText(("É melhor utilizar Álcool"));
              }


          }else{
              resultado.setText("Preencha os preços primeiro");
          }

      }

    public Boolean validarCampos(String pLitros, String pGasolina, String pAlcool, String pLitrosAlcool, String Kmpretendi) {
        Boolean camposValidados = true;

        if (pLitros == null || pLitros.isEmpty()) { // Correção aqui
            camposValidados = false;
        } else if (pLitrosAlcool == null || pLitrosAlcool.isEmpty()) { // Correção aqui
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.isEmpty()) { // Correção aqui
            camposValidados = false;
        } else if (pAlcool == null || pAlcool.isEmpty()) { // Correção aqui
            camposValidados = false;
        } else if (Kmpretendi == null || Kmpretendi.isEmpty()) { // Correção aqui
            camposValidados = false;
        }

        return camposValidados;
    }




}