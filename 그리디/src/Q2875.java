/*
대회 or 인턴

https://www.acmicpc.net/problem/2875
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-03
 * Time: 오후 5:05
 */

public class Q2875
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<=K; i++)
        {
            // 여학생에서 i명 뺌
            int girl = N-i;

            // 남학생에서 K-i명 뺌
            int boy = M-K+i;

            int cnt = 0;
            while(girl >= 2 && boy >= 1)
            {
                cnt++;
                girl -= 2;
                boy -= 1;
            }

            if(ans < cnt)
                ans = cnt;
        }

        System.out.println(ans);
    }
}
