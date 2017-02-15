package array;

public class RemoveUnncessarySpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I            live    in    Waterloo";
		String temp = str.replaceAll("( )+"," ");
		System.out.println(temp);
	}

}
