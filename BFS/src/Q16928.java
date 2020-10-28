/*
뱀과 사다리 게임

https://www.acmicpc.net/problem/16928
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
 * Date: 2020-10-28
 * Time: 오후 1:13
 */

public class Q16928
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ladder = new int[101];
        int[] snake = new int[101];
        boolean[] check = new boolean[101];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladder[x] = y;
        }

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            snake[u] = v;
        }

        Queue<int[]> queue = new LinkedList<>();

        int cnt = 0;
        // [0] : 칸, [1] : 이동 횟수
        queue.add(new int[]{1, cnt});
        check[1] = true;

        while(!queue.isEmpty())
        {
            int[] info = queue.peek();

            while(info[1] == cnt)
            {
                queue.poll();

                // 주사위를 1~6까지 굴린다.
                for(int dice=1; dice<=6; dice++)
                {
                    int target = info[0] + dice;

                    // 아직 들르지 않았고 범위 안이면 큐에 넣을 준비
                    if(!check[target] && target <= 100)
                    {
                        // 해당 칸에 사다리가 있으면 그 곳으로 간다.
                        if(ladder[target] != 0)
                            target = ladder[target];
                        else if(snake[target] != 0)
                            target = snake[target];

                        if(target == 100)
                        {
                            System.out.println(info[1] + 1);
                            return;
                        }

                        check[target] = true;
                        queue.add(new int[]{target, info[1]+1});
                    }
                }

                info = queue.peek();
            }

            cnt++;
        }
    }
}
