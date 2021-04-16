package com.example.supermercadotico.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BDHelper /*extends SQLiteOpenHelper */{

  /*  private static final String DATABASE_NAME = "supermercadosTico.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    SQLiteDatabase db;

    private final String DATABASE_PATH = context.getDatabasePath(DATABASE_NAME).getAbsolutePath(); //Retorna un tipo File o un tipo string, hay que ver cual Funca ak8
    private final String USER_TABLE = "usuario";


    public BDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        createDb();
    }
    @Override
    public void onCreate(SQLiteDatabase BD){

    }

    @Override
    public void onUpgrade(SQLiteDatabase BD, int oldVersion, int newVersion){

    }

    public void createDb(){
        boolean dbExist = checkDbExist();

        if(!dbExist){
            this.getReadableDatabase();
            copyDatabase();
        }
    }
    private boolean checkDbExist(){
        SQLiteDatabase sqLiteDatabase = null;

        try{
            String path = DATABASE_PATH + DATABASE_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception ex){
        }

        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
            return true;
        }

        return false;
    }

    private void copyDatabase(){
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);

            String outFileName = DATABASE_PATH + DATABASE_NAME;

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;

            while ((length = inputStream.read(b)) > 0){
                outputStream.write(b, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private SQLiteDatabase openDatabase(){
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close(){
        if(db != null){
            db.close();
        }
    }

    public boolean checkUserExist(String username, String password){
        //Bien chanchoso, pero es lo que hay... Aparantemente no existen los SPS en sqlite
        String query= "SELECT COUNT(*) FROM USUARIO WHERE identificacion = "+username+" AND CONTRASENA = "+password;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        cursor.close();
        close();

        return count > 0;
    }*/

}
