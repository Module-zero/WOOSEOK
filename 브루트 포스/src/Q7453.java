import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-07-15
 * Time: 오후 2:28
 */

public class Q7453
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[4000][4];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
            nums[i][3] = Integer.parseInt(st.nextToken());
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int ab = nums[i][0] + nums[j][1];

                Integer abi = map.get(ab);
                if(abi != null)
                    map.put(ab, abi+1);
                else
                    map.put(ab, 1);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int cd = nums[i][2] + nums[j][3];

                Integer abi = map.get(-cd);
                if(abi != null)
                    ans += abi;
            }
        }

        System.out.println(ans);
    }
}
