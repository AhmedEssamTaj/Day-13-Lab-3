import java.util.ArrayList;

public class Book extends Media{

    private int stock;
    private ArrayList<Review> reviews  ;

    public Book(String title, String auteur, String ISBN, double price, int stock) {
        super(title, auteur, ISBN, price);
        this.stock = stock;
        this.reviews = new ArrayList<>();
    }

    public Book (){

    }

    public Book(int stock) {
        this.stock = stock;

    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){

        reviews.add(review);

        }

        public double getAverageRating(){
        double average = 0;
        for(Review review : reviews){
            average+= review.getRating();
        }
        return average/reviews.size();
    }

    public void purchase (User user){

        user.getPurchaseMediaList().add(this);
        stock--;

    }

    public boolean isBestSeller(){
        return this.getAverageRating() >= 4.5;
    }

    public void restock (int quantity){
        this.stock += quantity;
        System.out.println("Book stock had been restocked successfully! ");
    }

    public String getMediaType (){
        if(this.isBestSeller()){
            return " Best Selling Book ";
        }
        else{
            return " Book ";
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "stock=" + stock +
                ", reviews=" + reviews +
                '}';
    }


}

