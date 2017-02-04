import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE05ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("((?<=[ ])[A-Za-z]+[a-zA-Z\\.-_]*[a-zA-Z]@[a-zA-Z]+[a-zA-Z-\\.]+[a-zA-Z](?=[\\.!?, ]))");

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
