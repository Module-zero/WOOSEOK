import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17179
{
    static int[] S = new int[1002];
    static int M;
    static int min;

    static int foo(int mid)
    {
        int l = 0;

        int cnt = 0;
        min = S[M+1];
        for(int i=1; i<=M+1; i++)
        {
            int d = S[i] - S[l];
            if(d < mid)
                continue;

            l = i;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        S[M+1] = L;
        for(int i=1; i<=M; i++)
            S[i] = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            int Q = Integer.parseInt(br.readLine());

            int l = 0;
            int r = L;
            int ans = 0;
            while(l <= r)
            {
                int mid = (l + r) / 2;

                int cnt = foo(mid);
                if(cnt > Q)
                {
                    l = mid + 1;

                    ans = Math.max(ans, mid);
                }
                else
                    r = mid - 1;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
