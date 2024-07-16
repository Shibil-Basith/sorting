import java.util.Scanner;

class p17 {
    public static int[] quickSort(int[] array, int l, int h) {
        if (l < h) {
            int j = partition(array, l, h);
            quickSort(array, l, j - 1);
            quickSort(array, j + 1, h);
        }
        return array;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int partition(int[] array, int l, int h)
{
    int pivot = array[l];
    int i = l+1;
    int j = h;
    while (i <= j) {
        while (i <= j && array[i] <= pivot) {
            i++;
        }
        while (j >= i && array[j] > pivot) {
            j--;
        }
        if (i < j) {
            swap(array, i, j);
        }
    }

    swap(array, l, j);
    return j;
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

        // Perform quicksort
        quickSort(array, 0, array.length - 1);

        // Print array after sorting
        System.out.println("Array after sorting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Close the scanner
        input.close();
    }
}
