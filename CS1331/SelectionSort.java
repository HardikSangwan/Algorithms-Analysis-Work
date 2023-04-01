import java.util.Random;

public class SelectionSort
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
 
    public static void selectionSort (Comparable[] list)
    {
        int min;
        Comparable temp;
        
        for (int index = 0; index < list.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
               // if (list[scan] < list[min])
                 if (list[scan].compareTo(list[min]) < 0)

                    min = scan;
            
            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
    
    
    public static void selectionSort (double[] list)
   {
      int min;
      double temp;

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan] < list[min])
               min = scan;

         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }

    public static void selectionSort (int[] list)
    {
        int min;
        int temp;
        
        for (int index = 0; index < list.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan] < list[min])
                    min = scan;
            
            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
    
    /*
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();
        int price;
        for (int i = 0; i< numbers.length - 1; i++) {
            numbers[i] = rand.nextInt(10000);
        }
        
      
        selectionSort(numbers);
        //Arrays.sort(numbers);
        
        for (int x = 0; x < numbers.length; x++) {
            System.out.println(numbers[x] + " ");
        }

    }
     */
    
    //now that we've implemented Comparable in YellowJackets, let's play with sorting them
    public static void main(String[] args) {
        YellowJacket[] jackets = new YellowJacket[10];
        Random rand = new Random();
        int price;
        for (int i = 0; i< jackets.length; i++) {
            jackets[i] = new YellowJacket(rand.nextInt(9));
        }
        
        for (int x = 0; x < jackets.length; x++) {
            System.out.println(jackets[x]);
                               }
        
        selectionSort(jackets);
        System.out.println("==========================================================");
        for (int x = 0; x < jackets.length; x++) {
            System.out.println(jackets[x]);
        }
        
    }

}
