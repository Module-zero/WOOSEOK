import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오전 3:37
 */

public class Q20117
{
    static int[] a = new int[100001];
    static int[] tmp = new int[100001];

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
            if(a[i] > a[j])
                tmp[k++] = a[i++];
            else
                tmp[k++] = a[j++];
        }

        while(i <= mid)
            tmp[k++] = a[i++];
        while(j <= end)
            tmp[k++] = a[j++];

        for(int l=start; l<=end; l++)
            a[l] = tmp[l-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        sort(0, N-1);

        int ans = 0;
        for(int i=0; i<N/2; i++)
            ans += 2*a[i];

        if(N % 2 == 1)
            ans += a[N/2];

        System.out.println(ans);
    }
}
