import java.util.Random;

public class Operation2 {
	static int sum = 0;
	public static String Operation(int n, int m1, int m2, int c, int o) {
		String brr = "";// ��¼ʽ��
		Random rand = new Random();
		int coun = 0;
		while (true) {
			int flag3 = 0;
			char charArr;
			char[] arr = { '+', '-' };
			int charCoun = o;// 1-10�������
			int temp;
			temp = rand.nextInt(2);
			charArr = arr[temp];
			int fanweiLift = m1;
			int fanweiRight = m2;
			int a0 = rand.nextInt(fanweiRight);// ���ַ�Χ
			int a1 = rand.nextInt(fanweiRight);
			if (charArr == '-') {
				sum = a0 - a1;
			}
			if (charArr == '+') {
				while (a0 + a1 > fanweiRight) {
					a0 = rand.nextInt(fanweiRight);
					a1 = rand.nextInt(fanweiRight);
				}
				sum = a0 + a1;
			}
			brr = a0 + "" + charArr + "" + a1;
			int flag4 = 0;
			for (int i = 1; i < charCoun; i++) {
				int temp1;
				temp1 = rand.nextInt(2);
				char charArr2 = arr[temp1];
				int b0 = rand.nextInt(fanweiRight);

				if (charArr2 == '-') {
					sum = sum - b0;
				}
				if (charArr2 == '+') {
					while (sum + b0 > fanweiRight) {
						b0 = rand.nextInt(fanweiRight);
					}
					sum = sum + b0;// ����
				}

				brr =b0+""+ charArr2 +"(" +brr + ")";
				if (charArr != charArr2)// �����ǰһ�����Ų���ͬ������Ϊ1.��ʽ�ӺϷ�������ʽ��
					flag3 = 1;
				charArr = charArr2;
			}
			if (sum <= fanweiRight && sum >= fanweiLift||sum>=-fanweiRight&&sum<=-fanweiLift)
				flag4 = 1;
			if ((flag3 == 1 && flag4 == 1) || o == 1) {
				System.out.println(brr + "=" + sum);
				break;
			}
		}
		return brr;
	}
}
