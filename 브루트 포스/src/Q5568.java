import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 7:25
 */

public class Q5568
{
    static int n;
    static int k;
    static int[] ary = new int[10];
    static boolean[] check = new boolean[10];
    static TreeSet<Integer> set = new TreeSet<>();

    public static void foo(int id, StringBuffer sb)
    {
        if(id == k)
        {
            int num = Integer.parseInt(sb.toString());
            set.add(num);
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(check[i])
                continue;

            check[i] = true;
            foo(id+1, new StringBuffer(sb).append(ary[i]));
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        set = new TreeSet<>();
        ary = new int[10];
        check = new boolean[10];
        for(int i=0; i<n; i++)
            ary[i] = Integer.parseInt(br.readLine());

        foo(0, new StringBuffer());
        System.out.println(set.size());
    }
}
