/*
중량제한

https://www.acmicpc.net/problem/1939
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-07
 * Time: 오후 5:36
 */

public class Q1939
{
    static int x;
    static int y;
    static boolean[] check;
    static ArrayList<ArrayList<Temp>> ary = new ArrayList<>();

    static class Temp
    {
        int dest;
        int limit;

        public Temp(int dest, int limit)
        {
            this.dest = dest;
            this.limit = limit;
        }
    }

    public static boolean dfs(int id, int mid)
    {
        // 이미 들렀으면 return
        if(check[id])
            return false;

        check[id] = true;
        if(id == y)
            return true;

        for(Temp tmp : ary.get(id))
        {
            // 현재 들고있는 짐이 중량제한을 넘으면 지나갈 수 없음
            // 이미 들렀으면 갈 필요가 없음
            if(tmp.limit < mid || check[tmp.dest])
                continue;

            if(dfs(tmp.dest, mid))
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            ary.get(A).add(new Temp(B, C));
            ary.get(B).add(new Temp(A, C));
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 1000000000;
        int max = Integer.MIN_VALUE;
        while(start <= end)
        {
            int mid = (start + end) / 2;

            check = new boolean[10001];
            // 목적지까지 갈 수 있었으면 짐의 무게를 늘린다.
            if(dfs(x, mid))
            {
                if(mid > max)
                    max = mid;
                start = mid + 1;
            }
            // 목적지까지 갈 수 없었으면 짐의 무게를 줄인다.
            else
                end = mid - 1;
        }

        System.out.println(max);
    }
}
