package br.edu.vianna.trabalhodupla.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.ViewDadosAluno;
import br.edu.vianna.trabalhodupla.adapter.holder.AgendaHolder;
import br.edu.vianna.trabalhodupla.adapter.holder.AlunoHolder;
import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;

public class ListaAlunos extends RecyclerView.Adapter {


    private List<Aluno> listaAlunos;
    private Context context;

    public ListaAlunos(Context context, List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.alunolinha, parent,false);
        AlunoHolder holder = new AlunoHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((AlunoHolder)holder).preenche( listaAlunos.get(position));





        // MANDA PARA TELA DE VIEW DADOS ALUNO
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(context, ViewDadosAluno.class);
                it.putExtra("aluno", listaAlunos.get(position));
                it.setFlags(it.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(it);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listaAlunos.size();
    }

}
