
public class StringLLTester {

	public static void main(String[] args) {
	StringLL message = new StringLL("Hello World");
	StringLL message2 = new StringLL("Good bye");

	System.out.println(message.toString());
	
	System.out.println(message.indexOf('r'));
	

	int compareValue = message.compareTo(message2);
	if(compareValue < 0)
		System.out.println(message + " comes before " + message2);
	else if(compareValue > 0)
		System.out.println(message + " comes after " + message2);
	else
		System.out.println(message + " and " + message2 + " match.");
	
	message.replace('o', 'y');
	System.out.println(message.toString());
	
	System.out.println(message.charCount('l'));
	
	System.out.println(message.substring(8));
	
	System.out.println(message.substring(2, 3));
	} 

}
