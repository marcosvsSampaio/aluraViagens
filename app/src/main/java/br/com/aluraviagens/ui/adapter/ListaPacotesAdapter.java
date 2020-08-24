package br.com.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacote;
import br.com.aluraviagens.ui.util.DiasUtil;
import br.com.aluraviagens.ui.util.MoedaUtil;
import br.com.aluraviagens.ui.util.ResourcesUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    public final List<Pacote> pacotes;
    public final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);
        setLocal(viewCriada, pacote);
        setImagem(viewCriada, pacote);
        setDias(viewCriada, pacote);
        setPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void setPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.itemPacotesPreco);
        String precoFormatado = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void setDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.itemPacotesDias);
        int quantidadeDeDias = pacote.getDias();
        String diasEmTexto = DiasUtil.formataParaTexto(quantidadeDeDias);
        dias.setText(diasEmTexto);
    }

    private void setImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.itemPacoteImagem);
        Drawable drawableImagemPacote = ResourcesUtil.getDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }



    private void setLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.itemPacoteLocal);
        local.setText(pacote.getLocal());
    }
}
