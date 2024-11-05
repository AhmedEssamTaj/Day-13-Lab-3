import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private ArrayList <Media> purchaseMediaList;
     private ArrayList<Media> shoppingCart;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.purchaseMediaList = new ArrayList<>();
        this.shoppingCart = new ArrayList<>();
    }

    public User () {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Media> getPurchaseMediaList() {
        return purchaseMediaList;
    }

    public void setPurchaseMediaList(ArrayList<Media> purchaseMediaList) {
        this.purchaseMediaList = purchaseMediaList;
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(Media media) {
       // if media is a Book check if it is available in the stock..
        if (media  instanceof Book) {
            Book b = (Book) media;
            if (b.getStock() >0){
                this.shoppingCart.add(media);
            }else {
                throw new IllegalArgumentException("Book is Out of Stock");
            }

        }else {
            this.shoppingCart.add(media);
        }
    }

    public void removeFromCart(Media media) {
        this.shoppingCart.remove(media);
    }

    public void checkout (){
        this.purchaseMediaList.addAll(shoppingCart);
        this.shoppingCart.clear();


        // the stock must be updated

        for (Media media : purchaseMediaList) {
            if (media  instanceof Book) {
               Book b = (Book) media;
               b.setStock(b.getStock() -1);
            }



        }


    }




}
