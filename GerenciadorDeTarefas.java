import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                opcao = -1;
            }
        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Remover tarefa");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Sair");
        System.out.println("Lista de Tarefas:");
        listarTarefas();
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarTarefa();
                break;
            case 2:
                removerTarefa();
                break;
            case 3:
                marcarTarefaComoConcluida();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine().trim();

        if (descricao.isEmpty()) {
            System.out.println("A descrição não pode estar vazia!");
            return;
        }

        tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void removerTarefa() {
        listarTarefas();
        System.out.print("Digite o número da tarefa para remover: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Número inválido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
    }

    private static void marcarTarefaComoConcluida() {
        listarTarefas();
        System.out.print("Digite o número da tarefa para marcar como concluída: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.get(indice).marcarComoConcluida();
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Número inválido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }
}