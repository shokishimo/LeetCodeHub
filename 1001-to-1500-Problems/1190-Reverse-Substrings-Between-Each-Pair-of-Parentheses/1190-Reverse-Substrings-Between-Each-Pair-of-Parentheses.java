class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') {
                StringAndInt res = reverseInside(s, i+1);
                sb.append(res.s);
                i = res.i;
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public StringAndInt reverseInside(String s, int i) {
        StringBuilder sb = new StringBuilder();

        for (; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') {
                StringAndInt res = reverseInside(s, i+1);
                sb.append(res.s);
                i = res.i;
            } else if (s.charAt(i) == ')') {
                break;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return new StringAndInt(sb.reverse().toString(), i);
    }
}

class StringAndInt
{
    String s;
    int i;

    public StringAndInt(String S, int I)
    {
        s = S;
        i = I;
    }
}