import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-13
 * Time: 오전 1:45
 */

public class Q20152
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        if(H < N)
        {
            int tmp = H;
            H = N;
            N = tmp;
        }

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        long[][] cnt = new long[31][31];
        cnt[N][N] = 1;
        for(int i=N; i<=H; i++)
        {
            for(int j=N; j<=i; j++)
            {
                if(i-1 >= 0)
                    cnt[i][j] += cnt[i-1][j];
                if(j-1 >= 0)
                    cnt[i][j] += cnt[i][j-1];
            }
        }

        System.out.println(cnt[H][H]);
    }
}
