import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class UniversalHashFamily {
    
	private int max_val;
    private BigInteger [] a = new BigInteger[100];
    private BigInteger [] b = new BigInteger[100];
    private BigInteger []  p = new BigInteger [100];
    public UniversalHashFamily(int max_val){
        buildHashFamily();
        this.max_val = max_val;
        
    }
    private void buildHashFamily() {
        for(int i= 0; i < this.a.length; i++){
            p[i] = new BigInteger(Integer.toBinaryString(ThreadLocalRandom.current().nextInt(this.max_val, Integer.MAX_VALUE)).length(), 5, new Random());
            
            a[i] = new BigInteger(""+ ThreadLocalRandom.current().nextInt(1, p[i].intValue()));
            b[i] = new BigInteger("" + ThreadLocalRandom.current().nextInt(1, p[i].intValue()));
        }
    }
    public BigInteger [] get_a(){
        return this.a;
    }
    public BigInteger [] get_b(){
        return this.b;
    }
    public BigInteger [] get_p(){
        return this.p;
    }
   
}