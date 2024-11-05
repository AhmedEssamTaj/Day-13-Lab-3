public class Novel extends Book{

    private String genre;

    public Novel(int stock, String genre) {
        super(stock);
        this.genre = genre;
    }

    public Novel(String genre) {
        this.genre = genre;
    }

    public Novel(String title, String auteur, String ISBN, double price, int stock, String genre) {
        super(title, auteur, ISBN, price, stock);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getMediaType() {
        if (this.isBestSeller()){
            return " BestSelling Novel ";
        }
        return " Novel ";
    }

    @Override
    public String toString() {
        return "Novel{" +
                "genre='" + genre + '\'' +
                '}';
    }

}
