package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaAgendaAlunosAdapter;
import br.edu.vianna.trabalhodupla.adapter.ListaAlunos;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AlunoDAO;

public class ViewAlunos extends AppCompatActivity {

    private RecyclerView rvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alunos);

        binding();

        List<Aluno> listAlunos;

        AlunoDAO dao = new AlunoDAO(getApplicationContext());
        dao.open();
        listAlunos = dao.buscarTodos();
        dao.close();



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvAlunos.setAdapter(new ListaAlunos(getApplicationContext(),listAlunos));
        rvAlunos.setLayoutManager(layoutManager);



    }

    private void binding() {
        rvAlunos = findViewById(R.id.rvAlunos);
    }
}