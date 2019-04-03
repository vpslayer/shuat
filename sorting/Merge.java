public class Merge {

    private Merge() {}

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // require a[lo-mid] a[mid+1-hi] is sorted
        int n = a.length;
        for(int i=0; i<n; i++) {
            aux[i] = a[i];
        }
        // two pointer i j to help construct sorted a from aux
        int i = lo, j = mid + 1;
        for(int k=lo; k<=hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(hi == lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi); // mid+1!
        merge(a, aux, lo, mid, hi);
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1); // length-1!
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,5,6,9,1};
        sort(arr);
        show(arr);
    }
}