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
    return Arrays.asList(new Object[][]{{1,0,0,1.5,1},{0,1,0,2,1},{0,0,1,3,1},{4,0,0,3,1},{0,3,0,3.5,1},{0,0,2,6,2},{4,3,2,12.5,4}});
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
	public void testStatement() {
		String expectedEnds="Amount owed is "+ String.valueOf(_totalAmount)+"\n"+"You earned "+String.valueOf(_frequentRenterPoints)+" frequent renter points";
		
		assertEquals(true,CreatCustomer().statement().endsWith(expectedEnds));
	}
	
	@Test
	public void testHtmlStatement(){
		String expectedEnds="<P>You owe<EM> "+String.valueOf(_totalAmount)+"</EM><P>\n"+"On this rental you earned <EM>"+String.valueOf(_frequentRenterPoints)+"</EM> frequent renter points<P>";
		assertEquals(true,CreatCustomer().htmlStatement().endsWith(expectedEnds));
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
