/*
단어 수학

https://www.acmicpc.net/problem/1339
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-27
 * Time: 오후 2:46
 */

public class Q1339
{
/*
    static int N;
    static String[] strs;
    // 해당 알파벳에 어떤 수가 매핑되었는지
    static int[] mapping = new int[26];
    // 어떤 수가 쓰인 상태인지
    static boolean[] integer = new boolean[10];
    static int max = Integer.MIN_VALUE;

    public static void foo(int i, int j, int sum, int colSum)
    {
        // 마지막 행이 끝나면 결산
        if(i == strs.length)
        {
            if(max < sum)
                max = sum;

            return;
        }

        // 열 인덱스를 초과하면 다음 행으로
        if(j == strs[i].length())
        {
            foo(i + 1, 0, sum + colSum, 0);
            return;
        }


        String str = strs[i];
        int index = str.charAt(j) - 'A';

        // 해당 알파벳(index)에 이미 매핑된 수가 있으면 매핑
        if(mapping[index] != -1)
            foo(i, j+1, sum, 10 * colSum + mapping[index]);
        // 매핑된 수가 없으면 매핑 하나씩 매핑
        else
        {
            for (int k = 9; k >= 0; k--)
            {
                // k가 아직 쓰이지 않은 수이면 매핑한다.
                if (!integer[k])
                {
                    mapping[index] = k;
                    integer[k] = true;

                    foo(i, j + 1, sum, 10 * colSum + k);

                    mapping[index] = -1;
                    integer[k] = false;
                }
            }
        }
    }
*/

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strs = new String[N];
        for(int i=0; i<N; i++)
            strs[i] = br.readLine();

        // 자리수 매핑
        int[] alphabet = new int[26];
        for(int i=0; i<N; i++)
        {
            String str = strs[i];
            int pow = (int)Math.pow(10, str.length()-1);

            for(int j=0; j<str.length(); j++)
            {
                char ch = str.charAt(j);
                alphabet[ch - 'A'] += pow;
                pow /= 10;
            }
        }

        // 오름차순으로 정렬한 후 맨 뒤 인덱스부터 9 매핑
        Arrays.sort(alphabet);

        int sum = 0;
        int value = 9;
        for(int i=alphabet.length-1; i>=0; i--)
        {
            if(value < 0 || alphabet[i] == 0)
                break;

            sum += alphabet[i] * value;
            value--;
        }

        System.out.println(sum);
    }
}
