package com.lza.car.service;

import com.lza.car.pojo.CarInfo;
import com.lza.car.vo.BuyCarVO;
import com.lza.car.vo.CarInfoVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
* CarInfo服务接口类
*
* @author          sj2x4w
* @date            7/24/2021 2:43 PM
* @version         1.0
*/
public interface CarInfoService {

     ResponseEntity<List<CarInfo>> getCarInfoByConditionService(CarInfoVO carInfoVO);

     ResponseEntity<String> buyCarService(BuyCarVO buyCarVO);
}
