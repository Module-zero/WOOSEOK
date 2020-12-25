/*
최단경로

https://www.acmicpc.net/problem/1753
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
 * Date: 2020-12-24
 * Time: 오후 9:00
 */

public class Q1753
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // [0] : 정점, [1] : 가중치
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i=0; i<=V; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new int[]{v, w});
            list.get(v).add(new int[]{u, w});
        }
    }
}
