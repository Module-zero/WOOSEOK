/*
가장 긴 증가하는 부분 수열 4

문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 그러한 수열이 여러가지인 경우 아무거나 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-13
 * Time: 오후 11:20
 */

public class Q14002
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N+1];
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        // 이전 인덱스를 저장할 배열
        int[] V = new int[N+1];
        int[] len = new int[N+1];
        int max = 1;
        int maxIndex = 1;

        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=N; i++)
        {
            len[i] = 1;
            for(int j=1; j<=i-1; j++)
            {
                if(A[j] < A[i] && len[i] < len[j] + 1)
                {
                    len[i] = len[j] + 1;
                    V[i] = j;

                    if(len[i] > max)
                    {
                        max = len[i];
                        maxIndex = i;
                    }
                }
            }
        }

        while(maxIndex > 0)
        {
            stack.push(A[maxIndex]);
            maxIndex = V[maxIndex];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max + "\n");
        while(!stack.isEmpty())
        {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}