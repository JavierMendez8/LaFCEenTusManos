package com.example.LaFCE.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String BASE_DE_DATOS = "Contactos";
    private static final int VERSION = 1;

    public DataBaseHelper(Context contexto){
        super(contexto, BASE_DE_DATOS, null, VERSION);
    }

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE contacto (_id INTEGER PRIMARY KEY,"+"nombre TEXT, mail TEXT, mensaje LONG);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int versionAnterior, int nuevaVersion){
        db.execSQL("ALTER TABLE contacto ADD COLUMN bandera BLOB");
    }
}
