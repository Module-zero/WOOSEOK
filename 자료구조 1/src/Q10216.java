/*
Count Circle Groups

https://www.acmicpc.net/problem/10216
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-23
 * Time: 오후 8:16
 */

public class Q10216
{
    static int N;
    static int[][] ary;
    static int[] p;

    public static int find(int n)
    {
        if(n == p[n])
            return n;

        return p[n] = find(p[n]);
    }

    public static boolean merge(int n1, int n2)
    {
        n1 = find(n1);
        n2 = find(n2);
        // 이미 같은 그룹이면 return
        if(n1 == n2)
            return false;
        else
        {
            p[n2] = n1;
            return true;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            N = Integer.parseInt(br.readLine());
            ary = new int[3001][3];
            p = new int[3001];

            for(int i=0; i<N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i] = i;

                for(int j=0; j<3; j++)
                    ary[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = N;
            for(int i=0; i<N-1; i++)
            {
                for(int j=i+1; j<N; j++)
                {
                    int dx = ary[i][0] - ary[j][0];
                    int dy = ary[i][1] - ary[j][1];
                    int dr = ary[i][2] + ary[j][2];
                    int dist = dx*dx + dy*dy;

                    if(dist <= dr*dr)
                    {
                        if(merge(i, j))
                            cnt--;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
