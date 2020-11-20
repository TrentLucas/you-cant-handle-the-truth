import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        String[] input = {
                null,
                "",
                "hello",
                "hello there this is a sentence that does not end and this sentence never ends",
                "yess iam a pirson",
                "i'm a person that likes to sleep-in",
                //"yes, i'm a person.",
        };

        TreeMap<Integer, HashSet> output1 = null;

        TreeMap<Integer, Set<String>> output2 = new TreeMap<>();
        output2.put(1, Collections.singleton(""));

        TreeMap<Integer, Set<String>> output3 = new TreeMap<>();
        output3.put(1, Collections.singleton("hello"));

        TreeMap<Integer, HashSet> output4 = new TreeMap<>(Collections.reverseOrder());
        String[] output4String1 = {"a", "that", "never", "not", "does", "and", "there", "ends", "is", "end", "hello"};
        String[] output4String2 = {"sentence", "this"};
        output4.put(2, Arrays.stream(output4String2).collect(Collectors.toCollection(HashSet::new)));
        output4.put(1, Arrays.stream(output4String1).collect(Collectors.toCollection(HashSet::new)));

        TreeMap<Integer, HashSet> output5 = new TreeMap<>();
        String[] output5String1 = {"yess", "iam", "a", "pirson"};
        output5.put(1, Arrays.stream(output5String1).collect(Collectors.toCollection(HashSet::new)));

        TreeMap<Integer, HashSet> output6 = new TreeMap<>();
        String[] output6String1 = {"i'm", "a", "person", "that", "likes", "to", "sleep-in"};
        output6.put(1, Arrays.stream(output6String1).collect(Collectors.toCollection(HashSet::new)));

        /*TreeMap<Integer, HashSet> output6 = new TreeMap<>();
        String[] c = {"yes", "i'm", "a", "person"};
        output6.put(1, Arrays.stream(c).collect(Collectors.toCollection(HashSet::new)));*/

        TreeMap[] output = {
                output1,
                output2,
                output3,
                output4,
                output5,
                output6,
                //output6,
        };
        for (int i = 0; i < input.length; i++) {
            TreeMap<Integer, Set<String>> expected = output[i];
            TreeMap<Integer, Set<String>> actual = HandleTruth.wordCount(input[i]);
            assertEquals(expected, actual);
        }

    }
}
/*
testcases: empty, 1 word, many words, same words but one with capital and one not, punctuation, misspelled words,
- will need to change the code to accept a input so that testcases can be used
- store each testcase in a string[] with expected outputs
- call the function
- compare the called function output to the string[]
 */