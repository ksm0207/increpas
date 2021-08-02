package pm;

public class Ex1_Exception {
	

	public static void main(String[] args)  {
		
		int[] array = new int[3];
		
		try {
			for (int i=0; i<=array.length;i++) {
				array[i] = (i+1) * 100;
			}
			// 배열의 범위를 벗어남
			System.out.println(array[0]/0);
			
		} catch (ArithmeticException error) {
			// TODO: ArithmeticException
			System.out.println("ArithmeticException (1) : "+error);
			
		} catch (ArrayIndexOutOfBoundsException arrError) {
			// TODO: ArrayIndexOutOfBoundsException
			System.out.println("ArrayIndexOutOfBoundsException (2) : "+arrError);
		}
		  catch (Exception e) {
			// TODO: 나머지 예외가 발생했을 때 수행하는 영역.
			  System.out.println("Exception : " + e);
		}
	}
}
