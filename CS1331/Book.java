public class Book {
    protected int pages;
    
    public Book(int pages) {
        this.pages = pages;
    }
    
    public int getPages() {
        return pages;
    }

    public void burn() {
        System.out.println("crackle");
        pages = 0;
    }

}