import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-17
 * Time: 오전 12:10
 */

public class Q14938
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] t = new int[101];
        for(int i=1; i<=n; i++)
            t[i] = Integer.parseInt(st.nextToken());

        int[][] dist = new int[101][101];
        int INF = 1000000000;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                dist[i][j] = INF;
        }

        for(int i=0; i<r; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            dist[a][b] = l;
            dist[b][a] = l;
        }

        for(int k=1; k<=n; k++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++)
        {
            int cur = t[i];
            for(int j=1; j<=n; j++)
            {
                if(i == j || dist[i][j] > m)
                    continue;

                cur += t[j];
            }

            ans = Integer.max(ans, cur);
        }

        System.out.println(ans);
    }
}
