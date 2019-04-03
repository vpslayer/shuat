// 插排，跟逆序数个数有关，最坏条件时间复杂度也要O(n^2)

public class Insertion {
    private Insertion() {}

    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i=1; i < n; i++) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,5,6,9,1};
        sort(arr);
        show(arr);
    }
}