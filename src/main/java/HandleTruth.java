import java.util.*;

public class HandleTruth {
    public static TreeMap<Integer, Set<String>> wordCount(String sentence) {
        String msg = sentence;
        // null case
        if (msg == null) {
            return null;
        }

        // split the message into word set(added basic sentence punctuation)
        String[] words = msg.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
            if (words[i].contains("!")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
            if (words[i].contains("?")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
            if (words[i].contains(".")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }

        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry);
        }

        // sort the map based on number of occurrences
        TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }

        for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
            System.out.println(entry);
        }
        return sortedMap;
    }
}