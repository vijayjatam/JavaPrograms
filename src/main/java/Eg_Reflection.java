import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Eg_Reflection {
	public static void main(String[] args) throws UnknownHostException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		InetAddress inet = InetAddress.getLocalHost();
		Method[] methodArray = inet.getClass().getMethods();
		for(Method method : methodArray) {
			String getsOnly = method.getName();
			System.out.println(method);
			if(getsOnly.charAt(0) == 'g') {
				System.out.println(method.invoke(inet, null));
			}
		}
	}
	
	
	/*public static void findWhoInherited(String componentName) {
		Reflections refl = new Reflections("java.util");
	}*/
}
