package br.edu.vianna.trabalhodupla;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaAgendaAlunosAdapter;
import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AlunoDAO;

public class ViewAgendarAlunos extends AppCompatActivity {

    public static final int VIEW_ADICIONAR_PESSOAS_AGENDA = 5;
    public static final int VIEW_TODAS_AGENDAS = 6;
    private static final int BOTAO_SALVAR_VIEW_AGENDAR = 10 ;




    private EditText edtPesquisar;
    private ImageView imgPesquisar,imgAdicionar;
    private Button btnVerAgenda;

    List<AgendarAluno> listaAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agendar_alunos);

        binding();

        imgAdicionar.setOnClickListener( callViewAdicionarAlunos());
        btnVerAgenda.setOnClickListener( callViewTodasAgendas() );



//        AgendaDAO dao = new AgendaDAO(getApplicationContext());
//        dao.open();
//        listaAgenda = dao.buscarTodos();
//        dao.close();
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvAgendaAlunos.setAdapter(new ListaAgendaAlunosAdapter(getApplicationContext(),listaAgenda));
//        rvAgendaAlunos.setLayoutManager(layoutManager);



    }

    private View.OnClickListener callViewTodasAgendas() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),ViewTodasAgendas.class);
                startActivityForResult(it, VIEW_TODAS_AGENDAS);
            }
        };
    }

    private View.OnClickListener callViewAdicionarAlunos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewAdicionarPessoasAgenda.class);
                startActivityForResult(it, VIEW_ADICIONAR_PESSOAS_AGENDA);

            }
        };
    }

    private void binding() {

        edtPesquisar = findViewById(R.id.edtPesquisar);
        imgPesquisar = findViewById(R.id.imgPesquisar);
        imgAdicionar = findViewById(R.id.imgAdicionar);
        btnVerAgenda = findViewById(R.id.btnVerAgenda);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == VIEW_ADICIONAR_PESSOAS_AGENDA){

           // Toast.makeText(getApplicationContext(), "FOI", Toast.LENGTH_LONG).show();

            if(resultCode ==  BOTAO_SALVAR_VIEW_AGENDAR){

              //  Toast.makeText(getApplicationContext(), "VOLTOU", Toast.LENGTH_LONG).show();
            }
        }
    }
}