import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-01
 * Time: 오후 12:20
 */

public class Q6159
{
    static int[] ary = new int[20001];
    static int[] tmp = new int[20001];

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
            if(ary[i] <= ary[j])
                tmp[k++] = ary[i++];
            else
                tmp[k++] = ary[j++];
        }

        while(i <= mid)
            tmp[k++] = ary[i++];
        while(j <= end)
            tmp[k++] = ary[j++];

        for(int a=start; a<=end; a++)
            ary[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);
        int cnt = 0;
        for(int i=0; i<N-1; i++)
        {
            if(ary[i] > S/2)
                break;

            for(int j=i+1; j<N; j++)
            {
                if(ary[i] + ary[j] <= S)
                    cnt++;
                else
                    break;
            }
        }

        System.out.println(cnt);
    }
}
