import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-27
 * Time: 오후 3:08
 */

public class Q16924_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] ary = new char[101][101];
        boolean[][] check = new boolean[101][101];

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1);
        }

        StringBuffer sb = new StringBuffer();
        int ans = 0;
        for(int x=1; x<=N; x++)
        {
            for(int y=1; y<=M; y++)
            {
                if(ary[x][y] == '*')
                {
                    int s = 0;

                    while(true)
                    {
                        int upX = x - s - 1;
                        if(upX <= 0 || ary[upX][y] != '*')
                            break;
                        int downX = x + s + 1;
                        if(downX > N || ary[downX][y] != '*')
                            break;
                        int leftY = y - s - 1;
                        if(leftY <= 0 || ary[x][leftY] != '*')
                            break;
                        int rightY = y + s + 1;
                        if(rightY > M || ary[x][rightY] != '*')
                            break;

                        s++;
                        ans++;
                        check[upX][y] = check[downX][y] = check[x][leftY] = check[x][rightY] = check[x][y] = true;
                        sb.append(x).append(' ').append(y).append(' ').append(s).append('\n');
                    }
                }
            }
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(ary[i][j] == '*' && !check[i][j])
                {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
        System.out.print(sb.toString());
    }
}
