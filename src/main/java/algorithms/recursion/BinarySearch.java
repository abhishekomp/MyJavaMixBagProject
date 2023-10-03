package algorithms.recursion;

/**
 * Created by sca820 on 19 dec., 2022
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 55, 66, 77};
        int target = 6;
        int index = search(arr, target, 0, arr.length - 1);
        System.out.println("index = " + index);
    }

    public static int search(int[] arr, int target, int s, int e) {
        if(s > e) {
            return -1;
        }
        int mid = s + (e-s)/2;
        if(arr[mid] == target) {
            return mid;
        }
        if(target < arr[mid]) {
            return search(arr, target, s, mid - 1);
        }
        return search(arr, target, mid + 1, e);
    }
}
