import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-28
 * Time: 오후 6:21
 */

public class Q19939
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = 0;
        for(int i=1; i<=K; i++)
            min += i;

        // 나눠 담기 x
        if(N < min)
        {
            System.out.println("-1");
            return;
        }

        N -= min;
        if(N % K == 0)
            System.out.println(K-1);
        else
            System.out.println(K);
    }
}
