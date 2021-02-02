/*
암기왕

https://www.acmicpc.net/problem/2776
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 12:31
 */

public class Q2776
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0; i<N; i++)
                set.add(Integer.parseInt(st.nextToken()));

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
            {
                if(set.contains(Integer.parseInt(st.nextToken())))
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
