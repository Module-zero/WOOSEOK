/*
단어 정렬

https://www.acmicpc.net/problem/1181
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-21
 * Time: 오후 11:27
 */

public class Q1181
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeSet<String>[] set = new TreeSet[10001];
        for(int i=0; i<10001; i++)
            set[i] = new TreeSet<>();

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            int len = str.length();

            set[len].add(str);
        }

        StringBuffer sb = new StringBuffer();
        for(TreeSet<String> tree : set)
        {
            for(String str : tree)
                sb.append(str).append('\n');
        }

        System.out.print(sb.toString());
    }
}
