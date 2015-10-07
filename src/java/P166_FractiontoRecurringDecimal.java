package java;
import java.util.*; 

public class P166_FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator)
    {
        if (0 == denominator)
        {
            return "";
        }
        else if (1 == denominator)
        {
            return String.valueOf(numerator);
        }
        else if (-1 == denominator)
        {
            return String.valueOf(-(long)numerator);
        }
        else if (0 == numerator)
        {
            return "0";
        }
        else
        {
            final StringBuilder sb = new StringBuilder();
            if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))
            {
                sb.append("-");
            }

            final long num = Math.abs((long)numerator);
            final long den = Math.abs((long)denominator);


            sb.append(num / den);

            if (num % den != 0)
            {
                sb.append(".");
                final Map<Long, Integer> map = new HashMap<>();
                long remain;
                for (remain = num % den; remain != 0; )
                {
                    if (map.containsKey(remain))
                    {
                        sb.insert(map.get(remain), "(");
                        sb.append(")");
                        break;
                    }
                    else
                    {
                        map.put(remain, sb.length());
                    }

                    remain *= 10;
                    sb.append(remain / den);
                    remain %= den;
                }
            }

            return sb.toString();
        }
    }

}
