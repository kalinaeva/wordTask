import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Kalinaeva M.
 * @see #main(String[])
 */
public class Base {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            нужно написать путь к файлу
         */
        File f = new File("C://Users/Glur/IdeaProjects/Masha/Words/target/Words.txt");
        Scanner scanner = new Scanner(f);
        List<String> words = new ArrayList();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        java.util.Collections.sort(words);
        System.out.println("Отсортированный массив слов: ");
        System.out.println(words);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        Map<String, Integer> wordsMap = new TreeMap();

        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                int counter = wordsMap.get(word);
                wordsMap.put(word, counter + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        for (Map.Entry entry : wordsMap.entrySet()) {
            System.out.println("Слово: " + entry.getKey());
            System.out.println("Количество повторений: " + entry.getValue());
            System.out.println("-----------------------------------------");
        }
        System.out.println("-----------------------------------------");


        System.out.println("Максимальный элемент");
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println("Слово с максимальным количеством повторений: " + maxEntry.getKey());
        System.out.println("Количество повторений: " + maxEntry.getValue());
    }
}
