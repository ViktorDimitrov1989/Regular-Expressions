import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03NonDigitCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(text);

        int cnt = 0;
        while (matcher.find()){
            cnt++;
        }
        System.out.println("Non-digits: " + cnt);

    }
}
