package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView cvAgendarAluno,cvViewExercicios,cvViewAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        cvAgendarAluno.setOnClickListener( callViewAgendarAluno() );

        cvViewExercicios.setOnClickListener( callViewExercicios() );

        cvViewAlunos.setOnClickListener( callViewAlunos() );


    }

    private View.OnClickListener callViewAlunos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewAlunos.class);
                startActivityForResult(it,3);

            }
        };
    }

    private View.OnClickListener callViewExercicios() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(), ViewExec.class);
                startActivityForResult(it,2);
            }
        };
    }


    private View.OnClickListener callViewAgendarAluno() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewAgendarAlunos.class);
                startActivityForResult(it,1);
            }
        };
    }


    private void binding() {
        cvAgendarAluno = findViewById(R.id.cvAgendarAluno);
        cvViewExercicios = findViewById(R.id.cvViewExercicios);
        cvViewAlunos = findViewById(R.id.cvViewAlunos);
    }

}