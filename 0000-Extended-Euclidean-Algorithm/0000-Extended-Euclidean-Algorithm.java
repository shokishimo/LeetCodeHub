import java.math.BigInteger;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        BigInteger a, b;
        BigInteger[] result;
        BigInteger n;
        BigInteger res;

        System.out.println("------- Exercise 3 ------");
        a = new BigInteger("527");
        b = new BigInteger("1258");
        result = exercise3(a, b);
        System.out.println("gcd("+a+", "+b+") = ("
                +result[0]+") *"+a+" + ("+result[1]+") *"+b + " = " + result[2]);

        a = new BigInteger("163961");
        b = new BigInteger("167181");
        result = exercise3(a, b);
        System.out.println("gcd("+a+", "+b+") = ("
                +result[0]+") *"+a+" + ("+result[1]+") *"+b + " = " + result[2]);

        a = new BigInteger("3892394");
        b = new BigInteger("239847");
        result = exercise3(a, b);
        System.out.println("gcd("+a+", "+b+") = ("
                +result[0]+") *"+a+" + ("+result[1]+") *"+b + " = " + result[2]);

        a = new BigInteger("16534528044");
        b = new BigInteger("8332745927");
        result = exercise3(a, b);
        System.out.println("gcd("+a+", "+b+") = ("
                +result[0]+") *"+a+" + ("+result[1]+") *"+b + " = " + result[2]);

        System.out.println("\n------- Exercise 4 ------");

        a = new BigInteger("4");
        n = new BigInteger("7");
        res = exercise4(a, n);
        if (res.equals(BigInteger.ZERO))
            System.out.println("No such inverse exists for a = " + a + ", n = " + n);
        else
            System.out.println("The inverse of " + a + " modulo " + n + " is " + res);

        a = new BigInteger("9");
        n = new BigInteger("22");
        res = exercise4(a, n);
        if (res.equals(BigInteger.ZERO))
            System.out.println("No such inverse exists for a = " + a + ", n = " + n);
        else
            System.out.println("The inverse of " + a + " modulo " + n + " is " + res);

        a = new BigInteger("4");
        n = new BigInteger("16");
        res = exercise4(a, n);
        if (res.equals(BigInteger.ZERO))
            System.out.println("No such inverse exists for a = " + a + ", n = " + n);
        else
            System.out.println("The inverse of " + a + " modulo " + n + " is " + res);
    }

    private static BigInteger[] exercise3(BigInteger a, BigInteger b)
    {
        // if b == 0, return error values
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[]{
                    new BigInteger("-1"), new BigInteger("-1")
            };
        }

        // use hashmap to keep track of u and v for a certain remainder R
        HashMap<BigInteger, BigInteger[]> map = new HashMap<>();
        // remember a and b
        map.put(a, new BigInteger[]{new BigInteger("1"), new BigInteger("0")});
        map.put(b, new BigInteger[]{new BigInteger("0"), new BigInteger("1")});
        BigInteger Q = a.divide(b); // Quotient
        BigInteger R;               // Remainder
        BigInteger u;               // u of a
        BigInteger v;               // u of b
        BigInteger prevA = a;       // previous a
        BigInteger prevB = b;       // previous b
        BigInteger prevQ = Q;       // previous Q
        while (true) {
            Q = a.divide(b);
            R = a.remainder(b);
            BigInteger[] uvB = map.get(b);  // get u and v of b
            BigInteger[] uvA = map.get(a);  // get u and v of a
            u = uvA[0].subtract(uvB[0].multiply(Q)); // calculate the next u
            v = uvA[1].subtract(uvB[1].multiply(Q)); // calculate the next v

            map.put(R, new BigInteger[]{u, v});     // remember u and v for the R
            if (R.equals(BigInteger.ZERO)) break;   // end condition
            // remember the previous formula parameters
            prevA = a;
            prevB = b;
            prevQ = Q;
            // update a and b
            a = b;
            b = R;
        }
        // calculate the u and v (the answer), using the previous parameters and hashmap memory
        u = map.get(prevA)[0].subtract(map.get(prevB)[0].multiply(prevQ));
        v = map.get(prevA)[1].subtract(map.get(prevB)[1].multiply(prevQ));
        return new BigInteger[] {u, v, b};
    }

    private static BigInteger exercise4(BigInteger a, BigInteger n)
    {
        BigInteger[] res = exercise3(a, n);
        // return the inverse of a mod n, using the exercise 3, if exists
        if (res[2].equals(BigInteger.ONE)) return res[0];

        // if gcd(a, n) != 1, return 0 as a false
        return new BigInteger("0");
    }
}
