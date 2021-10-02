import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오후 8:46
 */

public class Q17266
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] x = new int[100000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            x[i] = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = N;
        while(l <= r)
        {
            int mid = (l + r) / 2;

            int left = 0;
            boolean isFail = false;
            for(int i=0; i<=M; i++)
            {
                int d = 0;
                if(i == 0)
                    d = x[i] - left;
                else if(i == M)
                    d = N - left;
                else
                    d = (x[i] - left + 1) / 2;

                if(d > mid)
                {
                    isFail = true;
                    break;
                }

                if(i != M)
                    left = x[i];
            }

            if(isFail)
                l = mid + 1;
            else
                r = mid - 1;
        }

        System.out.println(l);
    }
}
