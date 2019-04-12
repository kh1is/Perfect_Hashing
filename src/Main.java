import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Getting File Path
		File file = new File("C:\\Users\\HP\\workspace\\hashing 02\\src\\test.txt");
		// Reading File
		ReadFile r = new ReadFile(file);
		// Creating Hash Family
		UniversalHashFamily h = new UniversalHashFamily(r.maximum);
		//h.setHashSize((int) Math.ceil(Math.log(r.getSource().length) / Math.log(2)));
		
		
		  
        Method01 m1 = new Method01(h.get_a(),h.get_b(),h.get_p(), r.getSource() );

		m1.printNumOfCollision();
        
		//System.out.println(m1.find(4));
		//System.out.println(m1.find(78));
		
		//System.out.println(m1.printHashTable());
		//m1.printHashFunction();
		
        Method02 m2 = new Method02( r.getSource() ,h.get_a(),h.get_b(),h.get_p());
        
        m2.printNumOfCollision();
       // m2.printHashTable();
      //  System.out.println(m2.find(7));
  
	}

}
