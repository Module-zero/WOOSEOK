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
 * Date: 2020-10-15
 * Time: 오후 5:24
 */

public class Q14500
{
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

        int[][][] tetro =
        {
                // 작대기
                {{0, 1}, {0, 2}, {0, 3}},
                {{1, 0}, {2, 0}, {3, 0}},
                // ㄴ
                {{1, 0}, {1, 1}, {1, 2}},
                {{1, 0}, {2, -1}, {2, 0}},
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {1, 0}, {2, 0}},
                // ㄴ 뒤집은 모양
                {{1, -2}, {1, -1}, {1, 0}},
                {{0, 1}, {1, 1}, {2, 1}},
                {{0, 1}, {0, 2}, {1, 0}},
                {{1, 0}, {2, 0}, {2, 1}},
                // ㅁ
                {{0, 1}, {1, 0}, {1, 1}},
                // ㅗ, ㅓ, ㅜ, ㅏ
                {{1, -1}, {1, 0}, {1, 1}},
                {{1, -1}, {1, 0}, {2, 0}},
                {{0, 1}, {0, 2}, {1, 1}},
                {{1, 0}, {1, 1}, {2, 0}},
                // ㄹ
                {{0, 1}, {1, 1}, {1, 2}},
                {{1, -1}, {1, 0}, {2, -1}},
                {{0, 1}, {1, -1}, {1, 0}},
                {{1, 0}, {1, 1}, {2, 1}}
        };

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                for(int r=0; r<19; r++)
                {
                    int sum = ary[i][j];

                    for(int c=0; c<3; c++)
                    {
                        int newRow = i + tetro[r][c][0];
                        if(newRow < 0 || newRow >= N)
                            break;
                        int newCol = j + tetro[r][c][1];
                        if(newCol < 0 || newCol >= M)
                            break;

                        sum += ary[newRow][newCol];
                    }

                    if(max < sum)
                        max = sum;
                }
            }
        }

        System.out.println(max);
    }
}
