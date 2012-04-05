package test.hash;

/**
 * 
 * @author wangx
 */
public class Test {


	public static void main(String[] args) {
		testObjectHashCode();
	}
	
	/**
	 * @see http://www.cogs.susx.ac.uk/courses/dats/notes/html/node114.html
	 * @see http://rdc.taobao.com/team/jm/archives/1501
	 * @author wangx
	 * @date 2012-4-5
	 */
	public static void testStringHashCode(){
		//s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		System.out.println("abc".hashCode());
		//String..hashCode()算法
		//h = 31*h + val[off++];
		// h = 31*h + s[i++];
		
		// h = 31*0 + s[0]
		// h = 31*(31*0 + s[0]) + s[1]
		// h = 31*(31*(31*0 + s[0]) + s[1]) + s[2]
		// h = s[0]*31^(n-1) + s[0]*31^(n-2) + ... + s[n-1]*31^[n-n]
		
		System.out.println((97 * 31 + 97)*31 + 97);
		System.out.println((97) + (97 * 31) + (97 * 31 * 31));
	}
	
	
	public static void testObjectHashCode(){
		T t = new T();
		T t1 = new T();
		System.out.println(t.hashCode());
		System.out.println(Integer.toHexString(t.hashCode()));
		System.out.println(t);
		t.setName("Ab");
		System.out.println(t.hashCode());
		t.setName("BB");
		System.out.println(t.hashCode());
		
	}
}
class T{
	private String name;
	
	public T(){}
	
	public T(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
