/*
연결 요소의 개수

https://www.acmicpc.net/problem/11724
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-21
 * Time: 오전 12:41
 */

public class Q11724
{
    static int N;
    static int M;
    static int[][] ary = new int[1001][1001];
    static boolean[] check = new boolean[1001];
    static int cnt = 0;

    public static void dfs(int n)
    {
        // 방문하지 않았을 경우 방문한다.
        for(int i=1; i<=N; i++)
        {
            if (ary[n][i] == 1 && !check[i])
            {
                check[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[a][b] = 1;
            ary[b][a] = 1;
        }

/*
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++)
        {
            // 아직 방문하지 않았으면 큐에 넣는다.
            if(!check[i])
            {
                cnt++;
                queue.add(i);
                check[i] = true;
            }

            // 연결된 노드들을 모두 방문한다.(BFS)
            while(!queue.isEmpty())
            {
                int num = queue.poll();

                for(int j=1; j<=N; j++)
                {
                    if(ary[num][j] == 1 && !check[j])
                    {
                        queue.add(j);
                        check[j] = true;
                    }
                }
            }
        }
*/

        for(int i=1; i<=N; i++)
        {
            if(!check[i])
            {
                cnt++;
                check[i] = true;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }
}
