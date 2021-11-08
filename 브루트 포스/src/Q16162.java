import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-08
 * Time: 오후 7:47
 */

public class Q16162
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[20001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            if(ary[i] != A)
                continue;

            A += D;
            ans++;
        }

        System.out.println(ans);
    }
}
