package br.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.dao.PacoteDAO;
import br.com.aluraviagens.model.Pacote;
import br.com.aluraviagens.ui.adapter.ListaPacotesAdapter;

import static br.com.aluraviagens.ui.activity.PacoteActivity.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pacotes);
        setTitle(R.string.string_pacotes);

        configuraLista();
    }

    private void configuraLista() {
        ListView llistaDePacotes = findViewById(R.id.listaDePacotes);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        llistaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        llistaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacote = pacotes.get(position);
                vaiParaResumoPacote(pacote);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }
}
