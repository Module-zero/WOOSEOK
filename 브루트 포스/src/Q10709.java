/*
기상캐스터

https://www.acmicpc.net/problem/10709
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-22
 * Time: 오후 4:21
 */

public class Q10709
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] ans = new int[101][101];
        char[][] map = new char[101][101];
        ArrayList<int[]> cList = new ArrayList<>();
        for(int i=0; i<H; i++)
        {
            String str = br.readLine();

            for(int j=0; j<W; j++)
            {
                map[i][j] = str.charAt(j);
                if(map[i][j] != 'c')
                    ans[i][j] = -1;
                else
                    cList.add(new int[]{i, j});
            }
        }

        for(int[] c : cList)
        {
            for(int j=c[1]+1; j<W; j++)
            {
                // 구름이면 스킵
                if(map[c[0]][j] == 'c')
                    continue;
                // 아직 기록하지 않았으면 기록
                else if(ans[c[0]][j] == -1)
                    ans[c[0]][j] = j - c[1];
                else
                    ans[c[0]][j] = Integer.min(ans[c[0]][j], j - c[1]);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<H; i++)
        {
            for(int j=0; j<W; j++)
                sb.append(ans[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
