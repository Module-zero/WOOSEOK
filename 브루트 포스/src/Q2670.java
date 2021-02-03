/*
연속부분최대곱

https://www.acmicpc.net/problem/2670
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 8:24
 */

public class Q2670
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] ary = new double[10001];
        double[] ps = new double[10001];
        ary[0] = Double.parseDouble(br.readLine());
        ps[0] = ary[0];
        double max = ary[0];
        for(int i=1; i<N; i++)
        {
            double num = Double.parseDouble(br.readLine());
            double mul = ps[i-1] * num;

            if(Double.compare(num, mul) > 0)
                ps[i] = num;
            else
                ps[i] = mul;

            max = Double.max(max, ps[i]);
        }

        System.out.printf("%.3f\n", max);
    }
}
