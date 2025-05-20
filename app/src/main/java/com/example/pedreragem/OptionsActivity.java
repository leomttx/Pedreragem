package com.example.pedreragem;

    import android.content.Intent;
    import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    private Button btnCalculosPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnCalculosPage = findViewById(R.id.btnCalculos);

        btnCalculosPage.setOnClickListener(view -> {
            startActivity(new Intent(OptionsActivity.this, CalcActivity.class));
        });
    }
}

