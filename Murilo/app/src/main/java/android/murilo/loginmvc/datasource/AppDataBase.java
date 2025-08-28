package android.murilo.loginmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.murilo.loginmvc.api.AppUtil;
import android.murilo.loginmvc.datamodel.UsuarioDataModel;
import android.util.Log;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "MVC.sqlite";
    public static int version = 1;
    SQLiteDatabase db;
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, version);
        Log.i(AppUtil.TAG, "AppDataBase: Criando a Conexao!");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean insert(String tabela, ContentValues dados){
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e){
            e.getMessage();
        }
        return retorno;
    }
    public Boolean checkUserPassword(String username, String password){
        db = getWritableDatabase();
        boolean retorno = false;
        Cursor cursor = db.rawQuery("SELECT *FROM " + UsuarioDataModel.TABELA + " WHERE username = ?" +
                        " AND password = ?",
                    new String[]{username, password});
        return cursor.getCount() > 0;

    }
    public Boolean checkUser(String username){
        db = getWritableDatabase();
        boolean retorno = false;
        Cursor cursor = db.rawQuery("SELECT *FROM " +
                        UsuarioDataModel.TABELA + " WHERE email = ?",
                new String[]{username});
        return cursor.getCount() > 0;
    }

}
