import java.util.Arrays;

public class CopiesEverywhere {

	public static void main(String[] args) 
	{
		int[] a = {1, 2, 3};
		int[] b = a;
		
		a[2] = 300;
		
		System.out.println(Arrays.toString(b)); // 1,2,300
		System.out.println(b);
		
		int[] c = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}

		System.out.println(Arrays.toString(a)); // 1,2,300
		System.out.println(a);
		System.out.println(Arrays.toString(c)); // 1,2,300
		System.out.println(c);
		a[1] = 200;
		
		System.out.println(Arrays.toString(c)); // 1,2,300	
		
		int[] array = {6, 12, 496};
		changeMe(42, "life", array);
		
		int[] mainArray = {10, 20, 30, 40, 50};
		makeAMess(mainArray);
		System.out.println(Arrays.toString(mainArray));
	}
	
	public static void changeMe(int num, String myStr, int[] arr) {
		num = num + 5;
		myStr = myStr + 5;
		arr[1] = 5;
	}
	
	public static void makeAMess(int[] origArray) {
		int[] copyArray = origArray;
		int[] newArray = new int[origArray.length];
		
		origArray = newArray;
		
		origArray[1] = 100;
		copyArray[2] = -50;
		newArray[3] = 42;
		
		System.out.println("orig" + Arrays.toString(origArray));
		System.out.println("copy" + Arrays.toString(copyArray));
		System.out.println("new" + Arrays.toString(newArray));
	}	
}

