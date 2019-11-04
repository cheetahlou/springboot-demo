package com.cheelou.base.xyz;

/**
 * 动态规划
 * @author louzf
 * @decription
 * @createTime 2019/10/11 9:58
 */
public class DP {
    public static void main(String[] args) {
        Integer[] value = {60,100,120};
        int[] weight = {10,20,40};

        int w = 50;
        int n = 3;
        int dp[][] = new int [n+1][w+1];
        for (int j = n; j >=0 ; j--) {
            for (int i = 0; i <= w; i++) {
                System.out.print(dp[j][i] + " ");
            }

            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                if(weight[i-1] <= cw){
                    dp[i][cw] = Math.max(
                            value[i-1]+dp [i-1][cw-weight [i-1]],
                            dp[i-1][cw]
                    );
                }else{
                    dp[i][cw] = dp[i-1][cw];
                }
            }
        }

        System.out.println("袋子能装入的最大价值为："+dp[n][w]);
        System.out.println("数组为：");
        System.out.println();
        for (int j = n; j >=0 ; j--) {
            for (int i = 0; i <= w; i++) {
                System.out.print(dp[j][i] + " ");
            }

            System.out.println();
        }

    }

    /*
0 0 0 0 0 0 0 0 0 0 60 60 60 60 60 60 60 60 60 60 100 100 100 100 100 100 100 100 100 100 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 180
0 0 0 0 0 0 0 0 0 0 60 60 60 60 60 60 60 60 60 60 100 100 100 100 100 100 100 100 100 100 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160 160
0 0 0 0 0 0 0 0 0 0 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60 60
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
    * */
}
