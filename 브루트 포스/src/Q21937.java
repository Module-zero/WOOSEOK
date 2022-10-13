import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q21937
{
    static int N;
    static int M;
    static ArrayList<Integer>[] list = new ArrayList[100001];
    static boolean[] check = new boolean[100001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=100000; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }

        int X = Integer.parseInt(br.readLine());
        int ans = 0;
        ans += dfs(X);

        System.out.println(ans-1);
    }

    public static int dfs(int n) {
        check[n] = true;

        int ans = 1;
        for(int i=0; i<list[n].size(); i++) {
            int next = list[n].get(i);
            if(!check[next])
                ans += dfs(next);
        }

        return ans;
    }
}
