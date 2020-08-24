package br.com.aluraviagens.ui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoBrasileiro.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta.getTime());
        return dataIdaFormatada + " - " +
                dataVoltaFormatada + " de " +
                dataVolta.get(Calendar.YEAR);
    }
}
