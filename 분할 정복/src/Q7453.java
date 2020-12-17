/*
합이 0인 네 정수

https://www.acmicpc.net/problem/7453
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 4:09
 */

public class Q7453
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[4001];
        int[] B = new int[4001];
        int[] C = new int[4001];
        int[] D = new int[4001];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, 0, n);
        Arrays.sort(B, 0, n);
        Arrays.sort(C, 0, n);
        Arrays.sort(D, 0, n);

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int sum = A[i] + B[j];

                int start = 0;
                int end = n;

                while(start < end)
                {
                    int mid = (start + end) / 2;

                    if(C[mid] >= sum)
                        end = mid;
                    else
                        start = mid + 1;
                }
            }
        }
    }
}
