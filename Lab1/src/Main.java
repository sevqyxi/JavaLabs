import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String text = "cat dog pasta october rust peter steele type o negative";

        String[] words = text.split(" ");
        String[] result = new String[words.length];
        int count = 0;

        for (int i = 0; i < words.length; i++) {

            boolean unique = true;
            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                for (int k = j + 1; k < word.length(); k++) {
                    if (word.charAt(j) == word.charAt(k)) {
                        unique = false;
                        break;
                    }
                }
                if (unique == false) {
                    break;
                }
            }
            if (unique == true) {
                result[count] = word;
                count++;
            }
        }

        String[] finalResult = new String[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        System.out.println(Arrays.toString(finalResult));
    }
}