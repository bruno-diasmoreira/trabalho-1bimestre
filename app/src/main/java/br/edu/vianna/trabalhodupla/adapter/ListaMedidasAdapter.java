package br.edu.vianna.trabalhodupla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.trabalhodupla.R;
import br.edu.vianna.trabalhodupla.adapter.holder.FichaHolder;
import br.edu.vianna.trabalhodupla.adapter.holder.MedidaHolder;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.Medida;

public class ListaMedidasAdapter extends RecyclerView.Adapter {

    private List<Medida> listaMedidas;
    private Context context;

    public ListaMedidasAdapter(Context context, List<Medida> listaMedidas) {
        this.listaMedidas = listaMedidas;
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.medida, parent,false);
        MedidaHolder holder = new MedidaHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((MedidaHolder)holder).preenche( listaMedidas.get(position));

    }

    @Override
    public int getItemCount() {
        return listaMedidas.size();
    }
}
