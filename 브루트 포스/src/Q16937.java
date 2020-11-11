/*
두 스티커

https://www.acmicpc.net/problem/16937
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 11:08
 */

public class Q16937
{
    static int H;
    static int W;
    static int N;
    static int[] R = new int[101];
    static int[] C = new int[101];
    static int max = Integer.MIN_VALUE;

    public static void firstSticker(int i, int r1, int c1)
    {
        // 모눈종이에 꽉차는 스티커면 2개를 붙일 수 없다.
        if(r1 == H && c1 == W)
            return;

        // 한 면은 꽉 차도 된다.(넘는 건 안됨)
        if(r1 <= H && c1 <= W)
        {
            // 스티커 하나의 넓이 저장
            int area1 = r1 * c1;

            // 남은 칸을 저장
            int rRem = H - r1;
            int cRem = W - c1;

            // 두 번째 스티커를 붙여본다.
            secondSticker(i, rRem, cRem, area1);
        }
    }

    public static void secondSticker(int i, int rRem, int cRem, int area1)
    {
        for (int j = i + 1; j < N; j++)
        {
            int[] row = {R[j], C[j]};
            int[] col = {C[j], R[j]};

            for(int k = 0; k < 2; k++)
            {
                int r2 = row[k];
                int c2 = col[k];

                // 행 방향으로 붙일 수 있으면
                if (r2 <= rRem && c2 <= W)
                {
                    int area = area1 + r2 * c2;

                    if (max < area)
                        max = area;
                }

                // 열 방향으로 붙일 수 있으면
                if (c2 <= cRem && r2 <= H)
                {
                    int area = area1 + r2 * c2;

                    if (max < area)
                        max = area;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++)
        {
            // 첫 번째 스티커를 붙인다.
            firstSticker(i, R[i], C[i]);
            // 뒤집어서 붙인다.
            firstSticker(i, C[i], R[i]);
        }

        if(max < 0)
            System.out.println(0);
        else
            System.out.println(max);
    }
}
