/*
숨바꼭질 3

https://www.acmicpc.net/problem/13549
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 7:33
 */

public class Q13549
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new LinkedList<>();
        boolean[] check = new boolean[100001];
        int sec = 0;

        // [0] : 위치, [1] : 시간
        deque.addFirst(new int[]{N, sec});
        check[N] = true;

        while(!deque.isEmpty())
        {
            // 꺼내기 전에 정보를 본다.
            int[] info = deque.peek();

            while(info[1] == sec)
            {
                int location = info[0];
                int time = info[1];

                deque.poll();

                // 동생을 찾았으면 종료
                if(location == K)
                {
                    System.out.println(time);
                    return;
                }

                if(2*location <= 100000 && !check[2*location])
                {
                    deque.addFirst(new int[]{2 * location, time});
                    check[2 * location] = true;
                }

                if(location-1 >= 0 && !check[location-1])
                {
                    deque.addLast(new int[]{location - 1, time + 1});
                    check[location - 1] = true;
                }

                if(location+1 <= 100000 && !check[location+1])
                {
                    deque.addLast(new int[]{location + 1, time + 1});
                    check[location + 1] = true;
                }


                info = deque.peek();
            }

            sec++;
        }
    }
}
