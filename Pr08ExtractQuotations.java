import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr08ExtractQuotations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("(\"|')(.*?)\\1");

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
