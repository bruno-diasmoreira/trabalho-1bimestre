package br.edu.vianna.trabalhodupla.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.domain.Ficha;

public class FichaHolder extends  RecyclerView.ViewHolder {

    private TextView tvDescricaoFicha;
    private ImageView imgFicha;


    public FichaHolder(@NonNull View ficha) {
        super(ficha);

        tvDescricaoFicha = ficha.findViewById(R.id.tvDescricaoFicha);
        imgFicha = ficha.findViewById(R.id.imgFicha);
    }

    public void preenche(Ficha ficha) {
        tvDescricaoFicha.setText(ficha.getDescricao());
        imgFicha.setImageResource(R.drawable.ic_baseline_menu_book_24);
    }
}
