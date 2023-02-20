import java.util.ArrayList;
import java.util.Random;
import java.lang.Comparable;

public class GenericSort 
{
    /**
     * Generic method for bubble sort.
     * 
     * @param a ArrayList to sort.
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> a)
    {
        for (int i = a.size(); i > 1; i--)  
        {
            for (int j = 0; j < i - 1; j++)
            {
                if (a.get(j).compareTo(a.get(j + 1)) > 0)  
                {    
                    E temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set((j + 1), temp);
                }
            }
        }
    }   

    /**
     * Generic method of mergeArray that sorts a main array based on the values of
     * two subarrays (left and right), then merges them together.
     *
     * @param initial Original array to sort and merge.
     * @param a "Left" array to sort and merge.
     * @param b "Right" array to sort and merge.
     */
    public static <E extends Comparable<E>> void mergeArray(ArrayList<E> initial, ArrayList<E> a, ArrayList<E> b)
    {
        // i and j iterate through a and b, k iterates through initial.
        int i = 0, j = 0, k = 0;
        
        while(i < a.size() && j < b.size())
        {
            if(a.get(i).compareTo(b.get(j)) < 0)
            {
                initial.set(k, a.get(i));
                k++;
                i++;
            }
            else
            {
                initial.set(k, b.get(j));
                k++;
                j++;
            }
        }

        while (i < a.size())
        {
            initial.set(k, a.get(i));
            k++;
            i++;
        }

        while (j < b.size())
        {
            initial.set(k, b.get(j));
            k++;
            j++;
        }
    }

    /**
     * Generic merge sort method to sort an ArrayList.
     * 
     * @param initial Original ArrayList to sort.
     */
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> initial)
    {
        // Base case.
        if (initial.size() <= 1)
        {
            return;
        }

        // Initialize empty left and right ArrayLists.
        ArrayList<E> a = new ArrayList<>();
        ArrayList<E> b = new ArrayList<>();

        int middle = initial.size() / 2;

        // Fill both arrays with values from original array.
        for (int i = 0; i < middle; i++)
        {
            a.add(initial.get(i));
        }
        for (int j = middle; j < initial.size(); j++)
        {
            b.add(initial.get(j));
        }

        // Sort both subarrays.
        mergeSort(a);
        mergeSort(b);

        // Merge the arrays together.
        mergeArray(initial, a, b);  
    }


    public static void main(String[] args) throws Exception 
    {
        // Using floats in this example. Works for other types, too.
        ArrayList<Float> arrayList1 = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();

        // Populating arrays based on type (Float). 
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            arrayList1.add(random.nextFloat(100));
        }

        for (int j = 0; j < 10; j++)
        {
            arrayList2.add(random.nextFloat(100));
        }

        // Print and display results of generic bubble sort.
        System.out.println("Unsorted ArrayList to sort using bubble sort:\n" + arrayList1.toString());
        bubbleSort(arrayList1);
        System.out.println("Sorted ArrayList using bubble sort:\n" + arrayList1.toString() +"\n"); 

        // Print and display results of generic merge sort.
        System.out.println("Unsorted ArrayList to sort using merge sort:\n" + arrayList2.toString());
        mergeSort(arrayList2);
        System.out.println("Sorted ArrayList using merge sort:\n" + arrayList2.toString());    
    }
}
