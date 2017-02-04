import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE04ReplaceAtag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");

        while (!"END".equals(line = reader.readLine())) {
            str.append(line).append("\n");
        }

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int startMatch = matcher.start();
            int endMatch = matcher.end();
            String replacement = "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";

            str.replace(startMatch,endMatch,replacement);

            matcher = pattern.matcher(str);
        }
        System.out.println(str);
    }
}