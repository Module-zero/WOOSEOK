/*
나는야 포켓몬 마스터 이다솜

https://www.acmicpc.net/problem/1620
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 5:17
 */

public class Q1620
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] ary = new String[100001];
        for(int i=1; i<=N; i++)
            ary[i] = br.readLine();

        StringBuffer sb = new StringBuffer();
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=1; i<=N; i++)
            map.put(ary[i], i);

        for(int i=0; i<M; i++)
        {
            String str = br.readLine();
            char ch = str.charAt(0);

            if(ch >= '0' && ch <= '9')
            {
                int num = Integer.parseInt(str);
                sb.append(ary[num]).append('\n');
            }
            else
                sb.append(map.get(str)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
