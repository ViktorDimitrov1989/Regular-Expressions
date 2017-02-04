import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE03SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Pattern pattern = Pattern.compile("([a-zA-Z])\\1+");
        Matcher matcher = pattern.matcher(line);

        String replaced = "";
        while (matcher.find()){
            replaced = matcher.replaceAll("$1");
        }
        System.out.println(replaced);
    }
}
