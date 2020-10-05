import java.util.Scanner;

public class wangyihuyu {
    public static void main(String[] args) {
        char a = '1';
        System.out.println(a - '0');
        Integer a1 = -128;
        Integer b =-128;
        System.out.println(a1==b);
    }
    static void helper(int[][] nums,int istart,int iend,int jstart,int jend,int num,boolean flag){
        if(istart>iend||jstart>jend)return;
        if(flag){
            for(int j=jstart;j<=jend;j++){
                nums[istart][j] = num++;
            }
            for(int i=istart+1;i<=iend;i++){
                nums[i][jend] = num++;
            }
            for(int j=jend-1;j>=jstart;j--){
                nums[iend][j] = num++;
            }
            for(int i=iend-1;i>=istart+1;i--){
                nums[i][jstart] = num++;
            }
        }else{
            for(int i=istart;i<=iend;i++){
                nums[i][jstart] = num++;
            }
            for(int j=jstart+1;j<=jend;j++){
                nums[iend][j] = num++;
            }
            for(int i=iend-1;i>=istart;i--){
                nums[i][jend] = num++;
            }
            for(int j=jend-1;j>=jstart+1;j--){
                nums[istart][j] = num++;
            }
        }
        helper(nums,istart+1,iend-1,jstart+1,jend-1,num,!flag);
    }
}
