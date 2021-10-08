package br.edu.vianna.trabalhodupla.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;

public class AgendaHolder extends RecyclerView.ViewHolder {

    private TextView tvNome,tvData,textViewHora;
    public ImageView imgRemover,imgPessoa;

    public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SimpleDateFormat df = new SimpleDateFormat("HH:mm");


    public AgendaHolder(@NonNull View linha) {
        super(linha);

        tvNome = linha.findViewById(R.id.tvNome);
        tvData = linha.findViewById(R.id.tvData);
        textViewHora = linha.findViewById(R.id.textViewHora);
        imgRemover = linha.findViewById(R.id.imgRemover);
        imgPessoa = linha.findViewById(R.id.imgPessoa);
    }




    public void preenche(AgendarAluno agendarAluno) {

        tvNome.setText(""+agendarAluno.getAluno().getNome());
        tvData.setText(sdf.format(agendarAluno.getDataAula()));
        textViewHora.setText(df.format(agendarAluno.getHoraAula().getTime()));
        imgPessoa.setImageResource(R.drawable.ic_baseline_assignment_ind_24);
        imgRemover.setImageResource(R.drawable.remover);

    }

}
