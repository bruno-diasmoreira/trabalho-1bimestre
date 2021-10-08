package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.vianna.trabalhodupla.domain.Aluno;

public class ViewDadosAluno extends AppCompatActivity {

    private TextView textViewNome,textViewIdade,textViewAltura,textViewPeso;
    private Button btnCadastrarFicha,btnVerFicha,btnVerMedidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dados_aluno);

        binding();

        // PEGANDO OS DADOS DO ALUNO DA OUTRA PAGINA PELO INTENT
        Aluno aluno = getAluno();

        // SETA AS INFORMAÇÕES BASICAS DO ALUNO NOS TEXT VIEW
        setarInfoAluno(aluno);


        btnCadastrarFicha.setOnClickListener( callViewCadastrarFicha());

        btnVerFicha.setOnClickListener( callViewVerFicha() );

        btnVerMedidas.setOnClickListener( CallViewVerMedidas());



    }

    private View.OnClickListener CallViewVerMedidas() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ViewMedidas.class);
                it.putExtra("aluno",getAluno());
                startActivityForResult(it,32);

            }
        };
    }

    private View.OnClickListener callViewVerFicha() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),ViewVerFichas.class);
                it.putExtra("aluno",getAluno());
                startActivityForResult(it,31);
            }
        };
    }

    private View.OnClickListener callViewCadastrarFicha() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),ViewCadastrarFicha.class);
                it.putExtra("aluno",getAluno());
                startActivityForResult(it,30);
            }
        };
    }


    public void setarInfoAluno(Aluno aluno){
        textViewNome.setText("Nome: "+aluno.getNome());
        textViewIdade.setText("Idade: "+aluno.getIdade());
        textViewAltura.setText("Altura: "+ aluno.getAltura());
        textViewPeso.setText("Peso: "+aluno.getPeso());
    }


    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }

    private void binding() {

        textViewNome = findViewById(R.id.textViewNome);
        textViewIdade = findViewById(R.id.textViewIdade);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewPeso = findViewById(R.id.textViewPeso);
        btnCadastrarFicha = findViewById(R.id.btnCadastrarFicha);
        btnVerFicha = findViewById(R.id.btnVerFicha);
        btnVerMedidas = findViewById(R.id.btnVerMedidas);
    }
}