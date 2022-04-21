import java.util.Arrays;

/**
 * @author Kyrie
 * @date 2022/2/24 10:14 AM
 */
public class Sort {
    public static int[] tmp;
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,5};
        System.out.println(String.format("Before sort: %s", Arrays.toString(arr)));
        arr = MergeSort(arr);
        System.out.println(String.format("After sort: %s", Arrays.toString(arr)));
    }
    public static int[] MergeSort(int[] arr) {
        tmp = new int[arr.length];
        Sort(arr, 0, arr.length - 1);
        return arr;
    }

    // arr[lo..hi]
    public static void Sort (int[] arr, int lo, int hi) {
        if (lo == hi){
            return;
        }
        int mid = lo + (hi - lo) / 2;
        Sort(arr, lo, mid);
        Sort(arr, mid + 1, hi);
        // lo <= mid < hi
        Merge(arr, lo, mid, hi);
    }

    public static void Merge (int[] arr, int lo, int mid, int hi) {
        tmp = Arrays.copyOf(arr, arr.length);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                arr[k] = tmp[j++];
            } else if (j > hi){
                arr[k] = tmp[i++];
            } else if (tmp[i] < tmp[j]){
                arr[k] = tmp[i++];
            } else{
                arr[k] = tmp[j++];
            }
        }
    }

}
