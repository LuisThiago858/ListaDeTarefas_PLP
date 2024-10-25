package com.example.listadetarefas

data class Tarefa(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val dataPrazo: String,
    val prioridade: String,
    val concluida: Boolean
)
