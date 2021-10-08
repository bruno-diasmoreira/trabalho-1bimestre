package br.edu.vianna.trabalhodupla.domain.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.edu.vianna.trabalhodupla.domain.database.DataBase;

public abstract class DaoGenerics<T> {

    protected Context context;
    private DataBase db;
    protected static SQLiteDatabase conection;

    public DaoGenerics(Context context){
        this.context = context;
    }

    public abstract void inserir(T obj);
    public abstract void apagar(T obj);
    public abstract void editar(T obj);
    public abstract T buscar(int key);
    public abstract ArrayList<T> buscarTodos();
    public abstract int total();


    public SQLiteDatabase getConection(){
        if(conection == null){
            open();
        }
        return conection;
    }


    public void open(){

        db = new DataBase(context);
        conection = db.getWritableDatabase();
    }

    public void close(){
        conection.close();
        db.close();
    }

}
