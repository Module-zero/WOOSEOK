import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 2:00
 */

public class scf1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxt = Integer.MIN_VALUE;
        int mint = Integer.MAX_VALUE;
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ~ ");

            StringTokenizer start = new StringTokenizer(st.nextToken(), ":");
            StringTokenizer end = new StringTokenizer(st.nextToken(), ":");

            String sh = start.nextToken();
            String sm = start.nextToken();
            String eh = end.nextToken();
            String em = end.nextToken();
            int startTime = Integer.parseInt(sh) * 60 + Integer.parseInt(sm);
            int endTime = Integer.parseInt(eh) * 60 + Integer.parseInt(em);

            maxt = Integer.max(maxt, startTime);
            mint = Integer.min(mint, endTime);
        }

        if(maxt > mint)
            System.out.println(-1);
        else
            System.out.printf("%02d:%02d ~ %02d:%02d\n", maxt/60, maxt%60, mint/60, mint%60);
    }
}
