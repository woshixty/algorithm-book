package chapter2.快速排序;

public class Quick {
    public static void sort(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + "---");
        }
        System.out.println();
        sort(a, 0, a.length - 1);
        for (Comparable comparable : a) {
            System.out.print(comparable + "---");
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //将数组切分
        Comparable base = a[lo];
        //左右扫描指针
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i].compareTo(base) > 0)
                if (i == hi)
                    break;
            while (a[--j].compareTo(base) < 0)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            Comparable exch = a[i];
            a[i] = a[j];
            a[j] = exch;
        }
        a[lo] = a[j];
        a[j] = base;
        return j;
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 60, 777, 27, 900, 2, 9, 4, 1000, 345, 600};
        sort(a);
    }
}
