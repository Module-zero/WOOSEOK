import sun.util.locale.StringTokenIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 2:05
 */

public class Q11256
{
    static class Box implements Comparable<Box>
    {
        int capacity;
        int remain;

        public Box(int capacity, int remain)
        {
            this.capacity = capacity;
            this.remain = remain;
        }

        @Override
        public int compareTo(Box o)
        {
            return capacity - o.capacity;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            PriorityQueue<Box> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                pq.add(new Box(R*C, R*C));
            }

            int cnt = 0;
            while(!pq.isEmpty())
            {
                Box box = pq.poll();
                if(j > box.remain)
                {
                    cnt++;
                    j -= box.remain;
                }
                else
                {
                    if(box.capacity == box.remain)
                        cnt++;

                    break;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
