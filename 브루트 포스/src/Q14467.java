/*
소가 길을 건너간 이유 1

https://www.acmicpc.net/problem/14467
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-23
 * Time: 오후 4:38
 */

public class Q14467
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ary = new int[11];
        for(int i=1; i<=10; i++)
            ary[i] = -1;

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cow = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(ary[cow] == -1)
                ary[cow] = num;
            else if(ary[cow] != num)
            {
                ary[cow] = num;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
