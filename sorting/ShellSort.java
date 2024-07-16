import java.util.*;

public class ShellSort
{
    public static void shellSort(int[] array, int n)
    {
        for(int gap=n/2; gap>0; gap/=2)
        {
            for(int i=gap; i<n; i++)
            {
                int temp = array[i];

                int j = i-gap;

                while(j>=0 && array[j]>temp)
                {
                    array[j+gap] = array[j];
                    j = j-gap;
                }
                j = j+gap;
                array[j] = temp;
            }
        }
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        // Print array before sorting
        System.out.println("Array before sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        shellSort(array, array.length);

        // Print array after sorting
        System.out.println("Array after sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}