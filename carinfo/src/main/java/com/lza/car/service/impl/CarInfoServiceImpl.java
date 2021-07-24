package com.lza.car.service.impl;

import com.lza.car.dao.CarInfoDao;
import com.lza.car.pojo.CarInfo;
import com.lza.car.pojo.CarStock;
import com.lza.car.service.CarInfoService;
import com.lza.car.vo.BuyCarVO;
import com.lza.car.vo.CarInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CarInfo服务接口实现类
 *
 * @author          sj2x4w
 * @date            7/24/2021 2:43 PM
 * @version         1.0
 */
@Service
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    CarInfoDao carInfoDao;


    @Override
    public ResponseEntity<List<CarInfo>> getCarInfoByConditionService(CarInfoVO carInfoVO) {

        List<CarInfo> carInfoList = carInfoDao.selectCarInfoByConditon(carInfoVO);
        ResponseEntity<List<CarInfo>> responseEntity = new ResponseEntity<List<CarInfo>>(carInfoList, HttpStatus.OK);
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> buyCarService(BuyCarVO buyCarVO) {
        CarStock carStock = new CarStock();
        synchronized (this) {
            carStock = carInfoDao.selectCarInfoById(buyCarVO.getCarId());
        }
        if(carStock.getCarStock() < buyCarVO.getQuantity()){
            return new ResponseEntity<String>("当前车库存只有"+carStock.getCarStock()+",库存不足", HttpStatus.OK);
        }
        carInfoDao.updateCarStockById(buyCarVO.getCarId(), carStock.getCarStock() - buyCarVO.getQuantity());
        return new ResponseEntity<String>("购买成功！", HttpStatus.OK);
    }
}
