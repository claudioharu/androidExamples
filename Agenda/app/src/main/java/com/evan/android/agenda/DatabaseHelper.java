package com.evan.android.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by laila-usr on 05/11/2016.
 */
public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "agendaDB";

    private static final String TABELA_PESSOAS = "pessoas";

    public static final String COLUNA_IDPESSOA = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TELEFONE = "telefone";

    private static final String CRIA_TABELAPESSOAS =
            "create table "+ TABELA_PESSOAS +" ("
                    + COLUNA_IDPESSOA +" integer primary key autoincrement, "
                    + COLUNA_NOME + " varchar(75) not null, "
                    + COLUNA_TELEFONE + " varchar(90) not null, "
                    +"UNIQUE ("+ COLUNA_NOME + "));";

    public DatabaseHelper(Context context) {
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Cria", "passou aqui3.");

        db.execSQL(CRIA_TABELAPESSOAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CRIA_TABELAPESSOAS);
        onCreate(db);
    }

    //function to fill  People
    public boolean insertPessoa(String nome, String telefone) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUNA_NOME, nome);
        contentValues.put(COLUNA_TELEFONE, telefone);

        long result = db.insert(TABELA_PESSOAS, null, contentValues);

        db.close();

        if(result == -1)
            return false;
        else
            return true;

    }

    public int removePessoa(String nome){
        SQLiteDatabase db = this.getReadableDatabase();
        int result = db.delete(TABELA_PESSOAS, COLUNA_NOME + "= ?", new String[]{nome});
        return result;
    }

    public int updatePessoa(String nome, String tel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, nome);
        values.put(COLUNA_TELEFONE, tel);

        int result = db.update(TABELA_PESSOAS, values, COLUNA_NOME + "= ?", new String[]{nome} );

        db.close();
        return result;
    }

    //Used to display infos of Students
    public ArrayList<ItemPeople> loadDataToFillList(){

        ArrayList<ItemPeople>  list = new ArrayList<ItemPeople>();


        SQLiteDatabase db = this.getReadableDatabase();

        String[] campos =  {COLUNA_IDPESSOA, COLUNA_NOME, COLUNA_TELEFONE};

        Cursor cursor = db.query(TABELA_PESSOAS, campos, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                //Loading data from cursor
                String id = cursor.getString(cursor.getColumnIndex(COLUNA_IDPESSOA));
                String name = cursor.getString(cursor.getColumnIndex(COLUNA_NOME));
                String tel = cursor.getString(cursor.getColumnIndex(COLUNA_TELEFONE));

                //Fill item
                // String colId, String colName, String colAddress, String colSchool, String colShift, String colPrice)
                ItemPeople data = new ItemPeople(id, name, tel);

                //Fill list
                list.add(data);

                // do what ever you want here
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;

    }
}
