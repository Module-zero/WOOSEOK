import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-07
 * Time: 오후 5:19
 */

public class Q1082
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[51];
        for(int i=0; i<N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());


    }
}
