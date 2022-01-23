package ro.fasttrackit.homework14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QuoteReader {


    public List<Quote> readAllQuotes(String filePath) throws Exception {
        List<Quote> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                result.add(readQuote(id++, line));
            }
        }
        return result;
    }

    public Quote readQuote(int id, String line) {
        String[] tokens = line.split(Pattern.quote("~"));

        return new Quote(id, tokens[0], tokens[1]);
    }
}
