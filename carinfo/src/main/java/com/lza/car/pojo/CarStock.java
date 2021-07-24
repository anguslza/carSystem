package com.lza.car.pojo;

import lombok.Data;

/**
* car库存实体类
* @author          sj2x4w
* @date            7/24/2021 4:17 PM
* @version         1.0
*/
@Data
public class CarStock {

    private Integer id;
    private Integer carId;
    public String carName;
    public Integer carStock;
}
