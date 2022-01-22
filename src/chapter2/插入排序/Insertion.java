package chapter2.插入排序;

public class Insertion {
    public static void sort(Comparable[] a) {
        //将a[]按照升序排列
        int N = a.length;
        for (int i = 1; i < N; i++)
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j - 1);
    }
 
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
