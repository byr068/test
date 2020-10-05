package com;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Person> waibao = new HashMap<>();
        HashMap<String,Person> Manger = new HashMap<>();
        HashMap<String,Person> thezuzhang = new HashMap<>();
        while(in.hasNext()){
            String s = in.nextLine();
            if("eof".equals(s)){
                in.close();
                break;
            }
            String[] split = s.split(",");
            if(split.length == 2){
                Person person = new Person(split[0],Integer.valueOf(split[1]));
                waibao.put(split[0],person);
            }
            if(split.length==3){
               String managerName = split[0];
               Person manager;
                Person zuzhang;
               String zuzhangName = split[1];
               String curWaibaoName = split[2];
               Person curWaibao = waibao.get(curWaibaoName);
               if(!thezuzhang.containsKey(zuzhangName)){
                   zuzhang = new Person(zuzhangName);
                   thezuzhang.put(zuzhangName,zuzhang);
               }else{
                   zuzhang = thezuzhang.get(zuzhangName);
               }
               zuzhang.count += curWaibao.count;
               zuzhang.sub.add(curWaibaoName);
               if(!Manger.containsKey(managerName)){
                   manager = new Person(managerName);
                   Manger.put(managerName,manager);
               }else{
                   manager = Manger.get(managerName);
               }
               manager.sub.add(zuzhangName);
            }
        }
        for(String m:Manger.keySet()){
            int count = 0;
            Person manger = Manger.get(m);
            Set<String> sub = manger.sub;
            for(String zuyuan : sub){
                count += thezuzhang.get(zuyuan).count;
            }
            manger.count = count;
        }
        List<Person> managerList  = new ArrayList<>();
        for(String m:Manger.keySet()){
            managerList.add(Manger.get(m));
        }
        Comparator<Person> comparator = (o1,o2)->{
            if(o1.count == o2.count) {
                return o1.name.compareTo(o2.name);
            }else
                return o2.count - o1.count;

        };
        Collections.sort(managerList,comparator);
        for(Person m : managerList){
            System.out.println(m.print());
            Set<String> sub = m.sub;
            List<Person> myZuyuan = new ArrayList<>();
            for(String z:sub){
                Person zuzhang = thezuzhang.get(z);
                myZuyuan.add(zuzhang);
            }
            Collections.sort(myZuyuan,comparator);
            for(int i=0;i<myZuyuan.size();i++){
                Person zu = myZuyuan.get(i);
                System.out.println("-"+zu.print());
                Set<String> zusub = zu.sub;
                List<Person> myWaibao = new ArrayList<>();
                for(String wai:zusub){
                    Person waibao2 = waibao.get(wai);
                    myWaibao.add(waibao2);
                }
                Collections.sort(myWaibao,comparator);
                for(int j=0;j<myWaibao.size();j++){
                    System.out.println("--"+myWaibao.get(j).print());
                }
            }
        }
    }
}
class Person{
    String name;
    int count;
    Set<String> sub;
    public Person(String name,int count){
        this.name = name;
        this.count = count;
        this.sub = new HashSet<>();
    }
    public Person(String name){
        this.name = name;
        this.count = 0;
        this.sub = new HashSet<>();
    }
    public String print(){
        return name+"<"+this.count+">";
    }
}