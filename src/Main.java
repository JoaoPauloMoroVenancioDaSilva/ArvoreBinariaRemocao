import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = null;

        int opcao;

        System.out.println("Bem vindo ao criador de árvores Binárias.");

        do {
            System.out.println("Escolha uma opção a seguir:");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Remover valor");
            System.out.println("3 - Visualizar pré-ordem");
            System.out.println("4 -  Visualizar em ordem");
            System.out.println("5 - Visualizar pós-ordem");
            System.out.println("6 - Mudar modo de remoção (dois filhos)");
            System.out.println("7 - Ver modo atual de remoção");
            System.out.println("8 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    if (arvore == null) {
                        arvore = new ArvoreBinaria(valorInserir);
                        System.out.println("Árvore criada com raiz " + valorInserir);
                    } else {
                        arvore.inserirRecursivoRedirecionamento2(valorInserir);
                        System.out.println("Valor inserido!");
                    }
                    break;

                case 2:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia. Insira ao menos um valor.");
                        break;
                    }
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.removerNo(valorRemover);
                    System.out.println("Processo de remoção finalizado.");
                    break;

                case 3:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia.");
                        break;
                    }
                    System.out.println("Pré-ordem:");
                    arvore.visualizarPreOrdem();
                    break;

                case 4:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia.");
                        break;
                    }
                    System.out.println("Em ordem:");
                    arvore.visualizarEmOrdem();
                    break;

                case 5:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia.");
                        break;
                    }
                    System.out.println("Pós-ordem:");
                    arvore.visualizarPosOrdem();
                    break;

                case 6:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia.");
                        break;
                    }
                    System.out.println("Escolha o modo de remoção:");
                    System.out.println("1 - Maior dos menores");
                    System.out.println("2 - Menor dos maiores");
                    int modo = scanner.nextInt();
                    if (modo == 1 || modo == 2) {
                        arvore.setModoRemocaoDoisFilhos(modo);
                        System.out.println("Modo alterado.");
                    } else {
                        System.out.println("Modo inválido.");
                    }
                    break;

                case 7:
                    if (arvore == null || arvore.estaVazia()) {
                        System.out.println("A árvore está vazia. Insira um valor primeiro.");
                    }
                    else{
                        if (arvore.getModoRemocaoDoisFilhos() == 1){
                            System.out.println("O modo de remoção é o maior dos menores.");
                        }
                        else if (arvore.getModoRemocaoDoisFilhos() == 2){
                            System.out.println("O modo de remoção é o menor dos maiores.");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Obrigado por utilizar o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha outra opção.");
            }
        } while (opcao != 8);

    }
}
