package br.com.adrisilva.agenda.controller;

import br.com.adrisilva.agenda.model.Tarefa;
import java.util.HashMap;
import java.util.Set;

public class AgendaHash implements Agenda {

    private final HashMap<String, Tarefa> lista_tarefas;

    public AgendaHash() {
        this.lista_tarefas = new HashMap<>();
    }

    @Override
    public void cadastrarTarefa(String desc, String data, String local, int hr_inicio, double valor_hora, double duracao) {

        Tarefa t = new Tarefa(hr_inicio, valor_hora, duracao, desc, data, local);

        lista_tarefas.put(desc, t);

        System.out.println("-> Tarefa Cadastrada com sucesso.");
    }

    @Override
    public void removerTarefa(String desc_tarefa) {
        int qtd_tarefas = this.lista_tarefas.size();

        this.lista_tarefas.remove(desc_tarefa);

        if (this.lista_tarefas.size() != qtd_tarefas) {
            System.out.println("-> Tarefa Removida com sucesso.");
        } else {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }
    }

    @Override
    public void buscarTarefa(String desc_tarefa) {
        try {
            Tarefa tarefa = this.lista_tarefas.get(desc_tarefa);

            String descricao = tarefa.getDescricao();
            String status_sigla = tarefa.getStatus();
            String status = "";
            String data = tarefa.getData();
            String local = tarefa.getLocal();
            int importancia = tarefa.getImportancia();
            int hr_inicio = tarefa.getHora_inicio();
            double valor_hora = tarefa.getValor_hora();
            double valor_cobrado = tarefa.getValor_cobrado();

            switch (status_sigla) {
                case "P":
                    status = "Por fazer";
                    break;
                case "A":
                    status = "Andamento";
                    break;
                case "F":
                    status = "Feito";
                    break;
            }
            System.out.println("- - - - - Tarefa - - - - -");
            System.out.println("Descrição: " + descricao);
            System.out.println("Status: (" + status_sigla + ") -> " + status);
            System.out.println("Data: " + data);
            System.out.println("Hora Inicio: " + hr_inicio);
            System.out.println("Local: " + local);
            System.out.println("Importância: " + importancia);
            System.out.println("Valor Hora: R$ " + valor_hora);
            System.out.println("Valor Cobrado: R$ " + valor_cobrado);
        } catch (Exception ex) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

    @Override
    public void iniciarTarefa(String desc_tarefa) {
        try {
            this.lista_tarefas.get(desc_tarefa).iniciarTarrefa();
            System.out.println("-> Tarefa Iniciada com sucesso.");
        } catch (Exception ex) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }
    }

    @Override
    public void encerrarTarefa(String desc_tarefa, double valor_cobrado) {
        try {
            this.lista_tarefas.get(desc_tarefa).encerrarTarefa(valor_cobrado);
            System.out.println("-> Tarefa Encerrada com sucesso.");
        } catch (Exception ex) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }
    }

    @Override
    public void listarTarefas() {
        if (lista_tarefas.isEmpty()) {
            System.err.println("Nenhuma Tarefa agendada.");
        } else {

            Set<String> keys = lista_tarefas.keySet();

            for (String key : keys) {

                Tarefa tarefa = lista_tarefas.get(key);

                String descricao = tarefa.getDescricao();
                String status_sigla = tarefa.getStatus();
                String status = "";
                String data = tarefa.getData();
                String local = tarefa.getLocal();
                int importancia = tarefa.getImportancia();
                int hr_inicio = tarefa.getHora_inicio();
                double valor_hora = tarefa.getValor_hora();
                double valor_cobrado = tarefa.getValor_cobrado();

                switch (status_sigla) {
                    case "P":
                        status = "Por fazer";
                        break;
                    case "A":
                        status = "Andamento";
                        break;
                    case "F":
                        status = "Feito";
                        break;
                }

                System.out.println("- - - - - Tarefa - - - - -");
                System.out.println("Descrição: " + descricao);
                System.out.println("Status: (" + status_sigla + ") -> " + status);
                System.out.println("Data: " + data);
                System.out.println("Hora Inicio: " + hr_inicio);
                System.out.println("Local: " + local);
                System.out.println("Importância: " + importancia);
                System.out.println("Valor Hora: R$ " + valor_hora);
                System.out.println("Valor Cobrado: R$ " + valor_cobrado);
            }

        }
    }

    @Override
    public void incrementarImportancia(String desc_tarefa) {

        try {
            Tarefa tarefa = this.lista_tarefas.get(desc_tarefa);

            if (tarefa.getImportancia() < 5) {
                tarefa.incrementarImportancia();
                System.out.println("Importância da tarefa " + desc_tarefa + " aumentada.");
            } else {
                System.err.println("Essa tarefa já está com sua importância maximizada(5).");
            }
        } catch (Exception ex) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

}
