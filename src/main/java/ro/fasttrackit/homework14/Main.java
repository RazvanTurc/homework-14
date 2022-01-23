package ro.fasttrackit.homework14;

public class Main {
    public static void main(String[] args) throws Exception{
        QuoteReader reader = new QuoteReader();
        QuoteService quotes = new QuoteService(reader.readAllQuotes("quotes.txt"));


        System.out.println(quotes.getAllQuotes());
        System.out.println();
        System.out.println(quotes.getAuthors());
        System.out.println();
        System.out.println(quotes.getQuotesFromAuthor(null));
        System.out.println();
        System.out.println(quotes.getQuoteById(11));
        quotes.setFavorite(11);
        System.out.println(quotes.getFavorites());
        System.out.println();
        System.out.println(quotes.getRandomQuote());
    }
}
