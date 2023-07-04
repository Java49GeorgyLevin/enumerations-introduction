package telran.measure;

public enum LengthUnit {
	
	MM(1), CM(10), DM(100), M(1000), KM(1_000_000),
	IN(25.4f), FT(304.8f), YARD(914.4f), MILE(1_609_344);
	float value;

	LengthUnit(float value) {
		this.value = value;		
	}
	
	public Length between(Length length1, Length length2) {
		Length l1 = length1.convert(this);
		Length l2 = length2.convert(this);
		float del = l2.getAmount() - l1.getAmount();	
		return new Length(del, this);
	}
}
