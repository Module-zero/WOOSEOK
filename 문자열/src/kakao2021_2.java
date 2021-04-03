import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-13
 * Time: 오후 4:32
 */

public class kakao2021_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] orders = new String[21];
        int i=0;
        while(true)
        {
            String str = br.readLine();

            if(str == null)
                break;

            orders[i++] = str;
        }

        int[] courses = new int[11];
        courses[0] = 2;
        courses[0] = 3;
        courses[0] = 4;

        TreeMap<Integer, String> map = new TreeMap<>();

    }
}
