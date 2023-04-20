package university_work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTextProcessor implements TextProc{

    private final String regex = "\\b\\w+\\b";
    private final String template = "This is a Text!";

    public String process(String inputSequence) {
        String[] words = inputSequence.split("[\\s]+");
        StringBuilder outputText = new StringBuilder();
        for (String word : words) {
            String transformedWord = transformWord(word);
            outputText.append(transformedWord).append(" ");
        }
        return outputText.toString().trim();
    }

    public int regexCount(String inputSequence) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputSequence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String regexRemove(String inputSequence) {
        String[] wordsToRemove = {"text", "words"};
        List<String> wordList = new ArrayList<>(Arrays.asList(inputSequence.split("[\\s]+")));
        List<String> removedWords = new ArrayList<>();
        for (String word : wordsToRemove) {
            while (wordList.contains(word)) {
                removedWords.add(wordList.remove(wordList.indexOf(word)));
            }
        }
        return String.join(" ", wordList);
    }

    public String regexReplace(String inputSequence) {
        return inputSequence.replaceAll(regex, "Java");
    }

    public String[] regexFind(String inputSequence) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputSequence);
        List<String> foundWords = new ArrayList<>();
        while (matcher.find()) {
            foundWords.add(matcher.group());
        }
        return foundWords.toArray(new String[0]);
    }

    public String getTemplate() {
        return template;
    }

    public String getRegex() {
        return regex;
    }

    public String[] get10Examples() {
        return new String[]{"Java", "text", "words", "example", "regex", "processor", "sequence", "input", "output", "pattern"};
    }

    private String transformWord(String word) {
        return word.toUpperCase();
    }
    
    public static void main(String[] args) {
    	TextProc processor = new JavaTextProcessor();
    	String inputSequence1 = "This is the input sequence that contains a few words.";
    	String outputSequence = processor.regexRemove(inputSequence1);
    	System.out.println("Output sequence: " + outputSequence + "\n");

    	
    	String inputSequence = "This is the input sequence that contains a few words.";
    	String[] foundWords = processor.regexFind(inputSequence);
    	int wordCount = processor.regexCount(inputSequence);
    	System.out.println("Found words: " + Arrays.toString(foundWords));
    	System.out.println("Word count: " + wordCount);
    	
    	
    	

	}

}

