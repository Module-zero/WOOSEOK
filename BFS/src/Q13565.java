import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-16
 * Time: 오후 7:23
 */

public class Q13565
{
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int M;
    static int N;
    static boolean[][] check = new boolean[1000][1000];
    static int[][] ary = new int[1001][1001];

    public static boolean dfs(int r, int c)
    {
        if(r == M-1)
            return true;

        check[r][c] = true;
        for(int i=0; i<4; i++)
        {
            int newR = r + dr[i];
            if(newR < 0 || newR >= M)
                continue;

            int newC = c + dc[i];
            if(newC < 0 || newC >= N)
                continue;

            if(ary[newR][newC] == 1)
                continue;
            if(check[newR][newC])
                continue;

            if(dfs(newR, newC))
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j) - '0';
        }

        for(int i=0; i<N; i++)
        {
            if(ary[0][i] == 0)
            {
                if(dfs(0, i))
                {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}
