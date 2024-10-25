package com.example.listadetarefas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CriarEditarTarefaActivity : AppCompatActivity() {

    private lateinit var editTextTitulo: EditText
    private lateinit var editTextDescricao: EditText
    private lateinit var editTextDataPrazo: EditText
    private lateinit var spinnerPrioridade: Spinner
    private lateinit var buttonSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_editar_tarefa)

        editTextTitulo = findViewById(R.id.editTextTitulo)
        editTextDescricao = findViewById(R.id.editTextDescricao)
        editTextDataPrazo = findViewById(R.id.editTextDataPrazo)
        spinnerPrioridade = findViewById(R.id.spinnerPrioridade)
        buttonSalvar = findViewById(R.id.buttonSalvar)

        // Configurar Spinner de prioridade
        val prioridades = arrayOf("Baixa", "Média", "Alta")
        spinnerPrioridade.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, prioridades)

        buttonSalvar.setOnClickListener {
            // Salvar tarefa (inserir no banco de dados ou retornar para a MainActivity)
        }
    }
}
