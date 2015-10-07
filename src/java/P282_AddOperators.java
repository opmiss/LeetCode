package java;
import java.util.*;

public class P282_AddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return res;
		StringBuffer sb = new StringBuffer();
		find(res, sb, num, 0, target);
		return res;
	}

	public void find(List<String> sols, StringBuffer sol, String num, int pos,
			int target) {
		if (pos >= num.length()) {
			if (evaluate(sol.toString(), target))
				sols.add(sol.toString());
			return;
		}
		if (sol.length() > 0) {
			for (int k = 2; k >= 0; k--) {
				sol.append(opt(k));
				sol.append(num.charAt(pos));
				find(sols, sol, num, pos + 1, target);
				sol.deleteCharAt(sol.length() - 1);
				sol.deleteCharAt(sol.length() - 1);
			}
		}
		sol.append(num.charAt(pos));
		find(sols, sol, num, pos + 1, target);
		sol.deleteCharAt(sol.length() - 1);
	}

	char opt(int code) {
		if (code == 0)
			return '+';
		if (code == 1)
			return '-';
		if (code == 2)
			return '*';
		return '/';
	}

	int code(char opt) {
		if (opt == '+')
			return 0;
		if (opt == '-')
			return 1;
		if (opt == '*')
			return 2;
		return -1;
	}

	int eval(int left, int opt, int right) {
		if (opt == 0)
			return left + right;
		if (opt == 1)
			return left - right;
		if (opt == 2)
			return left * right;
		return right;
	}

	public boolean evaluate(String exp, int target) {
		StringBuffer sb = new StringBuffer();
		int left = -1, opt = -1, _left = -1, _opt = -1;
		for (int i = 0; i <= exp.length(); i++) {
			char ch = (i < exp.length()) ? exp.charAt(i) : '+';
			if (ch >= '0' && ch <= '9') {
				sb.append(ch);
				continue;
			}
			if (sb.charAt(0) == '0' && sb.length() > 1)
				return false;
			int num = 0;
			try {
				num = Integer.parseInt(sb.toString());
			} catch (Exception e) {
				return false;
			}
			if (ch == '+' || ch == '-') {
				left = eval(left, opt, num);
				if (_opt == 0 || _opt == 1) {
					left = eval(_left, _opt, left);
					_left = -1;
					_opt = -1;
				}
				opt = code(ch);
				sb = new StringBuffer();
			} else {
				if (opt == 0 || opt == 1) {
					_left = left;
					_opt = opt;
					left = -1;
					opt = -1;
				}
				left = eval(left, opt, num);
				opt = 2;
				sb = new StringBuffer();
			}
		}
		return (left == target);
	}

}
