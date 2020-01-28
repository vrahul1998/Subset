import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class ConverterTesting {
	CelciusToFarenheitConverter celciusToFarenheitConverter;
	
	@BeforeEach
	void setup(){
		celciusToFarenheitConverter=new CelciusToFarenheitConverter();
	}
	
	
	@ParameterizedTest(name="Farenheit value is {1} for {0} ")
	@CsvSource({"10,50","20,68"})
	void happyflow(float celcius,float expected) {
		assertEquals(expected,celciusToFarenheitConverter.Converter(celcius),0.01);	
	}
	@DisplayName("When degree is 100 ")
	@Test
	void upperBound() {
		assertEquals(212,celciusToFarenheitConverter.Converter(100),0.01);
	}
	@Test
	void lowerBound() {
		assertEquals(32,celciusToFarenheitConverter.Converter(0),0.01);
	}
	
	@Test
	void upperInvalid() {
		IllegalArgumentException illegalArgumentException=assertThrows(IllegalArgumentException.class,()->celciusToFarenheitConverter.Converter(101));
		assertEquals("Value has to be between 0 and 100 degrees.",illegalArgumentException.getMessage());
	}
	
	@Test
	void LowerInvalid() {
		IllegalArgumentException illegalArgumentException=assertThrows(IllegalArgumentException.class,()->celciusToFarenheitConverter.Converter(-2));	
		assertEquals("Value has to be between 0 and 100 degrees.",illegalArgumentException.getMessage());	
	}

}
