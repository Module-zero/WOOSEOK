/*
선분과 점

https://www.acmicpc.net/problem/11664
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 4:02
 */

public class Q11664
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ary = new int[9];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<9; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        double x1 = (ary[0] + ary[3]) / 2.0;
        double y1 = (ary[1] + ary[4]) / 2.0;
        double z1 = (ary[2] + ary[5]) / 2.0;
        double x2 = (double)ary[6];
        double y2 = (double)ary[7];
        double z2 = (double)ary[8];

        double ans = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) + (z1-z2)*(z1-z2));
        System.out.println(ans);
    }
}
