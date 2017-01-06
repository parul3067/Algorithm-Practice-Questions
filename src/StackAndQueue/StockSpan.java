package StackAndQueue;

public class StockSpan {
	
	private void findSpan(int a[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		System.out.println("Stock Span for "+a[0]+" : 1");
		for(int i=1;i<a.length;i++) {
			if(a[i] < a[s.peek().data]) {
				System.out.println("Stock Span for "+a[i]+" : "+(i-s.top.data));
				s.push(i);
			} else {
				while(s.top != null && a[i] >= a[s.top.data]) {
					s.pop();
				}
				if(s.top == null) {
					System.out.println("Stock Span for "+a[i]+" : "+(i+1));
				} else {
					System.out.println("Stock Span for "+a[i]+" : "+(i-s.top.data));
				}
				s.push(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockSpan s = new StockSpan();
		int a[] = {10, 4, 5, 90, 120, 80};
		s.findSpan(a);
	}

}
