package com.dev.laudson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordService {

    /*
    \u001b[31m
    \033[31m
     */

    public int countOcurrences(String text, String target){
        Pattern pattern = buildPattern(target);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }

    public String highlightWord(String text, String target){
        Pattern pattern = buildPattern(target);
        Matcher matcher = pattern.matcher(text);

        String corVermelha = "\u001b[31m";
        String resetCor = "\u001b[0m";

        StringBuilder result = new StringBuilder();

        while (matcher.find()){
            String found = matcher.group();
            matcher.appendReplacement(result,corVermelha + found + resetCor);
        }

        matcher.appendTail(result);
        return result.toString();
    }

    private Pattern buildPattern(String target){
        String regex = "\\b" + Pattern.quote(target) + "\\b";
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

}
