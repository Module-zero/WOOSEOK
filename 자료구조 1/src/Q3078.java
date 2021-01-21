/*
좋은 친구

https://www.acmicpc.net/problem/3078
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
 * Date: 2021-01-06
 * Time: 오후 4:03
 */

public class Q3078
{
    static class Friend
    {
        String name;
        int rank;
        int len;

        public Friend(String name, int rank, int len)
        {
            this.name = name;
            this.rank = rank;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Friend>[] queue = new LinkedList[21];
        for(int i=2; i<=20; i++)
            queue[i] = new LinkedList<>();

        long ans = 0;
        for(int rank=1; rank<=N; rank++)
        {
            String name = br.readLine();
            int len = name.length();

            // 이름의 길이가 같으면서
            if(!queue[len].isEmpty())
            {
                // 등수의 차이가 K까지

                while(!queue[len].isEmpty())
                {
                    if(rank - queue[len].peek().rank <= K)
                    {
                        ans += queue[len].size();
                        break;
                    }
                    else
                        queue[len].poll();
                }
            }

            queue[len].add(new Friend(name, rank, len));
        }

        System.out.println(ans);
    }
}
