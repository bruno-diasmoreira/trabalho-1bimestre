package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaAgendaAlunosAdapter;
import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;

public class ViewTodasAgendas extends AppCompatActivity {
    private RecyclerView rvAgendaAlunos;

    List<AgendarAluno> listaAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todas_agendas);
        binding();


        AgendaDAO dao = new AgendaDAO(getApplicationContext());
        dao.open();
        listaAgenda = dao.buscarTodos();
        dao.close();



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvAgendaAlunos.setAdapter(new ListaAgendaAlunosAdapter(getApplicationContext(),listaAgenda));
        rvAgendaAlunos.setLayoutManager(layoutManager);
        
    }

    private void binding() {
        rvAgendaAlunos = findViewById(R.id.rvAgendaAlunos);
    }
}