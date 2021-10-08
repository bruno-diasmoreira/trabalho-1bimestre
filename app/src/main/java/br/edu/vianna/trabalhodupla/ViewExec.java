package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.Exercicios;
import br.edu.vianna.trabalhodupla.utils.Item;
import br.edu.vianna.trabalhodupla.utils.ListaArrayAdapter;

public class ViewExec extends AppCompatActivity {

    private TextView tvTeste;
    private ListView listView;

    Exercicios exec = new Exercicios();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercicios);

        binding();



        ListaArrayAdapter adpterItem = new ListaArrayAdapter(this,arrayLista());

        listView.setAdapter(adpterItem);

        listView.setOnItemClickListener(callViewTreinos() );


    }

    private AdapterView.OnItemClickListener callViewTreinos() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),arrayLista().get(i).getDescricao(),Toast.LENGTH_LONG).show();
            }
        };
    }

    private void binding() {
        listView = findViewById(R.id.lvExercicios);
    }

    public ArrayList<Item> arrayLista(){

        ArrayList lista = new ArrayList<Item>();

        Item peitoral = new Item(R.drawable.peitoral,"Peitoral");
        Item triceps = new Item(R.drawable.triceps,"Tríceps");
        Item costas = new Item(R.drawable.costas,"Costas");
        Item biceps = new Item(R.drawable.biceps,"Biceps");
        Item pernas = new Item(R.drawable.pernas,"Pernas");
        Item ombro = new Item(R.drawable.ombro,"Ombro");


        lista.add(peitoral);
        lista.add(triceps);
        lista.add(costas);
        lista.add(biceps);
        lista.add(pernas);
        lista.add(ombro);

        return lista;
    }
}