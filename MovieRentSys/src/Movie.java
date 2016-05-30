
public class Movie {
	public static final int CHILDRENS=2;
	public static final int REGULAR=0;
	public static final int NEW_RELEASE=1;
	
	private String _title;
	private Price  _price;
	
	public Movie(String title,int priceCode){
		_title=title;
		setPriceCode(priceCode);		
	}
	
	public int getPriceCode(){
		return _price.getPriceCode();
	}
	
	public void setPriceCode(int arg){
		switch(arg){
		case Movie.CHILDRENS:
			_price=new ChildrensPrice();
			break;
		case Movie.REGULAR:
			_price=new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			_price=new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrent Price Code");
		}
	}
	
	public String getTitle(){
		return _title;
	}
	public double getCharge(int DaysRented){
		return _price.getCharge(DaysRented);
	}
	
	public int getFrequentPoints(int daysRented){
		return _price.getFrequentRenterPoints(daysRented);
	}
}
