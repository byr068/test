package com.com.meituan;

import java.util.*;

public class word {
    /*
    去掉了分隔符的英文文章和一本字典（用小写字母表示），要他求出有多少种可以翻译的方法。
    第一行表示文章，长度不超过5000
    第二行包含一个正整数N（2<=N<=50000）。表示字典的单词数量
    接下来的N行，每行表示一个单词（单词长度不超过20）
    输出描述：
    一个正整数，考虑到结果数值可能是非常大，输出对835672545的余数即可
    如果无法翻译，输出0
    输入：
    abcba
    5
    ab
    cb
    bc
    ba
    a
    输出：
    2
    说明：ab,cb,a
          a,dc,ba
     */
    static int flag = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s==null||s.length()==0) System.out.println(0);
        int n = in.nextInt();
        String[] sb = new String[n];
        for(int i=0;i<n;i++){
            sb[i] = in.next();
        }
        helper(sb,new ArrayList<>(),s);
        System.out.println(flag%835672545);
    }
    static void helper(String[] sb, List<String> list, String s){
        String res = "";
        for(String s1:list){
            res+=s1;
        }
        if(res.length()>=s.length()){
            if(res.equals(s)){
                flag++;
                System.out.println("res:"+res+flag);
            }
            return;
        }
        for(int i=0;i<sb.length;i++){
            if(!list.contains(sb[i])){
                list.add(sb[i]);
                helper(sb,list,s);
                list.remove(sb[i]);
            }
        }
    }
}
