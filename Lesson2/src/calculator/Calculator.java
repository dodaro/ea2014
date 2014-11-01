package calculator;

public class Calculator
{		
		public Calculator()
		{
		}
		
		public Double execute( double num1, double num2, char operation )
		{
			switch( operation )
			{
				case '+':
					return num1 + num2;
				case '-':
					return num1 - num2;
				case '/':
					if( num2 == 0 )
						return null;
					return num1 / num2;
				case '*':
					return num1 * num2;
				default:
					return 0.0;
			}
		}
		
		public Double square( double value )
		{
			return value * value;
		}
}
