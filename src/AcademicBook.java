public class AcademicBook extends Book {

    private String subject ;

    public AcademicBook(String title, String auteur, String ISBN, double price, int stock, String subject) {
        super(title, auteur, ISBN, price, stock);
        this.subject = subject;
    }

    public AcademicBook(String subject) {
        this.subject = subject;
    }

    public AcademicBook(int stock, String subject) {
        super(stock);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getMediaType() {
        if (this.isBestSeller()){
            return " Bestselling Academic Book ";
        }
        return " Academic Book ";
    }

    @Override
    public String toString() {
        return "AcademicBook{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
