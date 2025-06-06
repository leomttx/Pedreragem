package com.example.pedreragem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class EtapasObrasActivity extends AppCompatActivity {

    private ListView listViewEtapas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapas_obra);

        listViewEtapas = findViewById(R.id.listViewEtapas);

        // Lista com etapas iniciais de uma obra
        List<String> etapas = Arrays.asList(
                "1. Levantamento topográfico do terreno",
                "2. Projeto arquitetônico e estrutural",
                "3. Aprovação dos projetos na prefeitura",
                "4. Limpeza e demarcação do terreno",
                "5. Fundação (baldrame, sapata, estaca)",
                "6. Estrutura (vigas, pilares, laje)",
                "7. Alvenaria (paredes)",
                "8. Instalações elétricas e hidráulicas"
        );

        // Adapter para exibir a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                etapas
        );

        listViewEtapas.setAdapter(adapter);
    }
}
