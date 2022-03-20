package 操作系统课设.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 降雨实体
 */
@Getter
@Setter
public class ChartProperty {
    // 纵坐标
    private Double yvalue;
    // 横坐标
    private String xvalue;
    // 图表名类型
    private String chartName;
}

