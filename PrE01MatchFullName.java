import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PrE01MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "^([A-Z]{1}[a-z]{1,}) ([A-Z]{1}[a-z]{1,})$";

        String line = reader.readLine();
        while (!"end".equals(line)){
            if(line.matches(pattern)){
                System.out.println(line);
            }
            line = reader.readLine();
        }
    }
}
