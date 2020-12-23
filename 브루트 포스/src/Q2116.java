/*
주사위 쌓기

https://www.acmicpc.net/problem/2116
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-22
 * Time: 오후 5:26
 */

public class Q2116
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[10001][6];
        for(int i=1; i<=n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        // 위가 몇 번째 면인지 저장
        int[] up = new int[10001];
        for(int dice1=0; dice1<6; dice1++)
        {
            up[1] = dice1;

            for(int i=2; i<=n; i++)
            {
                for(int plane=0; plane<6; plane++)
                {
                    // 현재 주사위의 밑면이 아래 주사위의 윗면과 같으면 다음 주사위로
                    if(dice[i][plane] == dice[i-1][up[i-1]])
                    {
                        if(plane == 0 || plane == 5)
                            up[i] = 5 - plane;
                        else if(plane == 1 || plane == 3)
                            up[i] = 4 - plane;
                        else
                            up[i] = 6 - plane;
                        break;
                    }
                }
            }

            int sum = 0;
            // 각 주사위의 옆면의 최댓값을 합친다.
            for(int i=1; i<=n; i++)
            {
                switch(up[i])
                {
                    case 0:
                    case 5:
                        sum += Integer.max(dice[i][1], Integer.max(dice[i][2], Integer.max(dice[i][3], dice[i][4])));
                        break;
                    case 1:
                    case 3:
                        sum += Integer.max(dice[i][0], Integer.max(dice[i][2], Integer.max(dice[i][4], dice[i][5])));
                        break;
                    case 2:
                    case 4:
                        sum += Integer.max(dice[i][0], Integer.max(dice[i][1], Integer.max(dice[i][3], dice[i][5])));
                        break;
                }
            }

            max = Integer.max(max, sum);
        }

        System.out.println(max);
    }
}
