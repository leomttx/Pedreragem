package com.example.pedreragem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResumo;  // TextView para exibir o resultado dos cálculos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Referência ao componente do layout
        tvResumo = findViewById(R.id.textResumo);

        // Recebe o resumo passado pela intent
        Intent intent = getIntent();
        String resumo = intent.getStringExtra("resumo");

        // Exibe o resumo na tela
        tvResumo.setText(resumo);
    }
}
