import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Method01 {

	private Integer[] HashTable;
	
	private BigInteger[] As;
	private BigInteger[] Bs;
	private BigInteger[] ps;
	
	private int size;
	
	public ArrayList<Integer> valuesInserted = new ArrayList<Integer>();
	
	private int counter=0;
	 
	public Method01(BigInteger[] a,BigInteger[] b,BigInteger[] p,int[] elements){
		
		this.As = a;
		this.Bs = b;
		this.ps = p;
		insert(elements);
	
	}
	
	
	
	private void insert(int[] arr) {
		
		size = (int) Math.pow(arr.length , 2);
		this.HashTable = new Integer[size];
		
		int key = 0;
		
		for(int i=0;i<arr.length;i++){
			boolean flag = true;
			
			key = hash(arr[i], As[0], Bs[0], ps[0]); 
			
			if(HashTable[key] == null){
				HashTable[key] = arr[i];
				valuesInserted.add(arr[i]);
			}
			
			else{
				counter++;
				int x = 1;
				while(flag && x < As.length){
					
					key = hash(arr[i], As[x], Bs[x], ps[x]);
					
					if(HashTable[key] == null){
						HashTable[key] = arr[i];
						valuesInserted.add(arr[i]);
						flag = false;
					}
					else {
						x++;
					}
				}
			}
		}
		
	}
	
	public boolean find(int value){
	
		int key = 0;
		
		key = hash(value, As[0], Bs[0], ps[0]); 
		
		if(HashTable[key] == null){
			return false;
		}
		else if(HashTable[key] == value){
			return true;
		}
		else{
			int x = 1;
			while(x < As.length){

				key = hash(value, As[x], Bs[x], ps[x]); 
				
				if(HashTable[key] == null){
					
					return false;
				}
				else if(HashTable[key] == value){
					return true;
				}
				else {
					x++;
				}
			}
		}
		return false;
	}
	
	
	private Integer hash(Integer x,BigInteger  a, BigInteger b, BigInteger p) {
		return (a.add(b.multiply(new BigInteger(x + "")))).mod(p).mod(new BigInteger(size + "")).intValue();
	}
	
	public String printHashTable(){
		
		String str = "";
		for(Object obj: HashTable){
			str += obj + " ";
		}
		return str;
	}
	public int tableSize(){
		return this.HashTable.length;
	}
	

	
	public void printNumOfCollision() {
		System.out.println("num of collision in O(N^2)= " + " " + counter);
	}
}
