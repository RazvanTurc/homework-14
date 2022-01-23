package ro.fasttrackit.homework14;

import java.util.Objects;

public class Quote {
    private final int id;
    private final String author;
    private final String quote;
    private boolean favorite;

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author != null ? author : "";
        this.quote = quote != null ? quote : "";
        this.favorite = false;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return id == quote1.id && favorite == quote1.favorite && Objects.equals(author, quote1.author) && Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, quote, favorite);
    }

    @Override
    public String toString() {
        return "Quote: " +
                "ID -> " + id +
                "| Author -> " + author + '\'' +
                "| Quote -> " + quote + '\'' +
                "| Favorite Quote -> " + favorite + "\n";
    }
}
