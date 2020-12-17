/*
십자가 2개 놓기

https://www.acmicpc.net/problem/17085
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-09
 * Time: 오후 4:32
 */

public class Q17085
{
    static int N;
    static int M;
    static char[][] ary = new char[16][16];

    public static boolean putCross(int r, int c, int size)
    {
        if(isOk(r, c, size))
        {
            for(int i=r-size; i<=r+size; i++)
                ary[i][c] = '*';

            for(int j=c-size; j<=c+size; j++)
                ary[r][j] = '*';

            return true;
        }

        return false;
    }

    public static void deleteCross(int r, int c, int size)
    {
        for(int i=r-size; i<=r+size; i++)
            ary[i][c] = '#';

        for(int j=c-size; j<=c+size; j++)
            ary[r][j] = '#';
    }

    public static boolean isOk(int r, int c, int size)
    {
        for(int i=r-size; i<=r+size; i++)
        {
            if(i < 0 || i >= N)
                return false;

            if(ary[i][c] != '#')
                return false;
        }

        for(int i=c-size; i<=c+size; i++)
        {
            if(i < 0 || i >= M)
                return false;

            if(ary[r][i] != '#')
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        int max = Integer.MIN_VALUE;
        for(int r1=0; r1<N; r1++)
        {
            for(int c1=0; c1<M; c1++)
            {
                // 십자가를 놓을 수 있으면
                if(ary[r1][c1] == '#')
                {
                    for(int size1=7; size1>=0; size1--)
                    {
                        // 놓을 수 있는 가장 큰 십자가 선택
                        if(putCross(r1, c1, size1))
                        {
                            for(int r2=0; r2<N; r2++)
                            {
                                for(int c2=0; c2<M; c2++)
                                {
                                    if(r1 == r2 && c1 == c2)
                                        continue;

                                    // 두 번째 십자가를 놓는다.
                                    for(int size2=7; size2>=0; size2--)
                                    {
                                        if(putCross(r2, c2, size2))
                                        {
                                            int ans = (4*size1 + 1) * (4*size2 + 1);

                                            if(max < ans)
                                                max = ans;

                                            deleteCross(r2, c2, size2);
                                        }
                                    }
                                }
                            }

                            deleteCross(r1, c1, size1);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
