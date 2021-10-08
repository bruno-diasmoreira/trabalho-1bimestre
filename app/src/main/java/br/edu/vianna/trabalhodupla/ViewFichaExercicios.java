package br.edu.vianna.trabalhodupla;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaAgendaAlunosAdapter;
import br.edu.vianna.trabalhodupla.adapter.ListaExerciciosDaFicha;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Exercicios;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.impl.ExerciciosDAO;

public class ViewFichaExercicios extends AppCompatActivity {

    private TextView textView13,tvTipoA,tvTipoB;
    private Button btnExec1;

    private RecyclerView rvListaExercicios;

    List<Exercicios> listaExercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ficha_exercicios);


        textView13 = findViewById(R.id.textView13);
        tvTipoA = findViewById(R.id.tvTipoA);
        tvTipoB = findViewById(R.id.tvTipoB);
        btnExec1 = findViewById(R.id.btnExec1);
        rvListaExercicios = findViewById(R.id.rvListaExercicios);


        ExerciciosDAO dao = new ExerciciosDAO(getApplicationContext());

        dao.open();

        listaExercicios = dao.buscarTodos(getFicha().getId());

        dao.close();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvListaExercicios.setAdapter(new ListaExerciciosDaFicha(getApplicationContext(),listaExercicios));
        rvListaExercicios.setLayoutManager(layoutManager);


        grupoA();
        grupoB();


       btnExec1.setOnClickListener(CallViewCadastrarExercicios());




    }

    private View.OnClickListener CallViewCadastrarExercicios() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewCadastrarExercicios.class);

                it.putExtra("fichas",getFicha());
                startActivityForResult(it,40);
            }
        };
    }


    public void grupoA(){

        if(getFicha().isEhPeito()){
           // tvGrupoA.setText(exercios.getPeito().toString());
            tvTipoA.setText("Peito");
        }
        else if(getFicha().isEhTriceps()){
           // tvGrupoA.setText(exercios.getTriceps().toString());
            tvTipoA.setText("Triceps");
        }
        else if(getFicha().isEhCostas()){
           // tvGrupoA.setText(exercios.getCostas().toString());
            tvTipoA.setText("Costas");
        }
        else if(getFicha().isEhBiceps()){
           // tvGrupoA.setText(exercios.getBiceps().toString());
            tvTipoA.setText("Biceps");
        }
        else if(getFicha().isEhPernas()){
          //  tvGrupoA.setText(exercios.getPernas().toString());
            tvTipoA.setText("Pernas");
        }
        else if(getFicha().isEhOmbro()){
           // tvGrupoA.setText(exercios.getOmbro().toString());
            tvTipoA.setText("Ombro");
        }
    }

    public void grupoB(){

        if(getFicha().isEhPeito()){
           // tvGrupoB.setText(exercios.getPeito().toString());
            tvTipoB.setText("Peito");
        }
        if(getFicha().isEhTriceps()){
           // tvGrupoB.setText(exercios.getTriceps().toString());
            tvTipoB.setText("Triceps");
        }
        if(getFicha().isEhCostas()){
            //tvGrupoB.setText(exercios.getCostas().toString());
            tvTipoB.setText("Costas");
        }
        if(getFicha().isEhBiceps()){
           // tvGrupoB.setText(exercios.getBiceps().toString());
            tvTipoB.setText("Biceps");
        }
        if(getFicha().isEhPernas()){
            //tvGrupoB.setText(exercios.getPernas().toString());
            tvTipoB.setText("Pernas");
        }
        if(getFicha().isEhOmbro()){
            //tvGrupoB.setText(exercios.getOmbro().toString());
            tvTipoB.setText("Ombro");
        }

    }




    public Ficha getFicha(){
        Ficha ficha;
        Intent it = new Intent();
        ficha = (Ficha) getIntent().getExtras().getSerializable("fichas");
        return ficha;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 40){

            if(resultCode == 50){

                ExerciciosDAO dao = new ExerciciosDAO(getApplicationContext());

                dao.open();

                listaExercicios = dao.buscarTodos(getFicha().getId());

                dao.close();


                LinearLayoutManager layoutManager = new LinearLayoutManager(this);

                rvListaExercicios.setAdapter(new ListaExerciciosDaFicha(getApplicationContext(),listaExercicios));
                rvListaExercicios.setLayoutManager(layoutManager);

            }


        }



    }
}