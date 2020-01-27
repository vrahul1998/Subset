import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximumRobberyTestCases {


	@Test
	void HappyFlowTestCase1() {
		int arr[]= {1,2,3,1};
		MaximumMoneyRobbed maximumMoneyRobbed=new MaximumMoneyRobbed(arr, 4);
		assertEquals(4,maximumMoneyRobbed.arraySorting(arr));
	}
	@Test
	void HappyFlowTestCase2() {
		int arr[]= {2,7,9,3,1};
		MaximumMoneyRobbed maximumMoneyRobbed=new MaximumMoneyRobbed(arr, 5);
		assertEquals(12,maximumMoneyRobbed.arraySorting(arr));
	}
	@Test
	void indexOutOfBounds() {
		int arr[]= {2,7,9,3,1};
		ArrayIndexOutOfBoundsException arrayIndexOutOfBounds=assertThrows(ArrayIndexOutOfBoundsException.class,()->new MaximumMoneyRobbed(arr, 9).arraySorting(arr));
		assertEquals("invalid size provided",arrayIndexOutOfBounds.getMessage());
		
	}
	@Test
	void arraySizeMissMatch() {
		int arr[]= {2,7,9,3,1,5,6};
		ArrayIndexOutOfBoundsException arrayIndexOutOfBounds=assertThrows(ArrayIndexOutOfBoundsException.class,()->new MaximumMoneyRobbed(arr, 7).arraySorting(arr));
		assertEquals("invalid size provided",arrayIndexOutOfBounds.getMessage());
		
	}
	@Test
	void nullValue() {
		int arr[]= {2,7,9,3,1};
		IllegalArgumentException illegalArgumentException=assertThrows(IllegalArgumentException.class,()->new MaximumMoneyRobbed(arr,-1).arraySorting(arr));
		assertEquals("size must be greater than 0",illegalArgumentException.getMessage());
		
	}

}
