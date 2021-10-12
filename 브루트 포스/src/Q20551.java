import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-11
 * Time: 오후 11:45
 */

public class Q20551
{
    static int[] A = new int[200001];
    static int[] tmp = new int[200001];
    static int N;

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
            if(A[i] < A[j])
                tmp[k++] = A[i++];
            else
                tmp[k++] = A[j++];
        }

        while(i <= mid)
            tmp[k++] = A[i++];
        while(j <= end)
            tmp[k++] = A[j++];

        for(int a=start; a<=end; a++)
            A[a] = tmp[a-start];
    }

    public static int lowerbound(int n)
    {
        int start = 0;
        int end = N-1;

        while(start < end)
        {
            int mid = (start + end) / 2;

            if(tmp[mid] < n)
                start = mid+1;
            else
                end = mid;
        }

        return end;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++)
        {
            int D = Integer.parseInt(br.readLine());

            int n = lowerbound(D);
            if(tmp[n] == D)
                sb.append(n).append('\n');
            else
                sb.append(-1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
