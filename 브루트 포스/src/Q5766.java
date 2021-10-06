import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 2:21
 */

public class Q5766
{
    static Temp[] ary;
    static Temp[] tmp;

    static class Temp implements Comparable<Temp>
    {
        int id;
        int num;

        public Temp(int id, int num)
        {
            this.id = id;
            this.num = num;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(this.num == o.num)
                return o.id - this.id;
            else
                return num - o.num;
        }
    }

    public static void sort(int start, int end)
    {
        if(start >= end)
            return;

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid+1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j<= end)
        {
            if(ary[i].compareTo(ary[j]) > 0)
                tmp[k++] = ary[i++];
            else
                tmp[k++] = ary[j++];
        }

        while(i <= mid)
            tmp[k++] = ary[i++];
        while(j <= end)
            tmp[k++] = ary[j++];

        for(int a=start; a<=end; a++)
            ary[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0)
                break;

            ary = new Temp[10001];
            for(int i=0; i<=10000; i++)
                ary[i] = new Temp(i, 0);
            tmp = new Temp[10001];
            for(int i=0; i<=10000; i++)
                tmp[i] = new Temp(i, 0);

            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++)
                {
                    int id = Integer.parseInt(st.nextToken());

                    ary[id].num++;
                }
            }

            sort(0, 10000);
            int cri = ary[1].num;
            for(int i=1; i<=10000; i++)
            {
                if(ary[i].num != cri)
                    break;

                sb.append(ary[i].id).append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
