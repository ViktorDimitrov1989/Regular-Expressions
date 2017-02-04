import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE6SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyWord = reader.readLine();
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(?<= |^)([a-zA-Z0-9,_ \\-'\" ]+(?=[?!.])[?.!])");
        Matcher matcher = pattern.matcher(input);

        Pattern keyPattern = Pattern.compile(String.format(".+\\b%s\\b.+", keyWord));

        while (matcher.find()) {
            String sentence = matcher.group(0);
            Matcher keyWordMatcher = keyPattern.matcher(sentence);
            if (keyWordMatcher.find()) {
                System.out.println(sentence);
            }
        }
    }
}
