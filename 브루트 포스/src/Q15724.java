import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 11:17
 */

public class Q15724
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[1025][1025];
        int[][] sum = new int[1025][1025];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = ary[i][j] + sum[i][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(K-- > 0)
        {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x=x1; x<=x2; x++)
                ans += sum[x][y2] - sum[x][y1-1];

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
