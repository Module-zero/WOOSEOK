/*
화살표 그리기

https://www.acmicpc.net/problem/15970
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-13
 * Time: 오후 11:07
 */

public class Q15970
{
    static class Temp implements Comparable<Temp>
    {
        int x;
        int y;

        public Temp(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(y == o.y)
                return x - o.x;
            else
                return y - o.y;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Temp> list = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Temp(x, y));
        }

        Collections.sort(list);

        long ans = 0;
        int size = list.size();

        for(int i=0; i<size; i++)
        {
            Temp cur = list.get(i);

            int min = Integer.MAX_VALUE;
            if(i - 1 >= 0 && list.get(i-1).y == cur.y)
                min = Integer.min(min, cur.x - list.get(i-1).x);

            if(i + 1 < size && list.get(i+1).y == cur.y)
                min = Integer.min(min, list.get(i+1).x - cur.x);

            if(min != Integer.MAX_VALUE)
                ans += min;
        }

        System.out.println(ans);
    }
}
