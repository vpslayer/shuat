import java.util.Random;
import java.util.Random.nextInt;

public class Quick {
    private Quick() { };
    public static void sort(Comparable[] c) {
        shuffle(c);
        sort(c, 0, c.length-1);
    }
    public static void sort(Comparable[] c, int lo, int hi) {
        if(hi <= lo) return;
        int pivot = partition(c, lo, hi);
        sort(c, lo, pivot-1);
        sort(c, pivot+1, hi);
    }
    // 找到切分元素位置j -> a[lo..j-1] <= a[j] <= a[j+1..hi]
    private static int partition(Comparable[] c, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = c[lo];
        while(true) {
            while(less(c[++i], v)) {
                if(i == hi) break;
            }
            while(less(v, c[--j])) {
                if(j == lo) break;
            }
            if(i >= j) break;
            exch(c, i, j);
        }
        exch(c, lo, j);
        return j;
    }
    // ==========================================
    // helper function
    private static void shuffle(Comparable[] c) {
        final long seed = System.currentTimeMillis();
        final var random = new Random(seed);
        assert(c.length != 0);
        int len = c.length;
        for(int i=0; i<len; i++) {
            int r = i + random.nextInt(len - i);
            Comparable tmp = c[i];
            c[i] = c[r];
            c[r] = tmp;
        }
    }

    private static void exch(Object[] c, int v, int w) {
        Object swap = c[v];
        c[v] = c[w];
        c[w] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        if(v == w) return false;
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // ==========================================
   
    public static void main(String[] args) {
        Integer[] arr = {3,1,5,6,9,1};
        sort(arr);
        show(arr);
    }
}