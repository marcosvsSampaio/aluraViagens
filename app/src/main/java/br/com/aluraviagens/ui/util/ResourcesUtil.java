package br.com.aluraviagens.ui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.aluraviagens.model.Pacote;

public class ResourcesUtil {
    public static Drawable getDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableEmTexto, "drawable", context.getPackageName());
        return resources.getDrawable(drawableId);
    }
}
