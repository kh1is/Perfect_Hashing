import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Method02 {
    Object[] HashTable;
    private int b;
    private int counter=0;
    private BigInteger a_param [] , b_param [] , p_param [];
    public Method02(int[] arr, BigInteger [] a , BigInteger [] b, BigInteger [] c) {
        this.a_param = a;
        this.b_param = b;
        this.p_param = c;
        this.b = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        this.insert(arr);
        //System.out.println("B: " + b);
    }
    private void insert(int[] arr) {
        
        this.HashTable = new Object[arr.length];
        for(Integer i: arr){
                int check = hash(i, a_param[0], b_param[0], p_param[0]);
                //System.out.println("Check: " + check);
                //System.out.println("After Check: " + i);
                if(HashTable[check] == null){
                    HashTable[check] = i;
                }
                else {
                	counter++;
                    if(HashTable[check] instanceof Integer){
                        int[] temp_arr = new int[2];
                        temp_arr[0] = i;
                        temp_arr[1] = (Integer)HashTable[check];
                        Method01 method = new Method01(this.a_param, this.b_param, this.p_param, temp_arr);
                        HashTable[check] = method;
                    }
                    else if (HashTable[check] instanceof Method01){
                        Method01 method = (Method01) HashTable[check];
                        int [] temp_arr = new int[method.valuesInserted.size() + 1];
                        int l = 0;
                        for(Integer k : method.valuesInserted){
                            temp_arr[l] = k;
                            l++;
                        }
                        temp_arr[l] = i;
                        Method01 method1 = new Method01(this.a_param, this.b_param, this.p_param, temp_arr);
                        HashTable[check] = method1;
                        
                    }
                }
            
        }
        
     //   this.printHashTable();
        
    }
    public boolean find(int key) {
            int check = hash(key,this.a_param[0], this.b_param[0], this.p_param[0]);
            if(HashTable[check] == null)
                return false;
            else if(HashTable[check] instanceof Integer){
                if((Integer)HashTable[check] == key)
                    return true;
                else
                    return false;
            }
            else if(HashTable[check] instanceof Method01){
                return ((Method01)HashTable[check]).find(key);
            }
        
         return false;
    }
    private Integer hash(Integer x,BigInteger  a, BigInteger b, BigInteger p) {
        
        return (a.add(b.multiply(new BigInteger(x + "")))).mod(p).mod(new BigInteger(HashTable.length + "")).intValue();
    }
    
    
    public void printHashTable(){
        int counter = 0;
        System.out.println("Length: " + HashTable.length);
        
        for(Object obj : HashTable){
            if(obj instanceof Integer){
                System.out.println("Integer Item Num " + (++counter) + ": " + obj);
            }
            else if (obj instanceof Method01){
                System.out.println("Sub Hash Item Num " + (++counter) + ": Length: " +((Method01)obj).tableSize() + " : "+((Method01)obj).printHashTable());
            }
            else{
                System.out.println("Item Num " + (++counter) + ": " + obj);
            }
        }
    }
    
    public void printNumOfCollision() {
		System.out.println("num of collision in O(N)= " + " " + counter);
	}
    
}