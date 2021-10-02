import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 10:40
 */

public class Q1453
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] ary = new boolean[101];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-- > 0)
        {
            int num = Integer.parseInt(st.nextToken());
            if(ary[num])
                ans++;
            else
                ary[num] = true;
        }

        System.out.println(ans);
    }
}
