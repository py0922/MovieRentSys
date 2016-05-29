import java.lang.reflect.*;
public class OwnerInvocationHandler implements InvocationHandler {
	PersonBean person;
	public OwnerInvocationHandler(PersonBean person){
		this.person=person;
	}
	public Object invoke(Object proxy,Method method, Object[] args)
			throws IllegalAccessException{
		try{
			if(method.getName().equals("setHotOrNotRating"))
				throw new IllegalAccessException();
			else 
				 return method.invoke(person, args);
		}
		catch(InvocationTargetException e){
			
		}
		return null;
	}
}
