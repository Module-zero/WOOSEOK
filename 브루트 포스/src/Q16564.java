import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-23
 * Time: 오후 1:09
 */

public class Q16564
{
    static int[] X = new int[1000001];
    static int[] tmp = new int[1000001];
    static int N;
    static int K;

    public static void sort(int start, int end)
    {
        if(start >= end)
            return;

        int mid = (start + end) / 2;
        sort(start, mid);
        sort(mid+1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(X[i] <= X[j])
                tmp[k++] = X[i++];
            else
                tmp[k++] = X[j++];
        }

        while(i <= mid)
            tmp[k++] = X[i++];
        while(j <= end)
            tmp[k++] = X[j++];

        for(int a=start; a<=end; a++)
            X[a] = tmp[a-start];
    }

    public static boolean foo(int T)
    {
        int cnt = 0;
        for(int i=0; i<N; i++)
        {
            if(X[i] >= T || cnt > K)
                break;

            cnt += T - X[i];
        }

        return cnt <= K;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++)
            X[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);

        int start = -1;
        int end = X[N-1] + K;

        while(start+1 < end)
        {
            int mid = (start + end) / 2;

            if(foo(mid))
                start = mid;
            else
                end = mid;
        }

        System.out.println(end-1);
    }
}
