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
    static boolean[] check;
    static int ans = 0;
    static int ansIndex = 0;

    public static void postorder(int index, int sum)
    {
        check[index] = true;

        int size = ary.get(index).size();

        // 탐색
        for(int i=0; i<size; i++)
        {
            int[] tmp = ary.get(index).get(i);

            if(!check[tmp[0]])
            {
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ary = new ArrayList<>();
        for(int i=0; i<=n; i++)
            ary.add(new ArrayList<>());

        int i = n;
        while(i-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // [0] : 정점, [1] : 거리
            ary.get(parent).add(new int[]{child, dist});
            ary.get(child).add(new int[]{parent, dist});
        }

        check = new boolean[10001];
    }
}
