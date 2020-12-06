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
    public static void foo(StringBuilder sb, char ch, int num)
    {
        for(int i=0; i<num; i++)
            sb.append(ch);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1001];
        int min = Integer.MAX_VALUE;
        int minR = 0;
        int minC = 0;
        for(int i=0; i<R; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<C; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                // 검은 칸의 최솟값을 저장한다.
                if(ary[i][j] < min && (i+j) % 2 == 1)
                {
                    min = ary[i][j];
                    minR = i;
                    minC = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 행이 짝수
        if(R % 2 == 0)
        {
            // 열도 짝수(짝 x 짝) -> 모든 칸 방문 불가능. 검은 칸 하나를 방문할 수 없다.
            if(C % 2 == 0)
            {
                int r1 = 0;
                int c1 = 0;

                // 2열씩 전진
                while(r1 + 2 <= minR)
                {
                    if(r1 + 2 == minR && minC == 0)
                        break;

                    foo(sb, 'R', C-1);
                    foo(sb, 'D', 1);
                    foo(sb, 'L', C-1);
                    foo(sb, 'D', 1);
                    r1 += 2;
                }

                // 2행씩 전진
                while(c1 + 2 <= minC)
                {
                    if(c1 + 2 == minC && minR == r1)
                        break;

                    foo(sb, 'D', 1);
                    foo(sb, 'R', 1);
                    foo(sb, 'U', 1);
                    foo(sb, 'R', 1);
                    c1 += 2;
                }

                StringBuilder sb2r = new StringBuilder();
                int r2 = R-1;
                int c2 = C-1;

                // 2열씩 후진
                while(r2 - 2 >= minR)
                {
                    if(r2 - 2 == minR && minC == C-1)
                        break;

                    foo(sb2r, 'D', 1);
                    foo(sb2r, 'L', C-1);
                    foo(sb2r, 'D', 1);
                    foo(sb2r, 'R', C-1);
                    r2 -= 2;
                }

                // 2행씩 후진
                StringBuilder sb2c = new StringBuilder();
                while(c2 - 2 >= minC)
                {
                    if(c2 - 2 == minC && minR == r2)
                        break;

                    foo(sb2c, 'R', 1);
                    foo(sb2c, 'U', 1);
                    foo(sb2c, 'R', 1);
                    foo(sb2c, 'D', 1);
                    c2 -= 2;
                }

                // 가지 못하는 칸이 오른쪽 칸이면
                if(minC == c1+1)
                {
                    foo(sb, 'D', 1);
                    foo(sb, 'R', 1);
                }
                // 가지 못하는 칸이 아래 칸이면
                else
                {
                    foo(sb, 'R', 1);
                    foo(sb, 'D', 1);
                }

                System.out.println(sb.append(sb2c).append(sb2r).toString());
            }
            // 열은 홀수(짝 x 홀) -> ㄹ 뒤집은 모양으로 방문
            else
            {
                foo(sb, 'D', R-1);

                for(int i=0; i<C/2; i++)
                {
                    foo(sb, 'R', 1);
                    foo(sb, 'U', R-1);
                    foo(sb, 'R', 1);
                    foo(sb, 'D', R-1);
                }

                System.out.println(sb.toString());
            }
        }
        // 행이 홀수
        else
        {
            // 열은 짝수(홀 X 짝) -> ㄹ 모양으로 방문
            // 열도 홀수(홀 X 홀) -> ㄹ 모양으로 방문
            foo(sb, 'R', C - 1);

            for(int i=0; i<R/2; i++)
            {
                foo(sb, 'D', 1);
                foo(sb, 'L', C-1);
                foo(sb, 'D', 1);
                foo(sb, 'R', C-1);
            }

            System.out.println(sb.toString());
        }
    }
}
