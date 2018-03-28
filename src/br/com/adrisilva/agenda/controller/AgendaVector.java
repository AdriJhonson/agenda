package br.com.adrisilva.agenda.controller;

import br.com.adrisilva.agenda.model.Tarefa;

import java.util.Vector;


public class AgendaVector implements Agenda{

    private Vector<Tarefa> lista_tarefas;

    public AgendaVector() {
        this.lista_tarefas = new Vector<>();
    }

    @Override
    public void cadastrarTarefa(String desc, String data, String local, int hr_incicio, double valor_hora, double duracao) {

        Tarefa t = new Tarefa(hr_incicio, valor_hora, duracao, desc, data, local);

        lista_tarefas.add(t);

        System.out.println("-> Tarefa Cadastrada com sucesso.");
    }

    @Override
    public void removerTarefa(String desc_tarefa) {

        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            if (this.lista_tarefas.get(i).getDescricao().equals(desc_tarefa)) {
                this.lista_tarefas.remove(i);
                qtd_tarefas++;
            }

        }

        if (qtd_tarefas > 0) {
            System.out.println("-> Tarefa Removida com sucesso.");
        } else {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

    @Override
    public void buscarTarefa(String desc_tarefa) {
        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            if (this.lista_tarefas.get(i).getDescricao().equals(desc_tarefa)) {

                String descricao = this.lista_tarefas.get(i).getDescricao();
                String status_sigla = this.lista_tarefas.get(i).getStatus();
                String status = "";
                String data = this.lista_tarefas.get(i).getData();
                String local = this.lista_tarefas.get(i).getLocal();
                int importancia = this.lista_tarefas.get(i).getImportancia();
                int hr_inicio = this.lista_tarefas.get(i).getHora_inicio();
                double valor_hora = this.lista_tarefas.get(i).getValor_hora();
                double valor_cobrado = this.lista_tarefas.get(i).getValor_cobrado();

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

                System.out.println("- - - - - Tarefa " + (i + 1) + "- - - - -");
                System.out.println("Descrição: " + descricao);
                System.out.println("Status: (" + status_sigla + ") -> " + status);
                System.out.println("Data: " + data);
                System.out.println("Hora Inicio: " + hr_inicio);
                System.out.println("Local: " + local);
                System.out.println("Importância: " + importancia);
                System.out.println("Valor Hora: R$ " + valor_hora);
                System.out.println("Valor Cobrado: R$ " + valor_cobrado);

                qtd_tarefas++;
            }

        }

        if (qtd_tarefas == 0) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

    @Override
    public void iniciarTarefa(String desc_tarefa) {
        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            if (this.lista_tarefas.get(i).getDescricao().equals(desc_tarefa)) {
                this.lista_tarefas.get(i).iniciarTarrefa();
                qtd_tarefas++;
            }

        }

        if (qtd_tarefas > 0) {
            System.out.println("-> Tarefa Iniciada com sucesso.");
        } else {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }
    }

    @Override
    public void encerrarTarefa(String desc_tarefa, double valor_cobrado) {
        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            if (this.lista_tarefas.get(i).getDescricao().equals(desc_tarefa)) {
                this.lista_tarefas.get(i).encerrarTarefa(valor_cobrado);
                qtd_tarefas++;
            }

        }

        if (qtd_tarefas > 0) {
            System.out.println("-> Tarefa Encerrada com sucesso.");
        } else {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }
    }

    @Override
    public void listarTarefas() {
        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            String descricao = this.lista_tarefas.get(i).getDescricao();
            String status_sigla = this.lista_tarefas.get(i).getStatus();
            String status = "";
            String data = this.lista_tarefas.get(i).getData();
            String local = this.lista_tarefas.get(i).getLocal();
            int importancia = this.lista_tarefas.get(i).getImportancia();
            int hr_inicio = this.lista_tarefas.get(i).getHora_inicio();
            double valor_hora = this.lista_tarefas.get(i).getValor_hora();
            double valor_cobrado = this.lista_tarefas.get(i).getValor_cobrado();

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

            System.out.println("- - - - - Tarefa " + (i + 1) + "- - - - -");
            System.out.println("Descrição: " + descricao);
            System.out.println("Status: (" + status_sigla + ") -> " + status);
            System.out.println("Data: " + data);
            System.out.println("Hora Inicio: " + hr_inicio);
            System.out.println("Local: " + local);
            System.out.println("Importância: " + importancia);
            System.out.println("Valor Hora: R$ " + valor_hora);
            System.out.println("Valor Cobrado: R$ " + valor_cobrado);

            qtd_tarefas++;
        }

        if (qtd_tarefas == 0) {
            System.err.println("Nenhuma Tarefa agendada.");
        }
    }

    @Override
    public void incrementarImportancia(String desc_tarefa) {
        int qtd_tarefas = 0;

        for (int i = 0; i < this.lista_tarefas.size(); i++) {

            if (this.lista_tarefas.get(i).getDescricao().equals(desc_tarefa)) {
                if(this.lista_tarefas.get(i).getImportancia() < 5){
                    this.lista_tarefas.get(i).incrementarImportancia();
                    qtd_tarefas++;
                }else{
                    System.err.println("Essa tarefa já está com sua importância maximizada(5)");
                    qtd_tarefas++;
                }
            }

        }

        if (qtd_tarefas > 0) {
            System.out.println("-> Importância da Tarefa: " + desc_tarefa + " aumentada.");
        }else{
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");            
        }
    }

}
