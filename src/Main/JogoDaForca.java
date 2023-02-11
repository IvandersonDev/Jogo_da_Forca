package Main;

import java.util.Scanner;

public class JogoDaForca {
    private static final String[] PALAVRAS = {"abacaxi", "amarelo", "bicicleta", "computador", "dinossauro", "elefante", "futebol", "girafa", "hamburguer", "internet", "jabuti", "kanguru", "limonada", "melancia", "navio", "ovelha", "palavra", "queijo", "raspberry", "sapato", "tigre", "uva", "violinista", "xadrez", "yoga", "zebra"};
    private static final int max_tentativas = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");

        String palavra = selecionarPalavra(PALAVRAS);
        char[] letrasErradas = new char[max_tentativas];
        int numErros = 0;
        StringBuilder palavraAtual = new StringBuilder("_".repeat(palavra.length()));

        while (numErros < max_tentativas && palavraAtual.indexOf("_") != -1) {
            System.out.println("Palavra: " + palavraAtual);
            System.out.println("Letras erradas: " + new String(letrasErradas, 0, numErros));
            System.out.println("Tentativas restantes: " + (max_tentativas - numErros));

            char letra = lerLetra(sc);

            if (palavra.indexOf(letra) != -1) {
                atualizarPalavraAtual(palavra, palavraAtual, letra);
            } else {
                letrasErradas[numErros] = letra;
                numErros++;
                desenharBoneco(numErros);
            }
        }

        if (numErros < max_tentativas) {
            System.out.println("Parabéns, você venceu!");
        } else {
            System.out.println("Você perdeu. A palavra era " + palavra);
            desenharBoneco(max_tentativas);
        }
    }

    private static String selecionarPalavra(String[] palavras) {
        return palavras[(int) (Math.random() * palavras.length)];
    }

    private static char lerLetra(Scanner sc) {
        System.out.print("Digite uma letra: ");
        String input = sc.next().toLowerCase();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Por favor, digite uma letra válida.");
            return lerLetra(sc);
        }
        return input.charAt(0);
    }

    private static void atualizarPalavraAtual(String palavra, StringBuilder palavraAtual, char letra) {
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                palavraAtual.setCharAt(i, letra);
            }
        }
    }

    private static void desenharBoneco(int numErros) {
        switch (numErros) {
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("      =====");
                break;
            case 7:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("      =====");
                break;

        }
    }
}