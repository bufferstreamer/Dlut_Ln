//
//package dlut.ln.controller;
//
//import Service.AddressDistanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.*;
//
//@Controller
//@RequestMapping("test")
//
//public class TravelingSalesman {
//
//    @Autowired
//    private  AddressDistanceService addressDistanceService;
//
//
//
//    public int count = 0;     //定义全局变量，用于计算当前已行走方案次数，初始化为0
//    public double MinDistance = 99999;    //定义完成一个行走方案的最短距离，初始化为99999（PS：99999此处表示比实际要大很多的距离）
////    public int[][] distance = {{0,2,5,7},{2,0,8,3},{5,8,0,1},{7,3,1,0}};   //使用二维数组的那个音图的路径相关距离长度
//    static List<String> sentLocations = new ArrayList<>();
//    static List<String> receiveLocations = new ArrayList<>();
//    public static Map<Integer,String> Index_Location = new TreeMap<>();//将邻接矩阵的数字行转化为地址行
//
//      {
//        sentLocations.add("北京");
//        receiveLocations.add("上海");
//        receiveLocations.add("天津");
//        receiveLocations.add("大连");
//         System.out.println(Arrays.deepToString(getChartMatrix(sentLocations, receiveLocations)));
//    }
//    public double[][] distance = getChartMatrix(sentLocations,receiveLocations);   //使用二维数组的那个音图的路径相关距离长度
//    public static Map<Integer,String > Map = new TreeMap<>();
//    public static Map<String, Double> result = new TreeMap<>();
//    public static String route = "";
//
///*
//     * start为开始进行排序的位置
//     * step为当前正在行走的位置
//     * n为需要排序的总位置数
//     * Max为n!值
//*/
//    public void Arrange(int[] A,int start,int step,int n,int Max){
//        if(step == n){   // 当正在行走的位置等于城市总个数时
//            ++count;           //每完成一次行走方案，count自增1
//            printArray(A);     //输出行走路线方案及其总距离
//        }
//        if(count == Max){
//            Set<String> keys = result.keySet();
//            String final_key = "";
//            double i = 10000;
//            for (String key : keys) {
////                System.out.println(key + result.get(key));
//
//                double final_result = result.get(key);
//                if (final_result < i){
//                    final_key = key;
//                    i = final_result;
//                }
//            }
//            System.out.println("已生成最短路径方案：" + final_key + result.get(final_key));
////            System.out.println("已完成全部行走方案！！！,最短路径距离为:"+MinDistance);
//        }
//        else{
//            for(int i = start;i < n;i++){
//
///*第i个数分别与它后面的数字交换就能得到新的排列,从而能够得到n!次不同排序方案
//                 * （PS：此处代码中递归的执行顺序有点抽象，具体解释详见本人另一篇博客：）
//                 *算法笔记_017:递归执行顺序的探讨（Java）
//                 */
//
//                swapArray(A,start,i);
//                Arrange(A,start+1,step+1,n,Max);
//                swapArray(A,i,start);
//            }
//        }
//    }
//
//    //交换数组中两个位置上的数值
//    public  void swapArray(int[] A,int p,int q){
//        int temp = A[p];
//        A[p] = A[q];
//        A[q] = temp;
//    }
//
//    //输出数组A的序列，并输出当前行走序列所花距离，并得到已完成的行走方案中最短距离
//    public void printArray(int[] A){
//        for(int i = 0;i < A.length;i++)   //输出当前行走方案的序列
//        {
//            route += (Index_Location.get(A[i]) + " ");
////            System.out.print(Map.get(A[i]) + "  ");
//        }route +=  "  行走路程总和：";
////        System.out.println(route);
//
//        double tempDistance = distance[A[0]][A[3]];     //此处是因为，最终要返回出发地城市，所以总距离要加上最后到达的城市到出发点城市的距离
//        for(int i = 0;i < (A.length-1);i++)   //输出当前行走方案所花距离
//            tempDistance += distance[A[i]][A[i+1]];
//
//        if(MinDistance > tempDistance){//返回当前已完成方案的最短行走距离
//            MinDistance = tempDistance;
//        }
//        result.put(route, (double) tempDistance);
////        System.out.println(route + result.get(route));
//        route = "";
////        System.out.println("  行走路程总和："+tempDistance);
//    }
//    //根据起点和多个终点得到不同点之间的距离的无向图矩阵
//    public  double[][] getChartMatrix(List<String> sentLocations, List<String> receiveLocations){
//        int size = sentLocations.size() + receiveLocations.size();//总共有多少个地点，即无向图的矩阵的行数或列数
//        double [][]distances = new double[size][size];//存储生成的无向图矩阵
//        double distance;//临时变量
//        List<String> locations = new ArrayList<>();//存放所有的地点的集合
////        AddressDistanceIml addressDistanceIml = new AddressDistanceIml();
//
//        locations.addAll(sentLocations);
//        locations.addAll(receiveLocations);
//
//        //将矩阵的边由索引变为地点名词
//        for (int i = 0; i < size; i++){
//            Index_Location.put(i,locations.get(i));
//        }
//        //初始化矩阵除对角元外的所有元素
//        for (int i = 0; i < locations.size(); i++){
//            for (int j = 0; j < locations.size(); j++){
//                if (i != j){
//                    distance = addressDistanceService.getAddressDistanceListByAddress(locations.get(i), locations.get(j)).getDistance();
//                    distances[i][j] = distance;
//                }
//            }
//        }
//
//        //初始化矩阵的对角元素
//        for (int i = 0; i < size; i++){
//            distances[i][i] = 99999;
//        }
//
//        return distances;
//    }
//
//
//    @RequestMapping("main")
//   public void main(){
//        int[] A = {0,1,2,3};
//
//
//        Arrange(A,0,0,4,24);    //此处Max = 4!=24
//    }
//
//
//}
//
