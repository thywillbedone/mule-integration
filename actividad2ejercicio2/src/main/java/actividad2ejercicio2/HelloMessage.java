package actividad2ejercicio2;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class HelloMessage implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		String payload = (String) eventContext.getMessage().getPayload();
		
		String name;
		String age;
		String error = "Input types are not correct.";
		
		try {
			String[] input = payload.split("-");
			
			//se valida que solo haya un "-"	
			if (input.length != 2){
				return error;
			}
			
			name = input[0];
			age = input[1];
			
			//se usa expresiones regulares para validar los input	
			if ((!name.matches("[A-Za-z]*")) || (!age.matches("\\d{1,2}"))){
				return error;
			}
			
		} catch (Exception e) {
			return error;
		}
		//Se a?ade al payload el message		
		return "Hello " + name + ", you are " + age + " years old";
	}
}
