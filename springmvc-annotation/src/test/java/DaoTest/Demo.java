package DaoTest;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import org.junit.jupiter.api.Test;

public class Demo {
    private String AK = "8m3QRM9FR3byASYqPOcVn7gGKGPebjc6";

    private String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak="+AK+"&output=json&coordtype=wgs84ll&location=";

    @Test

    public void test1() throws UnsupportedEncodingException, IOException {
        url = url+"38.919129149643446,121.62003780078754&output=json";

        StringBuilder json = new StringBuilder();

        System.out.println(url);

        URL getUrl = null;

        try {
            getUrl = new URL(url);

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block

            e.printStackTrace();

        }

        URLConnection link = null;

        try {
            link = getUrl.openConnection();

        } catch (IOException e) {
// TODO Auto-generated catch block

            e.printStackTrace();

        }

        InputStreamReader io = new InputStreamReader(link.getInputStream(),"UTF-8");

        BufferedReader bufferedReader = new BufferedReader(io);

        String in = null;

        while ((in=bufferedReader.readLine())!= null) {
            json.append(in);

        }

        System.out.println(json);

    }

}
