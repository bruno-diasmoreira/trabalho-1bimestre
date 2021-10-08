package br.edu.vianna.trabalhodupla.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.ViewDadosAluno;
import br.edu.vianna.trabalhodupla.ViewFichaExercicios;
import br.edu.vianna.trabalhodupla.adapter.holder.AlunoHolder;
import br.edu.vianna.trabalhodupla.adapter.holder.FichaHolder;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Ficha;

public class ListaFichas extends RecyclerView.Adapter {

    private List<Ficha> listaFichas;
    private Context context;

    public ListaFichas(Context context, List<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.ficha, parent,false);
        FichaHolder holder = new FichaHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((FichaHolder)holder).preenche( listaFichas.get(position));


        // MANDA PARA TELA DE VIEW LISTA DE FICHAS
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(context, ViewFichaExercicios.class);
                it.putExtra("fichas", listaFichas.get(position));
                it.setFlags(it.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(it);
            }
        });




    }

    @Override
    public int getItemCount() {
        return listaFichas.size();
    }
}
