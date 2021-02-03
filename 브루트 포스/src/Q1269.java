/*
대칭 차집합

https://www.acmicpc.net/problem/1269
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
 * Time: 오후 11:50
 */

public class Q1269
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++)
            set.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num))
                cnt++;
        }

        System.out.println(A + B - 2*cnt);
    }
}
