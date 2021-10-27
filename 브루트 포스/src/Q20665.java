import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-27
 * Time: 오후 1:18
 */

public class Q20665
{
    static class Temp implements Comparable<Temp>
    {
        int start;
        int end;

        public Temp(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Temp t)
        {
            if(start == t.start)
                return end - t.end;
            else
                return start - t.start;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Temp> list = new ArrayList<>();
        for(int i=0; i<T; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            start = (start / 100) * 60 + (start % 100);
            int end = Integer.parseInt(st.nextToken());
            end = (end / 100) * 60 + (end % 100);
            list.add(new Temp(start, end));
        }

        Collections.sort(list);

        int ans = 0;
        int[] check = new int[101];
        for(int i=0; i<N; i++)
            check[i] = 540;

        for(Temp t : list)
        {
            int[] d = new int[101];
            for(int i=0; i<N; i++)
            {
                // 퇴실 시간이 내 입실 시간보다 크면(앉아있으면) 각 좌석 거리 계산
                if(check[i] > t.start)
                {
                    int si = i-1;
                    int ei = i+1;

                    while(si >= 0)
                    {
                        if(d[si] == 0)
                            d[si] = i - si;
                        else
                            d[si] = Integer.min(d[si], i - si);
                        si--;
                    }

                    while(ei < N)
                    {
                        if(d[ei] == 0)
                            d[ei] = ei - i;
                        else
                            d[ei] = Integer.min(d[ei], ei - i);
                        ei++;
                    }
                }
            }

            int id = -1;
            int dist = -1;
            for(int i=0; i<N; i++)
            {
                if(check[i] > t.start)
                    continue;

                if(d[i] > dist)
                {
                    id = i;
                    dist = d[i];
                }
            }

            if(id == P)
                ans += t.start - check[id];

            check[id] = t.end;
        }

        ans += 1260 - check[P];
        System.out.println(ans);
    }
}
