import java.util.Comparator;

// 冒泡排序，内部循环从i开始扫描到最后一个元素，找到更小的就更新min，最后交换min和i
public class Selection {

    private Selection() {} // 禁止初始化该类

    public static void sort(Comparable[] a) {
        int l = a.length;
        for(int i=0; i<l; i++) {
            int min=i;
            for(int j=i+1; j<l; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    // Comparator 接口，继承该接口，实现compare方法就可以自定义比较方法
    public static void sort(Comparable[] a, Comparator c) {
        for(int i=0; i<l; i++) {
            int min=i;
            for(int j=i+1; j<l; j++) {
                if(less(c, a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean less(Comparator c, Object a, Object b) {
        return c.compare(a, b) < 0;
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
        Integer[] arr = {3,1,5,6,9,1}; // int[] 不行，primitive type
        sort(arr);
        show(arr);
    }
}