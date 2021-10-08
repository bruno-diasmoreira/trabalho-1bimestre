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

public class ViewAtualizarMedidas extends AppCompatActivity {

    private EditText edtAtualizarBraco,edtAtualizarAntiBraco,edtAtualizarAbdomen,edtAtualizarQuadril,edtAtualizarCintura,
            edtAtualizarCoxa,edtAtualizarPerna;

    private Button btnAtualizarMedidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_medidas);

        binding();


        btnAtualizarMedidas.setOnClickListener(CallViewAtualizarMedidas());

        preencherCampos();



    }

    public void preencherCampos(){

        MedidaDAO dao = new MedidaDAO(getApplicationContext());

        dao.open();

        Medida medida = dao.buscar(getAluno().getId());
        dao.close();

        edtAtualizarBraco.setText(""+medida.getBraco());
        edtAtualizarAntiBraco.setText(""+medida.getAntiBraco());
        edtAtualizarAbdomen.setText(""+medida.getAbdomen());
        edtAtualizarQuadril.setText(""+medida.getQuadril());
        edtAtualizarCintura.setText(""+medida.getCintura());
        edtAtualizarCoxa.setText(""+medida.getCoxa());
        edtAtualizarPerna.setText(""+medida.getPerna());



    }





    private View.OnClickListener CallViewAtualizarMedidas() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String braco = edtAtualizarBraco.getText().toString();
                String antiBraco = edtAtualizarAntiBraco.getText().toString();
                String abdomen = edtAtualizarAbdomen.getText().toString();
                String quadril = edtAtualizarQuadril.getText().toString();
                String cintura = edtAtualizarCintura.getText().toString();
                String coxa = edtAtualizarCoxa.getText().toString();
                String perna = edtAtualizarPerna.getText().toString();

                if(braco.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Braco não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarBraco.requestFocus();
                    return;
                }
                else if(antiBraco.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Anti Braco não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarAntiBraco.requestFocus();
                    return;
                }
                else if(abdomen.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Abdomen não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarAbdomen.requestFocus();
                    return;
                }
                else if(quadril.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Quadril não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarQuadril.requestFocus();
                    return;
                }
                else if(cintura.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Cintura não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarCintura.requestFocus();
                    return;
                }
                else if(coxa.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Coxa não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarCoxa.requestFocus();
                    return;
                }
                else if(perna.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Perna não pode ser vazio",Toast.LENGTH_LONG).show();
                    edtAtualizarPerna.requestFocus();
                    return;
                }



                MedidaDAO dao = new MedidaDAO(getApplicationContext());

                dao.open();

                Medida medida = dao.buscar(getAluno().getId());



                medida.setBraco(Double.parseDouble(braco));
                medida.setAntiBraco(Double.parseDouble(antiBraco));
                medida.setAbdomen(Double.parseDouble(abdomen));
                medida.setQuadril(Double.parseDouble(quadril));
                medida.setCintura(Double.parseDouble(cintura));
                medida.setCoxa(Double.parseDouble(coxa));
                medida.setPerna(Double.parseDouble(perna));
                medida.setAluno(getAluno());

                dao.editar(medida);
                dao.close();
                setResult(71);
                finish();
                Toast.makeText(getApplicationContext(),"Medidas atualizada com sucesso",Toast.LENGTH_LONG).show();

            }
        };
    }

    private void binding() {

        edtAtualizarBraco = findViewById(R.id.edtAtualizarBraco);
        edtAtualizarAntiBraco = findViewById(R.id.edtAtualizarAntiBraco);
        edtAtualizarAbdomen = findViewById(R.id.edtAtualizarAbdomen);
        edtAtualizarQuadril = findViewById(R.id.edtAtualizarQuadril);
        edtAtualizarCintura = findViewById(R.id.edtAtualizarCintura);
        edtAtualizarCoxa = findViewById(R.id.edtAtualizarCoxa);
        edtAtualizarPerna = findViewById(R.id.edtAtualizarPerna);
        btnAtualizarMedidas = findViewById(R.id.btnAtualizarMedidas);




    }


    public Aluno getAluno(){
        Aluno alun;
        Intent it = new Intent();
        alun = (Aluno)getIntent().getExtras().getSerializable("aluno");
        return alun;
    }

}