/*
트리의 지름

https://www.acmicpc.net/problem/1967
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-26
 * Time: 오후 3:10
 */

public class Q1967
{
    static ArrayList<ArrayList<int[]>> ary;
    static int n;
    static int max = Integer.MIN_VALUE;

    public static int postorder(int index, int gravity)
    {
        ArrayList<Integer> gravity = new ArrayList<>();
        int sum = 0;

        for(int[] tmp : ary.get(index))
        {
            int to = tmp[0];
            int cost = tmp[1];

            int res = postorder(to);

            sum = Integer.max(max, sum);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ary = new ArrayList<>();
        for(int i=0; i<=n; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<n-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            ary.get(parent).add(new int[]{child, dist});
        }


    }
}
