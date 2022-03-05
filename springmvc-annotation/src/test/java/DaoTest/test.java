package DaoTest;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class test {


    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            System.out.println("urlNameString:==============>" + urlNameString);

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
          /*  for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String url = "https://restapi.amap.com/v5/direction/driving";
        String parameters = "address=北京&output=JSON&key=1d9801ec3c792505986ce94fb4d49ef7";
//        List<HashMap<String, Object>> jsonList = json.getJsonList(sendGet(url, parameters));
        String s = sendGet(url, parameters);
        System.out.println(s);
//        object json = new Gson().fromJson("", object.class);
//        for (int i = 0; i < json.route.paths.size(); i++) {
//            System.out.println(json.route.paths.get(i).distance);
//        }
         Map<Integer,String[]> Index_Location = new TreeMap<>();//将邻接矩阵的数字行转化为地址行
        String[] strs = new String[2];
        strs[0] = "d";

        Index_Location.put(0, strs);
        for (int i = 0; i < strs.length; i++){
            System.out.println(Index_Location.get(0)[i]);
        }
        strs[1] = "dd";
        for (int i = 0; i < strs.length; i++){
            System.out.println(Index_Location.get(0)[i]);

        }

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class object{
    public String status;
    public String info;
    public String infocode;
    public String count;
    public routeInfo route;
    static class routeInfo{
        public String origin;
        public String destination;
        public List<pathInfo> paths;
        static class pathInfo{
            public String distance;
            public String restriction;
            public List<stepInfo> steps;

            public static class stepInfo {
                public String instruction;
                public String orientation;
                public String road_name;
                public String step_distance;
            }
        }
    }

}
