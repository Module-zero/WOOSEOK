import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 4:49
 */

public class Q1633
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        int[] wscore = new int[1001];
        int[] bscore = new int[1001];
        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            StringTokenizer st = new StringTokenizer(str);
            wscore[i] = Integer.parseInt(st.nextToken());
            bscore[i] = Integer.parseInt(st.nextToken());

            i++;
        }


    }
}
