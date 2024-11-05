import java.util.ArrayList;

public class Music extends Media {
    private String artist;

    public Music(String title, String auteur, String ISBN, double price, String artist) {
        super(title, auteur, ISBN, price);
        this.artist = artist;
    }

    public Music(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void listen (User user){
        user.getPurchaseMediaList().add(this);
    }

    public ArrayList <Music> generatePlaylist (ArrayList <Music> musicCatalog){

        ArrayList <Music> newList = new ArrayList <Music> ();

        for (Music music : musicCatalog) {
            if (this.getArtist().equals(music.getArtist())) {
                newList.add(music);
            }
        }
        return newList;

    }

    public String getMediaType (){
        if (this.getPrice() >= 10){
            return " Premium Music ";
        }
        return " Music ";
    }

    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                '}';
    }


}
