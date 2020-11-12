/*
감시

https://www.acmicpc.net/problem/15683
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오전 11:44
 */

public class Q15683
{
    static int N;
    static int M;
    static char[][] ary = new char[8][8];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]> cctvList = new ArrayList<>();

    public static void count()
    {
        int cnt = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(ary[i][j] == '0')
                    cnt++;
                // cctv 범위를 입력했던 것을 돌려놓는다.
                else if(ary[i][j] == '#')
                    ary[i][j] = '0';
            }
        }

        if(cnt < min)
            min = cnt;
    }

    public static void foo(int index)
    {
        // 모든 cctv 범위를 표시했으면 검사
        if(index == cctvList.size())
        {
            count();
            return;
        }

        int[] cctv = cctvList.get(index);

        switch(ary[cctv[0]][cctv[1]])
        {
            case '1':
                for(int i=0; i<4; i++)
                {

                }
                break;
            case '2':
                for(int i=0; i<2; i++)
                {

                }
                break;
            case '3':
                for(int i=0; i<4; i++)
                {

                }
                break;
            case '4':
                for(int i=0; i<4; i++)
                {

                }
                break;
            case '5':
            {
                for(int i=0; i<4; i++)
                {

                }
            }
                break;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // [0] : row, [1] : col
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
            {
                ary[i][j] = st.nextToken().charAt(0);

                // cctv면 저장
                if(ary[i][j] >= '1' && ary[i][j] <= '5')
                    cctvList.add(new int[]{i, j});
            }
        }

        foo(0);

        System.out.println(min);
    }
}
