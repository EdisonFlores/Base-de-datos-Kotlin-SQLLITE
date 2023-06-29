package com.example.basededatos
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class ayudaDb(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "nombres.db"
        const val TABLE_NAME = "tnombres"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "nombreU"
        const val COLUMN_APELLIDO = "apellido"
        const val COLUMN_EDAD = "edad"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_APELLIDO + " TEXT," +
                COLUMN_EDAD + " INTEGER" + ")")
        db?.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addName(persona: Persona) {
        val values = ContentValues()
        values.put(COLUMN_NAME, persona.nombre)
        values.put(COLUMN_APELLIDO, persona.apellido)
        values.put(COLUMN_EDAD, persona.edad)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT $COLUMN_ID, $COLUMN_NAME, $COLUMN_APELLIDO, $COLUMN_EDAD FROM $TABLE_NAME", null)
    }
}

data class Persona(val nombre: String, val apellido: String, val edad: Int)
