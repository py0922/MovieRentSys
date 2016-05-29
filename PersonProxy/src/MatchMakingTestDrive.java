import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MatchMakingTestDrive {
 private Map<String,PersonBean> data=new HashMap<String,PersonBean>();
 
 private void initializeDatabase(){
	 PersonBean Micheal=new PersonBeanImpl();
	 Micheal.setName("Micheal");
	 Micheal.setGender("male");
	 Micheal.setInterests("basketball");
	 data.put("Micheal", Micheal);
	 
	 PersonBean Alex=new PersonBeanImpl();
	 Alex.setName("Alex");
	 Alex.setGender("male");
	 Alex.setInterests("fishing");
	 data.put("Alex", Alex);	 
 }
 
 public MatchMakingTestDrive(){
	 initializeDatabase();
 }
 
 private PersonBean getOwnerProxy(PersonBean person){
	 return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
			 person.getClass().getInterfaces(),
			 new OwnerInvocationHandler(person));
 }
 
 private PersonBean getNonOwnerProxy(PersonBean person){
	 return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
			 person.getClass().getInterfaces(), 
			 new NonOwnerInvocationHandler(person));
 }
	
 public PersonBean getPersonFromDatabase(String name){
	 return data.get(name);
 }

 public void drive(){
	PersonBean Alex=getPersonFromDatabase("Alex");
	PersonBean ownerProxy=getOwnerProxy(Alex);
	System.out.println("Name is "+ownerProxy.getName());
	ownerProxy.setInterests("bowling, Go");
	try{
		ownerProxy.setHotOrNotRating(10);
    }
	catch(Exception e){
	  System.out.println("Can't set rating from owner proxy");
	}
	System.out.println("Rating is "+ownerProxy.getHotOrNotRating());
	
	
	
	PersonBean nonOwnerProxy=getNonOwnerProxy(Alex);
	System.out.println("Name is "+nonOwnerProxy.getName());
	try{
		nonOwnerProxy.setInterests("football");
	}
	catch(Exception e){
		System.out.println("Can't set the interests from nonOwnerProxy");
	}
	nonOwnerProxy.setHotOrNotRating(20);
	System.out.println("Rating is "+nonOwnerProxy.getHotOrNotRating());
	 
 }
 
 public static void main(String[] args){
	 MatchMakingTestDrive test=new MatchMakingTestDrive();
	 test.drive();
 }
 
}
