import java.util.Scanner;


/**
 * @author mahan.k.palavelli
 *
 */
public class Dec_To_Roman {
	public static void main(String[] args) {
		System.out.println("Enter Roman number");
		Scanner scan = new Scanner(System.in);
		int givenValue = scan.nextInt();
		String roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int intValues[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		int index = -1;
		int i =1;
		while(givenValue > 0) {
			i++;
			index++;
			if(givenValue >= intValues[index]) {
				System.out.print(roman[index]);
				givenValue = givenValue - intValues[index];
				index--;
			}
		}
//		System.out.println(i);
	}
}
