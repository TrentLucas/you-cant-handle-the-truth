import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        String[] input = {
                "",
                "hello",
                "hello there this is a sentence that does not end and this sentence never ends",
                "yes, i'm a person.",
                "yess iam a pirson",
        };
        TreeMap<Integer, Set<String>> output1 = new TreeMap<>();
        output1.put(1, Collections.singleton(""));

        TreeMap<Integer, Set<String>> output2 = new TreeMap<>();
        output2.put(1, Collections.singleton("hello"));

        TreeMap<Integer, HashSet> output3 = new TreeMap<>(Collections.reverseOrder());
        String[] a = {"a", "that", "never", "not", "does", "and", "there", "ends", "is", "end", "hello"};
        String[] b = {"sentence", "this"};
        output3.put(2, Arrays.stream(b).collect(Collectors.toCollection(HashSet::new)));
        output3.put(1, Arrays.stream(a).collect(Collectors.toCollection(HashSet::new)));


        TreeMap[] output = {
                output1,
                output2,
                output3,
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