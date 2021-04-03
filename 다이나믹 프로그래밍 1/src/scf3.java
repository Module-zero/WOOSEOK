import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 2:21
 */

public class scf3
{
    static int N;
    static int[][] ary;

    public static int foo(int i, int j, int size)
    {
        if(i + size - 1 > N || j + size - 1 > N)
            return 0;

        for(int c=j; c<j+size; c++)
        {
            for(int r=i; r<i+size; r++)
            {
                if(ary[r][c] == 0)
                    return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ary = new int[52][52];
        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=N; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        long ans = 0;

        int[] cnt = new int[51];
        for(int size=1; size<=N; size++)
        {
            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=N; j++)
                    cnt[size] += foo(i, j, size);
            }

            ans += cnt[size];
        }

        StringBuffer sb = new StringBuffer();
        sb.append("total: ").append(ans).append('\n');
        for(int i=1; i<=N; i++)
        {
            if(cnt[i] == 0)
                continue;

            sb.append("size[").append(i).append("]: ").append(cnt[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
