import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 7:59
 */

public class test
{
    static class Temp implements Comparable<Temp>
    {
        int M;
        int P;

        public Temp(int M, int P)
        {
            this.M = M;
            this.P = P;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(this.P == o.P)
                return 0;
            else if(this.P > o.P)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Temp[] temps = new Temp[10001];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            temps[i] = new Temp(M, P);
        }

        Arrays.sort(temps, 0, N, Collections.reverseOrder());

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            if(W - temps[i].M >= 0)
            {
                ans += temps[i].P * temps[i].M;
                W -= temps[i].M;
            }
            else
            {
                ans += temps[i].P * W;
                break;
            }
        }

        System.out.println(ans);
    }
}
