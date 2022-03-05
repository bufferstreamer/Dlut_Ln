/*
package dlut.ln.controller;

import Service.AddressDistanceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller

@RequestMapping("/tt")
public class tt {
    @Autowired
    private  AddressDistanceService addressDistanceService;
//    private AddressDistanceIml addressDistanceIml = new AddressDistanceIml();

    public static List<String> receiveLocations = new ArrayList<>();//收货地址集合
    public static List<String> sentLocation = new ArrayList<>();//发货地址，即当前仓库地址
    public  Map<Integer,String> Index_Location = new TreeMap<>();//将邻接矩阵的数字行转化为地址行
    static double[][] distance = new double[4][4];
    {
        sentLocation.add("北京");
        receiveLocations.add("上海");
        receiveLocations.add("天津");
        receiveLocations.add("大连");
    }
//    @Autowired
//    public tt(AddressDistanceService addressDistanceService){
//            tt.addressDistanceService = addressDistanceService;
//
//    }
    public  double[][] getChartMatrix(List<String> sentLocations, List<String> receiveLocations){
        int size = sentLocations.size() + receiveLocations.size();//总共有多少个地点，即无向图的矩阵的行数或列数
        double [][]distances = new double[size][size];//存储生成的无向图矩阵
        List<String> locations = new ArrayList<>();//存放所有的地点的集合
//        AddressDistanceIml addressDistanceIml = new AddressDistanceIml();


        locations.addAll(sentLocations);
        locations.addAll(receiveLocations);

        //将矩阵的边由索引变为地点名词
        for (int i = 0; i < size; i++){
            Index_Location.put(i,locations.get(i));
        }
        //初始化矩阵除对角元外的所有元素
        for (int i = 0; i < locations.size(); i++){
            for (int j = 0; j < locations.size(); j++){
                if (i != j){
                    distances[i][j] = addressDistanceService.getAddressDistanceListByAddress(locations.get(i), locations.get(j)).getDistance();
                }
            }
        }

        //初始化矩阵的对角元素
        for (int i = 0; i < size; i++){
            distances[i][i] = 99999;
        }

        return distances;
    }

@RequestMapping("/main")
public  void main() {
    System.out.println(sentLocation);
    System.out.println(addressDistanceService.getAddressDistanceList());
    System.out.println(receiveLocations);
        System.out.println(Arrays.deepToString(getChartMatrix(sentLocation, receiveLocations)));
        distance = getChartMatrix(sentLocation, receiveLocations);

}
}
*/
