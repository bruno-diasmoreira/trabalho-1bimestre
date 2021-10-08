package br.edu.vianna.trabalhodupla.domain.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public static final String PERSONAL_DB = "bancoPersonal.db";
    public static final int VERSION = 3;

    public DataBase(@Nullable Context context) {
        super(context, PERSONAL_DB, null, VERSION);
    }


    // Tabela ALUNO
    public static final String TABLE_ALUNO = "aluno";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NOME = "nome";
    public static final String FIELD_IDADE = "idade";
    public static final String FIELD_ALTURA = "altura";
    public static final String FIELD_PESO = "peso";


    public static final String CREATE_TABLE_ALUNO = "create table " + TABLE_ALUNO + "(" + FIELD_ID + " integer primary key autoincrement" +
            "," + FIELD_NOME + " text not null," +
            FIELD_IDADE + " integer not null," +
            FIELD_ALTURA + " double not null," +
            FIELD_PESO + " double not null);";




    //TABELA AGENDA
    public static final String TABLE_AGENDA = "agenda";

    public static final String FIELD_ID_ALUNO = "idAluno";
    public static final String FIELD_DESCRICAO = "descricao";
    public static final String FIELD_DATA_AULA = "dataAula";
    public static final String FIELD_HORA_AULA = "horaAula";


    public static final String CREATE_TABLE_AGENDA = "create table " + TABLE_AGENDA + "(" + FIELD_ID + " integer primary key autoincrement" +
            "," + FIELD_ID_ALUNO + " integer not null," +
            FIELD_DESCRICAO + " text not null," +
            FIELD_DATA_AULA + " text not null," +
            FIELD_HORA_AULA + " text not null);";





    // CRIANDO A TABELA FICHA
    public static final String TABLE_FICHA = "ficha";
    public static final String FIELD_EHPEITO = "ehPeito";
    public static final String FIELD_EHTRICEPS = "ehTriceps";
    public static final String FIELD_EHCOSTAS = "ehCostas";
    public static final String FIELD_EHBICEPS = "ehBiceps";
    public static final String FIELD_EHPERNAS = "ehPernas";
    public static final String FIELD_EHOMBRO = "ehOmbro";

    public static final String CREATE_TABLE_FICHA = "create table " + TABLE_FICHA + "(" + FIELD_ID + " integer primary key autoincrement" +
            "," + FIELD_DESCRICAO + " text not null," +
            FIELD_EHPEITO + " integer not null," +
            FIELD_EHTRICEPS + " integer not null," +
            FIELD_EHCOSTAS + " integer not null, " +
            FIELD_EHBICEPS + " integer not null," +
            FIELD_EHPERNAS + " integer not null," +
            FIELD_EHOMBRO + " integer not null," +
            FIELD_ID_ALUNO + " integer not null);";




    //TABELA EXERCICIOS
    public static final String TABLE_EXERCICIOS = "exercicios";

    public static final String FIELD_SERIE = "serie";
    public static final String FIELD_REPETICAO = "repeticao";
    public static final String FIELD_ID_FICHA = "idFicha";

    public static final String CREATE_TABLE_EXERCICIOS = "create table " + TABLE_EXERCICIOS + "(" + FIELD_ID + " integer primary key autoincrement" +
            "," + FIELD_DESCRICAO + " text not null," +
            FIELD_SERIE + " text not null," +
            FIELD_REPETICAO + " text not null," +
            FIELD_ID_FICHA + " integer not null);";



    // TABELA MEDIDAS
    public static final String TABLE_MEDIDA = "medida";
    public static final String FIELD_BRACO = "braco";
    public static final String FIELD_ANTI_BRACO = "antiBraco";
    public static final String FIELD_ABDOMEN = "abdomen";
    public static final String FIELD_QUADRIL = "quadril";
    public static final String FIELD_CINTURA = "cintura";
    public static final String FIELD_COXA = "coxa";
    public static final String FIELD_PERNA = "perna";

    public static final String CREATE_TABLE_MEDIDA = "create table " + TABLE_MEDIDA + "(" + FIELD_ID + " integer primary key autoincrement" +
            "," + FIELD_BRACO + " double not null," +
            FIELD_ANTI_BRACO + " double not null," +
            FIELD_ABDOMEN + " double not null," +
            FIELD_QUADRIL + " double not null," +
            FIELD_CINTURA + " double not null," +
            FIELD_COXA + " double not null," +
            FIELD_PERNA + " double not null," +
            FIELD_ID_ALUNO + " integer not null);";










    @Override
    public void onCreate(SQLiteDatabase db) {

        //CRIANDO E POPULANDO A TABELA ALUNOS
        db.execSQL(CREATE_TABLE_ALUNO);
        db.execSQL("insert into aluno(nome,idade,altura,peso) values ('Ronaldo','23','1.80','85')");
        db.execSQL("insert into aluno(nome,idade,altura,peso) values ('Pedrin','32','1.95','105')");
        db.execSQL("insert into aluno(nome,idade,altura,peso) values ('Xandao','19','2','150')");
        db.execSQL("insert into aluno(nome,idade,altura,peso) values ('Juliana','45','1.65','66')");



        //CRIANDO TABELA AGENDA
        db.execSQL(CREATE_TABLE_AGENDA);

        //CRIANDO TABELA FICHA
        db.execSQL(CREATE_TABLE_FICHA);


        //CRIANDO TABELA EXERCICIOS
        db.execSQL(CREATE_TABLE_EXERCICIOS);

        //CRIANDO TABELA EXERCICIOS
        db.execSQL(CREATE_TABLE_MEDIDA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoMobile, int versaoApp) {
        db.execSQL("DROP TABLE if exists " + TABLE_ALUNO);
        db.execSQL("DROP TABLE if exists " + TABLE_AGENDA);
        db.execSQL("DROP TABLE if exists " + TABLE_FICHA);
        db.execSQL("DROP TABLE if exists " + TABLE_EXERCICIOS);
        db.execSQL("DROP TABLE if exists " + TABLE_MEDIDA);
        onCreate(db);
    }
}
