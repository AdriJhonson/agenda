package br.com.adrisilva.agenda.controller;

public interface Agenda {
    void cadastrarTarefa(String desc, String data, String local, int hr_incicio, double valor_hora, double duracao);
    void removerTarefa(String desc_tarefa);
    void buscarTarefa(String desc_tarefa);
    void iniciarTarefa(String desc_tarefa);
    void encerrarTarefa(String desc_tarefa, double valor_cobrado);
    void listarTarefas();
    void incrementarImportancia(String desc_tarefa);
}
