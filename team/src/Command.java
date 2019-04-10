import java.io.PrintStream;
import java.util.Scanner;

public class Command {

	public static int n;
	public static int m1;
	public static int m2;
	public static int b = 0;
	public static int c = 0;
	public static int o = 1;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isN = 0;
		int isM = 0;
		/*n = 10;
		m1 = 1;
		m2 = 50;
		c=0;
		o=4;
		b=1;*/
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-n")) {
				isN = 1;
				try {
					n = Integer.parseInt(args[i + 1]);
					if (n <= 0 || n > 10000) {
						System.out.println("输入数字错误，请输入0到10000的数字哦");
						return;
					}
				} catch (Exception e) {
					System.out.println("不对哦，请重新输入数字哦");
				}
			}
			if (args[i].equals("-m")) {
				isM = 1;
				try {
					m1 = Integer.parseInt(args[i + 1]);
					m2 = Integer.parseInt(args[i + 2]);
					if (m1 <= 0 || m1 > 100) {
						System.out.println("输入数字错误，请输入0到100的数字哦");
						return;
					}
					if (m2 < 50 || m2 > 1000) {
						System.out.println("输入数字错误，请输入50到1000的数字哦入");
						return;
					}
				} catch (Exception e) {
					System.out.println("不对哦，请重新输入数字哦");
				}
			}
			if (args[i].equals("-o")) {
				try {
					o = Integer.parseInt(args[i + 1]);
					if (o <= 0 || o > 10) {
						System.out.println("输入数字错误，请输入1到10的数字哦");
						return;
					}
				} catch (Exception e) {
					System.out.println("不对哦，请重新输入数字哦");
				}
			}
			if (args[i].equals("-b")) {
				b = 1;// 括号
			}
			if (args[i].equals("-c")) {
				c = 1;// 乘除
			}
		}
		if (isN == 0) {
			System.out.println("参数n呢,请重新输入哦");
			return;
		}
		if (isM == 0) {
			System.out.println("参数m呢,请重新输入哦");
			return;
		}
		try {
			PrintStream ps = new PrintStream("../result.txt");// 生成文件
			System.setOut(ps);
		} catch (Exception e) {
			System.out.println("文件生成错误~");// 提示
		}
		if (b == 1&&c==1) {
			Operation.Operation(n, m1, m2, c, o);
		} else if(b == 0){
			Operation1.Operation(n, m1, m2, c, o);
		} else {
			Operation2.Operation(n, m1, m2, c, o);
		}
		//System.out.println("成功");
	}

}
