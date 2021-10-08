package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.Medida;
import br.edu.vianna.trabalhodupla.domain.dao.impl.MedidaDAO;

public class ViewCadastrarMedidas extends AppCompatActivity {

    private EditText editBraco,editAntiBraco,editAbdomen,editQuadril,editCintura,editCoxa,editPerna;

    private Button btnSalvarMedidas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastrar_medidas);

        binding();


        btnSalvarMedidas.setOnClickListener( CallViewSalvarMedidas());






    }

    private View.OnClickListener CallViewSalvarMedidas() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String braco = editBraco.getText().toString();
                String antiBraco = editAntiBraco.getText().toString();
                String abdomen = editAbdomen.getText().toString();
                String quadril = editQuadril.getText().toString();
                String cintura = editCintura.getText().toString();
                String coxa = editCoxa.getText().toString();
                String perna = editPerna.getText().toString();

                if(braco.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Braco não pode ser vazio",Toast.LENGTH_LONG).show();
                    editBraco.requestFocus();
                    return;
                }
                else if(antiBraco.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Anti Braco não pode ser vazio",Toast.LENGTH_LONG).show();
                    editAntiBraco.requestFocus();
                    return;
                }
                else if(abdomen.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Abdomen não pode ser vazio",Toast.LENGTH_LONG).show();
                    editAbdomen.requestFocus();
                    return;
                }
                else if(quadril.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Quadril não pode ser vazio",Toast.LENGTH_LONG).show();
                    editQuadril.requestFocus();
                    return;
                }
                else if(cintura.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Cintura não pode ser vazio",Toast.LENGTH_LONG).show();
                    editCintura.requestFocus();
                    return;
                }
                else if(coxa.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Coxa não pode ser vazio",Toast.LENGTH_LONG).show();
                    editCoxa.requestFocus();
                    return;
                }
                else if(perna.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Perna não pode ser vazio",Toast.LENGTH_LONG).show();
                    editPerna.requestFocus();
                    return;
                }


                Medida medida = new Medida();
                Aluno aluno = getAluno();

                medida.setBraco(Double.parseDouble(braco));
                medida.setAntiBraco(Double.parseDouble(antiBraco));
                medida.setAbdomen(Double.parseDouble(abdomen));
                medida.setQuadril(Double.parseDouble(quadril));
                medida.setCintura(Double.parseDouble(cintura));
                medida.setCoxa(Double.parseDouble(coxa));
                medida.setPerna(Double.parseDouble(perna));
                medida.setAluno(aluno);


                MedidaDAO dao = new MedidaDAO(getApplicationContext());

                dao.open();

                int quantidadeMedidas = dao.totaldeCadaAluno(aluno.getId());

                if(quantidadeMedidas >=1){
                    Toast.makeText(getApplicationContext(),"Ja cadastrou as medidas!!",Toast.LENGTH_LONG).show();
                    dao.close();
                }else{
                    dao.inserir(medida);
                    dao.close();
                    Toast.makeText(getApplicationContext(),"Medidas Cadastradas com sucesso !!",Toast.LENGTH_LONG).show();
                    setResult(70);
                    finish();
                }


            }
        };
    }

    private void binding() {

        editBraco = findViewById(R.id.editBraco);
        editAntiBraco = findViewById(R.id.editAntiBraco);
        editAbdomen = findViewById(R.id.editAbdomen);
        editQuadril = findViewById(R.id.editQuadril);
        editCintura = findViewById(R.id.editCintura);
        editCoxa = findViewById(R.id.editCoxa);
        editPerna = findViewById(R.id.editPerna);
        btnSalvarMedidas = findViewById(R.id.btnSalvarMedidas);
    }


    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }
}