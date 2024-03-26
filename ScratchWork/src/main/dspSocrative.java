package main;
public class dspSocrative {

	public dspSocrative() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mystery("medha"));
		System.out.println(mystery("aisha"));
		System.out.println(mystery("rayyan"));

	}



	public static String mystery(String val){
	   if(val.length() <= 1 ) {
		   return val;
	   }
	   else {
	       return mystery(val.substring(1)) + val.substring(0, 1) + mystery(val.substring(1));
	   }


	}

}
