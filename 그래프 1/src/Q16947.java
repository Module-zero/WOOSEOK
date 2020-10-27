/*
서울 지하철 2호선

https://www.acmicpc.net/problem/16947
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 1:38
 */

public class Q16947
{
    public static int N;
    public static ArrayList<ArrayList<Integer>> ary;
    public static int[] check = new int[3001];
    public static int[] dist = new int[3001];

    // -2 : 사이클을 찾았지만 해당 정점은 사이클이 아님
    // -1 : 사이클을 찾지 못함
    // 1 ~ n : 사이클의 시작 인덱스
    public static int dfs(int index, int prev)
    {
        if(check[index] == 1)
            return index;

        check[index] = 1;

        int size = ary.get(index).size();
        for(int i=0; i<size; i++)
        {
            int target = ary.get(index).get(i);
            // 바로 전 지나온 곳이 다음 목적지면 스킵
            if(target == prev)
                continue;

            int res = dfs(target, index);
            if(res == -2)
                return res;

            if(res >= 1)
            {
                check[index] = 2;
                return (res == index) ? -2 : res;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ary = new ArrayList<>();
        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        int i = N;
        while(i-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary.get(a).add(b);
            ary.get(b).add(a);
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[3001];

        for(int j=1; j<=N; j++)
        {
            // 순환선에서 시작
            if(check[j] == 2)
            {
                queue.add(j);
                visited[j] = true;

                while(!queue.isEmpty())
                {
                    int num = queue.poll();

                    int size = ary.get(num).size();
                    for(int k=0; k<size; k++)
                    {
                        int target = ary.get(num).get(k);

                        if(!visited[target])
                        {
                            if(check[target] != 2)
                                dist[target] = dist[num] + 1;

                            queue.add(target);
                            visited[target] = true;
                        }
                    }
                }
            }
        }

        for(int j=1; j<=N; j++)
            sb.append(dist[j] + " ");

        System.out.println(sb.toString());
    }
}
