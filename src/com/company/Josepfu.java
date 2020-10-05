package com.company;

public class Josepfu {
    public static void main(String[] args){

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.bianli();
        circleSingleLinkedList.leftCircle(1,2,5);

    }
}

class CircleSingleLinkedList{
    //创建first节点，当前没有赋值
    private Boy first = new Boy(-1);
    //添加节点
    public void addBoy(int num){
        if(num<1){
            System.out.println("num不正确");
            return;
        }
        //创建一个辅助节点,帮助构建环形列表
        Boy cur = null;
        for(int i=1;i<=num;i++){
            Boy boy = new Boy(i);
            //当添加第一个节点时
            if(i==1){
                first=boy;
                first.setNext(first);
                cur=first;
            }else{
                boy.setNext(first);//新加节点指向first
                cur.setNext(boy);//cur指向最后一个节点
                cur=boy;

            }
        }
    }

    //遍历当前环形列表
    public void bianli(){
        if(first==null){
            System.out.println("环形列表内容为空");
            return;
        }
        Boy cur = first;
        while(true){
            System.out.printf("输出的小孩编号为%d \n",cur.getNo());
            //判断是否遍历结束
            if(cur.getNext()==first){
                break;
            }
            //遍历么有结束，继续下移
            cur=cur.getNext();
        }

    }

    /**
     *
     * @param startnum 开始报名的位置
     * @param m  数几个数字出圈
     * @param nums  一共有几个人
     */
    public void leftCircle(int startnum, int m, int nums) {
        //先对数据进行校验
        if (first == null || startnum < 1 || startnum > nums) {
            System.out.println("输入的参数有误");
        }
        //定义一个辅助指针
        Boy helper = first;
        while(true){
            if(helper.getNext()==first){//说明指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        //报数前先让first和helper移动startnum-1
        for(int i=0;i<startnum-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //
        while(true){
            if(helper==first){
                break;
            }
            for(int i=0;i<m-1;i++){//报数时first和helper同时后移m-1
                first=first.getNext();
                helper=helper.getNext();
            }
            //这时first指向的节点就是小孩要出圈的节点
            System.out.printf("小孩出圈的节点是%d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后小孩出圈的节点是%d\n",first.getNo());

    }

}
//创建一个boy类，表示一个节点
class Boy{
    private int no;//节点编号
    private Boy next;//指向下一个节点

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
