import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-30
 * Time: 오후 6:23
 */

public class Q17393
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[500001];
        long[] B = new long[500001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            B[i] = Long.parseLong(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            int start = i;
            int end = N;

            while(start < end)
            {
                int mid = (start + end) / 2;

                if(B[mid] <= A[i])
                    start = mid + 1;
                else
                    end = mid;
            }

            sb.append(end - i - 1).append(' ');
        }

        System.out.println(sb.toString());
    }
}
