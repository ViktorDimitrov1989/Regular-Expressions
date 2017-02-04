import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE07ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("(?<=\\s|\\/|\\\\|^)([a-zA-Z]+[a-zA-Z0-9_]{2,25})");
        Matcher matcher = pattern.matcher(line);

        ArrayDeque<String> namesDeque = new ArrayDeque<>();
        while (matcher.find()) {
            String name = matcher.group(0);
            namesDeque.addLast(name);
        }

        int maxSum = 0;
        int tempSum = 0;

        String first = "";
        String sec = "";

        String debug = "";
        String nameToPeek;
        while (!namesDeque.isEmpty()){
            String nameToBeRemoved = namesDeque.removeFirst();
            if(namesDeque.size() == 0){
                nameToPeek = debug;
            }
            else {
                nameToPeek = namesDeque.peekFirst();
            }
            tempSum = nameToBeRemoved.length() + nameToPeek.length();
            if(tempSum > maxSum && namesDeque.size() != 0){
                maxSum = tempSum;
                first = nameToBeRemoved;
                sec = nameToPeek;
            }
            else{

            }
            debug = nameToBeRemoved;
        }
        System.out.println(first);
        System.out.println(sec);

    }
}