import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-04
 * Time: 오전 12:58
 */

public class Q21611
{
    static int N;
    static int M;
    static int[] ary = new int[2501];
    static int[][] marble = new int[50][50];
    static int[] marbleR = new int[2501];
    static int[] marbleC = new int[2501];
    static int[] mr = {0, 1, 0, -1};
    static int[] mc = {-1, 0, 1, 0};
    static int[] ans = new int[4];

    public static boolean move()
    {
        // 0의 개수만큼 앞으로 땡긴다.
        int cnt0 = 0;
        boolean allZero = true;
        for(int i=0; i<N*N-1; i++)
        {
            if(marble[marbleR[i]][marbleC[i]] == 0)
                cnt0++;
            else
            {
                allZero = false;

                if(cnt0 == 0)
                    continue;

                ary[i-cnt0] = ary[i];
                marble[marbleR[i-cnt0]][marbleC[i-cnt0]] = marble[marbleR[i]][marbleC[i]];

                ary[i] = 0;
                marble[marbleR[i]][marbleC[i]] = 0;
            }
        }

        return allZero;
    }

    public static void init()
    {
        int d = 0;
        int r = N/2;
        int c = N/2;

        int id = 0;
        boolean isOk = false;
        while(true)
        {
            int lim = (d+2)/2;
            if(lim == N)
            {
                lim--;
                isOk = true;
            }

            // 번호를 매긴다.
            // 구슬의 좌표 또한 기록.
            for(int i=0; i<lim; i++)
            {
                int newR = r + mr[d%4];
                int newC = c + mc[d%4];

                marbleR[id] = newR;
                marbleC[id] = newC;
                ary[id++] = marble[newR][newC];
                r = newR;
                c = newC;
            }

            if(isOk)
                break;

            d++;
        }
    }

    public static boolean boom()
    {
        while(true)
        {
            int cnt = 1;
            int bomb = 0;
            for(int i=1; i<N*N; i++)
            {
                if(ary[i] == 0)
                {
                    if(cnt >= 4)
                    {
                        ans[ary[i-1]] += cnt;
                        for(int j=1; j<=cnt; j++)
                        {
                            ary[i-j] = 0;
                            marble[marbleR[i-j]][marbleC[i-j]] = 0;
                        }

                        bomb++;
                    }

                    cnt = 1;
                    break;
                }

                if(ary[i] == ary[i-1])
                    cnt++;
                else
                {
                    if(cnt >= 4)
                    {
                        ans[ary[i-1]] += cnt;

                        for(int j=1; j<=cnt; j++)
                        {
                            ary[i-j] = 0;
                            marble[marbleR[i-j]][marbleC[i-j]] = 0;
                        }

                        bomb++;
                    }

                    cnt = 1;
                }
            }

            if(bomb == 0)
                break;

            if(move())
                return true;
        }

        return false;
    }

    public static boolean foo()
    {
        if(move())
            return true;

        if(boom())
            return true;

        int d = 0;
        int id = 0;
        int cnt = 0;
        int r = N/2;
        int c = N/2;
        boolean end = false;
        while(id < N*N-1)
        {
            int lim = (d+2)/2;
            if(lim == N)
            {
                if(cnt > 0)
                {
                    ary[id++] = cnt;
                    ary[id++] = marble[r][c];

                    cnt = 0;
                }

                end = true;
                lim--;
            }

            for(int i=0; i<lim; i++)
            {
                if(id >= N*N-1)
                    break;

                int newR = r + mr[d%4];
                int newC = c + mc[d%4];

                if(marble[newR][newC] == 0)
                {
                    if(cnt > 0)
                    {
                        ary[id++] = cnt;
                        ary[id++] = marble[r][c];

                        cnt = 0;
                        end = true;
                    }

                    break;
                }

                if(marble[newR][newC] == marble[r][c])
                    cnt++;
                else
                {
                    // 첫 시작점 제외
                    if(cnt > 0)
                    {
                        ary[id++] = cnt;
                        ary[id++] = marble[r][c];
                    }

                    cnt = 1;
                }

                r = newR;
                c = newC;
            }

            if(end)
            {
                if(cnt > 0 && id < N*N-1)
                {
                    ary[id++] = cnt;
                    ary[id++] = marble[r][c];
                }
                break;
            }

            d++;
        }

        for(int i=0; i<N*N-1; i++)
        {
            if(i >= id)
                marble[marbleR[i]][marbleC[i]] = 0;
            else
                marble[marbleR[i]][marbleC[i]] = ary[i];
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                marble[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = N/2;
        int c = N/2;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        init();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for(int i=1; i<=s; i++)
            {
                int newR = r + dr[d-1]*i;
                int newC = c + dc[d-1]*i;
                marble[newR][newC] = 0;
            }

            // 번호가 하나 작은 칸이 빈 칸이면 이동
            if(foo())
                break;
        }

        System.out.println(ans[1] + 2*ans[2] + 3*ans[3]);
    }
}
