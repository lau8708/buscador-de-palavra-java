package com.dev.laudson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordService wordService = new WordService();

        System.out.println("=== BUSCADOR DE PALAVRAS ===");
        String fullText;

        do {
            System.out.println("Cole seu texto abaixo (linha vazia para finalizar): ");

            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    break;
                }

                sb.append(line).append("\n");
            }

            fullText = sb.toString().trim();

            if (fullText.isEmpty()) {
                System.out.println("Texto vazio, tente novamente.\n");
            }
        } while (fullText.isEmpty());

        String target;
        do {

            System.out.println("\n Digite a palavra que deseja buscar: ");
            target = scanner.nextLine().trim();

            if (target.isEmpty()) {
                System.out.println("A palavra alvo não pode ser vazia.");
            }

        } while (target.isEmpty());

        int count = wordService.countOcurrences(fullText, target);
        String highlighted = wordService.highlightWord(fullText, target);

        System.out.println("\n--- RESULTADO ---");
        System.out.println("A palavra '" + target + "' apareceu " + count + " vezes");
        System.out.println("\nTexto formatado:\n" + highlighted);

        scanner.close();
    }
}