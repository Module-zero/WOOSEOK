import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 3:57
 */

public class Q1357
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();

        int X = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
        int Y = Integer.parseInt(sb2.append(st.nextToken()).reverse().toString());

        int ans = Integer.parseInt(sb3.append(X + Y).reverse().toString());
        System.out.println(ans);
    }
}
