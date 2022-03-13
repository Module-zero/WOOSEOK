import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-13
 * Time: 오전 12:49
 */

public class Q14620_2
{
    static int N;
    static int[][] G = new int[11][11];
    static int ans = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static boolean[][] b = new boolean[11][11];

    public static void foo(int rc, int cnt, int total)
    {
        if(cnt == 3)
        {
            ans = Integer.min(ans, total);
            return;
        }

        while(rc < N*N)
        {
            int i = rc / N;
            int j = rc % N;

            rc++;

            if(b[i][j] == true)
                continue;

            int k = 0;
            for(; k<4; k++)
            {
                int newR = i + dr[k];
                if(newR < 0 || newR >= N)
                    break;

                int newC = j + dc[k];
                if(newC < 0 || newC >= N)
                    break;

                if(b[newR][newC] == true)
                    break;
            }

            if(k < 4)
                continue;

            int cur = G[i][j];
            b[i][j] = true;
            for(k=0; k<4; k++)
            {
                int newR = i + dr[k];
                int newC = j + dc[k];

                cur += G[newR][newC];
                b[newR][newC] = true;
            }

            foo(rc, cnt+1, total+cur);

            b[i][j] = false;
            for(k=0; k<4; k++)
            {
                int newR = i + dr[k];
                int newC = j + dc[k];

                b[newR][newC] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                G[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0, 0);

        System.out.println(ans);
    }
}
