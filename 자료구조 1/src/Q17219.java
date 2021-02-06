/*
비밀번호 찾기

https://www.acmicpc.net/problem/17219
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 11:59
 */

public class Q17219
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String, String> map = new TreeMap<>();
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String pwd = st.nextToken();

            map.put(str, pwd);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++)
        {
            String str = br.readLine();
            sb.append(map.get(str)).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }
}
