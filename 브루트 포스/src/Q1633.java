import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 4:49
 */

public class Q1633
{
    static int[][][] ary = new int[1001][16][16];
    static int N;
    static int[] white;
    static int[] black;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        white = new int[1001];
        black = new int[1001];
        int i = 1;
        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            StringTokenizer st = new StringTokenizer(str);
            white[i] = Integer.parseInt(st.nextToken());
            black[i] = Integer.parseInt(st.nextToken());

            i++;
        }

        for(int j=1; j<i; j++)
        {
            for(int k=0; k<=15; k++)
            {
                for(int l=0; l<=15; l++)
                {
                    if(l > 0)
                        ary[j][k][l] = Integer.max(ary[j][k][l], ary[j-1][k][l-1] + white[j]);
                    if(k > 0)
                        ary[j][k][l] = Integer.max(ary[j][k][l], ary[j-1][k-1][l] + black[j]);

                    ary[j][k][l] = Integer.max(ary[j][k][l], ary[j-1][k][l]);
                }
            }
        }

        System.out.println(ary[i-1][15][15]);
    }
}
