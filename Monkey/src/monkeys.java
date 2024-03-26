import java.util.ArrayList;

public class monkeys {

	public monkeys() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> hello = new ArrayList<Integer>();
		hello.add(3);
		hello.add(1);
		hello.add(1);
		hello.add(52);
		hello.add(12);
		hello.add(1);
		hello.add(13);
		hello.add(12);
		hello.add(1);
		
		
		int a = 0;
		for(int i = 0; i < hello.size(); i++) {
			if(hello.get(i)== 1) {
				a += 1;
			}
		}
		
		System.out.println(a);
	}

}
