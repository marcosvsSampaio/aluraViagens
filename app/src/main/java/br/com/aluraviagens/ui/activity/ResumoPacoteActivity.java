package br.com.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacote;
import br.com.aluraviagens.ui.util.DataUtil;
import br.com.aluraviagens.ui.util.DiasUtil;
import br.com.aluraviagens.ui.util.MoedaUtil;
import br.com.aluraviagens.ui.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APP_BAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumoPacoteData);
        String dataFormatadaDoPacote = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDoPacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumoPacotePreco);
        String precoFormatado = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumoPacoteDias);
        String diasFormatado = DiasUtil.formataParaTexto(pacote.getDias());
        dias.setText(diasFormatado);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoPacoteImagem);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumoPacoteLocal);
        local.setText(pacote.getLocal());
    }
}