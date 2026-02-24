package com.dev.laudson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordServiceTest {

    @Test
    void shouldReturnThreeWordsWhenWordAppearsThreeTimes(){
        // Arrange
        WordService wordService = new WordService();
        String text = "I like java. Java is cool. JAVA is amazing";
        String target = "java";

        // Act
        int result = wordService.search(text, target).count();

        // Assert
        assertEquals(3, result, "A contagem deve ser de 3 palavras");
    }

    @Test
    void shouldNotCountWordInsideAnotherWord(){
        // Arrange
        WordService wordService = new WordService();
        String text = "javaScript is not java. javac. javaX";
        String target = "java";

        // Act
        int result = wordService.search(text, target).count();

        // Assert
        assertEquals(1, result, "Deve contar apenas 1 palavra");

    }

    @Test
    void shouldHighligthWordInRedWhenFound(){
        // Arrange
        WordService wordService = new WordService();
        String text = "java is cool";
        String target = "java";

        // Act
        WordSearchResult result = wordService.search(text, target);

        // Assert
        String highligthed = result.highLigthedText();

        assertTrue(highligthed.contains("\u001B[31mjava\u001B[0m"), "A apalvra deve estar destacada em vermelho");
    }

    @Test
    void shouldIgnoreCaseWhenCountingOccurrences() {
        // Arrange
        WordService service = new WordService();
        String text = "Java JAVA java";
        String target = "java";

        // Act
        WordSearchResult result = service.search(text, target);

        // Assert
        assertEquals(3, result.count(),
                "Deve ignorar maiúsculas e minúsculas");
    }

    @Test
    void shouldReturnZeroWhenWordIsNotFound() {
        // Arrange
        WordService service = new WordService();
        String text = "python is great";
        String target = "java";

        // Act
        WordSearchResult result = service.search(text, target);

        // Assert
        assertEquals(0, result.count(),
                "Deve retornar zero quando não encontrar a palavra");
    }

    @Test
    void shouldReturnOriginalTextWhenWordNotFound() {
        // Arrange
        WordService service = new WordService();
        String text = "python is great";
        String target = "java";

        // Act
        WordSearchResult result = service.search(text, target);

        // Assert
        assertEquals(text, result.highLigthedText(),
                "Texto deve permanecer igual quando não há ocorrências");
    }
}