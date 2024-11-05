import java.util.ArrayList;

public class Store {

    private ArrayList <User> users;
    private ArrayList <Media> media;

    public Store() {
       this.users = new ArrayList <>();
       this.media = new ArrayList <>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addMedia(Media media) {
        this.media.add(media);
    }

    public ArrayList<User> displayUsers() {
        return this.users;

    }

    public ArrayList<Media> displayMedia() {
        return this.media;
    }


    public Book searchBook(String title) {

        for (Media media : this.media) {
            if (media.getTitle().equals(title)) {
                return (Book) media;
            }
        }
        throw new IllegalArgumentException ("Book is not found");

    }





}
