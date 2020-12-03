/*
롤러코스터

https://www.acmicpc.net/problem/2873
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-03
 * Time: 오전 11:11
 */

public class Q2873
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int minR;
        int minC;
        int min = Integer.MAX_VALUE;

        int[][] ary = new int[1001][1001];
        for(int i=R-1; i>=0; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<C; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());

                // 검정칸의 최솟값을 저장한다.
                if(ary[i][j] < min && (i+j) % 2 == 0)
                {
                    min = ary[i][j];
                    minR = i;
                    minC = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 행과 열이 모두 짝수일 때만 검정칸 하나를 방문할 수 없게 된다.
        if(R % 2 == 0 && C % 2 == 0)
        {
            int j = 0;
            for(int i=R-1; i>=0; i--)
            {
                if(j == 0)
                {
                    while(j < C-1)
                    {
                        sb.append('R');
                        j++;
                    }
                }
                else
                {
                    while(j > 0)
                    {
                        sb.append('L');
                        j--;
                    }
                }

                if(i == 0 && j == C-1)
                    break;
                else
                    sb.append('D');
            }
        }
        else
        {
            int j = 0;
            for(int i=R-1; i>=0; i--)
            {
                if(j == 0)
                {
                    while(j < C-1)
                    {
                        sb.append('R');
                        j++;
                    }
                }
                else
                {
                    while(j > 0)
                    {
                        sb.append('L');
                        j--;
                    }
                }

                if(i == 0 && j == C-1)
                    break;
                else
                    sb.append('D');
            }
        }

        System.out.println(sb.toString());
    }
}
