public class StackTracing {

	public static int traceMe(int ans) {
		int tr1 = ans * 2 + 1; 
		tr1 = aboveTraceMe(tr1) + ans;
		tr1 = tr1 - 1;
		return tr1;
	}
	
	public static int aboveTraceMe(int ans) {
		int tr2 = upAnother(2) + ans; 
		tr2 += upAnother(tr2);
		return tr2;
	}
	
	public static int upAnother(int ans) {
		int tr3 = ans * 3 - 3;
		return tr3;
		
	}
}
