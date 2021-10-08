package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Exercicios;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.impl.FichaDAO;

public class ViewCadastrarFicha extends AppCompatActivity {

    private EditText edtDescricaoFicha;
    private Button btnSalvarFicha;
    private CheckBox checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;

    int cont = 0;

    Ficha ficha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastrar_ficha);

        binding();

        btnSalvarFicha.setOnClickListener( CallSalvarFicha() );



    }

    private View.OnClickListener CallSalvarFicha() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String descricao = edtDescricaoFicha.getText().toString();

                if(descricao.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo descrição não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtDescricaoFicha.requestFocus();
                    return;
                }
                // TODOS OS EXERCICIOS JA INSTANCIADOS
                Exercicios exercicios = new Exercicios();

                ficha = new Ficha();
                preencherValoresBoolean();
                Aluno aluno = getAluno();

                ficha.setDescricao(descricao);
                ficha.setAluno(aluno);

                FichaDAO f = new FichaDAO(getApplicationContext());

                f.open();

                int total = f.totaldeCadaAluno(aluno.getId());

                if(total>= 3){
                    Toast.makeText(getApplicationContext(),"Pode cadastrar apenas 3 fichas por aluno",Toast.LENGTH_LONG).show();
                    return;
                }else{

                    f.inserir(ficha);
                    f.close();

                    Toast.makeText(getApplicationContext(),"Ficha cadastrada",Toast.LENGTH_LONG).show();
                    finish();
                    setResult(30);

                }
            }
        };
    }



    public void preencherValoresBoolean(){
        if(checkBox2.isChecked()){
            ficha.setEhPeito(true);
        }
        if(checkBox3.isChecked()){
            ficha.setEhTriceps(true);
        }
        if(checkBox4.isChecked()){
            ficha.setEhCostas(true);
        }
        if(checkBox5.isChecked()){
            ficha.setEhPernas(true);
        }
        if(checkBox6.isChecked()){
            ficha.setEhBiceps(true);
        }
        if(checkBox7.isChecked()){
            ficha.setEhOmbro(true);
        }
    }




    private void binding() {

        edtDescricaoFicha = findViewById(R.id.edtDescricaoFicha);
        btnSalvarFicha = findViewById(R.id.btnSalvarFicha);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
    }


    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }




    public void onCheckBoxClick(View view) {

        if (((CheckBox)view).isChecked()) {
            cont += 1;
            //textView15.setText(String.valueOf(cont + " de 8 foram marcados."));
        } else {
            cont -= 1;
            //textView15.setText(String.valueOf(cont + " de 8 foram marcados."));
        }
        if(cont > 2){
            ((CheckBox)view).setChecked(false);
            cont--;
            Toast.makeText(getApplicationContext(),"Não pode marcar mais  que dois",Toast.LENGTH_LONG).show();
            return;
        }
    }




}