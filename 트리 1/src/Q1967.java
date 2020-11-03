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
    static int n;
    static boolean[] check = new boolean[10001];
    static ArrayList<ArrayList<int[]>> ary = new ArrayList<>();
    static int ans = 0;
    static int ansIndex = 0;

    public static void dfs(int index, int weight)
    {
        check[index] = true;

        ArrayList<int[]> list = ary.get(index);
        for(int i=0; i<list.size(); i++)
        {
            int[] tmp = list.get(i);

            // 아직 들르지 않았으면 들른다.
            if(!check[tmp[0]])
                dfs(tmp[0], weight + tmp[1]);
        }

        if(weight > ans)
        {
            ans = weight;
            ansIndex = index;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<n-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            ary.get(parent).add(new int[]{child, weight});
            ary.get(child).add(new int[]{parent, weight});
        }

        dfs(1, 0);
        check = new boolean[10001];
        dfs(ansIndex, 0);
        System.out.println(ans);
    }
}
