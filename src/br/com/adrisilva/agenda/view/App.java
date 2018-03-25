package br.com.adrisilva.agenda.view;

import br.com.adrisilva.agenda.controller.AgendaVector;
import java.util.Scanner;

public class App {
    public static int exibirMenu() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("####################################");
        System.out.println("Agenda Tarefas - Arrays");
        System.out.println("\t1 - Cadastrar uma tarefa");
        System.out.println("\t2 - Remover uma tarefa");
        System.out.println("\t3 - Consultar(listar) os dados de uma determinada tarefa");
        System.out.println("\t4 - Iniciar uma tarefa");
        System.out.println("\t5 - Encerrar uma tarefa");
        System.out.println("\t6 - Listar as Tarefas cadastradas");
        System.out.println("\t7 - Incrementar a importância de uma tarefa");
        System.out.println("\t8 - Sair");
        System.out.print("Sua escolha: ");

        int opcMenu = teclado.nextInt();

        return opcMenu;
    }

    public static void main(String[] args) {
        AgendaVector vectorController = new AgendaVector();
        Scanner teclado = new Scanner(System.in);
        String desc_tarefa;
        
        int opcMenu = exibirMenu();

        while (opcMenu != 8) {
            System.out.println("####################################");
            switch (opcMenu) {
                case 1:

                    System.out.print("Descrição da Tarefa: ");
                    String desc = teclado.nextLine();

                    System.out.print("Hora de início: ");
                    int hr_inicio = Integer.parseInt(teclado.nextLine());

                    System.out.print("Valor Hora: ");
                    double valor_hora = Double.parseDouble(teclado.nextLine());

                    System.out.print("Duração: ");
                    double duracao = Double.parseDouble(teclado.nextLine());

                    System.out.print("Data: ");
                    String data = teclado.nextLine();

                    System.out.print("Local: ");
                    String local = teclado.nextLine();
                    vectorController.cadastrarTarefa(desc, data, local, hr_inicio, valor_hora, duracao);
                    break;
                
                case 2:
                    System.out.print("Descrição da Tarefa que deseja remover: ");
                    String desc_remove = teclado.nextLine();
                    vectorController.removerTarefa(desc_remove);
                    break;
                    
                case 3:
                    System.out.print("Descrição da Tarefa que deseja Visualizar: ");
                    desc_tarefa = teclado.nextLine();
                    vectorController.buscarTarefa(desc_tarefa);
                    break;
                    
                case 4:
                    System.out.print("Descrição da Tarefa que deseja Iniciar: ");
                    desc_tarefa = teclado.nextLine();
                    vectorController.iniciarTarefa(desc_tarefa);
                    break;
                    
                case 5:
                    System.out.print("Descrição da Tarefa que deseja Encerrar: ");
                    desc_tarefa = teclado.nextLine();
                    
                    System.out.print("Valor cobrado pela tarefa: ");
                    double valor_cobrado = teclado.nextDouble();
                    
                    vectorController.encerrarTarefa(desc_tarefa, valor_cobrado);
                    break;
                    
                case 6:
                    vectorController.listarTarefas();
                    break;
                    
                case 7:
                    System.out.print("Descrição da Tarefa que deseja aumentar a importância: ");
                    desc_tarefa = teclado.nextLine();
                    vectorController.incrementarImportancia(desc_tarefa);
                    break;

                default:
                    System.err.println("Opção Inválida");
                    break;

            }

            opcMenu = exibirMenu();

        }
    }
}
