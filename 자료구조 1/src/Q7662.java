import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-21
 * Time: 오후 9:23
 */

public class Q7662
{
    static class Pair implements Comparable<Pair>
    {
        int num;
        int index;

        public Pair(int num, int index)
        {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o)
        {
            if(num > o.num)
                return 1;
            else if(num == o.num)
                return 0;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Pair> minHeap = new PriorityQueue<>();
            boolean[] check = new boolean[1000001];

            for(int i=0; i<k; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(command == 'I')
                {
                    Pair p = new Pair(num, i);
                    maxHeap.add(p);
                    minHeap.add(p);
                    check[i] = true;
                }
                else
                {
                    if(num == 1)
                    {
                        while(!maxHeap.isEmpty() && !check[maxHeap.peek().index])
                            maxHeap.poll();

                        if(!maxHeap.isEmpty())
                            check[maxHeap.poll().index] = false;
                    }
                    else
                    {
                        while(!minHeap.isEmpty() && !check[minHeap.peek().index])
                            minHeap.poll();

                        if(!minHeap.isEmpty())
                            check[minHeap.poll().index] = false;
                    }
                }
            }

            while(!maxHeap.isEmpty() && !check[maxHeap.peek().index])
                maxHeap.poll();
            while(!minHeap.isEmpty() && !check[minHeap.peek().index])
                minHeap.poll();

            if(minHeap.isEmpty() || maxHeap.isEmpty())
                sb.append("EMPTY\n");
            else
                sb.append(maxHeap.poll().num).append(' ').append(minHeap.poll().num).append('\n');
        }

        System.out.print(sb.toString());
    }
}
