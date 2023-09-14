package com.example.listatareas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var alerta : AlertDialog.Builder
    private lateinit var lista: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvtareas : ListView = findViewById(R.id.lvTareas)
        lista = mutableListOf()

        lista.add("Lunes")
        lista.add("Martes")
        lista.add("Miercoles")
        lista.add("Jueves")
        lista.add("Viernes")
        lista.add("Sabado")
        lista.add("Domingo")

        val adapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,
            android.R.layout.simple_list_item_1,
            lista
        )

        lvtareas.adapter= adapter
        configurarAlerta()

        val fabNuevo : FloatingActionButton = findViewById(R.id.fabNuevo)

        fabNuevo.setOnClickListener {
            alerta.show()
        }
    }
    private fun configurarAlerta(){
        alerta = AlertDialog.Builder(this)

        alerta.setTitle(getString(R.string.mis_tareas))

        val layout = layoutInflater.inflate(R.layout.tarea,null)
        val etTarea : EditText = layout.findViewById(R.id.etTarea)

        alerta.setView(layout)
        alerta.setPositiveButton(getString(R.string.aceptar)){ dialogInterface, i ->
            agregarTarea(etTarea.text.toString())
        }

        alerta.create()
    }
    private fun agregarTarea(tarea: String) {
        if(tarea.isNotEmpty()){
            lista.add(tarea)
        }
    }
}