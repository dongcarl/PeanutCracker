package PeanutCracker;

public class PowElement extends Element implements Comparable<PowElement>
{
	//this class is equivalent to x to power multiplied by constant
	double constant = 1;
	double power = 1;
	String variable = "x"; //semantic, not used
	
	public PowElement(double constan, double powe)
	{
		name = "powElement";
		constant = constan;
		power = powe;
		if (constant == 0)
		{
			new Constant(0.0);
		}
		else if (power == 0)
		{
			new Constant(constan);
		}
	}
	public PowElement()
	{
		this(1.0,1.0);
	}
	public double getPower()
	{
		return power;
	}
	public double getConstant() 
	{
		return constant;
	}
	public PowElement derive()
	{
		double newConstant = constant*(power);
		double newPower = (power-1);
		return new PowElement(newConstant, newPower);
	}
	public Element integrate()
	{
		if (power != -1)
		{
			double newConstant = constant/(power+1);
			double newPower = (power+1);
			return new PowElement(newConstant, newPower);
		}
		else
		{
			return new Logarithm();
		}
	}
	public Constant substitute(double d)
	{
		return new Constant((Math.pow(d, power)*constant));
	}
	public int compareTo(PowElement p) 
	{
		double diff = this.getPower()-p.getPower();
		if (diff>0) return 1;
		else if (diff<0) return -1;
		else return 0;
	}
}
