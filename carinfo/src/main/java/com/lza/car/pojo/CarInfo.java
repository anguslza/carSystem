package com.lza.car.pojo;

import lombok.Data;

/**
 * 车辆实体类
 *
 * @author          sj2x4w
 * @date            7/24/2021 2:26 PM
 * @version         1.0
 */
@Data
public class CarInfo {

    private Integer id;
    private String carName;
    private String price;
    private String carSeries;
    private String carType;
}
