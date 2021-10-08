package br.edu.vianna.trabalhodupla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.adapter.holder.AlunoHolder;
import br.edu.vianna.trabalhodupla.adapter.holder.ExerciciosHolder;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Exercicios;

public class ListaExerciciosDaFicha extends RecyclerView.Adapter {


    private List<Exercicios> listaExercicios;
    private Context context;

    public ListaExerciciosDaFicha(Context context, List<Exercicios> listaExercicios) {
        this.listaExercicios = listaExercicios;
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.exercicios, parent,false);
        ExerciciosHolder holder = new ExerciciosHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ExerciciosHolder)holder).preenche( listaExercicios.get(position));


    }

    @Override
    public int getItemCount() {
        return listaExercicios.size();
    }
}
