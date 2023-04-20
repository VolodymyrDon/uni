package university_work;
import java.util.*;

public class TextProcessor {
    public static void main(String[] args) {
        // Вхідний текст
        String inputText = "Це вхідний текст. Текст містить різні слова, наприклад, текст, рядок, символи. Вхідний текст повинен бути перетворений в вихідну послідовність.";

        // Варіант 1: перетворення слів вхідного тексту
        String[] words = inputText.split("[\\s]+");
        StringBuilder outputText = new StringBuilder();
        for (String word : words) {
            String transformedWord = transformWord(word);
            outputText.append(transformedWord).append(" ");
        }
        System.out.println(outputText.toString());

        // Варіант 2: видалення слів зі вхідного тексту та підрахунок кількості слів
        String[] wordsToRemove = {"текст", "слова"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        List<String> removedWords = new ArrayList<>();
        for (String word : wordsToRemove) {
            while (wordList.contains(word)) {
                removedWords.add(wordList.remove(wordList.indexOf(word)));
            }
        }
        int numRemovedWords = removedWords.size();
        String outputText2 = String.join(" ", wordList);
        System.out.println(outputText2);
        System.out.println("Кількість видалених слів: " + numRemovedWords);
        System.out.println("Список видалених слів: " + removedWords.toString());
    }

    // Метод для перетворення слова
    private static String transformWord(String word) {
        return word.toUpperCase();
    }
}
