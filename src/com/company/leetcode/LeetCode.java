package com.company.leetcode;

import java.util.HashMap;

public class LeetCode {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] sum =s.twoSum(new int[]{1,2,3,4,5},7);

        //第三题
        //int length  = s.lengthOfLongestSubstring("abcabcbb");
//        System.out.println(Arrays.toString());
//        ListNode l1= new ListNode(11);
//        ListNode l2= new ListNode(3);
//        ListNode l3 = s.addTwoNumbers(l1,l2);
//        SingledList s1= new SingledList();
//        s1.add(l3);
//        s1.list();
        s.convert("PAYPALISHIRING",3);
    }

}
class Solution{
    /**
     * 1、两个数的和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        int[] res = new int[]{-1,-1};
        if(nums==null||nums.length==0)return res;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=nums[i];
                    res[1]=nums[j];
                }
            }

        }
        return res;
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dem = new ListNode(0);
        ListNode cur = dem;
        ListNode p1 = l1,p2 = l2;
        int sum = 0;
        while(p1!=null||p2!=null){
            if(p1!=null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                sum += p2.val;
                p2=p2.next;
            }
            cur.next = new ListNode(sum%10);
            sum = sum/10;
            cur=cur.next;
        }
        if(sum==1){
            cur.next=new ListNode(1);
        }
        return dem.next;
    }
    /**
     *  3.找出不含重复字符的最长子串的长度
     *  "abcabcbb"
     *   输出：3
     * @param s 给定字符串
     * @return
     */
    public  int lengthOfLongestSubstring(String s){
        int res =0;
        HashMap<Character,Integer> map =new HashMap<>();
        if(s==null||s.length()==0)return 0;
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j+1);
        }
        return res;
    }

    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder[] sb= new StringBuilder[s.length()];
        for(int i=0;i<s.length();i++){
            sb[i]=new StringBuilder("");
        }
        for(int i=0;i<s.length();i++){
            int index = i%(2*numRows-2);
            index = index<numRows?index:2*numRows-2-index;
            sb[index].append(s.charAt(i));
        }
        for(int i=0;i<3;i++){
            System.out.println(sb[i].toString());
        }
        for(int i=1;i<sb.length;i++){
            sb[0].append(sb[i]);
        }
        System.out.println(sb[0].toString());
        return sb[0].toString();
    }
}
