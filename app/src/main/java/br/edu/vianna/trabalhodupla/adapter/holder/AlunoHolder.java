package br.edu.vianna.trabalhodupla.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.domain.Aluno;

public class AlunoHolder extends RecyclerView.ViewHolder {

    private TextView tvNomeAluno;
    private ImageView imgAluno;

    public AlunoHolder(@NonNull final View alunolinha) {
        super(alunolinha);

        tvNomeAluno = alunolinha.findViewById(R.id.tvNomeAluno);
        imgAluno = alunolinha.findViewById(R.id.imgAluno);

    }


    public void preenche(Aluno aluno) {
        tvNomeAluno.setText(aluno.getNome());
        imgAluno.setImageResource(R.drawable.teste_pessoa);
    }
}
