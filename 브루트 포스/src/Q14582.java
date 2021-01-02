/*
오늘도 졌다

https://www.acmicpc.net/problem/14582
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-01
 * Time: 오후 10:37
 */

public class Q14582
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] jem = new int[9];
        for(int i=0; i<9; i++)
            jem[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sta = new int[9];
        for(int i=0; i<9; i++)
            sta[i] = Integer.parseInt(st.nextToken());

        int jSum = 0;
        int sSum = 0;
        boolean jWin = false;
        for(int i=0; i<9; i++)
        {
            jSum += jem[i];
            if(jSum > sSum)
                jWin = true;

            sSum += sta[i];
        }

        if(jSum < sSum && jWin)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
