import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE08PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line = "";
        while (!"END".equals(line = reader.readLine())){
            sb.append(line).append("\n");
        }
        String patternString = "(?<name>(?=[A-Z])[a-zA-Z]*)([^a-zA-Z0-9\\+]+?)(?<phone>(\\+?)(?=[0-9])[0-9)(\\/.\\- ]+(?<=[0-9]))";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(sb);

        StringBuilder result = new StringBuilder();
        boolean match = false;
        while (matcher.find()){
            match = true;
            result.append(String.format("<li><b>%s:</b> %s</li>", matcher.group("name"), matcher.group("phone").replaceAll("[^0-9\\+]", "")));
        }
        if(match){
            result.insert(0,"<ol>");
            result.insert(result.length(),"</ol>");
            System.out.println(result);
        }
        else{
            System.out.println("<p>No matches!</p>");
        }
    }
}
