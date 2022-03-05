package DaoTest;

import Service.JsonIml;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class test2 {
    public static void main(String[] args) {
        JsonIml jsonIml = new JsonIml();
        System.out.println(jsonIml.sendGet("https://restapi.amap.com/v3/geocode/geo", "address=大连&output=JSON&key=1d9801ec3c792505986ce94fb4d49ef7"));
        try {
            System.out.println(URLEncoder.encode("北京", "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
