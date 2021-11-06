import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 2:25
 */

public class Q2458
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[501][501];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[a][b] = 1;
        }

        for(int k=1; k<=N; k++)
        {
            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=N; j++)
                {
                    if(ary[i][k] == 1 && ary[k][j] == 1)
                        ary[i][j] = 1;
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=N; i++)
        {
            int cnt = 0;
            for(int j=1; j<=N; j++)
            {
                if(i == j)
                    continue;

                if(ary[i][j] == 0 && ary[j][i] == 0)
                    cnt++;
            }

            if(cnt == 0)
                ans++;
        }

        System.out.println(ans);
    }
}
