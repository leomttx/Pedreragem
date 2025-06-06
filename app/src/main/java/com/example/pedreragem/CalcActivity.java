package com.example.pedreragem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity {

    private CheckBox cbTijoloComun, cbBlocoConcreto, cbBlocoCeramico;
    private CheckBox cbAssentamento, cbRevestimento;
    private EditText etLargura, etComprimento;
    private Button calcMateriais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);


        cbTijoloComun = findViewById(R.id.cbTijoloComun);
        cbBlocoCeramico = findViewById(R.id.cbBlocoCeramico);
        cbBlocoConcreto = findViewById(R.id.cbBlocoConcreto);
        cbAssentamento = findViewById(R.id.cbAssentamento);
        cbRevestimento = findViewById(R.id.cbRevestimento);
        etLargura = findViewById(R.id.etLargura);
        etComprimento = findViewById(R.id.etComprimento);
        calcMateriais = findViewById(R.id.calcMateriais);

        calcMateriais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularCusto();
            }
        });
    }

    private void calcularCusto() {
        String larguraStr = etLargura.getText().toString().trim();
        String comprimentoStr = etComprimento.getText().toString().trim();

        if(larguraStr.isEmpty() || comprimentoStr.isEmpty()) {
            Toast.makeText(this, "Informe Largura e Comprimento", Toast.LENGTH_SHORT).show();
            return;
        }
        double largura = Double.parseDouble(larguraStr);
        double comprimento = Double.parseDouble(comprimentoStr);
        double area = largura * comprimento;

        double precoTotalM2 = 0.0;

        // Materiais
        StringBuilder materiaisSelecionados = new StringBuilder("Materiais selecionados:\n");
        if (cbTijoloComun.isChecked()) {
            precoTotalM2 += 85;
            materiaisSelecionados.append("- Tijolo comum (R$85/m²)\n");
        }
        if (cbBlocoCeramico.isChecked()) {
            precoTotalM2 += 35;
            materiaisSelecionados.append("- Bloco cerâmico (R$35/m²)\n");
        }
        if (cbBlocoConcreto.isChecked()) {
            precoTotalM2 += 53;
            materiaisSelecionados.append("- Bloco de concreto (R$53/m²)\n");
        }

        // Serviços
        StringBuilder servicosSelecionados = new StringBuilder("Serviços selecionados:\n");
        if (cbAssentamento.isChecked()) {
            precoTotalM2 += 5.25;
            servicosSelecionados.append("- Assentamento (R$5,25/m²)\n");
        }
        if (cbRevestimento.isChecked()) {
            precoTotalM2 += 11.90;
            servicosSelecionados.append("- Revestimento (R$11,90/m²)\n");
        }


        double custoTotal = precoTotalM2 * area;

        // Monta o resumo formatado
        StringBuilder resumo = new StringBuilder();
        resumo.append("Resumo do Cálculo:\n\n");
        resumo.append(String.format("Área total: %.2f m²\n", area));
        resumo.append(String.format("Preço total por m²: R$ %.2f\n", precoTotalM2));
        resumo.append(String.format("Custo total estimado: R$ %.2f\n\n", custoTotal));
        resumo.append(materiaisSelecionados.toString()).append("\n");
        resumo.append(servicosSelecionados.toString());

        // Envia os resumos para a ResultActivity
        Intent intent = new Intent(CalcActivity.this, ResultActivity.class);
        intent.putExtra("resumo", resumo.toString());
        startActivity(intent);
    }
}
