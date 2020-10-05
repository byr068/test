package com.tencent;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = in.next();
            list.add(s);
        }
        //Collections.sort(list);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                int temp = map.get(list.get(i));
                map.put(list.get(i),temp+1);
            }else{
                map.put(list.get(i),1);
            }
        }
        PriorityQueue<String> q1 = new PriorityQueue<>((o1,o2)->map.get(o1)==map.get(o2)?o2.compareTo(o1):map.get(o1)-map.get(o2));
        PriorityQueue<String> q2 = new PriorityQueue<>((o1,o2)->map.get(o1)==map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1));
        for(String i : map.keySet()){
            q1.add(i);
            if(q1.size()>k){
                q1.poll();
            }
        }
        for(String i : map.keySet()){
            q2.add(i);
            if(q2.size()>k){
                q2.poll();
            }
        }
        String[] res1 = new String[k];
        for(int i=0;i<k;i++){
            res1[i] = q1.poll();
            System.out.println(res1[i]+" "+map.get(res1[i]));
        }
        String[] res2 = new String[k];
        for(int i=0;i<k;i++){
            res2[i] = q2.poll();
            System.out.println(res2[i]+" "+map.get(res2[i]));
        }

    }
}
