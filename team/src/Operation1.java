import java.util.Random;

public class Operation1 {
	static int sum = 0;
	public static String Operation(int n, int m1, int m2, int c, int o) {
		String brr = "";
		Random rand = new Random();
		int coun = 0;
		while (true) {
			int flag3 = 0;
			char charArr;
			char[] arr = { '+', '-', '*', '÷' };

			int charCoun = o;// 1-10个运算符
			int temp;
			if (c == 1) {
				temp = rand.nextInt(4);
			} else {
				temp = rand.nextInt(2);
			}
			charArr = arr[temp];
			int fanweiLift = m1;
			int fanweiRight = m2;
			int a0 = rand.nextInt(fanweiRight);// 数字范围
			int a1 = rand.nextInt(fanweiRight);
			if (charArr == '÷') {
				if (a1 == 0)
					a1++;
				while (a0 % a1 != 0) {
					// System.out.println(2);
					a0 = rand.nextInt(fanweiRight);
					a1 = rand.nextInt(fanweiRight) + 1;// 为了保证不出现0
				}
			}
			if (charArr == '-') {
				/*while (a0 < a1) {
					// System.out.println(3);
					a0 = rand.nextInt(fanweiRight);
					a1 = rand.nextInt(fanweiRight);
				}*/
			}
			if (charArr == '+') {
				while (a0 + a1 > fanweiRight) {
					// System.out.println(4);
					a0 = rand.nextInt(fanweiRight);
					a1 = rand.nextInt(fanweiRight);
				}
			}
			if (charArr == '*') {
				while (a0 * a1 > fanweiRight) {
					// System.out.println(5);
					a0 = rand.nextInt(fanweiRight);
					a1 = rand.nextInt(fanweiRight);
				}
			}
			brr = a0 + "" + charArr + "" + a1;
			//System.out.println(brr);
			int flag4 = 0;
			int go = 0;
			for (int i = 1; i < charCoun; i++) {
				// System.out.println(6);
				int Atemp = a1; // 保存a1的值，当后面a1改变时，且不符合条件时，把a1恢复原状。
				int temp1;
				if (c == 1) {
					temp1 = rand.nextInt(4);
				} else {
					temp1 = rand.nextInt(2);
				}
				char charArr2 = arr[temp1];
				int b0 = rand.nextInt(fanweiRight);
				if (Prior.prior(charArr) < Prior.prior(charArr2))// 优先级判断
				{
					if (charArr2 == '÷') {
						if (b0 == 0)
							b0++;
						while (a1 % b0 != 0) {
							// System.out.println(7);
							b0 = rand.nextInt(fanweiRight) + 1;
						}
						a1 = a1 / b0;
					}
					if (charArr2 == '*') {
						while (a1 * b0 > fanweiRight) {
							// System.out.println(8);
							b0 = rand.nextInt(fanweiRight);
						}
						a1 = a1 * b0;
					}
					if (Symbol.symbol(a0, charArr, a1) < 0) {
						i--;
						a1 = Atemp;
						continue;
					}
				} else {
					a0 = Symbol.symbol(a0, charArr, a1);
					if (a0 < 0 || a0 > fanweiRight) {
						go = 1;
						break;
					}
					if (charArr2 == '-') {
						/*while (a0 < b0) {
							// System.out.println(9);
							// System.out.println(a0+a1+""+charArr+""+charArr2+""+a1);
							b0 = rand.nextInt(fanweiRight);
						}*/
					}
					if (charArr2 == '÷') {
						if (b0 == 0)
							b0++;
						while (a0 % b0 != 0) {
							// System.out.println(10);
							b0 = rand.nextInt(fanweiRight) + 1;
						}
					}
					if (charArr2 == '*') {
						while (a0 * b0 > fanweiRight) {
							// System.out.println(11);
							b0 = rand.nextInt(fanweiRight);
						}
					}
					if (charArr2 == '+') {
						while (a0 + b0 > fanweiRight) {
							// System.out.println(12);
							b0 = rand.nextInt(fanweiRight);
						}
					}
					a1 = b0;
					if (charArr != charArr2)// 如果和前一个符号不相同，则标记为1.此式子合法，生成式子
						flag3 = 1;
					charArr = charArr2;
				}
				brr = brr + "" + charArr2 + "" + b0;
			}
			if (go == 1)
				continue;
			sum = Symbol.symbol(a0, charArr, a1);
			if (sum >= fanweiLift && sum <= fanweiRight||sum>=-fanweiRight&&sum<=-fanweiLift) {
				flag4 = 1;
			}
			if ((flag3 == 1 || o == 1) && flag4 == 1) {
				System.out.println(brr + "=" + sum);
				break;
			}
		}
		return brr;
	}
}

