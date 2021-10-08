package br.edu.vianna.trabalhodupla.domain.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.AgendarAluno;
import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.dao.DaoGenerics;
import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public class FichaDAO extends DaoGenerics<Ficha> {
    public FichaDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Ficha obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_DESCRICAO,obj.getDescricao());
        cv.put(DataBase.FIELD_EHPEITO,obj.isEhPeito());
        cv.put(DataBase.FIELD_EHTRICEPS,obj.isEhTriceps());
        cv.put(DataBase.FIELD_EHCOSTAS,obj.isEhCostas());
        cv.put(DataBase.FIELD_EHBICEPS,obj.isEhBiceps());
        cv.put(DataBase.FIELD_EHPERNAS,obj.isEhPernas());
        cv.put(DataBase.FIELD_EHOMBRO,obj.isEhOmbro());
        cv.put(DataBase.FIELD_ID_ALUNO,obj.getAluno().getId());

        conection.insert(DataBase.TABLE_FICHA,null,cv);


    }

    @Override
    public void apagar(Ficha obj) {

    }

    @Override
    public void editar(Ficha obj) {

    }

    @Override
    public Ficha buscar(int key) {
        return null;
    }

    @Override
    public ArrayList<Ficha> buscarTodos() {
        String sql = "select * from  ficha";

        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Ficha> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Ficha ficha = new Ficha();
            ficha.setId( cons.getInt(0 ) );
            ficha.setDescricao( cons.getString(1) );
            ficha.setEhPeito( cons.getInt(2 ) == 1 );
            ficha.setEhTriceps( cons.getInt(3 ) == 1 );
            ficha.setEhCostas( cons.getInt(4 ) == 1 );
            ficha.setEhBiceps( cons.getInt(5 ) == 1 );
            ficha.setEhPernas( cons.getInt(6 ) == 1 );
            ficha.setEhOmbro( cons.getInt(7 ) == 1 );
            ficha.setAluno( new AlunoDAO(context).buscar(cons.getInt(8 ) ) );
            lista.add(ficha);
        }
        return lista;
    }

    public ArrayList<Ficha> buscarTodos(int id){

        //String sql = "select * from  ficha WHERE idAluno = 'id'";

        String sql = "select * from "+DataBase.TABLE_FICHA+
                " Where "+DataBase.FIELD_ID_ALUNO +" = "+id;



        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Ficha> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Ficha ficha = new Ficha();
            ficha.setId( cons.getInt(0 ) );
            ficha.setDescricao( cons.getString(1) );
            ficha.setEhPeito( cons.getInt(2 ) == 1 );
            ficha.setEhTriceps( cons.getInt(3 ) == 1 );
            ficha.setEhCostas( cons.getInt(4 ) == 1 );
            ficha.setEhBiceps( cons.getInt(5 ) == 1 );
            ficha.setEhPernas( cons.getInt(6 ) == 1 );
            ficha.setEhOmbro( cons.getInt(7 ) == 1 );
            ficha.setAluno( new AlunoDAO(context).buscar(cons.getInt(8 ) ) );
            lista.add(ficha);
        }
        return lista;


    }



    public int totaldeCadaAluno(int id){

        String sql = "select count(*) from "+DataBase.TABLE_FICHA+
                " Where "+DataBase.FIELD_ID_ALUNO +" = "+id;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);

    }


    @Override
    public int total()
    {
        String sql = "select count(*) from "+DataBase.TABLE_FICHA;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);
    }
}
