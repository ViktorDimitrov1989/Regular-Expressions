import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr07ValidTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("^([0-9]{2}):([0-9]{2}):([0-9]{2}) (AM|PM)$");

        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (isValidHour(matcher)) {
                    System.out.println("valid");
                }
                else{
                    System.out.println("invalid");
                }
            }
            else{
                System.out.println("invalid");
            }
            line = reader.readLine();
        }
    }

    private static boolean isValidHour(Matcher matcher) {
        int hours = Integer.parseInt(matcher.group(1));
        int minutes = Integer.parseInt(matcher.group(2));
        int seconds = Integer.parseInt(matcher.group(3));
        return hours <= 12
                && hours >= 1
                && minutes <= 59
                && minutes >= 0
                && seconds <= 59
                && seconds >= 0;
    }
}
