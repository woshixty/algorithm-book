package 操作系统课设.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 图表数据
 */
@Getter
@Setter
public class ChartData {
    // id
    private String id;
    // 图表中每类数据的名称
    private String name;
    // 颜色
    private String color;
    // 数据
    private List<ChartProperty> dataList;
}

