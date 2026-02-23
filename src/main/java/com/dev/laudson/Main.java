package com.dev.laudson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordService wordService = new WordService();

        System.out.println("=== BUSCADOR DE PALAVRAS ===");
        System.out.println("Cole seu texto abaixo (linha vazia para finalizar): ");

        StringBuilder sb = new StringBuilder();
        while (true){
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            sb.append(line).append('\n');
        }

        String fullText = sb.toString();

        System.out.println("\n Digite a palavra que deseja buscar: ");
        String target = scanner.next();

        int count = wordService.countOcurrences(fullText, target);
        String highlighted = wordService.highlightWord(fullText, target);

        System.out.println("\n--- RESULTADO ---");
        System.out.println("A palavra '" + target + "' apareceu " + count + " vezes");
        System.out.println("\nTexto formatado:\n" + highlighted);

        scanner.close();
    }
}