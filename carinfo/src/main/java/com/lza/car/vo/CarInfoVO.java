package com.lza.car.vo;

import lombok.Data;

/**
* 车辆实VO类
*
* @author          sj2x4w
* @date            7/24/2021 2:26 PM
* @version         1.0
*/
@Data
public class CarInfoVO extends BaseVO{

    private String carName;
    private String carType;
    private String carSeries;

}
