/*
종이자르기

https://www.acmicpc.net/problem/2628
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
 * Date: 2021-02-03
 * Time: 오후 4:42
 */

public class Q2628
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> hor = new ArrayList<>();
        ArrayList<Integer> ver = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        hor.add(0);
        hor.add(Integer.parseInt(st.nextToken()));
        ver.add(0);
        ver.add(Integer.parseInt(st.nextToken()));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(command == 0)
                ver.add(num);
            else
                hor.add(num);
        }

        Collections.sort(hor);
        Collections.sort(ver);

        int hCnt = hor.size();
        int vCnt = ver.size();
        int max = 0;
        for(int i=0; i<hCnt-1; i++)
        {
            int horizon = hor.get(i+1) - hor.get(i);

            for(int j=0; j<vCnt-1; j++)
            {
                int vertical = ver.get(j+1) - ver.get(j);
                int area = horizon * vertical;
                max = Integer.max(max, area);
            }
        }

        System.out.println(max);
    }
}
