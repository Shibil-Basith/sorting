import java.util.*;

class Test2
{
    public static void radixSort(int[] array, int n, int positive)
    {
        if(n==0)
        {
            return;
        }
        int maxValue = getMax(array, n);

        for(int exp=1; (maxValue/exp)>0; exp*=10)
        {
            countSort(array, n, exp, positive);
        }
    }


    public static int getMax(int[] array, int n)
    {
        int maxValue = array[0];
        for(int i=0; i<n; i++)
        {
            if(array[i]>maxValue)
            {
                maxValue = array[i];
            }
        }
        return maxValue;
    }


    public static void countSort(int[] array, int n, int exp, int positive)
    {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(int i=0; i<n; i++)
        {
            int digit = array[i]/exp%10;
            count[digit]++;
        }

        for(int i=1; i<10; i++)
        {
            count[i] = count[i]+count[i-1];
        }

        for(int i=n-1; i>=0; i--)
        {
            int digit = array[i]/exp%10;
            output[count[digit]-1] = array[i];
            count[digit]--;
        }

        if(positive==0){
            for(int i=0, j=n-1; i<n&&j>=0; i++,j--)
            {
                array[i] = output[j];
            }
        }
        else
            {
                for(int i=0; i<n; i++)
                {
                    array[i] = array[i];
                }
            }

    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = input.nextInt();
        int array[] = new int[size];
        int positive = 0, negative = 0;
        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
            if(array[i]>=0)
                positive++;
            else
                negative++;
        }

        int positiveArray[] = new int[positive];
        int negativeArray[] = new int[negative];


        // Print array before sorting
        System.out.println("Array before sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        

        for(int i=0, j=0; j<array.length; j++)
        {
            if(array[j]>=0)
            {
                positiveArray[i] = array[j];
                i++;
            }
        }

        for(int i=0, j=0; j<array.length; j++)
        {
            if(array[j]<0)
            {
                negativeArray[i] = -1*array[j];
                i++;
            }
        }

        System.out.println("Negative Array: ");
        for(int i:negativeArray)
        {
            System.out.println(i);
        }


        radixSort(negativeArray, negative, 0);
        radixSort(positiveArray, positive, 1);

        for(int i=0; i<negative; i++)
        {
            negativeArray[i] = -negativeArray[i];
        }


        System.arraycopy(negativeArray, 0, array, 0, negativeArray.length);
        System.arraycopy(positiveArray, 0, array, negativeArray.length, positiveArray.length);

        // Print array after sorting
        System.out.println("Array after sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}