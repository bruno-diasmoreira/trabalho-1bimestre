package br.edu.vianna.trabalhodupla.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.R;

public class ListaArrayAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> lista;


    public ListaArrayAdapter(Context context, ArrayList<Item>lista){
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item itemPosicao = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item,null);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
        imageView.setImageResource(itemPosicao.getImagem());
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(itemPosicao.getDescricao());

        return convertView;

    }
}
