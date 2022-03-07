package 操作系统课设.Table;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 折线图基类
 */
public class XyChartFacDemo {
    //全部数据
    public List<ChartData> date;
    //当前要展示数据
    public List<ChartData> dateNow;
    //每一条折线的最大最小值
    public List<MaxMinCoordinat> value;
    //定义整个界面panel
    private JPanel contentPane;
    //折线图变量
    private final JFreeChart xylineChart = null;
    //折线图图表
    private JFreeChart lineChart;
    //数据集
    private TimeSeriesCollection dataset;
    //是否需要顯示
    private final boolean isShowX;
    //是否要查询条件
    private boolean isHaveSelect = false;
    //每隔多长时间一个数据点
    private int timeinterval = 15;
    //已知数据点时间长度，算出一天之内有多少个数据点/一天之内的总数据点个数
    private final int dataPoint = (24 * 60) / timeinterval;
    //下拉数据
    private List<String> selectData = new ArrayList<String>();
    private String[] list;

    /**
     * 构造方法
     */
    public XyChartFacDemo() {
        this(false);
    }

    public XyChartFacDemo(boolean isShowX) {
        this.isShowX = isShowX;
        date = new ArrayList<>();
        dateNow = new ArrayList<>();
    }

    public void init() {
        if (selectData != null && selectData.size() > 0) {
            list = new String[selectData.size()];
            for (int i = 0; i < selectData.size(); i++) {
                list[i] = selectData.get(i);
            }
        }

    }

    /**
     * 重新查询数据，刷新折线图
     */
    public void zxtPushData() {
        //查询数据
        //数据处理
        //刷新折线图
		LineChart push = new LineChart();
    }

    /**
     * Create the frame.
     * 获取一个折线图jpanel
     */
    public JPanel getChooseshow(List<ChartData> dateList) {
        contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setLayout(new BorderLayout(0, 0));

        getDate(dateList);
        //获取折线图
        LineChart xy = new LineChart();
        ChartPanel charpanal = xy.getCharPanel(createDataset(dateList));
        contentPane.add(charpanal, BorderLayout.CENTER);

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout(0, 0));
        top.setOpaque(false);
        contentPane.add(top, BorderLayout.NORTH);
        //放多选框按钮
        JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        top.add(panel_2, BorderLayout.WEST);
        if (isHaveSelect) {
            top.add(getCz(), BorderLayout.CENTER);
        }
        //循环添加选择框，并注册响应事件
        for (int i = 0; i < dateList.size(); i++) {
            JCheckBox checkBox = new JCheckBox(dateList.get(i).getName());
            checkBox.setOpaque(false);
            checkBox.setForeground(Color.decode(dateList.get(i).getColor()));
            checkBox.setFont(new Font("苹方字体", Font.PLAIN, 17));
            checkBox.setSelected(true);
            checkBox.setName(dateList.get(i).getName());
            panel_2.add(checkBox);
            //入库流量选择框触发事件
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    JCheckBox check = (JCheckBox) e.getSource();
                    // TODO Auto-generated method stub
                    if (!check.isSelected()) {
                        List<ChartData> xqlist = new ArrayList<ChartData>();
                        for (ChartData rk : dateNow) {
                            if (check.getName() != null && !"".equals(check.getName())) {
                                if (!check.getName().equals(rk.getName())) {
                                    xqlist.add(rk);
                                }
                            }
                        }
                        dateNow = xqlist;
                        updateDate(createDataset(dateNow));
                    } else {
                        for (ChartData rk : date) {
                            if (check.getName() != null && !"".equals(check.getName())) {
                                if (check.getName().equals(rk.getName())) {
                                    dateNow.add(rk);
                                }
                            }
                        }
                        updateDate(createDataset(dateNow));
                    }
                }
            });
        }
        return contentPane;
    }

    /**
     * 厂站
     *
     * @return
     */
    private JPanel getCz() {
        //厂站
        JPanel cz = new JPanel();
        cz.setOpaque(false);


        JLabel label_1 = new JLabel("厂（场）站：");
        label_1.setFont(new Font("宋体", Font.PLAIN, 20));
        label_1.setForeground(Color.WHITE);
        cz.add(label_1);
        init();
        final JComboBox box = new JComboBox(list);
        box.setPreferredSize(new Dimension(150, 25));
        box.setUI(new NewJComboBox());
        box.setBackground(Color.decode("#1A5C63"));
        box.setForeground(Color.white);
        box.setBorder(BorderFactory.createLineBorder(Color.decode("#1A5C63"), 1));
        (box.getEditor().getEditorComponent()).setBackground(Color.decode("#1A5C63"));
        (box.getEditor().getEditorComponent()).setForeground(Color.WHITE);
        // 添加条目选中状态改变的监听器
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + box.getSelectedIndex() + " = " + box.getSelectedItem());
                }
            }
        });
        box.setEditable(true);
        box.setSelectedIndex(1);
        cz.add(box);
        return cz;
    }

    /**
     * 数据库获取数据
     */
    public void getDate(List<ChartData> dateList) {
        date = dateList;
        dateNow = dateList;
    }

    /**
     * 数据出力
     *
     * @return
     */
    public XYDataset createDataset(List<ChartData> pushdata) {
        //刷新时根据勾选按钮刷新，只重新装载勾中的框的 数据
        List<ChartData> data = new ArrayList<ChartData>();
        for (int i = 0; i < pushdata.size(); i++) {
            int t = 0;
            for (int j = 0; j < dateNow.size(); j++) {
                if (pushdata.get(i).getName().equals(dateNow.get(j).getName())) {
                    t++;
                }
            }
            if (t > 0) {
                data.add(pushdata.get(i));
            }
        }
        dataset = new TimeSeriesCollection();
        value = new ArrayList<MaxMinCoordinat>();
        Hour day = new Hour(0, new Day());

        for (int i = 0; i < data.size(); i++) {
            TimeSeries series = new TimeSeries(data.get(i).getName(), Minute.class);
            double max = 0;
            int ymax = 0;
            double min = 100000000;
            int ymin = 0;

            Minute hour22 = new Minute(0, day);
            int count = data.get(i).getDataList().size();//折线的数据量
            for (int j = 0; j < dataPoint; j++) {//一天之内的总数据点个数
                if (j < count) {
                    if (max < data.get(i).getDataList().get(j).getYvalue()) {
                        max = data.get(i).getDataList().get(j).getYvalue();
                        ymax = j;
                    }
                    if (min > data.get(i).getDataList().get(j).getYvalue()) {
                        min = data.get(i).getDataList().get(j).getYvalue();
                        ymin = j;
                    }
                    series.add(hour22, data.get(i).getDataList().get(j).getYvalue());
                } else {
                    series.add(hour22, null);
                }
                for (int t = 0; t < timeinterval; t++) {
                    hour22 = (Minute) hour22.next();
                }
            }
            dataset.addSeries(series);
            MaxMinCoordinat maxVal = new MaxMinCoordinat();
            maxVal.setRow(1);//0：最小值       1：最大值
            maxVal.setXcoord(i);
            maxVal.setYcoord(ymax);
            value.add(maxVal);
            MaxMinCoordinat minVal = new MaxMinCoordinat();
            minVal.setRow(0);//0：最小值       1：最大值
            minVal.setXcoord(i);
            minVal.setYcoord(ymin);
            value.add(minVal);
        }
        return dataset;
    }

    /**
     * 刷新数据
     *
     * @param dataset
     * @return
     */
    public void updateDate(XYDataset dataset) {
        //刷新时根据勾选按钮刷新，只重新装载勾中的框的 数据
        XYPlot plot = (XYPlot) lineChart.getPlot();
        plot.setDataset(dataset);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();// 设置样式
        for (int i = 0; i < dateNow.size(); i++) {
            renderer.setSeriesPaint(i, Color.decode(dateNow.get(i).getColor()));
            renderer.setSeriesStroke(i, new BasicStroke(2.0f));
            renderer.setSeriesItemLabelPaint(i, Color.decode(dateNow.get(i).getColor()));
        }
    }

    public JFreeChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(JFreeChart lineChart) {
        this.lineChart = lineChart;
    }

    class LineChart {

        /**
         * 获取一个折线图
         *
         * @return
         */
        public void getjfreechar(XYDataset data) {
            lineChart = ChartFactory.createTimeSeriesChart(
                    "",
                    "",
                    "",
                    data,
                    false, true, false);
            lineChart.setBorderVisible(false);
            lineChart.setBackgroundPaint(null);
            lineChart.setBorderPaint(Color.red);
            lineChart.setBorderStroke(null);
            XYPlot plot = (XYPlot) lineChart.getPlot();

            plot.setRangeZeroBaselineVisible(true);
//     		plot.getDomainAxis().setLowerMargin(0.02);//数据区距离左右的距离
//     		plot.getDomainAxis().setUpperMargin(0.01);
            plot.getDomainAxis().setLowerMargin(0.0D);//数据区距离左右的距离
            plot.getDomainAxis().setUpperMargin(0.0D);
            plot.setDomainGridlinesVisible(false);//竖直网格线隐藏
            plot.setBackgroundAlpha(0);
            plot.setOutlineVisible(false);//数据区黑色边框不可见
            plot.getDomainAxis().setAxisLinePaint(Color.decode("#3CB5FC"));// X坐标轴颜色
            // 设置网格横线颜色
            plot.setRangeGridlinePaint(Color.decode("#1D566E"));
            plot.setRangeGridlineStroke(new BasicStroke(2));
            //x轴设置
            if (isShowX) {//显示横坐标刻度值
                plot.getDomainAxis().setTickLabelPaint(Color.decode("#00F4FC"));
            } else {
                plot.getDomainAxis().setTickLabelsVisible(false);
            }

            plot.getDomainAxis().setTickMarksVisible(false);
            plot.getDomainAxis().setAxisLinePaint(Color.decode("#1D566E"));//x轴颜色
            plot.getDomainAxis().setAxisLineStroke(new BasicStroke(2));
//     		categoryAxis.setVisible(false);
            // 取得纵轴
            plot.getRangeAxis().setAxisLineVisible(false);
            plot.getRangeAxis().setTickMarksVisible(false);
            NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
//     		numberAxis.setTickUnit(new NumberTickUnit(100));//纵轴每100一个刻度
            numberAxis.setTickLabelPaint(Color.decode("#13BBBF"));
            numberAxis.setUpperMargin(0.15);//设置最高数据显示与顶端的距离
            numberAxis.setLowerMargin(2);//设置最低的一个值与图片底端的距离
            numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            //设置折线颜色
            @SuppressWarnings("serial")
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer() {
                @Override
                public boolean getItemShapeVisible(int series, int item) {
                    // TODO Auto-generated method stub

                    boolean ret = false;
                    for (MaxMinCoordinat val : value) {

                        if (val.getXcoord() == series && val.getYcoord() == item) {//最大值
                            ret = true;
                            return ret;
                        } else {
                            ret = false;
                        }
                    }
                    return ret;
                }

            };
            XYItemLabelGenerator st = (dataset, row, column) -> {
                String ret = "";
                for (MaxMinCoordinat val : value) {

                    if (val.getRow() == 1 && val.getXcoord() == row && val.getYcoord() == column) {//最大值
                        ret = "max:" + dataset.getYValue(row, column);
                        return ret;
                    } else if (val.getRow() == 0 && val.getXcoord() == row && val.getYcoord() == column) {//最小值
                        ret = "min:" + dataset.getYValue(row, column);
                        return ret;
                    } else {
                        ret = "";
                    }
                }
                return ret;
            };

            renderer.setBaseItemLabelGenerator(st);
            for (int i = 0; i < dateNow.size(); i++) {
                renderer.setSeriesPaint(i, Color.decode(dateNow.get(i).getColor()));
                renderer.setSeriesStroke(i, new BasicStroke(2.0f));
                renderer.setSeriesItemLabelPaint(i, Color.decode(dateNow.get(i).getColor()));
            }
            renderer.setBaseItemLabelsVisible(true);
            renderer.setDrawOutlines(true);
            // 设置拐点是否可见/是否显示拐点
            renderer.setBaseShapesVisible(true);
            plot.setRenderer(renderer);
        }

        /**
         * 获取ChartPanel
         * @param data
         * @return
         */
        public ChartPanel getCharPanel(XYDataset data) {
            getjfreechar(data);
            ChartPanel chartPanel = new ChartPanel(lineChart);
            chartPanel.setOpaque(false);
            chartPanel.setMouseZoomable(true, false);
            return chartPanel;
        }
    }
}
