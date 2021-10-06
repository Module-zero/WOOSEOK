import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오후 10:35
 */

public class Q20055
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[201];
        for (int j = 0; j < 2*N; j++)
            A[j] = Integer.parseInt(st.nextToken());

        // 올리는 위치
        int l = 0;

        boolean[] check = new boolean[201];
        int cnt = 0;
        int ans = 1;
        while(true)
        {
            if(--l < 0)
                l = 2*N-1;
            int d = (l + N - 1) % (2*N);

            for(int i=0; i<N; i++)
            {
                int r = d - i;
                if(r < 0)
                    r = 2*N + r;

                if(!check[r])
                    continue;

                if(i == 0 && check[r])
                {
                    check[r] = false;
                    continue;
                }

                int next = (r + 1) % (2*N);
                if(!check[next] && A[next] > 0)
                {
                    A[next]--;
                    if(A[next] == 0)
                        cnt++;

                    check[r] = false;

                    // 내리는 위치
                    if(next == d)
                        continue;

                    check[next] = true;
                }
            }

            if(A[l] > 0)
            {
                check[l] = true;
                A[l]--;
                if(A[l] == 0)
                    cnt++;
            }

            if(cnt >= K)
                break;

            ans++;
        }

        System.out.println(ans);
    }
}
