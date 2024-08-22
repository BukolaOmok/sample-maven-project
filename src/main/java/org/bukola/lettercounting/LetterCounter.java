package org.bukola.lettercounting;

import java.util.*;


public class LetterCounter {
    private final Map<Character, Integer> counts;

    public LetterCounter() {
        counts = new HashMap<>();
    }

    public void countAll(String word) {
        char[] arrayOfChar = word.toCharArray();
        for (char character : arrayOfChar) {
            countOneLetter(character);
        }
    }

    public List<String> generateReport() {
        List<String> resultStrings = new ArrayList<>();
        Set<Character> letters = counts.keySet();

        for (Character letter : letters) {
            resultStrings.add(letter + ": " + counts.get(letter));
        }
        Collections.sort(resultStrings);
        return resultStrings;
    }

    public int getCountForLetter(char letter) {
        Character lowerCaseLetter = Character.toLowerCase(letter);
        return counts.getOrDefault(lowerCaseLetter, 0);
    }

    public void countOneLetter(Character inputLetter) {
        // Convert the input letter to lowercase
        Character lowerCaseLetter = Character.toLowerCase(inputLetter);

        // if the character is not a letter then exit and do not do any operation
        if (!Character.isLetter(lowerCaseLetter)) {
            return;
        }

        //If the count is not in the map then character should be the letter and integer should be 1
        //Else if the map already contains the letter, replace what is there before, with the letter and increment the integer by 1

        if (!counts.containsKey(lowerCaseLetter)) {
            counts.put(lowerCaseLetter, 1);
        } else {
            counts.replace(lowerCaseLetter, counts.get(lowerCaseLetter) + 1);
        }

    }

}


