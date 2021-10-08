package br.edu.vianna.trabalhodupla.domain.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.Ficha;
import br.edu.vianna.trabalhodupla.domain.Medida;
import br.edu.vianna.trabalhodupla.domain.dao.DaoGenerics;
import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public class MedidaDAO extends DaoGenerics<Medida> {
    public MedidaDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Medida obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_BRACO,obj.getBraco());
        cv.put(DataBase.FIELD_ANTI_BRACO,obj.getAntiBraco());
        cv.put(DataBase.FIELD_ABDOMEN,obj.getAbdomen());
        cv.put(DataBase.FIELD_QUADRIL,obj.getQuadril());
        cv.put(DataBase.FIELD_CINTURA,obj.getCintura());
        cv.put(DataBase.FIELD_COXA,obj.getCoxa());
        cv.put(DataBase.FIELD_PERNA,obj.getPerna());
        cv.put(DataBase.FIELD_ID_ALUNO,obj.getAluno().getId());

        conection.insert(DataBase.TABLE_MEDIDA,null,cv);


    }

    @Override
    public void apagar(Medida obj) {

    }

    @Override
    public void editar(Medida obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_BRACO,obj.getBraco());
        cv.put(DataBase.FIELD_ANTI_BRACO,obj.getAntiBraco());
        cv.put(DataBase.FIELD_ABDOMEN,obj.getAbdomen());
        cv.put(DataBase.FIELD_QUADRIL,obj.getQuadril());
        cv.put(DataBase.FIELD_CINTURA,obj.getCintura());
        cv.put(DataBase.FIELD_COXA,obj.getCoxa());
        cv.put(DataBase.FIELD_PERNA,obj.getPerna());
        cv.put(DataBase.FIELD_ID_ALUNO,obj.getAluno().getId());

        String where = "id = ?";
        String[] whereArgs = {Integer.toString(obj.getAluno().getId())};

        conection.update("medida",cv,where,whereArgs);
    }

    @Override
    public Medida buscar(int key) {

        String sql = "select * from "+DataBase.TABLE_MEDIDA+
                " Where "+DataBase.FIELD_ID_ALUNO +" = "+key;

        Cursor cons = conection.rawQuery(sql,null);

        Medida medida = null;

        if(cons.moveToFirst()){
            medida = new Medida();
            medida.setId( cons.getInt(0 ) );
            medida.setBraco( cons.getDouble(1) );
            medida.setAntiBraco( cons.getDouble(2) );
            medida.setAbdomen( cons.getDouble(3) );
            medida.setQuadril( cons.getDouble(4) );
            medida.setCintura( cons.getDouble(5) );
            medida.setCoxa( cons.getDouble(6) );
            medida.setPerna( cons.getDouble(7) );
            medida.setAluno( new AlunoDAO(context).buscar(cons.getInt(8 ) ) );
        }
        return medida;
    }

    @Override
    public ArrayList<Medida> buscarTodos() {

        String sql = "select * from  medida";

        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Medida> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Medida medida = new Medida();
            medida.setId( cons.getInt(0 ) );
            medida.setBraco( cons.getDouble(1) );
            medida.setAntiBraco( cons.getDouble(2) );
            medida.setAbdomen( cons.getDouble(3) );
            medida.setQuadril( cons.getDouble(4) );
            medida.setCintura( cons.getDouble(5) );
            medida.setCoxa( cons.getDouble(6) );
            medida.setPerna( cons.getDouble(7) );
            medida.setAluno( new AlunoDAO(context).buscar(cons.getInt(8 ) ) );
            lista.add(medida);
        }
        return lista;
    }

    public ArrayList<Medida> buscarTodos(int id){

        String sql = "select * from "+DataBase.TABLE_MEDIDA+
                " Where "+DataBase.FIELD_ID_ALUNO +" = "+id;



        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Medida> lista = new ArrayList<>();

        while (cons.moveToNext() ){
            Medida medida = new Medida();
            medida.setId( cons.getInt(0 ) );
            medida.setBraco( cons.getDouble(1) );
            medida.setAntiBraco( cons.getDouble(2) );
            medida.setAbdomen( cons.getDouble(3) );
            medida.setQuadril( cons.getDouble(4) );
            medida.setCintura( cons.getDouble(5) );
            medida.setCoxa( cons.getDouble(6) );
            medida.setPerna( cons.getDouble(7) );
            medida.setAluno( new AlunoDAO(context).buscar(cons.getInt(8 ) ) );
            lista.add(medida);
        }
        return lista;
    }



    public int totaldeCadaAluno(int id){

        String sql = "select count(*) from "+DataBase.TABLE_MEDIDA+
                " Where "+DataBase.FIELD_ID_ALUNO +" = "+id;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);

    }




    @Override
    public int total() {

        String sql = "select count(*) from "+DataBase.TABLE_MEDIDA;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(0);
    }
}
