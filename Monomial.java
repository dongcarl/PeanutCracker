package PeanutCracker;

public class Monomial extends Element implements Comparable<Monomial>
{
	//this class is equivalent to constant times x to the counting number power power
	double constant = 1;
	int power = 1;
	public Monomial(double constan, int powe)
	{
		name = "polyElement";
		constant = Math.abs(constan);
		power = Math.abs(powe);
		if (constant == 0)
		{
			new Constant(0.0);
		}
		else if (power == 0)
		{
			new Constant(constan);
		}
	}
	public Monomial()
	{
		this(1.0,1);
	}
	public double getPower()
	{
		return power;
	}
	public double getConstant() 
	{
		return constant;
	}
	public Monomial derive()
	{
		double newConstant = constant*(power);
		int newPower = (power-1);
		return new Monomial(newConstant, newPower);
	}
	public Monomial integrate()
	{
		double newConstant = constant/(power+1);
		int newPower = (power+1);
		return new Monomial(newConstant, newPower);
	}
	@Override
	public int compareTo(Monomial p) 
	{
		double diff = this.getPower()-p.getPower();
		if (diff>0) return 1;
		else if (diff<0) return -1;
		else return 0;
	}
	@Override
	public Constant substitute(double replace) 
	{
		return new Constant(Math.pow(replace, power)*constant);
	}
 
}
