package apnacollege.sorting.selectionSort;

//https://www.youtube.com/watch?v=PkJIc5tBRUE&list=PLfqMhTWNBTe0gqgFk-CUE-ktO5Cek1GdP&index=16
public class SelectionSort {
    //Time Complexity = O(n^2)
    public void sortAscending(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int smallestAtIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallestAtIndex]) {
                    smallestAtIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestAtIndex];
            arr[smallestAtIndex] = temp;
        }
    }

    public void sortDescending(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int biggestAtIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[biggestAtIndex]) {
                    biggestAtIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[biggestAtIndex];
            arr[biggestAtIndex] = temp;
        }
    }

    private void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 3, 2};
        final SelectionSort selectionSort = new SelectionSort();

        selectionSort.printArray(arr, "Before Sorting Ascending");
        selectionSort.sortAscending(arr);
        selectionSort.printArray(arr, "After Sorting Ascending");

//        selectionSort.printArray(arr, "Before Sorting Descending");
//        selectionSort.sortDescending(arr);
//        selectionSort.printArray(arr, "After Sorting Descending");

    }
}
