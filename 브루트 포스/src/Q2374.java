import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-12
 * Time: 오전 12:50
 */

public class Q2374
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(!st.isEmpty())
            {
                int tmp = st.peek();
                if(num >= tmp)
                {
                    st.pop();
                    ans += num - tmp;

                    while(!st.isEmpty())
                    {
                        tmp = st.peek();
                        if(num >= tmp)
                            st.pop();
                        else
                            break;
                    }
                }
            }

            st.add(num);
        }

        if(!st.isEmpty())
        {
            int a = st.pop();
            int b = a;

            while(!st.isEmpty())
                b = st.pop();

            ans += (b - a);
        }

        System.out.println(ans);
    }
}
