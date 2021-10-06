import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오후 6:51
 */

public class Q17471
{
    static int N;
    static int[] person = new int[11];
    static ArrayList<Integer>[] list = new ArrayList[11];
    static boolean[] check = new boolean[11];

    public static void foo(int id)
    {
        if(id > N)
        {
            return;
        }

        foo(id+1);
        check[id] = true;
        foo(id+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            person[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int lim = Integer.parseInt(st.nextToken());
            for(int j=0; j<lim; j++)
                list[i].add(Integer.parseInt(st.nextToken()));
        }


    }
}
