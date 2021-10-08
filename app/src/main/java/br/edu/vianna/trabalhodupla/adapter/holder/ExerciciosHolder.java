package br.edu.vianna.trabalhodupla.adapter.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Exercicios;

public class ExerciciosHolder extends RecyclerView.ViewHolder {

    private TextView tvExecDescricao,tvExecSerie,tvExecRepeticao;


    public ExerciciosHolder(@NonNull View viewExercicios) {
        super(viewExercicios);

        tvExecDescricao = viewExercicios.findViewById(R.id.tvExecDescricao);
        tvExecSerie = viewExercicios.findViewById(R.id.tvExecSerie);
        tvExecRepeticao = viewExercicios.findViewById(R.id.tvExecRepeticao);

    }


    public void preenche(Exercicios exercicios) {
        tvExecDescricao.setText(exercicios.getDescricao());
        tvExecSerie.setText("Serie: "+exercicios.getSerie());
        tvExecRepeticao.setText("Repetições: "+exercicios.getRepeticao());
    }

}
