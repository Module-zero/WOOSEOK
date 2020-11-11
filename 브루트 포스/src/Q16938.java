/*
캠프 준비

https://www.acmicpc.net/problem/16938
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오전 12:24
 */

public class Q16938
{
    static int N;
    static int L;
    static int R;
    static int X;
    static int[] A = new int[16];
    static int ans = 0;

    public static boolean promise(int min, int max, int sum)
    {

        return true;
    }

    public static void solve(int index, int cnt, int min, int max, int sum)
    {
        if (index == N)
        {
            // 문제가 2개 미만이면 안된다.
            if (cnt < 2)
                return;
            // 문제의 합이 L보다 작거나, R보다 크면 답이 될 수 없다.
            else if(sum < L || sum > R)
                return;
            // 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이가 X보다 작으면 답이 될 수 없다.
            else if(max - min < X)
                return;

            ans++;
            return;
        }

        // 포함하지 않았을 때
        solve(index + 1, cnt, min, max, sum);
        // 포함했을 때
        solve(index + 1, cnt + 1, Integer.min(min, A[index]), Integer.max(max, A[index]), sum + A[index]);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        solve(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        System.out.println(ans);
    }
}
