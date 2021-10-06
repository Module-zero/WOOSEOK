import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 4:15
 */

public class Q1652
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] ary = new char[100][100];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        int ansh = 0;
        int ansv = 0;
        for(int i=0; i<N; i++)
        {
            boolean isAns = false;
            // 이미 연산했으면 X가 나올 때까지 더 더하면 안된다
            boolean alreadyOp = false;

            for(int j=0; j<N; j++)
            {
                if(ary[i][j] == '.')
                {
                    if(isAns == true && alreadyOp == false)
                    {
                        ansh++;
                        alreadyOp = true;
                    }
                    else
                        isAns = true;
                }
                else
                {
                    isAns = false;
                    alreadyOp = false;
                }
            }

            isAns = false;
            alreadyOp = false;
            for(int j=0; j<N; j++)
            {
                if(ary[j][i] == '.')
                {
                    if(isAns == true && alreadyOp == false)
                    {
                        ansv++;
                        alreadyOp = true;
                    }
                    else
                        isAns = true;
                }
                else
                {
                    isAns = false;
                    alreadyOp = false;
                }
            }
        }

        System.out.println(ansh + " " + ansv);
    }
}
