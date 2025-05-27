package com.example.pedreragem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private Button btnOptions;
    private EditText usuario, senha;

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

        btnOptions = findViewById(R.id.entrar);
        usuario = findViewById(R.id.nameUser);
        senha = findViewById(R.id.passwordUser);

        btnOptions.setOnClickListener(view -> {
            // Captura dos valores inseridos pelo usuário
            String user = usuario.getText().toString().trim();
            String pass = senha.getText().toString().trim();

            if(user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this, "Por favor, prencha os campos.", Toast.LENGTH_SHORT).show();
            } else {
                // Lógica de verficação das credenciais
                if(user.equals("Leomttx") && pass.equals("Senha123")) {
                    //Intenção para a próxima Activity
                    Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Credenciais incorretas.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}