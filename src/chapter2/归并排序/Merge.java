package chapter2.归并排序;

public class Merge {
    //归并所需的辅助数组
    private static Comparable[] aux;

    //原地归并的方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[lo, mid] 和 b[mid+1, hi] 归并
        int i = lo, j = mid + 1;
        //将a复制到aux
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0)
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    //自顶向下的归并方法
    private static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo...hi]进行排序
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //将左半边排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        //一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 3, 90, 67, 55, 24, 100, 200, 130, 77};
        sort(a);
        for (Comparable comparable : a) {
            System.out.println(comparable);
        }
    }
}
