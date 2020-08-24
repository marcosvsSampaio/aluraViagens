package br.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.dao.PacoteDAO;
import br.com.aluraviagens.model.Pacote;
import br.com.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pacotes);
        setTitle(R.string.string_pacotes);

        configuraAdapter();
        startActivity(new Intent(this, ResumoCompraActivity.class));
    }

    private void configuraAdapter() {
        ListView llistaDePacotes = findViewById(R.id.listaDePacotes);
        List<Pacote> pacotes = new PacoteDAO().lista();
        llistaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
