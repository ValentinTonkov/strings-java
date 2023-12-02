import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        creatingStrings();
        comparingStrings();
        stringJoinExample();
        someStringMethods();
        concatTest();
        
        task1();
        task2();
    }

    private static void creatingStrings() {
        System.out.println("Creating Strings..");
        String s = "first string";
        String s2 = new String("second");
        String s3 = String.valueOf(123.212313d);
        String s4 = String.format("string - %s, int - %d, float - %f", "one", 12, 122.2f);

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String s5 = new String(chars);
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println();
    }


    private static void comparingStrings() {
        String s = "one";
        String s2 = "one";
        System.out.println("s = " + s + "  s2 = " + s2);
        System.out.println("s == s2 : " + (s == s2));
        System.out.println("s.hashCode() = " + s.hashCode() + "   s2.hashCode() = " + s2.hashCode());

        String s3 = new String("one");
        System.out.println("\ns = " + s + "  s3 = " + s3);
        System.out.println("s == s3 : " + (s == s3));
        System.out.println("s.equals(s3) : " + (s.equals(s3)));
        System.out.println("s.hashCode() = " + s.hashCode() + "   s3.hashCode() = " + s3.hashCode());
        System.out.println();
    }


    private static void someStringMethods() {
        System.out.println("\nSome String methods..");
        String s = "This is a new text.";
        System.out.println("s = " + s);
        System.out.println("s.lastIndexOf(\"is\") = " + s.lastIndexOf("is"));
        System.out.println("s.equalsIgnoreCase(\"New\") = " + s.equalsIgnoreCase("New"));
        System.out.println("s.substring(s.indexOf('a') + 1) = " + s.substring(s.indexOf('a') + 1));
        System.out.println("s.contains(\"is\") = " + s.contains("is"));
        System.out.println("s.toUpperCase() = " + s.toUpperCase());
    }

    private static void stringJoinExample() {
        System.out.println("Testing String.join()");
        System.out.println(String.join("/", "/home", "user1", "Desktop","newDir", "file1"));
        List<String> words = List.of("one", "two", "three","four","five", "six");
        System.out.println(String.join("#", words));
    }


    private static void concatWithAddition() {
        long startTime = System.nanoTime();
        String s = "";
        for (int i = 0; i < 10000; i++){
            s += "string";
        }
        long finishTime = System.nanoTime();
        System.out.println("method: += , time:           " + (finishTime - startTime)/1000 + "us");
    }

    private static void concatWithConcat() {
        long startTime = System.nanoTime();
        String s = "";
        for (int i = 0; i < 10000; i++){
            s = s.concat("string");
        }
        long finishTime = System.nanoTime();
        System.out.println("method: .concat , time:      " + (finishTime - startTime)/1000 + "us");
    }

    private static void concatWithStringBuffer() {
        long startTime = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++){
            buffer.append("string");
        }
        buffer.toString();
        long finishTime = System.nanoTime();
        System.out.println("method: StringBuffer, time:   " + (finishTime - startTime)/1000 + "us");
    }

    private static void concatWithStringBuilder() {
        long startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++){
            builder.append("string");
        }
        builder.toString();
        long finishTime = System.nanoTime();
        System.out.println("method: StringBuilder, time:   " + (finishTime - startTime)/1000 + "us");
    }

    private static void concatWithRepeat() {
        long startTime = System.nanoTime();
        String s = "string".repeat(10000);
        long finishTime = System.nanoTime();
        System.out.println("method: .repeat , time:         " + (finishTime - startTime)/1000 + "us");
    }

    private static void concatTest() {
        System.out.println("\nConcatenating Strings..");
        concatWithAddition();
        concatWithConcat();
        concatWithStringBuffer();
        concatWithStringBuilder();
        concatWithRepeat();
    }

    private static int countWordWithSubstring(String source, String word){
        int count = 0;

        while(source.indexOf(' ') > 0){
            source = source.trim();

            String newWord = source.substring(0, source.indexOf(" "));
            if (newWord.equalsIgnoreCase(word)) {
                count++;
            }
            source = source.substring(source.indexOf(' ') + 1);
        }
        return count;
    }

    private static int countWord(String source, String word) {
        String[] arr = source.split(" ");
        int counter = 0;
        for (String s :
                arr) {
            if (s.equalsIgnoreCase(word)) {
                counter++;
            }
        }
        return counter;
    }

    private static String replaceWord(String source, String wordToReplace, String newWord) {
        List<String> words = Arrays.asList(source.split(" "));
        words.replaceAll(s -> s.equalsIgnoreCase(wordToReplace) ? newWord : s);
        return String.join(" ", words);
    }

    private static void task1() {
        String source = "one two one two three four five three";
        String word = "one";
        System.out.println("\nTask1\nsource: " + source + "\nword: " + word + "\noccurrences: " + countWord(source, word));
        System.out.println("countWordWithSubstring(source, word) = " + countWordWithSubstring(source, word));
    }

    private static void task2() {
        String source = "one two One two three four five three one";
        String wordToReplace = "one";
        String newWord = "replaced";

        System.out.println("\nTask2");
        System.out.println(replaceWord(source, wordToReplace, newWord));
    }

}