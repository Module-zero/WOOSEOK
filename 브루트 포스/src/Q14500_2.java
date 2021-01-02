/*
테트로미노

https://www.acmicpc.net/problem/14500
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-28
 * Time: 오후 3:38
 */

public class Q14500_2
{
    static int[][][] d =
            {
                {{0, 1}, {1, 0}, {1, 1}}, // ㅁ
                {{0, 1}, {0, 2}, {0, 3}}, {{1, 0}, {2, 0}, {3, 0}}, // 일자
                {{1, 0}, {0, 1}, {0 ,2}}, {{1, 0}, {2, 0}, {2, 1}}, {{0, 1}, {0, 2}, {-1, 2}}, {{0, 1}, {1, 1}, {2, 1}}, // ㄴ
                {{0, 1}, {0, 2}, {1, 2}}, {{1, 0}, {2, 0}, {0, 1}}, {{1, 0}, {1, 1}, {1, 2}}, {{0, 1}, {-1, 1}, {-2, 1}}, // ㄴ 반대
                {{-1, 1}, {0, 1}, {1, 1}}, {{0, 1}, {0, 2}, {1, 1}}, {{1, 0}, {1, 1}, {2, 0}}, {{0, 1}, {0, 2}, {-1, 1}}, // ㅓ ㅏ ㅗ ㅜ
                {{0, 1}, {-1, 1}, {-1, 2}}, {{1, 0}, {1, 1}, {2, 1}}, // z
                {{0, 1}, {1, 1}, {1, 2}}, {{1, 0}, {0, 1}, {-1, 1}} // z 반대
            }; // [19][3][2]
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[501][501];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                for(int k=0; k<19; k++)
                {
                    int sum = ary[i][j];

                    int l = 0;
                    for(; l<3; l++)
                    {
                        int newR = i + d[k][l][0];
                        if(newR < 0 || newR >= N)
                            break;

                        int newC = j + d[k][l][1];
                        if(newC < 0 || newC >= M)
                            break;

                        sum += ary[newR][newC];
                    }

                    if(l == 3)
                        ans = Integer.max(ans, sum);
                }
            }
        }

        System.out.println(ans);
    }
}
