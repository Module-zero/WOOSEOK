/*
새로운 하노이 탑

https://www.acmicpc.net/problem/12906
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-17
 * Time: 오후 4:38
 */

public class Q12906
{
    static int[] size = new int[3];
    static char[][] state = new char[3][10];

    public static boolean check()
    {
        char[] ch = {'A', 'B', 'C'};

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<size[i]; j++)
            {
                if(state[i][j] != ch[i])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size[i] = Integer.parseInt(st.nextToken());

            String str = st.nextToken();
            for(int j=0; j<size[i]; j++)
                state[i][j] = str.charAt(j);
        }

        boolean[][][][][][] check = new boolean[11][11][11][11][11][11];
        Queue<int[]> queue = new LinkedList<>();
    }
}
