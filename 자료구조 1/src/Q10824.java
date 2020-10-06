/*
네 수

문제
네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.

두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.

입력
첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)

출력
A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-06
 * Time: 오후 5:18
 */

public class Q10824
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String AnB = st.nextToken() + st.nextToken();
            String CnD = st.nextToken() + st.nextToken();

            System.out.println(Long.parseLong(AnB) + Long.parseLong(CnD));
        }
        catch(Exception e) {}
    }
}