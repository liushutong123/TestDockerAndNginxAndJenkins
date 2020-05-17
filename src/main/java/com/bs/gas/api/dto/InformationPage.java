package com.bs.gas.api.dto;

import com.bs.gas.base.BasePage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZeHua Li 2020/05/15 0:33
 */
@Data
@ApiModel(value = "加油信息查询dto")
public class InformationPage extends BasePage {

    @ApiModelProperty(value = "月份")
    private String month;

    @ApiModelProperty(value = "加油类型")
    private String type;

    @ApiModelProperty(value = "加油站名称")
    private String name;
}
