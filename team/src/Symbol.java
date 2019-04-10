
public class Symbol {
	public static int symbol(int x,char Char,int y)
	{
		int sum=0;
		switch (Char)
		{
		case '+' :
			sum=x+y;
			break;
		case '-' :
			sum=x-y;
			break;
		case '*' :
			sum=x*y;
			break;
		case '¡Â' :
			sum=x/y;
			break;			
		}
		return sum;
	}
}
