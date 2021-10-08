package br.edu.vianna.trabalhodupla.domain.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.Exercicios;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.DaoGenerics;
import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public class ExerciciosDAO extends DaoGenerics<Exercicios> {
    public ExerciciosDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Exercicios obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_DESCRICAO,obj.getDescricao());
        cv.put(DataBase.FIELD_SERIE,obj.getSerie());
        cv.put(DataBase.FIELD_REPETICAO,obj.getRepeticao());
        cv.put(DataBase.FIELD_ID_FICHA,obj.getFicha().getId());
        conection.insert(DataBase.TABLE_EXERCICIOS,null,cv);

    }

    @Override
    public void apagar(Exercicios obj) {

    }

    @Override
    public void editar(Exercicios obj) {

    }

    @Override
    public Exercicios buscar(int key) {
        return null;
    }

    @Override
    public ArrayList<Exercicios> buscarTodos() {

        String sql = "select * from  exercicios";

        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Exercicios> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Exercicios exercicios = new Exercicios();
            exercicios.setId( cons.getInt(0 ) );
            exercicios.setDescricao( cons.getString(1) );
            exercicios.setSerie( cons.getString(2) );
            exercicios.setRepeticao( cons.getString(3) );
            exercicios.setFicha( new FichaDAO(context).buscar(cons.getInt(4 ) ) );
            lista.add(exercicios);
        }
        return lista;

    }

    public ArrayList<Exercicios> buscarTodos(int id) {

        String sql = "select * from "+DataBase.TABLE_EXERCICIOS+
                " Where "+DataBase.FIELD_ID_FICHA +" = "+id;

        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Exercicios> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Exercicios exercicios = new Exercicios();
            exercicios.setId( cons.getInt(0 ) );
            exercicios.setDescricao( cons.getString(1) );
            exercicios.setSerie( cons.getString(2) );
            exercicios.setRepeticao( cons.getString(3) );
            exercicios.setFicha( new FichaDAO(context).buscar(cons.getInt(4 ) ) );
            lista.add(exercicios);
        }
        return lista;

    }




    @Override
    public int total() {
        String sql = "select count(*) from "+DataBase.TABLE_EXERCICIOS;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);
    }
}
