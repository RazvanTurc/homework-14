package ro.fasttrackit.homework14;

import java.util.*;

public class QuoteService {
    private final List<Quote> quotes;

    public QuoteService(Collection<Quote> quotes) {
        this.quotes = quotes != null
                ? new ArrayList<>(quotes)
                : new ArrayList<>();
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for(Quote quote : quotes) {
            result.add(quote.getQuote());
        }
        return result;
    }

    public List<Quote> getQuotesFromAuthor(String author) throws InvalidAuthorException {
        validAuthor(author);
        List<Quote> result = new ArrayList<>();
        for(Quote quote : quotes) {
            if(doesMatch(author, quote)) {
                result.add(quote);
            }
        }
        return result;
    }
    //Ati cerut sa fie List insa am decis ca mai corect ar fi un Set
    public Set<String> getAuthors() {
        Set<String> result = new HashSet<>();
        for(Quote quote : quotes) {
            result.add(quote.getAuthor());
        }
        return result;
    }

    public void setFavorite(int id) {
        validID(id);
        for(Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavorite(true);
            }
        }
    }

    public String getQuoteById(int id) {
        validID(id);
        for(Quote quote : quotes) {
            if(quote.getId() == id) {
                return quote.getQuote();
            }
        }
        return "No quote found by the ID: " + id;
    }

    public List<Quote> getFavorites() {
        List<Quote> result = new ArrayList<>();
        for(Quote quote : quotes) {
            if(quote.isFavorite()) {
                result.add(quote);
            }
        }
        return result;
    }

    public String getRandomQuote() {
        Random random = new Random();
        int id = random.nextInt(1, quotes.size());

        return getQuoteById(id);
    }

    private void validID(int id) {
        if(id < 1 || id > quotes.size()) {
            throw new InvalidIDException("Invalid ID");
        }
    }

    private void validAuthor(String author) throws InvalidAuthorException{
        if(author == null) {
            throw new InvalidAuthorException("Author cannot be NULL");
        }
    }

    private boolean doesMatch(String author, Quote quote) {
        return quote.getAuthor().equalsIgnoreCase(author) ||
                quote.getAuthor().toLowerCase().matches("(.*)" + author.trim().toLowerCase() + "(.*)");
    }
}
