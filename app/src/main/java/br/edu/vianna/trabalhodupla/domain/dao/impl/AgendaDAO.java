package br.edu.vianna.trabalhodupla.domain.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.DaoGenerics;
import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public class AgendaDAO extends DaoGenerics<AgendarAluno> {
    public AgendaDAO(Context context) {
        super(context);
    }

    public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public SimpleDateFormat hor = new SimpleDateFormat("HH:mm");

    @Override
    public void inserir(AgendarAluno obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_ID_ALUNO,obj.getAluno().getId());
        cv.put(DataBase.FIELD_DESCRICAO,obj.getDescricao());
        cv.put(DataBase.FIELD_DATA_AULA,sdf.format(obj.getDataAula()));
        cv.put("horaAula",hor.format(obj.getHoraAula()));

        conection.insert(DataBase.TABLE_AGENDA,null,cv);
    }

    @Override
    public void apagar(AgendarAluno obj) {

        String sql = "DELETE FROM " + DataBase.TABLE_AGENDA+
                " where "+ DataBase.FIELD_ID + " = "+ obj.getId();
        conection.execSQL(sql);

    }

    @Override
    public void editar(AgendarAluno obj) {

//        String sql = "UPDATE "+DataBase.TABLE_ALUNO+
//                " SET " + DataBase.FIELD_NOME +" = '"+obj.getNome()+"'," +
//                "" + DataBase.FIELD_ID_ALUNO +" = '"+obj.getIdade()+"'," +
//                "" + DataBase.FIELD_DESCRICAO +" = '"+obj.getAltura()+"'," +
//                "" + DataBase.FIELD_DATA_AULA +" = '"+obj.getPeso()+"' "+ "WHERE "+DataBase.FIELD_ID +" = "+obj.getId();
//
//        conection.execSQL(sql);
    }

    @Override
    public AgendarAluno buscar(int key) {

        String sql = "SELECT * FROM " + DataBase.TABLE_AGENDA+" WHERE "+ DataBase.FIELD_ID + " = "+ key;

        Cursor cons = conection.rawQuery(sql,null);


        AgendarAluno agendar = null;
        if(cons.moveToFirst()){
            agendar = new AgendarAluno();
            agendar.setAluno(new AlunoDAO(context).buscar(cons.getColumnIndex(DataBase.FIELD_ID_ALUNO)));
            agendar.setDescricao(cons.getString(cons.getColumnIndex(DataBase.FIELD_DESCRICAO)));


            // MUDAR DEPOIS PARA CONS GET INT ( igual do metodo buscarTodos())
            try {
                agendar.setDataAula( sdf.parse( cons.getString(cons.getColumnIndex(DataBase.FIELD_DATA_AULA)) ) );
            } catch (ParseException e) {
                agendar.setDataAula(new Date());
            }

            try {
                agendar.setHoraAula( sdf.parse( cons.getString(cons.getColumnIndex(DataBase.FIELD_HORA_AULA)) ) );
            } catch (ParseException e) {
                agendar.setHoraAula(new Date());
            }

        }

        return agendar;
    }

    @Override
    public ArrayList<AgendarAluno> buscarTodos() {

        String sql = "select * from  agenda";

        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<AgendarAluno> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            AgendarAluno ala = new AgendarAluno();
            ala.setId( cons.getInt(0 ) );
            ala.setAluno( new AlunoDAO(context).buscar(cons.getInt(1 ) ) );
            ala.setDescricao( cons.getString(2) );
            try {
                ala.setDataAula(  sdf.parse( cons.getString(3) ) );
            } catch (ParseException e) {
                e.getMessage();
            }

            try {
                ala.setHoraAula(  hor.parse( cons.getString(4) ) );
            } catch (ParseException e) {
                e.getMessage();
            }


            lista.add(ala);
        }

        return lista;
    }

    @Override
    public int total() {

        String sql = "select count(*) from "+DataBase.TABLE_AGENDA;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);
    }
}
