package com.company.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args){
        //创建电台
        HashMap<String,HashSet<String>> broadcasts =  new HashMap<String, HashSet<String>>();
        //添加频道
        HashSet<String> hs1 = new HashSet<String>();
        hs1.add("北京");
        hs1.add("上海");
        hs1.add("天津");

        HashSet<String> hs2 = new HashSet<String>();
        hs2.add("广州");
        hs2.add("北京");
        hs2.add("深圳");

        HashSet<String> hs3 = new HashSet<String>();
        hs3.add("成都");
        hs3.add("上海");
        hs3.add("杭州");

        HashSet<String> hs4 = new HashSet<String>();
        hs4.add("上海");
        hs4.add("天津");

        HashSet<String> hs5 = new HashSet<String>();
        hs5.add("杭州");
        hs5.add("大连");

        broadcasts.put("k1",hs1);
        broadcasts.put("k2",hs2);
        broadcasts.put("k3",hs3);
        broadcasts.put("k4",hs4);
        broadcasts.put("k5",hs5);

        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建一个ArrayList,存放选择的电台合集
        ArrayList<String> selects = new ArrayList<String>();
        //定义一个临时的集合，在便利的过程中，存放遍历过程中的电台覆盖的地区和当前没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<String>();

        //定义maxKey,保存再一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey不等于null,则加入到selects
        String maxKey =null;
        while(allAreas.size()!=0){ //如果allAreas不等于null，则表示还没有覆盖所有的地区
            //每一次循环需要将maxKey清空
            maxKey = null;
            //遍历broadcasts,取出对应的key
            for(String key:broadcasts.keySet()){
                //每一次循环需要将tempSet清空
                tempSet.clear();

                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas的交集，交集会付给tempSet
                tempSet.retainAll(allAreas);
                //如果当前的tempSet包含的未覆盖的地区的数量比maxKey指向的集合地区多
                //需要重置maxKey
                //tempSet.size()>broadcasts.get(key).size()体现贪心算法的特点，每次选择都是最优的
                if(tempSet.size()>0&&
                        (maxKey == null || tempSet.size()>broadcasts.get(key).size())){
                    maxKey = key;
                }
            }
            //maxKey不等于null,就应该把maxKey加到selects
            if(maxKey!=null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas中删去
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }
        System.out.println(selects);
    }


}
