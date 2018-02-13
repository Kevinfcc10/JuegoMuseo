package com.example.kevin.juegomuseo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniela on 12/19/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Versión de la base de datos
    private static final int DATABASE_VERSION =2;

    //nombre de la BDD
    private static final String DATABASE_NAME = "PLAYWITHANIMALS";

    //nombre de la tabla animales
    private static final String TABLE_ANIMALS = "animales";

    //nombres de las columnas
    private static final String KEY_COD_ANIMAL = "codAnimal";
    private static final String KEY_NAME_ANIMAL = "nomAnimal";
    private static final String KEY_DESC_ANIMAL = "descAnimal";
    private static final String KEY_IMG_ANIMAL = "imgAnimal";
    private static final String KEY_COD_ECOSISTEMA = "codEcosistema";


    //nombre de la tabla ECOSISTEMAS
    private static final String TABLE_ECOSYSTEM = "ecosistemas";

    //nombres de las columnas
    private static final String KEY_COD_ECOSYSTEM = "codEcosistema";
    private static final String KEY_NAME_ECOSYSTEM = "nomEcosistema";
    private static final String KEY_DESC_ECOSYSTEM = "descEcosistema";
    private static final String KEY_IMG_ECOSYSTEM = "imgEcosistema";
    private static final String KEY_REG_ECOSYSTEM = "regEcosistema";



    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ANIMALS_TABLE = "CREATE TABLE " + TABLE_ANIMALS +
                "("             + KEY_COD_ANIMAL + " INTEGER PRIMARY KEY," + KEY_NAME_ANIMAL + " TEXT," + KEY_DESC_ANIMAL + " TEXT," +
                KEY_IMG_ANIMAL + " TEXT,"+ KEY_COD_ECOSISTEMA + " TEXT"+")";


        String CREATE_ECOSYSTEMS_TABLE = "CREATE TABLE " + TABLE_ECOSYSTEM +
                "("             + KEY_COD_ECOSYSTEM + " INTEGER PRIMARY KEY," + KEY_NAME_ECOSYSTEM + " TEXT," + KEY_DESC_ECOSYSTEM + " TEXT," +
                KEY_REG_ECOSYSTEM + " TEXT,"+KEY_IMG_ECOSYSTEM + " TEXT,"+")";
        sqLiteDatabase.execSQL(CREATE_ANIMALS_TABLE);
        sqLiteDatabase.execSQL(CREATE_ECOSYSTEMS_TABLE);
        addEcosistema(new Ecosistema(1,"Mataje","","Oriente","mataje.png"));
        addAnimal(new Animal(1,"Tucan","ave del mataje","tucan_mataje.png","1"));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ECOSYSTEM);
        onCreate(sqLiteDatabase);

    }

    private void addAnimal(Animal animal){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COD_ANIMAL, animal.getCodAnimal());
        values.put(KEY_NAME_ANIMAL, animal.getNomAnimal());
        values.put(KEY_DESC_ANIMAL, animal.getDescAnimal());
        values.put(KEY_IMG_ANIMAL, animal.getImgAnimal());
        values.put(KEY_COD_ECOSISTEMA, animal.getCodEcosistema());

        db.insert(TABLE_ANIMALS,null,values);
        db.close();
    }
    private void addEcosistema(Ecosistema ecosistema){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COD_ECOSISTEMA, ecosistema.getCodEcosistema());
        values.put(KEY_NAME_ECOSYSTEM, ecosistema.getNomEcosistema());
        values.put(KEY_DESC_ECOSYSTEM, ecosistema.getDescEcosistema());
        values.put(KEY_IMG_ECOSYSTEM, ecosistema.getImgEcosistema());
        values.put(KEY_REG_ECOSYSTEM, ecosistema.getRegEcosistema());

        db.insert(TABLE_ECOSYSTEM,null,values);
        db.close();
    }

    public Animal getAnimal(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_ANIMALS, new String[]{KEY_COD_ANIMAL, KEY_NAME_ANIMAL, KEY_DESC_ANIMAL,KEY_IMG_ANIMAL, KEY_COD_ECOSISTEMA}, KEY_COD_ANIMAL + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Animal animal = new Animal(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4));

        return animal;
    }


    public Ecosistema getEcosistema (int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_ECOSYSTEM, new String[]{KEY_COD_ECOSISTEMA, KEY_NAME_ECOSYSTEM, KEY_DESC_ECOSYSTEM,KEY_REG_ECOSYSTEM, KEY_IMG_ECOSYSTEM}, KEY_COD_ANIMAL + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Ecosistema ecosistema= new Ecosistema(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4));

        return ecosistema;
    }




    public List<Animal> getAllAnimals(){
        List<Animal> animalList = new ArrayList<Animal>();

        String sql_select = "SELECT * FROM " + TABLE_ANIMALS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select, null);

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                Animal animal = new Animal();
                animal.setCodAnimal(Integer.parseInt(cursor.getString(0)));
                animal.setNomAnimal(cursor.getString(1));
                animal.setDescAnimal(cursor.getString(2));
                animal.setImgAnimal(cursor.getString(3));
                animal.setCodEcosistema(cursor.getString(4));

                animalList.add(animal);
            }
        }
        return animalList;
    }


    public List<Ecosistema> getAllEcosystems(){
        List<Ecosistema> ecosystemList = new ArrayList<Ecosistema>();

        String sql_select = "SELECT * FROM " + TABLE_ECOSYSTEM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select, null);

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                Ecosistema ecosistema = new Ecosistema();
                ecosistema.setCodEcosistema(Integer.parseInt(cursor.getString(0)));
                ecosistema.setNomEcosistema(cursor.getString(1));
                ecosistema.setDescEcosistema(cursor.getString(2));
                ecosistema.setRegEcosistema(cursor.getString(3));
                ecosistema.setImgEcosistema(cursor.getString(4));

                ecosystemList.add(ecosistema);
            }
        }
        return ecosystemList;
    }
}
