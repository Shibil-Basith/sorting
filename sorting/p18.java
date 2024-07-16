import java.util.Scanner;

class p18 {


    public static void mergeSort(int[] array, int left, int right)
    {
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
        
    }


    public static void merge(int[] array, int left, int mid, int right)
    {
        int n1 = mid-left+1;
        int n2 = right-mid;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for(int i=0; i<n1; i++)
        {
            leftArray[i] = array[left+i];
        }

        for(int j=0; j<n2; j++)
        {
            rightArray[j] = array[mid+1+j];
        }

        int i = 0;
        int j = 0;
        int k = left;


        while(i<n1 && j<n2)
        {
            if(leftArray[i]<=rightArray[j])
            {
                array[k++] = leftArray[i++];
            }
            else
            {
                array[k++] = rightArray[j++];
            }
        }


        while(i<n1)
        {
            array[k++] = leftArray[i++];
        }


        while(j<n2)
        {
            array[k++] = rightArray[j++];
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

        mergeSort(array, 0, array.length - 1);

        // Print array after sorting
        System.out.println("Array after sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
