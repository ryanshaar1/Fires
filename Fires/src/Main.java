
import java.util.Scanner;
public class Main {
	
	public static Scanner reader = new Scanner(System.in);
	
	public static String generateRandomCode() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
		String code = "";
		for(int i = 0; i<6; i++) {
			byte random = (byte)(Math.random() * (chars.length()+1));
			code += chars.charAt(random);
		}
		return code;
	}
    public static Fire constructFireObject() {
        System.out.println("Enter fire zone code:");
        String zoneCode = reader.next();
        
        System.out.println("Enter month:");
        byte month = reader.nextByte();
        Fire fire = new Fire(generateRandomCode(), zoneCode, month);
        return fire;
    }
    public static Fire constructFireObjectWithDamage() {
        Fire fire = constructFireObject(); 
        System.out.println("Enter damages:");
        double damages = reader.nextDouble();
        fire.setDamages(damages);
        return fire;
    }
    public static Fires buildFirePoolForYear(short year) {
        Fires firePool = new Fires(year);
        for (int i = 0; i<500; i++) {
        	firePool.addFire(constructFireObjectWithDamage());
        }
        return firePool;
    }
    public static Fire[] createFirePool(int numFiresWithoutDamage, int numFiresWithDamage) {
        Fire[] firePool = new Fire[numFiresWithoutDamage + numFiresWithDamage];
        
        // Creating fires without damage
        for (int i = 0; i < numFiresWithoutDamage; i++) {
            firePool[i] = constructFireObject(); 
        }
        
        // Creating fires with damage
        for (int i = numFiresWithoutDamage; i < firePool.length; i++) {
            firePool[i] = constructFireObjectWithDamage(); 
        }
        
        return firePool;
    }

	public static void main(String[] args) {
	    Fire[] firePool2012 = createFirePool(1, 2); 
	    Fire[] firePool2010 = createFirePool(2, 1);
	    short year = reader.nextShort();
	    Fires firesPool2012 =new Fires(year);
	    Fires firesPool2010 =new Fires(year);
	    for(int i = 0; i<30;i++) {
	    	firesPool2012.addFire(firePool2012[i]);
	    }
		for(int i = 0; i<40;i++) {
		    firesPool2010.addFire(firePool2010[i]);
	    }
		System.out.println(firesPool2012.highestMonth());
		System.out.println(firesPool2010.getDmgEachMonth(year));
	}

	    	
		

	}