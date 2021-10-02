import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 6:34
 */

public class Q4396
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        char[][] ary = new char[11][11];
        for(int i=0; i<n; i++)
        {
            String str = br.readLine();

            for(int j=0; j<n; j++)
                ary[i][j] = str.charAt(j);
        }

        char[][] ans = new char[11][11];
        for(int i=0; i<n; i++)
        {
            String str = br.readLine();

            for(int j=0; j<n; j++)
                ans[i][j] = str.charAt(j);
        }

        boolean isMine = false;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(ans[i][j] == '.')
                    continue;

                if(ary[i][j] == '*')
                {
                    isMine = true;
                    continue;
                }

                char cnt = '0';
                for(int k=0; k<8; k++)
                {
                    int newR = i + dr[k];
                    if(newR < 0 || newR >= n)
                        continue;

                    int newC = j + dc[k];
                    if(newC < 0 || newC >= n)
                        continue;

                    if(ary[newR][newC] == '*')
                        cnt++;
                }

                ans[i][j] = cnt;
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isMine && ary[i][j] == '*')
                    ans[i][j] = '*';

                sb.append(ans[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
