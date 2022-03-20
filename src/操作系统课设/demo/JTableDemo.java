package 操作系统课设.demo;

import 操作系统课设.PageReplacementAlgorithm;

import javax.swing.*;
import java.awt.*;

import static 操作系统课设.PageReplacementAlgorithm.*;

public class JTableDemo {
    public static void main(String[] agrs) {
//        PageReplacementAlgorithm.pageReplacement(Type.FIFO);
        JFrame frame = new JFrame("页面置换算法表");
        frame.setBounds(200, 200, 1000, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        Object[][] tableDate = new Object[MEMORY_SIZE + 1][PAGELIST.length + 1];

        int j;
        for (j = 0; j < PageReplacementAlgorithm.MEMORY_SIZE; j++) {
            for (int i = 0; i < PageReplacementAlgorithm.PAGELIST.length; i++) {
                final Integer poll = RECORD.get(i).poll();
                final String x = String.valueOf((poll == null ? " " : poll));
                tableDate[j][i + 1] = x;
            }
        }
        for (int i = 0; i < BOOLEANS.length; i++) {
            tableDate[j][i + 1] = (BOOLEANS[i] ? "√" : " ");
        }

        tableDate[0][0] = "内存情况";
        tableDate[j][0] = "是否命中";

        String[] name = new String[PAGELIST.length + 1];
        name[0] = "访问序列";
        for (int i = 1; i < PAGELIST.length + 1; i++) {
            name[i] = String.valueOf(PAGELIST[i - 1]);
        }


        JTable table = new JTable(tableDate, name);
        contentPane.add(new JScrollPane(table));
        frame.setVisible(true);
    }
}
