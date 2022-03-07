package 操作系统课设;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * 画折线图
 */
public class LineChart {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = PageReplacementAlgorithm.getDataset();

        JFreeChart chart = ChartFactory.createLineChart("各算法内存大小与缺页数的关系", // 主标题的名称
                "内存大小", // X轴的标签
                "缺页数", // Y轴的标签
                dataset, // 图标显示的数据集合
                PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
                true, // 是否显示子标题
                true, // 是否生成提示的标签
                true); // 是否生成URL链接 // 处理图形上的乱码 // 处理主标题的乱码、
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
        // 处理子标题乱码
        chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
        // 获取图表区域对象
        CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
        // 获取X轴的对象
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        // 获取Y轴的对象
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        // 处理X轴上的乱码
        categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
        // 处理X轴外的乱码
        categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
        // 处理Y轴上的乱码
        numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
        // 处理Y轴外的乱码
        numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
        // 处理Y轴上显示的刻度，以10作为1格
        numberAxis.setAutoTickUnitSelection(false);
        NumberTickUnit unit = new NumberTickUnit(1);
        numberAxis.setTickUnit(unit);
        // 获取绘图区域对象
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
        // 在图形上显示数字
        lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineAndShapeRenderer.setBaseItemLabelsVisible(true);
        lineAndShapeRenderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
        // 在图形上添加转折点（使用小矩形显示）
        Rectangle shape1 = new Rectangle(5, 5);
        Rectangle shape2 = new Rectangle(5, 10);
        Rectangle shape3 = new Rectangle(10, 5);
        lineAndShapeRenderer.setSeriesShape(2, shape1);
        lineAndShapeRenderer.setSeriesShapesVisible(2, true);
        lineAndShapeRenderer.setSeriesShape(1, shape2);
        lineAndShapeRenderer.setSeriesShapesVisible(1, true);
        lineAndShapeRenderer.setSeriesShape(0, shape3);
        lineAndShapeRenderer.setSeriesShapesVisible(0, true);
        /* 8、生成相应的图片 */
//        File file = new File("LineChart.JPEG");
//        try {
//            ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 使用ChartFrame对象显示图像
        ChartFrame frame = new ChartFrame("zfc", chart);
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.pack();
    }
}
