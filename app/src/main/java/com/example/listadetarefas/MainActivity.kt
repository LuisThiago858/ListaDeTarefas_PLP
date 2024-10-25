package com.example.listadetarefas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tarefaAdapter: TarefaAdapter
    private var listaTarefas = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuração do RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTarefas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar o Adapter com uma lista de tarefas vazia inicialmente
        tarefaAdapter = TarefaAdapter(listaTarefas)
        recyclerView.adapter = tarefaAdapter

        // Botão para abrir a tela de configurações
        val buttonConfigurar = findViewById<Button>(R.id.buttonConfigurar)
        buttonConfigurar.setOnClickListener {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }

        // Carregar lista de tarefas (mock ou banco de dados, pode ser adicionado aqui)
        carregarTarefas()
    }

    // Método para carregar tarefas mock (exemplo)
    private fun carregarTarefas() {
        listaTarefas.add(Tarefa(1, "Comprar leite", "Comprar leite na padaria", "2024-10-30", "Alta", false))
        listaTarefas.add(Tarefa(2, "Estudar Kotlin", "Estudar as funcionalidades básicas de Kotlin", "2024-11-01", "Média", false))
        tarefaAdapter.notifyDataSetChanged()
    }

    // Inflar o menu na Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Definir ações dos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_configuracoes -> {
                val intent = Intent(this, ConfiguracoesActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

