package com.example.pedreragem;

    import android.content.Intent;
    import android.os.Bundle;
import android.widget.Button;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    private Button btnCalculosPage;
    private TextView saudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnCalculosPage = findViewById(R.id.btnCalculos);

        btnCalculosPage.setOnClickListener(view -> {
            startActivity(new Intent(OptionsActivity.this, CalcActivity.class));
        });

        saudacao = findViewById(R.id.saudacaoUser);

        String username = getIntent().getStringExtra("username");

        if (username != null) {
            saudacao.setText("Olá, " + username + "!");
        }
    }
}

