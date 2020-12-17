/*
사다리

https://www.acmicpc.net/problem/2022
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-07
 * Time: 오후 6:11
 */

public class Q2022
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double start = 0;
        double end = Math.min(x, y);
        for(int i=0; i<10000; i++)
        {
            double mid = (start + end) / 2;

            double h1 = Math.sqrt(x*x - mid*mid);
            double h2 = Math.sqrt(y*y - mid*mid);
            double h = (h1*h2)/(h1+h2);

            if(h > c)
                start = mid;
            else
                end = mid;
        }

        System.out.printf("%.3f\n", start);
    }
}
