/*
세 친구

https://www.acmicpc.net/problem/17089
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 2:28
 */

public class Q17089
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[4001][4001];
        int[] friendNum = new int[4001];

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
            check[b][a] = true;
            friendNum[a]++;
            friendNum[b]++;
        }

        int min = Integer.MAX_VALUE;
        for(int f1=1; f1<=N; f1++)
        {
            for(int f2=f1+1; f2<=N-1; f2++)
            {
                if(check[f1][f2])
                {
                    for(int f3=f2+1; f3<=N; f3++)
                    {
                        if(check[f1][f3] && check[f2][f3])
                        {
                            int sum = friendNum[f1] + friendNum[f2] + friendNum[f3] - 6;

                            if(sum < min)
                                min = sum;
                        }
                    }
                }
            }
        }

        // 세 사람을 고를 수 없는 경우
        if(min > 4000)
            min = -1;

        System.out.println(min);
    }
}
