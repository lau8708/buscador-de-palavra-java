package com.dev.laudson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordService {

    final String RED_COLOR = "\u001b[31m";
    final String RESET_COLOR = "\u001b[0m";


    public Pattern buildPattern(String target) {
       String regex = "\\b" + Pattern.quote(target) + "\\b";
       return Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

    public WordSearchResult search(String text, String target){

        Pattern pattern = buildPattern(target);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        StringBuilder result = new StringBuilder();

        while (matcher.find()){
            count++;
            String found  = matcher.group();
            matcher.appendReplacement(result, RED_COLOR + found + RESET_COLOR);
        }
        matcher.appendTail(result);

        return new WordSearchResult(count, result.toString());
    }
}