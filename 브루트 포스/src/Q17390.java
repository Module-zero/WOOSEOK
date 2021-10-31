import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-31
 * Time: 오후 3:37
 */

public class Q17390
{
    static int[] A = new int[300001];
    static int[] B = new int[300001];

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
            if(A[i] < A[j])
                B[k++] = A[i++];
            else
                B[k++] = A[j++];
        }

        while(i <= mid)
            B[k++] = A[i++];
        while(j <= end)
            B[k++] = A[j++];

        for(int a=start; a<=end; a++)
            A[a] = B[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        sort(1, N);

        StringBuffer sb = new StringBuffer();
        B[0] = 0;
        for(int i=1; i<=N; i++)
            B[i] = B[i-1] + A[i];

        for(int i=0; i<Q; i++)
        {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            sb.append(B[R] - B[L-1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
