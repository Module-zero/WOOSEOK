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

    public static void solve(int inLeft, int inRight, int postLeft, int postRight)
    {
        if(inLeft > inRight || postLeft > postRight)
            return;

        int root = post[postRight];
        int p = position[root];

        sb.append(root).append(" ");

        int leftSize = p - inLeft;
        // 잘 모르겠음
        solve(inLeft, p-1, postLeft, postLeft + leftSize - 1);
        solve(p+1, inRight, postLeft + leftSize, postRight-1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            post[i] = Integer.parseInt(st.nextToken());

        // 인덱싱을 빠르게 하기 위한 position 배열
        for(int i=0; i<n; i++)
            position[in[i]] = i;

        solve(0, n-1, 0, n-1);

        System.out.println(sb.toString());
    }
}
