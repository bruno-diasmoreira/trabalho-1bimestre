package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaFichas;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.impl.FichaDAO;

public class ViewVerFichas extends AppCompatActivity {

    private TextView textView17,textView18;

    private RecyclerView rvFichas;


    List<Ficha> fichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ver_fichas);




        binding();




        //MONTANDO O ADAPTER DAS FICHAS

        Aluno aluno = getAluno();

        FichaDAO f = new FichaDAO(getApplicationContext());

        f.open();

        fichas = f.buscarTodos(aluno.getId());

        f.close();



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvFichas.setAdapter(new ListaFichas(getApplicationContext(),fichas));
        rvFichas.setLayoutManager(layoutManager);

    }

    private void binding() {
        rvFichas = findViewById(R.id.rvFichas);
    }

    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }


}