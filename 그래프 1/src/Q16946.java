/*
DFS 스페셜 저지

https://www.acmicpc.net/problem/16964
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 9:54
 */

public class Q16946
{
    static int N;
    static ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
    public static boolean[] check = new boolean[100001];
    static int[] ans = new int[100001];
    static int[] order = new int[100001];
    static int cnt = 2;

    public static boolean dfs(int num)
    {
        check[num] = true;

        for(int i=0; i<ary.get(num).size(); i++)
        {
            int tmp = ary.get(num).get(i);

            if(!check[tmp])
            {
                if(order[tmp] != cnt)
                    return false;

                cnt++;
                check[tmp] = true;
                if(!dfs(tmp))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<N-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary.get(a).add(b);
            ary.get(b).add(a);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            ans[i] = Integer.parseInt(st.nextToken());
            order[ans[i]] = i;
        }

        // 시작 정점이 1이 아니면 0을 출력 후 종료
        if(ans[1] != 1)
        {
            System.out.println(0);
            return;
        }

        for(int i=1; i<=N; i++)
        {
            ArrayList<Integer> list = ary.get(i);
            Collections.sort(list, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    if(order[o1] > order[o2])
                        return 1;
                    else
                        return -1;
                }
            });
        }

        if(dfs(1))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
