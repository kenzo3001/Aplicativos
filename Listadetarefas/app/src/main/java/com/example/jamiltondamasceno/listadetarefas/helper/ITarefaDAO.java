package com.example.jamiltondamasceno.listadetarefas.helper;

import com.example.jamiltondamasceno.listadetarefas.model.Tarefa;

import java.util.List;

/**
 * Created by jamiltondamasceno
 */

public interface ITarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
