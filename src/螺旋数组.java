import java.util.Arrays;
import java.util.Scanner;

public class 螺旋数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[m*n];
        int k = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k++] = in.nextInt();
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[][] res = new int[m][n];
        helper(res,arr);
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(res[i][j]+"\t");
            }
            System.out.println();
        }
    }
    static void helper(int[][] res,int[] arr){
        int m = res.length;
        int n = res[0].length;
        int i = 0;
        int count = (Math.min(m,n)+1)/2;
        int k = 0;
        while(i<count){
            for(int j=i;j<n-i;j++){
                res[i][j] = arr[k++];
            }
            for(int j=i+1;j<m-i;j++){
                res[j][(n-1)-i] = arr[k++];
            }
            for(int j=(n-1)-(i+1);j>=i&&(m-1-i!=i);j--){
                res[m-1-i][j] = arr[k++];
            }
            for(int j=(m-1)-(i+1);j>=i+1&&(n-1-i)!=i;j--){
                res[j][i] = arr[k++];
            }
            i++;
        }
    }
}
