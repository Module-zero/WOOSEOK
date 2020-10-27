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
    static int max = 0;
    static int ans = 0;

    public static int postorder(int index, int sum)
    {
        int size = ary.get(index).size();

        // 탐색
        for (int i = 0; i < size; i++)
        {
            int[] tmp = ary.get(index).get(i);

            postorder(tmp[0], sum + tmp[1]);
        }


    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ary = new ArrayList<>();
        for(int i=0; i<=n; i++)
            ary.add(new ArrayList<>());

        int i = n-1;
        while(i-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // [0] : 정점, [1] : 거리
            ary.get(parent).add(new int[]{child, dist});
        }

        postorder(1, 0);
        System.out.println(ans);
    }
}
