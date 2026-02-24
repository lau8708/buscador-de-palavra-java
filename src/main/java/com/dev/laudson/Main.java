package com.dev.laudson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WordService wordService = new WordService();

        System.out.println("=== BUSCADOR DE PALAVRAS ===");

        try(Scanner scanner = new Scanner(System.in)){

            String text = readFullText(scanner);
            String targetWord = readTargetWord(scanner);

            WordSearchResult result = wordService.search(text, targetWord);

            showResult(result, targetWord);
        }
    }

    private static String readFullText(Scanner scanner){

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

        return fullText;
    }

    private static String readTargetWord(Scanner scanner){
        String target;
        do {

            System.out.println("\nDigite a palavra que deseja buscar: ");
            target = scanner.nextLine().trim();

            if (target.isEmpty()) {
                System.out.println("A palavra alvo não pode ser vazia.");
            }

        } while (target.isEmpty());
        return target;
    }

    private static void showResult(WordSearchResult result, String targetWord){

        String format = (result.count() == 1) ? "vez" : "vezes";

        System.out.printf(
                        "--- RESULTADO ---%n" +
                        "A palavra '%s' apareceu %d %s%n%n" +
                        "Texto formatado:%n%s"

        , targetWord, result.count(), format, result.highLigthedText());
    }
}