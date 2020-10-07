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

        // 조합 : n! / ((n-m)! * m!)
        // 더 큰 값으로 교체
        m = (n-m > m) ? (n-m) : m;

        int cntSum = 0;
        int cnt2 = 0;
        int cnt5 = 0;
        for(int i=m+1; i<=n; i++)
        {
            int tmp = i;
            if(tmp % 2 == 0)
            {
                while(tmp % 2 == 0)
                {
                    ++cnt2;
                    tmp /= 2;
                }
            }
            if(tmp % 5 == 0)
            {
                while(tmp % 5 == 0)
                {
                    ++cnt5;
                    tmp /= 5;
                }
            }
        }

        cntSum = (cnt2 < cnt5) ? cnt2 : cnt5;
        cnt2 = 0;
        cnt5 = 0;

        int endIndex = n-m;
        for(int i=1; i<=endIndex; i++)
        {
            int tmp = i;
            if(tmp % 2 == 0)
            {
                while(tmp % 2 == 0)
                {
                    ++cnt2;
                    tmp /= 2;
                }
            }
            if(tmp % 5 == 0)
            {
                while(tmp % 5 == 0)
                {
                    ++cnt5;
                    tmp /= 5;
                }
            }
        }

        cntSum -= (cnt2 < cnt5) ? cnt2 : cnt5;

        System.out.println(cntSum);
    }
}
