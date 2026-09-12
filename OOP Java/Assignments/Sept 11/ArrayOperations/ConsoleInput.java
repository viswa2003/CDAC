
public class ConsoleInput {
	public static String getString() {
		try {
			byte[] inputArr = new byte[100];
			int length = System.in.read(inputArr);
			byte[] finalArr = new byte[length - 2];
			System.arraycopy(inputArr, 0, finalArr, 0, length - 2);
			String result = new String(finalArr);
			return result;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getInt() {
		return Integer.parseInt(getString());
	}
}
