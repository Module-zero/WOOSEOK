/*
큐 2

https://www.acmicpc.net/problem/18258
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
 * Date: 2021-01-27
 * Time: 오전 12:22
 */

public class Q18258
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(N-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch(str)
            {
                case "push":
                {
                    int num = Integer.parseInt(st.nextToken());
                    dq.add(num);
                    break;
                }
                case "front":
                    if(dq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(dq.peek()).append('\n');
                    break;
                case "back":
                    if(dq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(dq.peekLast()).append('\n');
                    break;
                case "size":
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty":
                    if(dq.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');

                    break;
                case "pop":
                    if(dq.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(dq.poll()).append('\n');

                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
