import java.util.ArrayList;

public class Movie extends Media {

    private int duration;

    public Movie(String title, String auteur, String ISBN, double price, int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;
    }

    public Movie(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void watch (User user) {

        user.getPurchaseMediaList().add(this);

    }

    public ArrayList <Movie> recommendSimilarMovies(ArrayList <Movie> movieCatalog) {

        ArrayList <Movie> similarMovies = new ArrayList <Movie>();

        for (Movie m : movieCatalog){

            if (this.getAuteur().equals(m.getAuteur())){
                similarMovies.add(m);
            }

        }

        return similarMovies;
    }

public String getMediaType (){
        if (duration >= 120){
            return " Long Movie ";
        }
        return " Movie ";
}

    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                '}';
    }
}
