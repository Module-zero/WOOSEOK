import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-18
 * Time: 오후 4:21
 */

public class Q20166
{
    static int N;
    static int M;
    static int K;
    static char[][] ary = new char[11][11];
    static char[] str;
    static int len;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int ans = 0;

    public static void foo(int X, int Y, int index)
    {
        if(index == len)
        {
            ans++;
            return;
        }

        for(int i=0; i<8; i++)
        {
            int newX = X + dr[i];
            if(newX < 0)
                newX = N-1;
            else if(newX >= N)
                newX = 0;

            int newY = Y + dc[i];
            if(newY < 0)
                newY = M-1;
            else if(newY >= M)
                newY = 0;

            if(ary[newX][newY] != str[index])
                continue;

            foo(newX, newY, index+1);
        }
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
            String str = br.readLine();
            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        StringBuffer sb = new StringBuffer();
        while(K-- > 0)
        {
            str = br.readLine().toCharArray();
            len = str.length;
            ans = 0;

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(ary[i][j] != str[0])
                        continue;

                    foo(i, j, 1);
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
