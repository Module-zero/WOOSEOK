/*
듣보잡

https://www.acmicpc.net/problem/1764
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-23
 * Time: 오후 7:16
 */

public class Q1764
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<String> noHear = new TreeSet<>();
        TreeSet<String> noHearNoSee = new TreeSet<>();

        for(int i=0; i<N; i++)
            noHear.add(br.readLine());


        for(int i=0; i<M; i++)
        {
            String name = br.readLine();

            if(noHear.contains(name))
                noHearNoSee.add(name);
        }

        StringBuilder sb = new StringBuilder().append(noHearNoSee.size()).append('\n');
        for(String name : noHearNoSee)
            sb.append(name).append('\n');

        System.out.print(sb.toString());
    }
}
