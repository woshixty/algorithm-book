package 操作系统课设;

import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 页面置换算法
 * @Auther MrGan
 * @Email qyyzxty@icloud.com
 */
public class PageReplacementAlgorithm {
    // 内存容量
    public static int MEMORY_SIZE = 1;
    // 内存区域
    public static Queue<Integer> MEMORY = new LinkedList<>();
    // 内存记录
    public static List<Queue<Integer>> RECORD = new ArrayList<>();
    // 缺页数
    public static int NUM = 0;
    // 页面访问序列
    public static int[] PAGELIST;
    // 命中序列
    public static boolean[] BOOLEANS;
    // 正在访问的元素
    public static int POSITION;

    /**
     * 清空重置
     */
    public static void clear() {
        RECORD.clear();
        MEMORY.clear();
        NUM = 0;
        BOOLEANS = new boolean[PAGELIST.length];
        POSITION = 0;
    }

    /**
     * 先进先出算法（FIFO）
     * 先进入主存的页面先淘汰
     */
    public static void FIFO() {
    }

    /**
     * 最近最久未使用算法（LRU）
     * 最近最长时间未访问过的页面先淘汰
     */
    public static void  LRU() {
        // 将访问的元素移到队尾
        MEMORY.remove(PAGELIST[POSITION]);
        MEMORY.offer(PAGELIST[POSITION]);
    }

    /**
     * 最佳置换算法（OPT）（理想置换算法）
     * 以后永不使用或最长时间内不再访问的页面先淘汰
     */
    public static void OPT() {
        // 重排内存页面
        for (int j = PAGELIST.length - 1; j > POSITION; j--) {
            // 逆序访问需要的页面，每访问到将其放置到队尾
            if (MEMORY.contains(PAGELIST[j])) {
                // 将元素移到队尾
                MEMORY.remove(PAGELIST[j]);
                MEMORY.offer(PAGELIST[j]);
            }
        }
    }

    /**
     * 打印结果
     * @param type
     */
    public static void printResult(Type type) {
        System.out.println(type.getName());
        System.out.println("页面访问序列↓");
        for (int anInt : PAGELIST) {
            System.out.print(anInt + "\t");
        }
        System.out.println();
        for (int i = 0; i < PAGELIST.length; i++) {
            System.out.print("----");
        }
        System.out.println();
        for (int j = 0; j < MEMORY_SIZE; j++) {
            for (int i = 0; i < PAGELIST.length; i++) {
                final Integer poll = RECORD.get(i).poll();
                System.out.print((poll == null ? " " : poll) + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < BOOLEANS.length; i++) {
            System.out.print((BOOLEANS[i] ? "√" : " ") + "\t");
        }
        System.out.println();
        System.out.println(type.getName() + "缺页数：" + NUM);
        System.out.println();
    }

    /**
     * 进行页面置换
     * @param type
     */
    public static void pageReplacement(Type type, boolean tag) {
        clear();
        for (int i = 0; i < PAGELIST.length; i++) {
            POSITION = i;
            // 需要的页面不在内存
            if(!MEMORY.contains(PAGELIST[i])) {
                // 内存满了
                if (MEMORY.size() == MEMORY_SIZE) {
                    // 删除队列头
                    MEMORY.poll();
                }
                // 添加至队列尾
                MEMORY.offer(PAGELIST[i]);
                // 缺页数加一
                NUM++;
                BOOLEANS[i] = true;
            }
            chooseType(type);
            RECORD.add(new LinkedList<>(MEMORY));
        }
        if (tag) {
            printResult(type);
        }
    }

    /**
     * 选择算法
     * @param type
     */
    private static void chooseType(Type type) {
        switch (type) {
            case LRU:
                LRU();
                break;
            case OPT:
                OPT();
                break;
        }
    }

    /**
     * 构建折线图的数据
     * @return
     */
    public static DefaultCategoryDataset getDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // 每种内存大小
        for (int i = 1; i <= PAGELIST.length; i++) {
            MEMORY_SIZE = i;
            pageReplacement(Type.FIFO, true);
            dataset.addValue(NUM, Type.FIFO.name, String.valueOf(i));

            pageReplacement(Type.LRU, true);
            dataset.addValue(NUM, Type.LRU.name, String.valueOf(i));

            pageReplacement(Type.OPT, true);
            dataset.addValue(NUM, Type.OPT.name, String.valueOf(i));
        }
        return dataset;
    }

    public enum Type {
        FIFO(1, "先进先出算法（FIFO）"),
        LRU(2, "最近最久未使用算法（LRU）"),
        OPT(3, "最佳置换算法（OPT）（理想置换算法）");

        public final Integer code;
        public final String name;

        Type(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

     public static void main(String[] args) {
         PAGELIST = new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
         pageReplacement(Type.FIFO, true);
         pageReplacement(Type.LRU, true);
         pageReplacement(Type.OPT, true);
     }
}
