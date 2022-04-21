import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kyrie
 * @date 2021/6/28 5:42 下午
 */
public class Array {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(-1);
        BigDecimal b = new BigDecimal(5);
        b = b.add(a);
        System.out.println(b);
        int[] arr = new int[]{3,2,4,1};
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int x = 0;
        for(int i: list){
            System.out.println(i);
            x = list.iterator().next();
            System.out.println(x);
        }
        int partition = partition(arr, 0, arr.length-1);
        System.out.println(partition);
    }

    static int partition (int[] array, int l, int r){
        if (array == null || array.length == 0){
            System.out.println("Array is empty.");
        }
        if (l > r){
            System.out.println("l less than r");
        }
        int flag = 0;
        l++;
        while (l < r){
            while (array[l] <= array[flag]){
                l++;
            }
            while (array[r] >= array[flag] && r > l){
                r--;
            }
            if (l < r){
                swap(array, l, r);
                l++;
                r--;
            }
        }
        swap(array, 0, r);
        return flag;
    }

    static void swap (int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int partition2 (int[] array, int l, int r){
        if  (array == null || array.length == 0){
            System.out.println("Array is empty.");
        }
        int flag = l;
        int pivot = array[flag];
        while (l < r){
            while (array[l] <= pivot){
                l++;
            }
            while (array[r] >= pivot){
                r--;
            }
            if (l < r){
                swap(array, l, r);
                l++;
                r--;
            }
        }
        swap(array, flag, r);
        return 0;
    }
}
