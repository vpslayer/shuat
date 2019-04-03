public class Heap {

    private Heap() {}
    
    public static void sort(Comparable[] pq) {
        // index从1开始，后面的exch和less要减去1
        int n = pq.length;
        for(int i=n/2; i>=1; i--) sink(pq, i, n);
        // 建好堆后，将index为1的元素和堆尾部元素交换，堆size减1，再将index为1的元素sink下去，循环完即sorted
        while(n>1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        // 1-based array
        while(k*2 <= n) {
            int j = k*2;
            if(j<n && less(pq, j, j+1)) j++;
            if(!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
            }
    }

    private static boolean less(Comparable[] c, int v, int w) {
        return c[v-1].compareTo(c[w-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object temp = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

    private static void show(Comparable[] pq) {
        for(int i=0; i<pq.length; i++) {
            System.out.println(pq[i]);
        }
    }
    
    public static void main(String[] args) {
        Integer[] arr = {3,1,5,6,9,1};
        sort(arr);
        show(arr);
    }
}
