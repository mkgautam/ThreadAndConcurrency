package singleton.pattern;

public class FactoryMethodSingleton {
	
	private static final FactoryMethodSingleton INSTANCE = new FactoryMethodSingleton(); 
	
	private FactoryMethodSingleton() {
		//private constructor
	}
	
	public static FactoryMethodSingleton getInstance() {
		return INSTANCE;
	}
}
