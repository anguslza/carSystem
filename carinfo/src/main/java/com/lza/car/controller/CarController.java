package com.lza.car.controller;

import com.lza.car.pojo.CarInfo;
import com.lza.car.service.CarInfoService;
import com.lza.car.vo.BuyCarVO;
import com.lza.car.vo.CarInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
* 某个品牌的车辆模糊查询
 * 车辆购买功能
*
* @author          sj2x4w
* @date            7/24/2021 2:24 PM
* @version         1.0
*/
@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    CarInfoService carInfoService;

    @PostMapping("getCarByCondition")
    public ResponseEntity<List<CarInfo>> getCarInfoByCondition(@RequestBody CarInfoVO carInfoVO){
        return carInfoService.getCarInfoByConditionService(carInfoVO);
    }

    @PostMapping("buyCar")
    public ResponseEntity<String> BuyCar(@RequestBody BuyCarVO buyCarVO){
        return carInfoService.buyCarService(buyCarVO);
    }
}
