import java.util.ArrayList;

/*
Author: Ahmed Essam Taj
Date: 5, November
Day 13 - Lab 3

 */
public class Main {
    public static void main(String[] args) {


        // Creating 2 users for testing ...
        User me = new User("Ahmed Taj", "ahmedtaj273@gmail.com");
        User dummy = new User("John Doe", "johndoe@gmail.com");


        // Creating 2 Books object
        Book firstBook = new Book("the best word in the world!", "khalid alghamdi"
                , "1030303", 15, 20);

        Book secondBook = new Book("the secrets of success", "Bob mike"
                , "1234343434", 300, 5);


        // Creating an AcademicBook object
        AcademicBook calculs = new AcademicBook("Math for beginners", "Bob mike"
                , "12343uj734", 199, 6, "Calculus");

        //Creating a Novel object
        Novel funnyNovel = new Novel("if you laugh you lose", "Bob mike"
                , "123w43uj73q4", 199, 1, "comedy");

        // Creating 4 Movie Objects
        Movie mirror = new Movie("Mirror 1","Chris nolan",
                "233342",20,165);
        Movie mirror2 = new Movie("Mirror 2","Chris nolan",
                "2@3ffgf2",20,123);
        Movie mirror3 = new Movie("Mirror 3","john doe",
                "2@*dja32",20,105);
        Movie mirror4 = new Movie("Mirror 4","Chris nolan",
                "2@4frk2",20,162);

        // Creating 3 Music objects
        Music song = new Music("first song","Ahmed taj","123r343f",
                4.99,"john doe");

        Music song2 = new Music("second song","Ahmed taj","3423r343f",
                4.99,"ali khalid");

        Music song3 = new Music("third song","Ahmed taj","123r673h",
                20,"john doe");
        
        // Revewing the books RATING MUST BE BETWEEN 1-5
        try {
            firstBook.addReview(new Review("Ahmed Taj", 500, "This is a masterpice !"));
            firstBook.addReview(new Review("john doe", 1, "This is a so bad !"));

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        }

        // Creating a Store object
        Store jarir = new Store();


        // Adding objects (Media) to the Store MediaList
        jarir.addMedia(firstBook);
        jarir.addMedia(secondBook);
        jarir.addMedia(calculs);
        jarir.addMedia(funnyNovel);
        jarir.addMedia(mirror);
        jarir.addMedia(mirror2);
        jarir.addMedia(mirror3);
        jarir.addMedia(song);
        jarir.addMedia(song2);
        jarir.addMedia(song3);

        // Show All the Media available in the Store (ONLY THE TITLE and TYPE) ..
        System.out.println("Store has the following Media: ");
        System.out.println();
        for (Media m:jarir.displayMedia()){
            System.out.println("Title:"+m.getTitle()+" Type:"+m.getMediaType());
            System.out.println("-----------------------------------------------");
        }

        // Adding Users to the Store UserList
        jarir.addUser(me);
        jarir.addUser(dummy);

        // Show all the Users in the Store..
        System.out.println("Store has the following Users: ");
        System.out.println();
        for (User u:jarir.displayUsers()){
            System.out.println("Username: "+u.getUsername());
            System.out.println("-----------------------------------------------");
        }

        // Search for a book in the Store (if not available Exception)
        try {
            System.out.println(jarir.searchBook("Math is fun!").getTitle());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());;
        }


        // User AddToCart Media items (if out Of stock Exception will be thrown)
        try {
            me.addToCart(calculs);
            me.addToCart(funnyNovel);
            me.addToCart(mirror);
            me.addToCart(mirror2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());;
        }

        // check the User cart before checkout
        System.out.println("=============== User Cart ===============");
        for (Media med: me.getShoppingCart() ){
            System.out.println("Title:"+med.getTitle()+" Type:"+med.getMediaType());
        }
        System.out.println("=========================================");

        // Check the stock for a book before the user checkout
        System.out.println("the stock for the book before checkout is "+calculs.getStock());

        // User Checkout All the Media in the cart
        me.checkout();

        // check the User cart after checkout
        System.out.println();
        System.out.println("Cart after checkout ...");
        System.out.println("=============== User Cart ===============");
        for (Media med: me.getShoppingCart() ){
            System.out.println("Title:"+med.getTitle()+" Type:"+med.getMediaType());
        }
        System.out.println("=========================================");

        // Check the stock for the book after the user checkout
        System.out.println("the stock for the book after checkout is "+calculs.getStock());

        // Finding similar movies using recommendSimilarMovies () {
        ArrayList <Movie> listOfMovies = new ArrayList<Movie>();
        listOfMovies.add(mirror);
        listOfMovies.add(mirror2);
        listOfMovies.add(mirror3);
        listOfMovies.add(mirror4);

        ArrayList <Movie>similarMovies = mirror.recommendSimilarMovies(listOfMovies);
        System.out.println();
        System.out.println("List of similar movies: ");
        for (Movie m: similarMovies){
            System.out.println("Title:"+m.getTitle()+" Type:"+m.getMediaType());
        }

        // Testing the average reviews method and is bestseller method
        try {
            calculs.addReview(new Review("fahad ahmed", 5, "This is a masterpice !"));
            calculs.addReview(new Review("khalid mohammed", 5, "very nice and summed "));
            calculs.addReview(new Review("hassan hashim", 1, "very bad"));
            calculs.addReview(new Review("ali yahya", 1, "poorly written!"));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());;
        }
        System.out.println();
        System.out.println("The average rating for "+calculs.getTitle()+" is "+calculs.getAverageRating());
        System.out.println("book "+calculs.getTitle()+" is best seller: "+calculs.isBestSeller());



        // Testing purchase method
        System.out.println();
        // let's check the stock before the purchase command
        System.out.println("stock for ("+firstBook.getTitle()+") before purchase is "+firstBook.getStock());
        firstBook.purchase(me);
        System.out.println("stock for ("+firstBook.getTitle()+") after purchase is "+firstBook.getStock());
        // user new purchesed list after using purchase method
        System.out.println();

        for (Media m: me.getPurchaseMediaList()){
            System.out.println("Purchased - Title:"+m.getTitle()+" Type:"+m.getMediaType());
        }

        // testing the watch, and listen methods
        mirror4.watch(me);
        song.listen(me);

        // The new purchesed list
        System.out.println();
        System.out.println("New purchased list after watching and listning");
        for (Media m: me.getPurchaseMediaList()){
            System.out.println("Purchased - Title:"+m.getTitle()+" Type:"+m.getMediaType());
        }


    }

}