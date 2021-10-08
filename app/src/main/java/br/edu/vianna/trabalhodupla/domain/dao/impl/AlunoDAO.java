package br.edu.vianna.trabalhodupla.domain.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.Aluno;
import br.edu.vianna.trabalhodupla.domain.dao.DaoGenerics;
import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public class AlunoDAO extends DaoGenerics<Aluno> {


    public AlunoDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Aluno obj) {

        ContentValues cv = new ContentValues();
        cv.put(DataBase.FIELD_ID,obj.getId());
        cv.put(DataBase.FIELD_NOME,obj.getId());

        conection.insert(DataBase.TABLE_ALUNO,null,cv);
    }

    @Override
    public void apagar(Aluno obj) {

        String sql = "DELETE FROM " + DataBase.TABLE_ALUNO+
                " where "+ DataBase.FIELD_ID + " = "+ obj.getId();
        conection.execSQL(sql);

    }

    @Override
    public void editar(Aluno obj) {

        String sql = "UPDATE "+DataBase.TABLE_ALUNO+
                " SET " + DataBase.FIELD_NOME +" = '"+obj.getNome()+"'," +
                "" + DataBase.FIELD_IDADE +" = '"+obj.getIdade()+"'," +
                "" + DataBase.FIELD_ALTURA +" = '"+obj.getAltura()+"'," +
                "" + DataBase.FIELD_PESO +" = '"+obj.getPeso()+"' "+ "WHERE "+DataBase.FIELD_ID +" = "+obj.getId();

        conection.execSQL(sql);

    }

    @Override
    public Aluno buscar(int key) {

        String sql = "SELECT * FROM " + DataBase.TABLE_ALUNO+" WHERE "+ DataBase.FIELD_ID + " = "+ key;

        Cursor cons = conection.rawQuery(sql,null);


        Aluno alu = null;
        if(cons.moveToFirst()){
            alu = new Aluno();
            alu.setNome(cons.getString(cons.getColumnIndex(DataBase.FIELD_NOME)));
            alu.setId(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ID)));
            alu.setIdade(cons.getInt(cons.getColumnIndex(DataBase.FIELD_IDADE)));
            alu.setAltura(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ALTURA)));
            alu.setPeso(cons.getInt(cons.getColumnIndex(DataBase.FIELD_PESO)));
        }

        return alu;
    }

    public Aluno buscarPeloNome(String key) {

        String[] selectionArgs = new String[]{key};
        Cursor cons = conection.rawQuery(" SELECT * FROM " + DataBase.TABLE_ALUNO + " WHERE " + DataBase.FIELD_NOME + " = ? ", selectionArgs);

        Aluno alu = null;
        if(cons.moveToFirst()){
            alu = new Aluno();
            alu.setNome(cons.getString(cons.getColumnIndex(DataBase.FIELD_NOME)));
            alu.setId(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ID)));
            alu.setIdade(cons.getInt(cons.getColumnIndex(DataBase.FIELD_IDADE)));
            alu.setAltura(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ALTURA)));
            alu.setPeso(cons.getInt(cons.getColumnIndex(DataBase.FIELD_PESO)));
        }

        return alu;
    }

    @Override
    public ArrayList<Aluno> buscarTodos() {

        String sql = "SELECT * FROM " + DataBase.TABLE_ALUNO;
        Cursor cons = conection.rawQuery(sql,null);

        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        while(cons.moveToNext() ){
            Aluno alu = new Aluno();
            alu.setNome(cons.getString(cons.getColumnIndex(DataBase.FIELD_NOME)));
            alu.setId(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ID)));
            alu.setIdade(cons.getInt(cons.getColumnIndex(DataBase.FIELD_IDADE)));
            alu.setAltura(cons.getInt(cons.getColumnIndex(DataBase.FIELD_ALTURA)));
            alu.setPeso(cons.getInt(cons.getColumnIndex(DataBase.FIELD_PESO)));
            listaAlunos.add(alu);
        }
        return listaAlunos;
    }

    @Override
    public int total() {

        String sql = "select count(*) from " + DataBase.TABLE_ALUNO;

        Cursor cons = conection.rawQuery(sql,null);

        cons.moveToFirst();

        return cons.getInt(cons.getColumnIndex(DataBase.FIELD_ID));
    }
}
