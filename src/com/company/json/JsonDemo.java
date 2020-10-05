package com.company.json;


import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        //stringJson();
        //istJson();
        complexJson();
    }

    /**
     * 字符串解析成对应的user类
     */
    public static void stringJson() {
        String objectStr = "{\"name\":\"JAVA\",\"age\":\"1\"}";
        JSONObject jsonObject = JSONObject.fromObject(objectStr);
        user us = (user) JSONObject.toBean(jsonObject, user.class);

        System.out.println(us.getAge());
        System.out.println(us.getName());
    }

    /**
     * 接送数据中包含数组
     */

    public static void listJson() {
        String object = "{\"name\":\"JAVA\",\"age\":\"1\",\"goodList\":[{\"name\":\"JAVA\",\"age\":\"1\"}, {\"name\":\"C\",\"age\":\"2\"}]}";
        JSONObject jsonObject = JSONObject.fromObject(object);
        Map<String,Class> classmap = new HashMap<>();
        classmap.put("goodList", Goods.class);
        user user2 = (user)JSONObject.toBean(jsonObject, user.class, classmap);
        System.out.println(user2.getAge());
        List<Goods> list = user2.getGoodList();
        for(Goods goods : list){
            System.out.println("userAge"+goods.getAge()+"     "+"username"+goods.getName());
        }
    }

    public static void complexJson(){
        String weather = "{\"weather6\":" +
                "[{\"basic\":{\"cid\":\"北京\"}," +
                "\"daily_forecast\":[{\"cond_code_d\":\"103\"},{\"cond_code_d\":\"589\"},{\"cond_code_d\":\"584\"}]," +
                "\"status\":\"ok\"," +
                "\"update\":{\"loc\":\"2017-10-26\",\"utc\":\"2017-10-26\"}" +
                "}]}";
        //字符串转json
        JSONObject jo = JSONObject.fromObject(weather);
        //System.out.println(jo);
        //获取第二层数组，将其转成JSONArray,key为weather6
        JSONArray jsonArray = jo.getJSONArray("weather6");

        //JSONArray里只有一个数据（一个{}），所以value的下标为0
        JSONObject jsonObject2 = jsonArray.getJSONObject(0);

        //第三对的数据值
        String three = jsonObject2.get("status").toString();
        System.out.println(three);

        //第一对的数据值
        JSONObject one = jsonObject2.getJSONObject("basic");
        String oneCid = one.get("cid").toString();
        System.out.println(oneCid);

        //第四对取值
        JSONObject four = jsonObject2.getJSONObject("update");
        String fourloc = four.get("loc").toString();
        String fourutc = four.get("utc").toString();
        System.out.println("loc"+fourloc+"  "+"utc"+fourutc);

        //第二对取值
        JSONArray twos = jsonObject2.getJSONArray("daily_forecast");
        JSONObject two = null;
        List<Map<String, String>> maps = new ArrayList<>();
        for(int i=0;i<twos.size();i++){
            two=twos.getJSONObject(i);
            Map<String,String> map = new HashMap<>();
            map.put("天气情况",two.get("cond_code_d").toString());
            maps.add(map);
        }
        System.out.println(maps.toString());
    }


}



