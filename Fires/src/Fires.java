

public class Fires {
	private short year;
	private short counter;
	private Fire[] fires;
	
	
	public Fires(short year) 
	{
		this.year = year; 
		this.fires = new Fire[500];

	}
	public void updateDamage(String fireCode, double damages) {
		for(short i=0; i<fires.length; i++ ) {
			if(fires[i].getFireCode()==fireCode) {
				fires[i].setDamages(damages);
			}
		}
	}
	public void addFire(Fire newFire) {
	    if (counter < fires.length) {
	        fires[counter] = newFire;
	        counter++;
		}
	}
	public double getTotalDamagesByArea(String areaCode) {
		double damages = 0.0;
		for(short i=0; i<fires.length; i++) {
			if(fires[i].getAreaCode() ==areaCode) {
				damages += fires[i].getDamages();
			}
		}
		return damages;
	}
	public byte highestMonth() {
		int[] months = new int[12];
		for(int i = 0 ; i<fires.length; i++) {
			for(int j = 0 ; j<months.length ; j++) {
				if(fires[i].getMonth()==j+1)
					months[j]++;
			}

		}
		byte maxMonth = 0;
		for(int i = 0 ; i<months.length ; i++) {
			if(months[i]>maxMonth) {
				maxMonth = (byte) (i+1);
			}
		}
		return maxMonth;
	}
	public double[] getDmgEachMonth(short year) {
		double[] monthsDmgs = new double[12];
		for(int i = 0 ; i<monthsDmgs.length ; i++) {
			for(int j = 0 ; j<fires.length; j++) {
				if(fires[j].getMonth()==i+1) {
					monthsDmgs[i] += fires[j].getDamages();
				}
			}
		}
		return monthsDmgs;
	}
}