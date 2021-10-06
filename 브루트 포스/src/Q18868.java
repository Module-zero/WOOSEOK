import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 8:12
 */

public class Q18868
{
    static class Tmp implements Comparable<Tmp>
    {
        int id;
        int num;

        public Tmp(int id, int num)
        {
            this.id = id;
            this.num = num;
        }

        @Override
        public int compareTo(Tmp o)
        {
            if(num < o.num)
                return -1;
            else if(num > o.num)
                return 1;
            else
            {
                if(id < o.id)
                    return -1;
                else
                    return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Tmp[][] pq = new Tmp[10][100];
        for(int j=0; j<M; j++)
        {
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++)
                pq[j][i] = new Tmp(i, Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++)
            Arrays.sort(pq[i], 0, N);

        int ans = 0;
        for(int i=0; i<M-1; i++)
        {
            for(int j=i+1; j<M; j++)
            {
                ans++;
                for(int k=0; k<N; k++)
                {
                    if(pq[i][k].id != pq[j][k].id)
                    {
                        ans--;
                        break;
                    }
                    else
                    {
                        if(k == 0)
                            continue;

                        int s1 = pq[i][k].num - pq[i][k-1].num;
                        int s2 = pq[j][k].num - pq[j][k-1].num;
                        if(s1 > 0 && s2 > 0)
                            continue;
                        else if(s1 == 0 && s2 == 0)
                            continue;
                        else if(s1 < 0 && s2 < 0)
                            continue;
                        else
                        {
                            ans--;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
