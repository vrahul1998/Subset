
public class CelciusToFarenheitConverter {
	
	public float Converter(float celcius) {
		if(celcius<0) {
			throw new IllegalArgumentException("Value has to be between 0 and 100 degrees.");
		}
		if(celcius>100) {
			throw new IllegalArgumentException("Value has to be between 0 and 100 degrees.");
		}
		float farenheit=(celcius * 9/5) + 32;
	//	JSONObject obj=new JSONObject("{}") ;
		return farenheit;
		
	}
	

}
