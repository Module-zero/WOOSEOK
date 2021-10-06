import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 10:47
 */

public class Q15886
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;

        char ch1 = str.charAt(0);
        char ch2 = 0;
        for(int i=1; i<N; i++)
        {
            ch2 = str.charAt(i);
            if(ch1 == 'E' && ch2 == 'W')
                ans++;

            ch1 = ch2;
        }

        System.out.println(ans);
    }
}
