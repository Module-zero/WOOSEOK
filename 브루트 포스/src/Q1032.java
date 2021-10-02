import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 3:52
 */

public class Q1032
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ans = br.readLine().toCharArray();
        int len = ans.length;
        for(int i=1; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<len; j++)
            {
                if(str.charAt(j) != ans[j])
                    ans[j] = '?';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++)
            sb.append(ans[i]);

        System.out.println(sb.toString());
    }
}
