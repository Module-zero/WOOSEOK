import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-15
 * Time: 오후 9:51
 */

public class Q16507
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1001];
        for(int i=1; i<=R; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=C; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] hor = new int[1001][1001];

        for(int i=1; i<=R; i++)
        {
            for(int j=1; j<=C; j++)
                hor[i][j] = hor[i][j-1] + ary[i][j];
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<Q; i++)
        {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int r=r1; r<=r2; r++)
                sum += hor[r][c2] - hor[r][c1-1];

            int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);

            sb.append(sum/cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
