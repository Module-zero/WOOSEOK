import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-01
 * Time: 오후 12:32
 */

public class Q1493
{
    static int[] cube = new int[21];

    public static long foo(long tl, long tw, long th, int tn, long before)
    {
        if(tn == -1)
            return -1;

        int id = 1 << tn;
        if(tl < id || tw < id || th < id)
            return foo(tl, tw, th, tn-1, before*8);

        long rem = (tl/id) * (tw/id) * (th/id) - before;
        // 가진 큐브가 필요한 큐브보다 적으면
        if(cube[tn] <= rem)
            rem = cube[tn];

        long total = before + rem;
        // 다 채웠으면 rem개 리턴
        if(tl * tw * th == total*id*id*id)
            return rem;
        else
        {
            long ret = foo(tl, tw, th, tn-1, 8*total);
            if(ret == -1)
                return -1;
            else
                return rem + ret;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            cube[i] = j;
        }

        long ans = foo(l, w, h, N-1, 0);
        System.out.println(ans);
    }
}
