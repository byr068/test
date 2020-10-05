package com.offer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class mostWords {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\words.txt");
        if(!file.exists()){
            System.out.println("文件不存在");
            return;
        }
        Scanner sc = new Scanner(file);
        Map<String,Integer> map = new HashMap<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] lineWords = line.split(" ");
            Set<String> wordSet = map.keySet();
            for(int i=0;i<lineWords.length;i++){
                if(wordSet.contains(lineWords[i])){
                    Integer number = map.get(lineWords[i]);
                    number++;
                    map.put(lineWords[i],number);
                }else {
                    map.put(lineWords[i],1);
                }
            }
        }
        System.out.println("统计单词：------------------------------");
        Iterator<String> iterator=map.keySet().iterator();
        int max=0;
        String maxword=null;
        while(iterator.hasNext()){
            String word=iterator.next();
            //System.out.printf("单词:%-12s 出现次数:%d\n",word,hashMap.get(word));
            if(map.get(word)>max) {                          //比较出现次数最多的单词
                max=map.get(word);
                maxword=word;
            }
        }
        System.out.println("出现最多的是"+maxword);
        System.out.println("最多出现了"+max+"次");
    }
}
