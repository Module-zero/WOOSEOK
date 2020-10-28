/*
DSLR

https://www.acmicpc.net/problem/9019
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
 * Time: 오후 2:41
 */

public class Q9019
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] command = {'D', 'S', 'L', 'R'};
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            char[] check = new char[10000];
            int[] from = new int[10000];
            boolean isEnd = false;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);

            while(!queue.isEmpty())
            {
                int num = queue.poll();

                for(int i=0; i<4; i++)
                {
                    char ch = command[i];
                    int n = num;

                    switch(ch)
                    {
                        case 'D':
                            n = 2*n;
                            if(n > 9999)
                                n = n % 10000;
                            break;
                        case 'S':
                            if(n == 0)
                                n = 9999;
                            else
                                n = n - 1;
                            break;
                        case 'L':
                            n = ((n%1000)*10) + n/1000;
                            break;
                        case 'R':
                            n = ((n%10)*1000) + n/10;
                            break;
                    }

                    // 아직 나오지 않았던 수가 나오면 큐에 넣는다.
                    if(check[n] == 0)
                    {
                        from[n] = num;
                        check[n] = ch;

                        // n이 B가 됐으면 테스트 케이스 종료
                        if(n == B)
                        {
                            while(n != A)
                            {
                                sb.append(check[n]);
                                n = from[n];
                            }

                            System.out.println(sb.reverse());
                            isEnd = true;

                            break;
                        }

                        queue.add(n);
                    }
                }

                // n이 B가 됐으면 테스트 케이스 종료
                if(isEnd)
                    break;
            }
        }
    }
}
