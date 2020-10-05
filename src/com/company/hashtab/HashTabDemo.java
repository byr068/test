package com.company.hashtab;

public class HashTabDemo {
    public static void main(String[] args){

    }
}
//
class  HashTab{
    private  int size;
    private EmpLinkedList[] empLinkedListArray;
    //构造器
    public HashTab(int size){
    this.size = size;
    //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //
    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的id得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    //遍历所有的链表，遍历hashtab
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}
//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;//next默认为空
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head;

    //添加雇员到链表
    //假定添加雇员时id是自增长的，即id的分配是从小到大的
    //因此我们将雇员直接添加到链表的后面
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while(true){
            if(curEmp.next==null){//说明到链表最后
                break;
            }
            curEmp=curEmp.next;//后移
        }
        //退出时将emp加入到链表
        curEmp.next=emp;
    }
    //遍历雇员的信息
    public void list(){
        if(head == null){//
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head;//辅助指针
        while(true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;//后移遍历
        }
        System.out.println();
    }
}