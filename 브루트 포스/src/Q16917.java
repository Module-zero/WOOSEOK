/*
양념 반 후라이드 반

https://www.acmicpc.net/problem/16917
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 3:02
 */

public class Q16917
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int eachSum = A*X + B*Y;
        int halfSum;
        int addSum;
        int allHalfSum;

        // 양념을 후라이드보다 많이 사야 하면
        if(X > Y)
        {
            halfSum = 2*C * Y;

            // 양념을 추가로 사는 금액
            addSum = A * (X - Y);

            // 반반치킨만 최대로 사는 금액(남아도 됨)
            allHalfSum = 2*C * X;
        }
        // 후라이드를 양념보다 많이 사야 하면
        else
        {
            halfSum = 2*C * X;

            // 후라이드를 추가로 사는 금액
            addSum = B * (Y - X);

            // 반반치킨만 최대로 사는 금액(남아도 됨)
            allHalfSum = 2*C * Y;
        }

        System.out.println(Integer.min(Integer.min(eachSum, halfSum + addSum), allHalfSum));
    }
}
