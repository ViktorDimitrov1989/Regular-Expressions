import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE08SumAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keysString = reader.readLine();
        String text = reader.readLine();

        Pattern startKeyPattern = Pattern.compile("^[a-zA-Z_]+");
        Pattern endKeyPattern = Pattern.compile("(?<=[0-9\\s])([a-zA-Z_]+)(?=$)");

        String startKey = "";
        String endKey = "";

        Matcher startStringMatcher = startKeyPattern.matcher(keysString);
        Matcher endStringMatcher = endKeyPattern.matcher(keysString);
        while (startStringMatcher.find()){
            startKey = startStringMatcher.group(0);
        }
        while (endStringMatcher.find()){
            endKey = endStringMatcher.group(0);
        }


        if(startKey.equals("") || endKey.equals("")){
            System.out.println("<p>A key is missing</p>");
        }
        else{
            String patternString = String.format("(?:%s)(\\s*?)(?<number>[0-9.\\-+]+)(\\s*?)(?:%s)", startKey, endKey);
            Pattern digitPattern = Pattern.compile(patternString);
            double sum = 0f;
            Matcher matcher = digitPattern.matcher(text);
            while (matcher.find()){
                double num = Double.parseDouble(String.valueOf(matcher.group("number")));
                sum += num;
            }
            if(sum == 0){
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
            else{
                System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
            }
        }
    }
}
