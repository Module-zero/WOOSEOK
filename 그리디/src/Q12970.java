/*
AB

https://www.acmicpc.net/problem/12970
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 11:48
 */

public class Q12970
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int a=0; a<N; a++)
        {
            int b = N - a;
            // 답이 될 수 없으면 a의 개수를 증가
            if(a*b < K)
                continue;

            boolean[] check = new boolean[51];
            int aCnt = 0;
            for(int i=N-1; i>=0; i--)
            {
                int curCnt =
            }
        }

        System.out.println(-1);
    }
}
