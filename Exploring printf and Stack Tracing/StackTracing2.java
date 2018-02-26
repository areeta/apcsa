public class StackTracing2 {

	public static int traceThis(int ans) {
		int tr = ans * 2 + 1; 
		if (tr < 20)
			tr = traceThis(tr) + ans;
			tr = tr - 1;
		return tr;
	}
	
}
