/*
트리의 순회

https://www.acmicpc.net/problem/2263
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오후 3:58
 */

public class Q2263
{
    static int[] in = new int[100001];
    static int[] post = new int[100001];
    static int[] position = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void foo(int inStart, int inEnd, int postStart, int postEnd)
    {
        if(inStart > inEnd || postStart > postEnd)
            return;

        int root = post[postEnd];
        sb.append(root).append(' ');

        int pos = position[root];
        int leftSize = pos - inStart;

        foo(inStart, pos - 1, postStart, postStart + leftSize - 1);
        foo(pos + 1, inEnd, postStart + leftSize, postEnd-1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
        {
            in[i] = Integer.parseInt(st.nextToken());
            position[in[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            post[i] = Integer.parseInt(st.nextToken());

        foo(0, n-1, 0, n-1);

        System.out.println(sb.toString());
    }
}
