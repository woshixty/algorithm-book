package 操作系统课设;

import 操作系统课设.demo.JTableDemo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Index {
    public static void main(String[] args) {
        //创建Frame窗口
        JFrame frame = new JFrame("页面置换算法模拟实现");
        //创建面板
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4,1,4,4));

        //创建JButton对象
        JButton draw_btn = new JButton("缺页数折线图");
        JPanel draw_btn_jp = new JPanel();
        draw_btn_jp.add(draw_btn);
        jp.add(draw_btn_jp);

        //创建创建JComboBox
        JComboBox cmb = new JComboBox();
        //向下拉列表中添加一项
        cmb.addItem("--请选择内存大小--");
        for (int i = 1; i < 10; i++) {
            cmb.addItem(i);
        }
        JPanel cmb_jp = new JPanel();
        cmb_jp.add(cmb);
        jp.add(cmb_jp);

        //三种算法按钮
        JButton btn_FIFO = new JButton("FIFO");
        JButton btn_LRU = new JButton("LRU");
        JButton btn_OPT = new JButton("OPT");
        JPanel mid_jp = new JPanel();
        mid_jp.add(btn_FIFO);
        mid_jp.add(btn_LRU);
        mid_jp.add(btn_OPT);
        jp.add(mid_jp);

        //创建文本框
        JTextField txtfield = new JTextField(60);
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder2.append(((int) (Math.random() * 10)) + " ");
        }
        txtfield.setText(stringBuilder2.toString());
        txtfield.setText(stringBuilder2.toString());

        //随机生成按钮
        JButton btn_random = new JButton("随机生成引用串");
        btn_random.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                stringBuilder.append(((int) (Math.random() * 10)) + " ");
            }
            txtfield.setText(stringBuilder.toString());
        });
        JPanel txtfield_jp = new JPanel();
        txtfield_jp.add(txtfield);
        txtfield_jp.add(btn_random);
        jp.add(txtfield_jp);

        //画折线图
        draw_btn.addActionListener(e -> {
            final String text = txtfield.getText();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) <= '9' && text.charAt(i) >= '0')
                    list.add(text.charAt(i) - '0');
            }
            int[] pageList = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pageList[i] = list.get(i);
            }
            PageReplacementAlgorithm.PAGELIST = pageList;
            LineChart.main(null);
        });

        JLabel jLabel = new JLabel();
        //  Font f = new Font("宋体", Font.PLAIN, 16);
        jLabel.setText("");
        jLabel.setForeground(Color.red);
        cmb_jp.add(jLabel);
        //三个算法按钮
        btn_FIFO.addActionListener(e -> {
            if (cmb.getSelectedItem().equals("--请选择内存大小--")) {
                jLabel.setText("请选择内存大小");
            } else {
                jLabel.setText("");
                //获取内存大小
                PageReplacementAlgorithm.MEMORY_SIZE = Integer.valueOf(cmb.getSelectedItem().toString());
                //获取序列
                final String text = txtfield.getText();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) <= '9' && text.charAt(i) >= '0')
                        list.add(text.charAt(i) - '0');
                }
                int[] pageList = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    pageList[i] = list.get(i);
                }
                PageReplacementAlgorithm.PAGELIST = pageList;
                //计算
                PageReplacementAlgorithm.pageReplacement(PageReplacementAlgorithm.Type.FIFO, false);
                //画表
                JTableDemo.main(null);
            }
            jLabel.repaint();
        });
        btn_LRU.addActionListener(e -> {
            if (cmb.getSelectedItem().equals("--请选择内存大小--")) {
                jLabel.setText("请选择内存大小");
            } else {
                jLabel.setText("");
                //获取内存大小
                PageReplacementAlgorithm.MEMORY_SIZE = Integer.valueOf(cmb.getSelectedItem().toString());
                //获取序列
                final String text = txtfield.getText();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) <= '9' && text.charAt(i) >= '0')
                        list.add(text.charAt(i) - '0');
                }
                int[] pageList = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    pageList[i] = list.get(i);
                }
                PageReplacementAlgorithm.PAGELIST = pageList;
                //计算
                PageReplacementAlgorithm.pageReplacement(PageReplacementAlgorithm.Type.LRU, false);
                //画表
                JTableDemo.main(null);
            }
            jLabel.repaint();
        });
        btn_OPT.addActionListener(e -> {
            if (cmb.getSelectedItem().equals("--请选择内存大小--")) {
                jLabel.setText("请选择内存大小");
            } else {
                jLabel.setText("");
                //获取内存大小
                PageReplacementAlgorithm.MEMORY_SIZE = Integer.valueOf(cmb.getSelectedItem().toString());
                //获取序列
                final String text = txtfield.getText();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) <= '9' && text.charAt(i) >= '0')
                        list.add(text.charAt(i) - '0');
                }
                int[] pageList = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    pageList[i] = list.get(i);
                }
                PageReplacementAlgorithm.PAGELIST = pageList;
                //计算
                PageReplacementAlgorithm.pageReplacement(PageReplacementAlgorithm.Type.OPT, false);
                //画表
                JTableDemo.main(null);
            }
            jLabel.repaint();
        });
        //------------------------------------------------
        frame.add(jp);
        frame.setBounds(300, 200, 800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
