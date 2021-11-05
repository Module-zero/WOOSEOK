import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-05
 * Time: 오후 2:26
 */

public class Q11508
{
    static int[] C = new int[100001];
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
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(C[i] > C[j])
                tmp[k++] = C[i++];
            else
                tmp[k++] = C[j++];
        }

        while(i <= mid)
            tmp[k++] = C[i++];
        while(j <= end)
            tmp[k++] = C[j++];

        for(int a=start; a<=end; a++)
            C[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
            C[i] = Integer.parseInt(br.readLine());

        sort(0, N);
        int ans = 0;
        for(int i=0; i<N; i++)
        {
            if(i % 3 == 2)
                continue;

            ans += C[i];
        }

        System.out.println(ans);
    }
}
