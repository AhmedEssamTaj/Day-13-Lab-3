public class Review {
    private String username;
    private int rating;
    private String comment;

    public Review(String username, int rating, String comment) {
        this.username = username;
        if (rating <1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }else {
            this.rating = rating;
        }

        this.comment = comment;
    }

    public Review (){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws IllegalArgumentException {
        if (rating <=0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }else {
            this.rating = rating;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
