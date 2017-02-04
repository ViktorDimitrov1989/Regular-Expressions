import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrE02MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "^\\+359( |-)2\\1(\\d{3})\\1(\\d{4})$";

        String line = reader.readLine();
        while (!"end".equals(line)){
            if(line.matches(pattern)){
                System.out.println(line);
            }
            line = reader.readLine();
        }
    }
}
