import java.util.ArrayList;
import java.util.List;

public class WorkingOnArrays_1 {
	static List  finalValues = new ArrayList();
	
	
	public static void main(String[] args) {
		int[] array = new int[]{3,-1,1,2,5};
		
		System.out.println(listcount(array));
		
		
		findPossibleValues(array, 0);
		
		System.out.println(finalValues);
	}
	
	
	
	public static void findPossibleValues(int[] array, int index) {
		if(array.length > index && index >= 0) {
			finalValues.add(array[index]);
			findPossibleValues(array, array[index]);
		}
		else if(index == -1)
			return;
		else
			System.out.println("Invalid");
	}
	
	
	
	
	public static int listcount(int[] array) {
		int count=1;
		for (int i = 0; i < array.length; ) {
			if (array[i]!=-1) {
				count++;
				i=array[i];
			}
			else{
				break;
			}
		}
		return count;
	}
}
