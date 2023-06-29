package com.example.basededatos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAgregar: Button = findViewById(R.id.btnAgregar)
        val btnTodos: Button = findViewById(R.id.btnTodos)
        val etNombre: EditText = findViewById(R.id.etNombre)
        val etApellido: EditText = findViewById(R.id.etApellido)
        val etEdad: EditText = findViewById(R.id.etedad)
        val tvMuestraNombre: TextView = findViewById(R.id.tvMuestraNombre)

        btnAgregar.setOnClickListener {
            val dbHandler = ayudaDb(this, null)
            val persona = Persona(etNombre.text.toString(), etApellido.text.toString(), etEdad.text.toString().toInt())
            dbHandler.addName(persona)
            Toast.makeText(this, "Se agregó a la base de datos a: " + persona.nombre, Toast.LENGTH_LONG).show()
            etNombre.setText("")
            etApellido.setText("")
            etEdad.setText("")
        }

        btnTodos.setOnClickListener {
            tvMuestraNombre.text = ""
            val dbHandler = ayudaDb(this, null)
            val cursor = dbHandler.getAllName()
            if (cursor != null) {
                cursor.moveToFirst()
                tvMuestraNombre.append("ID | Nombre | Apellido | Edad\n")
                tvMuestraNombre.append("------------------------------\n")
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(ayudaDb.COLUMN_ID))
                    val nombre = cursor.getString(cursor.getColumnIndex(ayudaDb.COLUMN_NAME))
                    val apellido = cursor.getString(cursor.getColumnIndex(ayudaDb.COLUMN_APELLIDO))
                    val edad = cursor.getInt(cursor.getColumnIndex(ayudaDb.COLUMN_EDAD))
                    tvMuestraNombre.append("$id | $nombre | $apellido | $edad\n")
                } while (cursor.moveToNext())
                cursor.close()
            }
        }
    }
}