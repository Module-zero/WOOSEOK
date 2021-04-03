import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:50
 */

public class test7
{
    public static int lowerBound(ArrayList<Integer> list, int target)
    {
        int begin = 0;
        int end = list.size();

        while(begin < end)
        {
            int mid = (begin + end) / 2;

            if(list.get(mid) >= target)
                end = mid;
            else
                begin = mid + 1;
        }

        return end;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[300001];
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> upper = new ArrayList<>();
        int[] up = new int[300001];

        upper.add(A[0]);
        up[0] = 1;
        int idx = 0;
        for(int i=1; i<N; i++)
        {
            if(upper.get(idx) < A[i])
            {
                idx++;
                upper.add(A[i]);
                up[i] = upper.size();
            }
            else
            {
                int id = lowerBound(upper, A[i]);
                upper.set(id, A[i]);
                up[i] = id + 1;
            }
        }

        ArrayList<Integer> lower = new ArrayList<>();
        int[] down = new int[300001];
        lower.add(A[N-1]);
        down[N-1] = 1;
        idx = 0;
        for(int i=N-2; i>=0; i--)
        {
            if(lower.get(idx) < A[i])
            {
                idx++;
                lower.add(A[i]);
                down[i] = lower.size();
            }
            else
            {
                int id = lowerBound(lower, A[i]);
                lower.set(id, A[i]);
                down[i] = id + 1;
            }
        }

        for(int i=0; i<N; i++)
            System.out.print(up[i] + " ");
        System.out.println();

        for(int i=0; i<N; i++)
            System.out.print(down[i] + " ");
    }
}
