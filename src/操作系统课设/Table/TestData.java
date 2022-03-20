package 操作系统课设.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestData {
    /**
     * 数据库获取数据
     */
    public static List<ChartData> getDateBssw() {
        List<ChartData> returndate = new ArrayList<>();
        ChartData line = new ChartData();
        line.setName("坝上水位");
        line.setColor("#FFFD38");
        List<ChartProperty> dateList1 = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            ChartProperty d1 = new ChartProperty();
            d1.setYvalue(Double.parseDouble(new Random().nextInt(400) + ""));
            d1.setChartName("坝上水位");
            d1.setXvalue("" + i);
            dateList1.add(d1);
        }
        line.setDataList(dateList1);
        returndate.add(line);
        return returndate;
    }
}

