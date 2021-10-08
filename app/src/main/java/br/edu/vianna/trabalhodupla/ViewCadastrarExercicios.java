package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.vianna.trabalhodupla.domain.Exercicios;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.impl.ExerciciosDAO;

public class ViewCadastrarExercicios extends AppCompatActivity {

    public static final int CALL_VIEW_CADASTRAR_EXERCICIOS = 50;
    private EditText editFieldDescricao,editFieldSerie,editFieldRepeticao;

    private Button btnSalvarExercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastrar_exercicios);

        binding();

        btnSalvarExercicios.setOnClickListener(CallSalvarExercicios());



    }

    private View.OnClickListener CallSalvarExercicios() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String descricao = editFieldDescricao.getText().toString();
                String serie = editFieldSerie.getText().toString();
                String repeticao = editFieldRepeticao.getText().toString();

                if(descricao.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo descrição não pode ser vazio",Toast.LENGTH_LONG).show();
                    editFieldDescricao.requestFocus();
                    return;
                }
                if(serie.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo serie não pode ser vazio",Toast.LENGTH_LONG).show();
                    editFieldSerie.requestFocus();
                    return;
                }
                if(repeticao.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo repeticao não pode ser vazio",Toast.LENGTH_LONG).show();
                    editFieldRepeticao.requestFocus();
                    return;
                }


                Exercicios exercio = new Exercicios();


                exercio.setDescricao(descricao);
                exercio.setSerie(serie);
                exercio.setRepeticao(repeticao);
                exercio.setFicha(getFicha());


                ExerciciosDAO execDAO = new ExerciciosDAO(getApplicationContext());

                execDAO.open();

                execDAO.inserir(exercio);
                execDAO.close();

                Toast.makeText(getApplicationContext(),"Exercicio cadastrado",Toast.LENGTH_LONG).show();
                setResult(CALL_VIEW_CADASTRAR_EXERCICIOS);
                finish();

            }
        };
    }


    public Ficha getFicha(){
        Ficha ficha;
        Intent it = new Intent();
        ficha = (Ficha) getIntent().getExtras().getSerializable("fichas");
        return ficha;
    }

    private void binding() {

        editFieldDescricao = findViewById(R.id.editFieldDescricao);
        editFieldSerie = findViewById(R.id.editFieldSerie);
        editFieldRepeticao = findViewById(R.id.editFieldRepeticao);
        btnSalvarExercicios = findViewById(R.id.btnSalvarExercicios);
    }
}