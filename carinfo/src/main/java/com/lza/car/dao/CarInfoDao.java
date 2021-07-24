package com.lza.car.dao;

import com.lza.car.pojo.CarInfo;
import com.lza.car.pojo.CarStock;
import com.lza.car.vo.CarInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.annotation.Resource;
import java.util.List;

/**
* CarInfo Dao类
* @author          sj2x4w
* @date            7/24/2021 3:01 PM
* @version         1.0
*/
@Mapper
@Resource
public interface CarInfoDao {

    @Select({"<script>",
            "SELECT * FROM (",
            "SELECT ROWNUM AS rowno, cm.* FROM CARMESSAGE cm",
            "WHERE ROWNUM &lt;= (#{carInfo.pageNum} * #{carInfo.pageSize})",
            "<if test=\"carInfo.carName!=null or carInfo.carName!=''\">",
            "AND CARNAME LIKE '%' || #{carInfo.carName} || '%'",
            "</if>",
            "<if test=\"carInfo.carSeries!=null or carInfo.carSeries!=''\">",
            "AND CARSERIES LIKE '%' || #{carInfo.carSeries} || '%'",
            "</if>",
            "<if test=\"carInfo.carType!=null or carInfo.carType!=''\">",
            "AND CARTYPE LIKE '%' || #{carInfo.carType} || '%'",
            "</if>",
            ") T WHERE T.ROWNO &gt; ((#{carInfo.pageNum}-1) * #{carInfo.pageSize}) ",
            "</script>"})
    List<CarInfo> selectCarInfoByConditon(@Param("carInfo")CarInfoVO carInfoVO);

    @Select("SELECT * FROM CARSTOCK WHERE CARID = #{carId} ")
    CarStock selectCarInfoById(@Param("carId") Integer carId);
    @Update("UPDATE CARSTOCK SET CARSTOCK = #{carStock} WHERE CARID = #{carId} ")
    int updateCarStockById(@Param("carId") Integer carId, @Param("carStock") Integer carStock);
}
