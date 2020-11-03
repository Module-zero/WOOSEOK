/*
소수 경로

https://www.acmicpc.net/problem/1963
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
 * Date: 2020-11-03
 * Time: 오후 10:18
 */

public class Q1963
{
    static boolean[] prime = new boolean[10000];
    static boolean[] check = new boolean[10000];
    static int[] d = {10000, 1000, 100, 10, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        for(int i=2; i<10000; i++)
        {
            if(!check[i])
            {
                prime[i] = true;

                for(int j=i*i; j<10000; j+=i)
                    check[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            boolean isFind = false;
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if(num == target)
            {
                sb.append("0").append("\n");
                continue;
            }

            // [0] : 수, [1] : 바꾼 횟수
            queue.add(new int[]{num, 0});
            visited[num] = true;

            while(!queue.isEmpty())
            {
                int[] tmp = queue.poll();

                for(int i=1; i<5; i++)
                {
                    for(int j=0; j<=9; j++)
                    {
                        int newNum = ((tmp[0] / d[i-1]) * d[i-1]) + (j * d[i]) + (tmp[0] % d[i]);
                        if(newNum < 1000)
                            continue;

                        if(newNum == target)
                        {
                            sb.append(tmp[1] + 1).append("\n");
                            isFind = true;
                        }

                        // 찾았으면 탈출
                        if(isFind)
                            break;

                        if(prime[newNum] && !visited[newNum])
                        {
                            visited[newNum] = true;
                            queue.add(new int[]{newNum, tmp[1] + 1});
                        }
                    }

                    // 찾았으면 탈출
                    if(isFind)
                        break;
                }

                // 찾았으면 탈출
                if(isFind)
                    break;
            }

            // 못찾았으면 Impossible 출력
            if(!isFind)
                sb.append("Impossible").append("\n");
        }

        System.out.print(sb.toString());
    }
}
