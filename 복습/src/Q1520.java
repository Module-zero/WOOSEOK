import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-31
 * Time: 오후 4:27
 */

public class Q1520
{
    static int M;
    static int N;
    static int[][] ary = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static int dfs(int r, int c)
    {
        if(r == 0 && c == 0)
            dp[r][c] = 1;

        if(dp[r][c] != -1)
            return dp[r][c];

        dp[r][c] = 0;

        for(int i=0; i<4; i++)
        {
            int newR = r + dr[i];
            if(newR < 0 || newR >= M)
                continue;

            int newC = c + dc[i];
            if(newC < 0 || newC >= N)
                continue;

            if(ary[newR][newC] <= ary[r][c])
                continue;

            dp[r][c] += dfs(newR, newC);
        }

        return dp[r][c];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
                dp[i][j] = -1;
        }

        dfs(M-1, N-1);

        System.out.println(dp[M-1][N-1]);
    }
}
