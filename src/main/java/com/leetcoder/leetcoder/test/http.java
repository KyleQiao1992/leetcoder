package com.leetcoder.leetcoder.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 9:34 下午 2022/6/2
 **/
public class http {

    private static String file_path = "/Users/a11080314/Desktop/secureRes.txt";

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    private static Map<Integer, String> stateMap = new HashMap<>();

    static {
        stateMap.put(23, "Wisconsin");
        stateMap.put(28, "Alaska");
        stateMap.put(31, "North Carolina");
        stateMap.put(32, "Wyoming");

//        stateMap.put(25, "California");
//        stateMap.put(11, "Texas");
//        stateMap.put(1, "Not Listed");
//        stateMap.put(39, "Arizona");
//        stateMap.put(30, "Florida");
//        stateMap.put(14, "Georgia");
//        stateMap.put(6, "New York");
//
//        stateMap.put(2, "Colorado");
//        stateMap.put(7, "Virginia");
//        stateMap.put(10, "Pennsylvania");
//        stateMap.put(18, "Illinois");
//        stateMap.put(9, "Washington");
//        stateMap.put(29, "New Jersey");
//        stateMap.put(36, "Tennessee");
//        stateMap.put(51, "Nevada");
//        stateMap.put(22, "Ohio");
//        stateMap.put(42, "Oregon");
//        stateMap.put(16, "Oklahoma");
//        stateMap.put(5, "South Carolina");
//        stateMap.put(38, "Minnesota");
//        stateMap.put(45, "Utah");
//        stateMap.put(4, "Maryland");
//        stateMap.put(12, "Louisiana");
//        stateMap.put(20, "Mississippi");
//        stateMap.put(8, "New Mexico");
//        stateMap.put(33, "Alabama");
//        stateMap.put(19, "Indiana");
//        stateMap.put(34, "Michigan");
//        stateMap.put(13, "Massachusetts");
//        stateMap.put(21, "Nebraska");
//        stateMap.put(17, "Iowa");
//        stateMap.put(35, "Kansas");
//        stateMap.put(3, "Idaho");
//        stateMap.put(40, "Arkansas");
//        stateMap.put(15, "Kentucky");
//
//        stateMap.put(41, "Missouri");
//        stateMap.put(47, "Connecticut");
//
//        stateMap.put(49, "West Virginia");
//        stateMap.put(44, "South Dakota");
//        stateMap.put(55, "Delaware");
//        stateMap.put(52, "Rhode Island");
//        stateMap.put(27, "Puerto Rico");
//        stateMap.put(46, "New Hampshire");
//        stateMap.put(54, "District of Columbia");
//        stateMap.put(50, "Hawaii");
//        stateMap.put(43, "North Dakota");
//        stateMap.put(37, "Maine");
//        stateMap.put(48, "Montana");
//        stateMap.put(26, "Guam");
//
//        stateMap.put(56, "Northern Mariana Islands");
//        stateMap.put(53, "Virgin Islands");
//        stateMap.put(24, "Vermont");

    }

    public static void main(String[] args) {
        //获取州
        for (Integer stateId : stateMap.keySet()) {
            bufferedOutputStreamMethod(file_path, "___________________这是 " + stateMap.get(stateId) + "的数据 start ____________________________\n");

            try {
                //获取country
                Request countryRes = new Request.Builder()
                        .url("https://trac.syr.edu/phptools/immigration/secure/table.php?stat=count&LEA_state=" + stateId + "&dimension=trac_fac_name_county&sort=valdesc")
                        .get()
                        .build();

                Response response = okHttpClient.newCall(countryRes).execute();
                if (response.body() == null) {
                    return;
                }
                String respStr = response.body().string();
                Document doc = Jsoup.parse(respStr);
                Elements trs = doc.select("table").select("tr");

                List<String> countryIdList = new ArrayList<>();
                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).select("a");
                    for (int j = 0; j < tds.size(); j++) {
                        Elements hrefElement = tds.get(j).getElementsByAttribute("href");
                        String hrefElementStr = hrefElement.toString();
                        if (hrefElementStr.contains("tableSortClick") || hrefElementStr.contains("ALL") || hrefElementStr.contains("All")) {
                            continue;
                        }

                        hrefElementStr = hrefElementStr.replace("<A HREF=\"javascript:m.tableClick(", "");
                        hrefElementStr = hrefElementStr.replace("<a href=\"javascript:m.tableClick(", "");

                        hrefElementStr = hrefElementStr.replace(");\">", ",");
                        hrefElementStr = hrefElementStr.replace("</a>", "");

                        countryIdList.add(hrefElementStr);
                    }
                }

                Map<String, String> countryMap = new HashMap<>();

                for (String country : countryIdList) {
                    String[] strs = country.split(",");
                    if (strs.length < 3) {
                        continue;
                    }
                    countryMap.put(strs[1], strs[2]);
                }


                countryMap.keySet().parallelStream().forEach(countryIdStr -> {
                    try {
                        String countryName = countryMap.get(countryIdStr);
                        countryIdStr = countryIdStr.replace("'", "");
                        Request resReq = new Request.Builder()
                                .url("https://trac.syr.edu/phptools/immigration/secure/graph.php?stat=count&timescale=fymon&LEA_state=" + stateId + "&trac_fac_name_county=" + countryIdStr + "&timeunit=number")
                                .get()
                                .build();

                        Response resResp = okHttpClient.newCall(resReq).execute();
                        if (resResp.body() == null) {
                            return;
                        }
                        String resStr = resResp.body().string();
                        JSONObject resJson = JSONObject.parseObject(resStr);

                        if (resJson != null && resJson.containsKey("timeline")) {
                            JSONArray timelineArr = resJson.getJSONArray("timeline");
                            if (timelineArr == null || timelineArr.size() == 0) {
                                int a = 0;
                            }
                            String resLine = null;
                            for (int i = 0; i < timelineArr.size(); i++) {
                                JSONObject object = timelineArr.getJSONObject(i);
                                if (object != null && object.containsKey("number") && object.containsKey("fymon")) {
                                    String fymon = object.getString("fymon");
                                    String num = object.getString("number");

                                    resLine = stateMap.get(stateId) + "," + countryName + "," + fymon + "," + num + "\n";
                                    bufferedOutputStreamMethod(file_path, resLine);
                                }
                            }
                        }

                    } catch (Exception e) {

                    }
                });
            } catch (Exception e) {

            }
            bufferedOutputStreamMethod(file_path, "___________________这是 " + stateMap.get(stateId) + "的数据 end ____________________________\n\n");
        }
    }


    public static void bufferedOutputStreamMethod(String filepath, String content) {

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(filepath, true))) {
            bufferedOutputStream.write(content.getBytes());
        } catch (Exception e) {

        }
    }


}
