/*
중복 빼고 정렬하기

https://www.acmicpc.net/problem/10867
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 1:06
 */

public class Q10867
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-- > 0)
            set.add(Integer.parseInt(st.nextToken()));

        Iterator<Integer> it = set.iterator();
        StringBuffer sb = new StringBuffer();
        while(it.hasNext())
            sb.append(it.next()).append(' ');

        System.out.println(sb.toString());
    }
}
