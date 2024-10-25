package com.example.listadetarefas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfiguracoesActivity : AppCompatActivity() {

    private lateinit var switchNotificacoes: Switch
    private lateinit var editTextTempoAviso: EditText
    private lateinit var buttonSalvarConfiguracoes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        switchNotificacoes = findViewById(R.id.switchNotificacoes)
        editTextTempoAviso = findViewById(R.id.editTextTempoAviso)
        buttonSalvarConfiguracoes = findViewById(R.id.buttonSalvarConfiguracoes)

        val sharedPreferences = getSharedPreferences("Configuracoes", MODE_PRIVATE)
        switchNotificacoes.isChecked = sharedPreferences.getBoolean("notificacoesAtivadas", true)
        editTextTempoAviso.setText(sharedPreferences.getInt("tempoAviso", 15).toString())

        buttonSalvarConfiguracoes.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("notificacoesAtivadas", switchNotificacoes.isChecked)
            editor.putInt("tempoAviso", editTextTempoAviso.text.toString().toInt())
            editor.apply()
            Toast.makeText(this, "Configurações salvas", Toast.LENGTH_SHORT).show()
        }
    }
}
