/*
30

https://www.acmicpc.net/problem/10610
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 10:40
 */

public class Q10610
{
    static char[] ch = new char[1000001];
    static char[] tmp = new char[1000001];

    public static void sort(int left, int right)
    {
        if(left == right)
            return;

        int mid = (left + right) / 2;

        sort(left, mid);
        sort(mid+1, right);
        merge(left, right);
    }

    public static void merge(int left, int right)
    {
        int mid = (left + right) / 2;

        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right)
        {
            if(ch[i] < ch[j])
                tmp[k++] = ch[i++];
            else
                tmp[k++] = ch[j++];
        }

        while(i <= mid)
            tmp[k++] = ch[i++];
        while(j <= right)
            tmp[k++] = ch[j++];

        for(int a=left; a<=right; a++)
            ch[a] = tmp[a-left];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int sum = 0;
        int num0 = 0;
        int lenN = N.length();
        for(int i=0; i<lenN; i++)
        {
            ch[i] = N.charAt(i);

            sum += ch[i] - '0';

            if(ch[i] == '0')
                num0++;
        }

        if(sum % 3 != 0 || num0 == 0)
        {
            System.out.println(-1);
            return;
        }

        sort(0, lenN - 1);

        StringBuilder sb = new StringBuilder();

        for(int i=lenN-1; i>=0; i--)
            sb.append(ch[i]);

        System.out.println(sb.toString());
    }
}
