package chapter2.归并排序;

public class MergeSort {
    //归并所需要的辅助数组
    private Comparable[] aux;
    //输入数组
    private Comparable[] a;

    public void setAux(Comparable[] aux) {
        this.aux = aux;
    }

    public void setA(Comparable[] a) {
        this.a = a;
    }

    public void showA() {
        for (Comparable comparable : a) {
            System.out.print(comparable + " - ");
        }
    }

    //原地归并的方法
    public void merge1(int lo, int mid, int hi) {
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
}
