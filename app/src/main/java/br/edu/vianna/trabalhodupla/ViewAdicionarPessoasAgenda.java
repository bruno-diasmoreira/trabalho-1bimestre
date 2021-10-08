package br.edu.vianna.trabalhodupla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AgendaDAO;
import br.edu.vianna.trabalhodupla.domain.dao.impl.AlunoDAO;
import br.edu.vianna.trabalhodupla.utils.DateFragment;

public class ViewAdicionarPessoasAgenda extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private Spinner spinnerAlunos;
    private EditText editDescricao;
    private ImageView imgCalendario,imgHora;
    private TextView tvData,tvHora;
    private Button btnSalvarAgenda;


    //variaveis horario
    int t1Hora,t1Minuto;

    public SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");




    private final static int BOTAO_SALVAR_VIEW_AGENDAR = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adicionar_pessoas_agenda);

        binding();



        //ADAPTER DO SPINNER DE ALUNOS
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayAlunos());
        spinnerAlunos.setAdapter(arrayAdapter);

        // CHAMAR A TELA DE CALENDARIO
        imgCalendario.setOnClickListener( callViewData() );

        //SALVAR A AGENDA ALUNOS QUANDO CLICAR NO BUTTON
        btnSalvarAgenda.setOnClickListener( callViewSalvarAgenda());


        //CHAMAR A TELA DE HORARIOS
        imgHora.setOnClickListener( callViewHora() );


    }

    private View.OnClickListener callViewHora() {
        return  new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ViewAdicionarPessoasAgenda.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        t1Hora = i;
                        t1Minuto = i1;

                        Calendar calendar = Calendar.getInstance();

                        calendar.set(0,0,0,t1Hora,t1Minuto);


                        //SETANDO O HORARIO
                        Date date = calendar.getTime();
                        String horaFormatada = df.format(date);

                        tvHora.setText(horaFormatada);



                        //tvHora.setText(android.text.format.DateFormat.format("hh:mm aa", calendar));
                    }
                },24,0,true);

                timePickerDialog.updateTime(t1Hora,t1Minuto);
                timePickerDialog.show();
            }
        };
    }

    private View.OnClickListener callViewSalvarAgenda() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String descricao = editDescricao.getText().toString();
                String data = tvData.getText().toString();
                String hora = tvHora.getText().toString();


                if(descricao.equals("")){
                    Toast.makeText(getApplicationContext(), "Campo descrição não pode ser vazio",Toast.LENGTH_LONG).show();
                    editDescricao.requestFocus();
                    return;
                }
                if(data.equals("")){
                    Toast.makeText(getApplicationContext(), "Selecione uma data",Toast.LENGTH_LONG).show();
                    return;
                }
                if(hora.equals("")){
                    Toast.makeText(getApplicationContext(), "Selecione uma hora",Toast.LENGTH_LONG).show();
                    return;
                }

                // COMPARA PARA VER SE JA TEM AULA MARCADA NO DIA
                if(compararAulaHora()){
                    Toast.makeText(getApplicationContext(),"Horário já marcado",Toast.LENGTH_LONG).show();
                    return;
                }



                //PREENCHER O OBJETO AGENDAR ALUNO

                AgendarAluno agendar = new AgendarAluno();
                String a = spinnerAlunos.getSelectedItem().toString();

                AlunoDAO dao = new AlunoDAO(getApplicationContext());

                dao.open();
                Aluno aluno = dao.buscarPeloNome(a);
                dao.close();


                try {

                    Date novaData = sdf.parse(data);

                    Date novaHora = df.parse(hora);

                    agendar.setDataAula(novaData);
                    agendar.setHoraAula(novaHora);
                    agendar.setDescricao(editDescricao.getText().toString());
                    agendar.setAluno(aluno);

                } catch (ParseException e) {
                    e.printStackTrace();
                }



                //INSERIR O OBJETO NO BANCO DE DADOS
                AgendaDAO agenDAO = new AgendaDAO(getApplicationContext());

                agenDAO.open();
                agenDAO.inserir(agendar);
                agenDAO.close();

                setResult(BOTAO_SALVAR_VIEW_AGENDAR);
                finish();


            }
        };
    }


    private View.OnClickListener callViewData() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFragment df = new DateFragment();
                df.show(getSupportFragmentManager(),"Escolha a Data");
            }
        };
    }

    private void binding() {
        spinnerAlunos = findViewById(R.id.spinnerAlunos);
        editDescricao = findViewById(R.id.editDescricao);
        imgCalendario = findViewById(R.id.imgCalendario);
        tvData = findViewById(R.id.tvData);
        btnSalvarAgenda = findViewById(R.id.btnSalvarAgenda);
        imgHora = findViewById(R.id.imgHora);
        tvHora = findViewById(R.id.tvHora);
    }



    public List<String> arrayAlunos(){
        List<String> alunos = new ArrayList<>();

        AlunoDAO dao = new AlunoDAO(getApplicationContext());

        dao.open();
        List<Aluno> alunosBanco = dao.buscarTodos();
        dao.close();

        for(int i = 0; i < alunosBanco.size(); i++){
            alunos.add(alunosBanco.get(i).getNome());
        }


        return alunos;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {

        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR,ano);
        c.set(Calendar.MONTH,mes);
        c.set(Calendar.DAY_OF_MONTH,dia);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        tvData.setText(sdf.format(c.getTime()));
    }


    public boolean compararAulaHora(){

        boolean ehIgual = false;

        AgendaDAO ageDAO = new AgendaDAO(getApplicationContext());
        ageDAO.open();
        List<AgendarAluno> lista = ageDAO.buscarTodos();
        ageDAO.close();


        for(int i = 0; i < lista.size(); i++){

            if(sdf.format(lista.get(i).getDataAula()).equals(tvData.getText().toString())){
                if(df.format(lista.get(i).getHoraAula()).equals(tvHora.getText().toString())){
                    ehIgual = true;
                    break;
                }
            }
        }
        return ehIgual;
    }



}