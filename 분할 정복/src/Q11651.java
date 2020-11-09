/*
좌표 정렬하기 2

https://www.acmicpc.net/problem/11651
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-09
 * Time: 오후 7:22
 */

public class Q11651
{
    static Location[] locations = new Location[100001];
    static Location[] tmp = new Location[100001];

    static class Location implements Comparable<Location>
    {
        int x;
        int y;

        public Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o)
        {
            if(y < o.y)
                return -1;
            else if(y == o.y)
            {
                if(x < o.x)
                    return -1;
                else if(x == o.x)
                    return 0;
                else
                    return 1;
            }
            else
                return 1;
        }
    }

    public static void sort(int start, int end)
    {
        if(start >= end)
            return;

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(locations[i].compareTo(locations[j]) == -1)
                tmp[k++] = locations[i++];
            else
                tmp[k++] = locations[j++];
        }

        while(i <= mid)
            tmp[k++] = locations[i++];
        while(j <= end)
            tmp[k++] = locations[j++];

        for(int a=start; a<=end; a++)
            locations[a] = tmp[a - start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int x;
        int y;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            locations[i] = new Location(x, y);
        }

        sort(0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
            sb.append(locations[i].x).append(' ').append(locations[i].y).append('\n');

        System.out.print(sb.toString());
    }
}
