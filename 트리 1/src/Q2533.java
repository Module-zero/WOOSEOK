import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-22
 * Time: 오후 3:58
 */

public class Q2533
{
    static int[] p;

    public static int find(int n)
    {
        if(p[n] < 0) return n;
        return p[n] = find(p[n]);
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b) return;
        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
