/**
 * Word List Downloader program that can get a list of English words from internet.
 *
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 * @date 1/20/2024
 * @version ___1.0____
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordList {

    public static void main(String[] args) throws Exception {
        String urlString = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";
        String regex = "^[a-zA-Z-]*$"; // all english characters with 0 or more repeat
        Pattern pattern = Pattern.compile(regex);

        URL url = new URL(urlString);
        // fetch the file using URL provided
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        PrintWriter writer = new PrintWriter("wordlist.txt", "UTF-8");

        String word;
        while ((word = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                // convert all words to upper case
                writer.println(word.toUpperCase());
            }
        }

        reader.close();
        writer.close();
    }
}
