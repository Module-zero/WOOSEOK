import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 11:03
 */

public class Q20944
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<len; i++)
            sb.append('a');

        System.out.println(sb.toString());
    }
}
