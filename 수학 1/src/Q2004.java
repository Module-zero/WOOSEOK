/*
조합 0의 개수

문제
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.

출력
첫째 줄에 0의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 3:03
 */

public class Q2004
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int o = n-m;

        long cnt2 = 0;
        long cnt5 = 0;

        for(long power = 2; power <= n; power *= 2)
            cnt2 += n/power;
        for(long power = 5; power <= n; power *= 5)
            cnt5 += n/power;

        for(long power = 2; power <= m; power *= 2)
            cnt2 -= m/power;
        for(long power = 5; power <= m; power *= 5)
            cnt5 -= m/power;

        for(long power = 2; power <= o; power *= 2)
            cnt2 -= o/power;
        for(long power = 5; power <= o; power *= 5)
            cnt5 -= o/power;

        System.out.println((cnt2 < cnt5) ? cnt2 : cnt5);
    }
}
