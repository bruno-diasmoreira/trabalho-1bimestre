package br.edu.vianna.trabalhodupla;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import br.edu.vianna.trabalhodupla.adapter.ListaExerciciosDaFicha;
import br.edu.vianna.trabalhodupla.adapter.ListaMedidasAdapter;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Medida;
import br.edu.vianna.trabalhodupla.domain.dao.impl.ExerciciosDAO;
import br.edu.vianna.trabalhodupla.domain.dao.impl.MedidaDAO;

public class ViewMedidas extends AppCompatActivity {

    private RecyclerView rvMedidasAluno;
    private Button btnCadastrarMedidas,btnAtualizarMedidas;

    List<Medida> listaMedidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_medidas);

        binding();


        btnCadastrarMedidas.setOnClickListener(CallViewCadastrarMedias());

        btnAtualizarMedidas.setOnClickListener(CallViewAtualizarMedidas());




        // LISTAR NO RECYCLER VIEW
        MedidaDAO medidaDao = new MedidaDAO(getApplicationContext());

        medidaDao.open();

        listaMedidas = medidaDao.buscarTodos(getAluno().getId());

        medidaDao.close();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMedidasAluno.setAdapter(new ListaMedidasAdapter(getApplicationContext(),listaMedidas));
        rvMedidasAluno.setLayoutManager(layoutManager);



    }

    public int quantidadeMedidas(){

        MedidaDAO medidaDao = new MedidaDAO(getApplicationContext());

        medidaDao.open();
        int quantidade = medidaDao.totaldeCadaAluno(getAluno().getId());
        medidaDao.close();

        return quantidade;
    }


    private View.OnClickListener CallViewAtualizarMedidas() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(quantidadeMedidas() <=0){
                    Toast.makeText(getApplicationContext(),"Cadastre as medidas primeiro",Toast.LENGTH_LONG).show();

                }else{
                    Intent it = new Intent(getApplicationContext(),ViewAtualizarMedidas.class);
                    it.putExtra("aluno",getAluno());
                    startActivityForResult(it,66);
                }

            }
        };
    }

    private View.OnClickListener CallViewCadastrarMedias() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewCadastrarMedidas.class);
                it.putExtra("aluno",getAluno());
                startActivityForResult(it,65);

            }
        };

    }

    private void binding() {

        btnCadastrarMedidas = findViewById(R.id.btnCadastrarMedidas);
        btnAtualizarMedidas = findViewById(R.id.btnAtualizarMedidas);
        rvMedidasAluno = findViewById(R.id.rvMedidasAluno);
    }

    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }


    public void atualizarRecyclerViewNaTela(){

        MedidaDAO medidaDao = new MedidaDAO(getApplicationContext());

        medidaDao.open();

        listaMedidas = medidaDao.buscarTodos(getAluno().getId());

        medidaDao.close();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMedidasAluno.setAdapter(new ListaMedidasAdapter(getApplicationContext(),listaMedidas));
        rvMedidasAluno.setLayoutManager(layoutManager);

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 65){

            if(resultCode == 70){

                atualizarRecyclerViewNaTela();

            }
        }

        if(requestCode == 66){

            if(resultCode == 71){
                atualizarRecyclerViewNaTela();
            }

        }



    }
}