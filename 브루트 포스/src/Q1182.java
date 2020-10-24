/*
부분수열의 합

https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 4:47
 */

public class Q1182
{
    static int N;
    static int S;
    static int[] ary;
    static int ans = 0;

    public static void foo(int index, int sum, int cnt)
    {
        if(index == N)
        {
            // 공집합 제외
            if(cnt == 0)
                return;
            else if(sum == S)
                ans++;

            return;
        }

        // 포함하지 않았을 때
        foo(index+1, sum, cnt);
        // 포함했을 때
        foo(index+1, ary[index] + sum, cnt+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ary = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] =  Integer.parseInt(st.nextToken());

        foo(0, 0, 0);

        System.out.println(ans);
/*
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] ary = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] =  Integer.parseInt(st.nextToken());

        int cnt = 0;

        // 0부터 2^n - 1까지 연산하기 위해 2^n - 1을 구한다.
        int max = 1;
        for(int i=0; i<N; i++)
            max *= 2;

        // 1부터 max(2^n - 1)까지 연산
        for(int set=1; set<max; set++)
        {
            int sum = 0;

            // 0번 인덱스~N-1번 인덱스까지 검사한 후 더한다.
            int bit = 1;
            for(int i=0; i<N; i++)
            {
                // 포함될 경우
                if((set & bit) != 0)
                    sum += ary[i];

                bit <<= 1;
            }

            if(sum == S)
                cnt++;
        }

        System.out.println(cnt);
*/
    }
}
