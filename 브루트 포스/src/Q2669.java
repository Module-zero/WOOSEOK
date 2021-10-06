import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 4:52
 */

public class Q2669
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] ary = new boolean[101][101];
        for(int i=0; i<4; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x=x1; x<x2; x++)
            {
                for(int y=y1; y<y2; y++)
                {
                    ary[x][y] = true;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<=100; i++)
        {
            for(int j=0; j<=100; j++)
                if(ary[i][j])
                    ans++;
        }

        System.out.println(ans);
    }
}
