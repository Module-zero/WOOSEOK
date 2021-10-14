import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-14
 * Time: 오후 5:01
 */

public class Q16401
{
    static int[] L = new int[1000001];
    static int[] tmp  = new int[1000001];

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
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(L[i] < L[j])
                tmp[k++] = L[i++];
            else
                tmp[k++] = L[j++];
        }

        while(i <= mid)
            tmp[k++] = L[i++];
        while(j <= end)
            tmp[k++] = L[j++];

        for(int a=start; a<=end; a++)
            L[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            L[i] = Integer.parseInt(st.nextToken());

        sort(0, N-1);

        int start = 1;
        int end = L[N-1];
        int ans = 0;
        while(start <= end)
        {
            int mid = (start + end) / 2;

            long cnt = 0;

            for(int i=0; i<N; i++)
                cnt += L[i] / mid;

            if(cnt >= M)
            {
                start = mid + 1;
                ans = mid;
            }
            else
                end = mid - 1;
        }

        System.out.println(ans);
    }
}
