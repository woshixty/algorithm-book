package pat刷题.Emergency;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //几个节点
        int numOfNodes = 0;
        //几条边
        int numOfSides = 0;
        //起始节点
        int beginNode = 0;
        //终点节点
        int endNode = 0;
        Scanner in = new Scanner(System.in);
        //读取头四位数字
        numOfNodes = in.nextInt();
        numOfSides = in.nextInt();
        beginNode = in.nextInt();
        endNode = in.nextInt();
        //存放图
        int[][] Graph = new int[numOfNodes][numOfNodes];
        for (int i = 0; i < numOfNodes; i++)
            for (int j = 0; j < numOfNodes; j++)
                Graph[i][j] = 0;
        //存放访问标记
        Set<Integer> vis = new HashSet<>();
        //存放路径长度
        int[] dis = new int[numOfNodes];
        for (int i = 0; i < dis.length; i++)
            dis[i] = Integer.MAX_VALUE;
        //医疗队的数量
        int[] emergencyNum = new int[numOfNodes];
        //依次读取医疗队的数量
        for (int i = 0; i < numOfNodes; i++)
            emergencyNum[i] = in.nextInt();
        //只要有数字就三个三个读取
        for (int i = 0; i < numOfSides; i++) {
            //起点
            int b = in.nextInt();
            //终点
            int e = in.nextInt();
            //长度
            int l = in.nextInt();
            Graph[b][e] = l;
            Graph[e][b] = l;
        }
        //队列用于广度遍历
        Queue<Integer> queue = new LinkedList<>();
        //现将首节点遍历
        queue.offer(beginNode);
        vis.add(beginNode);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < numOfNodes; i++)
                if (Graph[poll][i] != 0) {
                    if (!vis.contains(i)) {
                        //访问标记
                        vis.add(i);
                        queue.offer(i);
                    }
                }

        }
    }
}
