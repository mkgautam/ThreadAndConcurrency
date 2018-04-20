package singleton.pattern;

public class BillPughSingleton {
	
private BillPughSingleton(){}
    
	//inner class
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
	
}
