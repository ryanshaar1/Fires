
public class Fire {
	
	private String fireCode;
	private String areaCode;
	private byte month;
	private double damages;
	
	public void setMonth(byte month) {
		if(this.month >=1 && this.month <=12)
			this.month = month;
		else
			this.month = 1;
	}
	public void setDamages(double damages) {
		if(this.damages >=0)
			this.damages = damages;
		else
			this.damages = 0;
	}
	public byte getMonth() {
		return this.month;
	}
	public double getDamages() {
		return this.month;
	}
	public String getAreaCode() {
		return this.areaCode;
	}
	public String getFireCode() {
		return this.fireCode;
	}
	
	public Fire(String fireCode, String areaCode, byte month) {
		this.fireCode = fireCode;
		this.areaCode = areaCode;
		this.month = month;
	}
	public Fire(String fireCode,String areaCode,byte month,double damages) {
		this.fireCode = fireCode;
		this.areaCode = areaCode;
		this.month = month;
		this.damages = damages;
	}
	
	
}