/*
스타트링크

https://www.acmicpc.net/problem/5014
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
 * Date: 2020-11-16
 * Time: 오후 3:34
 */

public class Q5014
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] check = new int[1000001];
        for(int i=0; i<1000001; i++)
            check[i] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        check[S] = 0;

        while(!queue.isEmpty())
        {
            int cur = queue.poll();

            int up = cur + U;
            if(up > F)
                continue;

            // 아직 들르지 않은 층이면 전진
            if(check[up] == -1)
            {
                queue.add(up);
                check[up] = check[cur] + 1;
            }

            // 만약 정답이면 출력하고 종료
            if(up == G)
            {
                System.out.println(check[up]);
                return;
            }

            int down = cur - D;
            if(down < 1)
                continue;

            // 아직 들르지 않은 층이면 전진
            if(check[down] == -1)
            {
                queue.add(down);
                check[down] = check[cur] + 1;
            }

            // 만약 정답이면 출력하고 종료
            if(down == G)
            {
                System.out.println(check[down]);
                return;
            }

        }

        // 갈 수 없으면 출력
        if(check[G] == -1)
            System.out.println("use the stairs");
        else
            System.out.println(check[G]);
    }
}
