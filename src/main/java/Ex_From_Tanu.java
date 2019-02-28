
public class Ex_From_Tanu {

	public static void main(String[] args){
		breakZ();
	} 
	
	public static void breakZ(){

		String o = ""; 
		z:
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 2; y++) {
				if(x==1){
					break;
				}
				if(x==2 && y==1){
					break z;
				}
				o = o + x + y; 
			} 
		} 
		System.out.println(o); 		
	}
	public static void returnZ(int number){
		z:{
			if(number>=10){
				System.out.println("Still...!");
//				continue z;
			}
		}
	}
}
