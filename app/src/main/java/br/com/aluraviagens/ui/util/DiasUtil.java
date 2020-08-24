package br.com.aluraviagens.ui.util;

import br.com.aluraviagens.R;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataParaTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + PLURAL;
        }
        return quantidadeDeDias + SINGULAR;
    }
}
