import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 2:34
 */

public class scf4
{
    static double[] ary;
    static class Tmp implements Comparable<Tmp>
    {
        char info;
        char genre;
        int i;
        int j;

        public Tmp(char info, char genre, int i, int j)
        {
            this.info = info;
            this.genre = genre;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Tmp o)
        {
            if(info == o.info)
            {
                int tmp1 = genre - 'A';
                int tmp2 = o.genre - 'A';

                if(ary[tmp1] == ary[tmp2])
                {
                    if(i == o.i)
                        return j - o.j;
                    else
                        return i - o.i;
                }
                else if(ary[tmp1] > ary[tmp2])
                    return -1;
                else
                    return 1;
            }
            else if(info == 'Y' && o.info == 'O')
                return -1;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ary = new double[5];
        for(int i=0; i<5; i++)
            ary[i] = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] info = new char[101][11];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                info[i][j] = str.charAt(j);
        }

        char[][] genre = new char[101][11];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                genre[i][j] = str.charAt(j);
        }

        PriorityQueue<Tmp> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(info[i][j] == 'W')
                    continue;

                pq.add(new Tmp(info[i][j], genre[i][j], i, j));
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty())
        {
            Tmp t = pq.poll();

            sb.append(t.genre).append(' ').append(String.format("%.1f", ary[t.genre-'A'])).append(' ').append(t.i).append(' ').append(t.j).append('\n');
        }

        System.out.print(sb.toString());
    }
}
