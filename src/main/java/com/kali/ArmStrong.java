package com.kali;

/**
 * Created by mpalavelli on 12-04-2018.
 */
public class ArmStrong
{
    public static void main(String[] args)

        {
            int a = 153;
            int q = a;
            int f = 0;
            while (q > 10) {
                int r = q % 10;
                r = r * r * r;
                f = f + r;
                q = q / 10;
            }

            f = f + (q * q * q);
            if (f == a)
                System.out.println("Armstrong");
            else
                System.out.println("Not Armstrong");
        }

}

