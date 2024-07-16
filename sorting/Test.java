import java.util.*;

class Test
{
    public static void radixSort(int[] array, int n)
    {
        int maxValue = getMax(array, n);

        for(int exp=1; (maxValue/exp)>0; exp*=10)
        {
            countSort(array, n, exp);
        }
    }


    public static int getMax(int[] array, int n)
    {
        int maxValue = array[0];
        for(int i=1; i<n; i++)
        {
            if(array[i]>maxValue)
            {
                maxValue = array[i];
            }
        }
        return maxValue;
    }


    public static void countSort(int[] array, int n, int exp)
    {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(int i=0; i<n; i++)
        {
            int digit = (array[i]/exp)%10;
            count[digit]++;
        }

        for(int i=1; i<10; i++)
        {
            count[i] = count[i]+count[i-1];
        }

        for(int i=n-1; i>=0; i--)
        {
            int digit = (array[i]/exp)%10;
            output[count[digit]-1] = array[i];
            count[digit]--;
        }

        for(int i=0; i<n; i++)
        {
            array[i] = output[i];
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

        radixSort(array, array.length);

        // Print array after sorting
        System.out.println("Array after sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}