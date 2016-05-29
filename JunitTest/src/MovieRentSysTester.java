import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MovieRentSysTester {
 
    @Parameters
    public static Collection<Object[]> data(){
    return Arrays.asList(new Object[][]{{1,0,0,1.5,1},{0,1,0,2,1}});
    	//		return Arrays.asList(new Object[][] {{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }   });
    }
    
    private int _children;
    private int _regular;
    private int _newRelease;
    private double _totalAmount;
    private int _frequentRenterPoints;
    

    public  MovieRentSysTester(int children,int regular, int newRelease,double totalAmount, int frequentRenterPoints){
    	_children=children;
    	_regular=regular;
    	_newRelease=newRelease;
    	_totalAmount=totalAmount;
    	_frequentRenterPoints=frequentRenterPoints;
    }
	
	@Test
	public void test() {
		String expectedEnds="Amount owed is "+ String.valueOf(_totalAmount)+"\n"+"You earned "+String.valueOf(_frequentRenterPoints)+" frequent renter points";
		
		assertEquals(true,CreatCustomer().statement().endsWith(expectedEnds));
	}
	
	private Customer CreatCustomer(){
		Customer _customer=new Customer("Tester");
		if(_children!=0)
			_customer.addRental(new Rental(new Movie("childrenMovie",Movie.CHILDRENS),_children));
		if(_regular!=0)
			_customer.addRental(new Rental(new Movie("regularMovie",Movie.REGULAR),_regular));
		if(_newRelease!=0)
			_customer.addRental(new Rental(new Movie("newReleaseMovie",Movie.NEW_RELEASE),_newRelease));
		return _customer;
	}

}
