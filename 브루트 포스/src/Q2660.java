import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 11:22
 */

public class Q2660
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] ary = new int[51][51];
        int INF = 100000000;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                ary[i][j] = INF;
        }

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1)
                break;

            ary[a][b] = ary[b][a] = 1;
        }

        for(int k=1; k<=n; k++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                    ary[i][j] = Integer.min(ary[i][j], ary[i][k] + ary[k][j]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        for(int i=1; i<=n; i++)
        {
            int tmp = 0;
            for(int j=1; j<=n; j++)
            {
                if(i == j)
                    continue;

                tmp = Integer.max(tmp, ary[i][j]);
            }

            pq.add(new int[]{i, tmp});
        }

        StringBuilder sb = new StringBuilder();
        int ansScore = pq.peek()[1];
        int ansNum = 0;
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            if(tmp[1] > ansScore)
                break;

            ansNum++;
            sb.append(tmp[0]).append(' ');
        }

        System.out.println(ansScore + " " + ansNum);
        System.out.println(sb.toString());
    }
}
