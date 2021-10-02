import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오전 1:56
 */

public class Q18290
{
    static int[][] ary = new int[10][10];
    static int N;
    static int M;
    static int K;
    static int[] dr = {0, -1, 0, 0, 1};
    static int[] dc = {0, 0, -1, 1, 0};
    static int[][] check = new int[10][10];
    static int max;

    public static int dfs(int r, int c, int id, int sum)
    {
        if(id == K-1)
            return sum;

        for(int k=0; k<5; k++)
        {
            int newR = r + dr[k];
            if(newR < 0 || newR >= N)
                continue;
            int newC = c + dc[k];
            if(newC < 0 || newC >= M)
                continue;

            check[newR][newC]++;
        }

        for(int i=r; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(i == r && j <= c)
                    continue;

                if(check[i][j] > 0)
                    continue;

                max = Math.max(max, dfs(i, j, id+1, sum + ary[i][j]));
            }
        }

        for(int k=0; k<5; k++)
        {
            int newR = r + dr[k];
            if(newR < 0 || newR >= N)
                continue;
            int newC = c + dc[k];
            if(newC < 0 || newC >= M)
                continue;

            check[newR][newC]--;
        }

        return max;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                max = Integer.MIN_VALUE;
                ans = Math.max(ans, dfs(i, j, 0, ary[i][j]));
            }
        }

        System.out.println(ans);
    }
}
