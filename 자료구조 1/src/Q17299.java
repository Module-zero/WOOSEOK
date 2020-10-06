/*
오등큰수

문제
크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.

Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오등큰수는 -1이다.

예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다. A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다. A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

출력
총 N개의 수 NGF(1), NGF(2), ..., NGF(N)을 공백으로 구분해 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-06
 * Time: 오후 2:58
 */

public class Q17299
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] F = new int[1000001];
        int[] ary = new int[N];
        int[] NGF = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            ary[i] = num;
            ++F[num];
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++)
        {
            while(!stack.isEmpty())
            {
                int index = stack.pop();
                int value = ary[index];
                int target = ary[i];

                if(F[value] < F[target])
                    NGF[index] = target;
                else
                {
                    stack.push(index);
                    break;
                }
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int index = stack.pop();

            NGF[index] = -1;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(NGF[0]);
        for(int i=1; i<N; i++)
        {
            sb.append(" " + NGF[i]);
        }

        System.out.println(sb.toString());
    }
}
