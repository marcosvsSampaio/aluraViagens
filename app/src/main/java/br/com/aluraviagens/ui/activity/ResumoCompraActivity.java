package br.com.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacote;
import br.com.aluraviagens.ui.util.DataUtil;
import br.com.aluraviagens.ui.util.MoedaUtil;
import br.com.aluraviagens.ui.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_RESUMO_COMPRA = "Resumo Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_RESUMO_COMPRA);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraData(pacote);
            mostraImagem(pacote);
            mostraPreco(pacote);
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumoCompraPreco);
        String precoFormatado = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoCompraImagem);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumoCompraData);
        String dataFormatada = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumoCompraLocal);
        local.setText(pacote.getLocal());
    }
}