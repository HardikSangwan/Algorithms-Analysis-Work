public class Dictionary extends Book {

    protected int definitions;
    
    public Dictionary(int pages, int definitions) {
        super(pages);  //this or super call must be called before anything
        this.definitions = definitions;
    }
    
    public int getDefinitions() {
        return definitions;
    }
    
    public double computeRatio() {
        return definitions/pages;
    }
    
    public void burn() {
        super.burn();  //not required to be first
        definitions = 0;
    }
    
    
    public String toString() {
       
        return pages + " - " + definitions;
    }

public static void main(String[] args) {
    
    //Book b1 = new Book(99);
    Dictionary d1 = new Dictionary(101, 100000);
    
    d1.burn();
    
    System.out.println(d1.toString());



}



}