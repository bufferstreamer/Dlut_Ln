package Dao;

import pojo.Station;

import java.util.List;

public interface StationDao {

    //查询全部站点
    List<Station> getStationList();
    //根据ID查询站点
    Station getStationByID(int id);
    //插入新的站点
    int addStation(Station station);
    //修改站点信息
    int updateStation(Station station);
    //删除站点信息
    int deleteStation(int id);
}
