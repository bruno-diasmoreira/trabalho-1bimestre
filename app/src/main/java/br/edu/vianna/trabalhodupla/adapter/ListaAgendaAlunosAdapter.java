package br.edu.vianna.trabalhodupla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.adapter.holder.AgendaHolder;
import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;

public class ListaAgendaAlunosAdapter extends RecyclerView.Adapter {

    private List<AgendarAluno> listaAgenda;
    private Context context;

    public ListaAgendaAlunosAdapter(Context context, List<AgendarAluno> listaAgenda) {
        this.listaAgenda = listaAgenda;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.linha, parent,false);
        AgendaHolder holder = new AgendaHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((AgendaHolder)holder).preenche( listaAgenda.get(position));

        ((AgendaHolder)holder).imgRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgendaDAO dao = new AgendaDAO(context);
                dao.open();
                dao.apagar(listaAgenda.get(position));
                dao.close();

                //remove da lista para fazer a atualização na tela
                listaAgenda.remove(position);

                
                // NOTIFICA O ADAPTER QUE TEVE ALTERAÇÃO PARA ATUALIZAR A LISTA NA TELA
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,listaAgenda.size());
                Toast.makeText(context, "Agenda apagada com sucesso!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaAgenda.size();
    }
}
