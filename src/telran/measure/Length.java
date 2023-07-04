package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit unit;
	private LengthUnit[] units = LengthUnit.values();

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		for(LengthUnit un : units) {
			if (unit.name() == un.name()) {
				this.unit = unit;
			}
		}		
	}	
	@Override
	public boolean equals(Object un) {		
		if(this == un) {
			return true;
		}
		Length conv = ((Length) un).convert(unit);		
		int comp = Float.compare(amount, conv.amount);
	
		return comp == 0 ? true : false;
	}
	
	public String toString() {
		return Float.toString(amount) + unit.name();
		
	}

	@Override
	public int compareTo(Length o) {
		float sizeO = o.convert(unit).amount;
		return Float.compare(amount, sizeO);
	}
	
	public Length convert(LengthUnit lengthUnit) {
		float k = unit.value / lengthUnit.value;
		Length conv = new Length(amount * k, lengthUnit);		
		return conv;
	}
	
	public LengthUnit getUnit() {
		return unit;
	}
	
	public float getAmount() {
		return amount;
	}

}
