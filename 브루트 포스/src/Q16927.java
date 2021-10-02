import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 5:08
 */

public class Q16927
{
    static int N;
    static int M;
    static int[][] ary = new int[301][301];
    static int[][] tmp = new int[301][301];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int min;

    /*
    public static void clock(int cnt)
    {
        while(cnt-- > 0)
        {
            for(int i=0; i<min; i++)
            {
                int sr = i;
                int sc = M-i-1;
                int d = 3;

                while(true)
                {
                    int nr = sr + dr[d];
                    if(nr < i || nr >= N-i)
                    {
                        d = d-1;
                        if(d < 0)
                            d = 3;
                        continue;
                    }
                    int nc = sc + dc[d];
                    if(nc < i || nc >= M-i)
                    {
                        d = d-1;
                        if(d < 0)
                            d = 3;
                        continue;
                    }

                    tmp[nr][nc] = ary[sr][sc];

                    if(nr == i && nc == M-i-1)
                        break;

                    sr = nr;
                    sc = nc;
                }
            }

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                    ary[i][j] = tmp[i][j];
            }
        }
    }
    */

    public static void ctclock(int R)
    {
        for(int cnt=0; cnt<R; cnt++)
        {
            boolean isOk = true;

            for(int i=0; i<min; i++)
            {
                int lim = R % (2*(M+N-2) - 8*i);

                // 박스가 정해진 횟수만큼 회전을 끝냈으면 회전하지 않는다.
                if(cnt >= lim)
                    continue;

                isOk = false;

                int sr = i;
                int sc = M-i-1;
                int d = 0;

                while(true)
                {
                    int nr = sr + dr[d];
                    if(nr < i || nr >= N-i)
                    {
                        d = (d+1) % 4;
                        continue;
                    }
                    int nc = sc + dc[d];
                    if(nc < i || nc >= M-i)
                    {
                        d = (d+1) % 4;
                        continue;
                    }

                    tmp[nr][nc] = ary[sr][sc];

                    sr = nr;
                    sc = nc;

                    if(nr == i && nc == M-i-1)
                        break;
                }
            }

            for(int r=0; r<N; r++)
            {
                for(int c=0; c<M; c++)
                {
                    if(tmp[r][c] == 0)
                        continue;

                    ary[r][c] = tmp[r][c];
                }
            }

            if(isOk)
                break;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        min = Math.min(N, M) / 2;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        ctclock(R);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                sb.append(ary[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
