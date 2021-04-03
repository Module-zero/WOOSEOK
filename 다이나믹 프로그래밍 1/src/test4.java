import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:26
 */

public class test4
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] W = new int[100001];
        for(int i=1; i<=N; i++)
            W[i] = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int cnt = 0;
        for(int i=1; i<=N; i++)
        {
            boolean ok = true;
            for(int v : list.get(i))
            {
                if(W[i] <= W[v])
                {
                    ok = false;
                    break;
                }
            }

            if(ok)
                cnt++;
        }

        System.out.println(cnt);
    }
}
