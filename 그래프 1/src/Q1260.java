/*
DFS와 BFS

https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오후 5:35
 */

public class Q1260
{
    static boolean[][] ary = new boolean[1001][1001];
    static boolean[] check = new boolean[1001];
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int V;

/*
    public static void dfs(int n)
    {
        sb.append(n + " ");
        check[n] = true;

        for(int i=1; i<=N; i++)
        {
            if (ary[n][i] && !check[i])
                dfs(i);
        }
    }
*/

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int id1 = Integer.parseInt(st.nextToken());
            int id2 = Integer.parseInt(st.nextToken());

            ary[id1][id2] = true;
            ary[id2][id1] = true;
        }

        // 재귀
//        dfs(V);

        // 반복문
        stack.push(V);
        check[V] = true;
        sb.append(V + " ");

        while(!stack.isEmpty())
        {
            int num = stack.peek();

            boolean flag = false;

            for(int i=1; i<=N; i++)
            {
                if(ary[num][i] && !check[i])
                {
                    stack.push(i);
                    sb.append(i + " ");

                    check[i] = true;
                    flag = true;
                    break;
                }
            }

            if(!flag)
                stack.pop();
        }

        sb.append("\n");

        check = new boolean[1001];
        check[V] = true;
        queue.add(V);
        sb.append(V + " ");

        while(!queue.isEmpty())
        {
            // 큐에서 하나 추출
            int num = queue.poll();

            for(int i=1; i<=N; i++)
            {
                if (ary[num][i] && !check[i])
                {
                    check[i] = true;
                    // 큐에 넣음
                    queue.add(i);
                    sb.append(i + " ");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
