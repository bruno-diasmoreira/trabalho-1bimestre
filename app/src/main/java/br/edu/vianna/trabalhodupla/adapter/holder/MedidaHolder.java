package br.edu.vianna.trabalhodupla.adapter.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.Medida;

public class MedidaHolder extends  RecyclerView.ViewHolder {

    private TextView tvTipoMedida,tvMedida,tvMedida2,tvMedida3,tvMedida4,tvMedida5,tvMedida6;


    public MedidaHolder(@NonNull View itemView) {
        super(itemView);

        tvTipoMedida = itemView.findViewById(R.id.tvTipoMedida);
        tvMedida = itemView.findViewById(R.id.tvMedida);
        tvMedida2 = itemView.findViewById(R.id.tvMedida2);
        tvMedida3 = itemView.findViewById(R.id.tvMedida3);
        tvMedida4 = itemView.findViewById(R.id.tvMedida4);
        tvMedida5 = itemView.findViewById(R.id.tvMedida5);
        tvMedida6 = itemView.findViewById(R.id.tvMedida6);
    }

    public void preenche(Medida medida) {
        tvTipoMedida.setText(""+medida.getBraco());
        tvMedida.setText(""+medida.getAntiBraco());
        tvMedida2.setText(""+medida.getAbdomen());
        tvMedida3.setText(""+medida.getQuadril());
        tvMedida4.setText(""+medida.getCintura());
        tvMedida5.setText(""+medida.getCoxa());
        tvMedida6.setText(""+medida.getPerna());
    }

}
