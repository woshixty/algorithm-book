package chapter2.归并排序;

/**
 * 自底向上的归并排序
 */
public class MergeBU {
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

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int i = 1; i < N; i*=2) {
            for (int j = 0; j < N; j += 2*i) {
                merge(a, j, j + i - 1, Math.min(j + 2*i - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 3, 90, 67, 55, 24, 100, 200, 130, 77};
        sort(a);
        for (Comparable comparable : a) {
            System.out.println(comparable);
        }
    }
}
