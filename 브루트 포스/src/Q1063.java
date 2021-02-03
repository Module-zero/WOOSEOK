/*
킹

https://www.acmicpc.net/problem/1063
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 9:22
 */

public class Q1063
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[8][8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        int kc = king.charAt(0) - 'A';
        int kr = king.charAt(1) - '1';
        String stone = st.nextToken();
        int sc = stone.charAt(0) - 'A';
        int sr = stone.charAt(1) - '1';

        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
        int N = Integer.parseInt(st.nextToken());
        while(N-- > 0)
        {
            String str = br.readLine();

            int dir = 0;
            switch(str)
            {
                case "R":
                    dir = 0;
                    break;
                case "L":
                    dir = 1;
                    break;
                case "B":
                    dir = 2;
                    break;
                case "T":
                    dir = 3;
                    break;
                case "RT":
                    dir = 4;
                    break;
                case "LT":
                    dir = 5;
                    break;
                case "RB":
                    dir = 6;
                    break;
                case "LB":
                    dir = 7;
                    break;
            }

            int newKr = kr + dr[dir];
            if(newKr < 0 || newKr >= 8)
                continue;
            int newKc = kc + dc[dir];
            if(newKc < 0 || newKc >= 8)
                continue;

            if(newKr == sr && newKc == sc)
            {
                int newSr = sr + dr[dir];
                if(newSr < 0 || newSr >= 8)
                    continue;
                int newSc = sc + dc[dir];
                if(newSc < 0 || newSc >= 8)
                    continue;

                sr = newSr;
                sc = newSc;
            }

            kr = newKr;
            kc = newKc;
        }

        StringBuffer sb = new StringBuffer();
        sb.append((char)(kc + 'A')).append(kr + 1).append('\n');
        sb.append((char)(sc + 'A')).append(sr + 1);
        System.out.println(sb.toString());
    }
}
