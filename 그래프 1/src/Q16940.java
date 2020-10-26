/*
BFS 스페셜 저지

https://www.acmicpc.net/problem/16940
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
 * Date: 2020-10-25
 * Time: 오후 7:17
 */

public class Q16940
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
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

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        int[] counts = new int[N+1];
        int cnt = 0;

        // 시작 정점은 1
        queue.add(1);
        check[1] = true;

        while(!queue.isEmpty())
        {
            ++cnt;

            int num = queue.poll();

            int size = ary.get(num).size();
            for(int i=0; i<size; i++)
            {
                // 연결된 정점 하나를 가져온다.
                int next = ary.get(num).get(i);

                if(!check[next])
                {
                    queue.add(next);
                    check[next] = true;
                    counts[next] = cnt;
                }
            }
        }

        // 입력된 BFS 방문 순서가 올바른지 prev 배열과 비교
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> tQueue = new LinkedList<>();
        boolean[] tCheck = new boolean[N+1];
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            tQueue.add(num);
        }

        int depth = 0;
        queue.add(1);
        tCheck[1] = true;

        while(!queue.isEmpty())
        {
            int num = queue.poll();
            int num2 = tQueue.poll();

            if(counts[num] != counts[num2])
            {
                System.out.println("0");
                return;
            }

            int size = ary.get(num).size();
            for(int i=0; i<size; i++)
            {
                int tmp = ary.get(num).get(i);

                if(!tCheck[tmp])
                {
                    queue.add(tmp);
                    tCheck[tmp] = true;
                }
            }

            depth++;
        }

        System.out.println("1");
        return;
    }
}
