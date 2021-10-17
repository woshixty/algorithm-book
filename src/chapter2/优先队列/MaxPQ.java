package chapter2.优先队列;

//基于堆的优先队列
public class MaxPQ<Key extends Comparable<Key>> {
    //基于堆的完全二叉树
    private Key[] pq;
    //存储于pq[1...N]中，pq[0]没有使用
    private int N = 0;

    //创建一个初始容量为max的优先队列
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    //用a[]中的元素创建一个优先队列
    public MaxPQ(Key[] a) {

    }

    //向优先队列中插入一个元素
    public void insert(Key v) {
        pq[++N] = v;

    }

    //返回最大元素
    public Key max() {
        return null;
    }

    //删除并返回最大元素
    public Key delMax() {
        return null;
    }

    //返回队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //返回优先队列中元素的个数
    public int size() {
        return N;
    }

    //以下为一些辅助方法
    //做比较
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //交换元素
    public void exch(int i, int j) {
        Key exch = pq[i];
        pq[i] = pq[j];
        pq[j] = exch;
    }

    //上浮
    public void swim(int k) {
        while(k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    //下潜
    public void sink(int k) {
        /**
         * 我的垃圾写法
        while(2*k <= N && less(k, 2*k) && less(k, 2*k + 1)) {
            if (less(2*k, 2*k + 1)) {
                exch(k, 2*k + 1);
                k = 2*k + 1;
            } else {
                exch(k, 2*k);
                k = 2*k;
            }
        }
        **/
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
    }
}
