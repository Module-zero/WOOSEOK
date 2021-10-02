import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 5:03
 */

public class Q2851
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        for(int i=0; i<10; i++)
        {
            int mush = Integer.parseInt(br.readLine());

            int eat = Math.abs(100 - ans - mush);
            int noeat = Math.abs(100 - ans);

            if(noeat < eat)
                break;
            else if(noeat == eat)
            {
                ans += mush;
                break;
            }
            else
                ans += mush;
        }

        System.out.println(ans);
    }
}
