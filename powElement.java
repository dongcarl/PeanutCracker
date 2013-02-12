package PeanutCracker;

public class powElement extends Element implements Comparable<powElement>
{
	//this class is equivalent to x to power multiplied by constant
	double constant = 1;
	double power = 1;
	String variable = "x"; //semantic, not used
	
	public powElement(double constan, double powe)
	{
		name = "powElement";
		constant = constan;
		power = powe;
		if (constant == 0)
		{
			new constant(0.0);
		}
		else if (power == 0)
		{
			new constant(constan);
		}
	}
	public powElement()
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
	public powElement derive()
	{
		double newConstant = constant*(power);
		double newPower = (power-1);
		return new powElement(newConstant, newPower);
	}
	public Element integrate()
	{
		if (power != -1)
		{
			double newConstant = constant/(power+1);
			double newPower = (power+1);
			return new powElement(newConstant, newPower);
		}
		else
		{
			return new logarithm();
		}
	}
	public constant substitute(double d)
	{
		return new constant((Math.pow(d, power)*constant));
	}
	public int compareTo(powElement p) 
	{
		double diff = this.getPower()-p.getPower();
		if (diff>0) return 1;
		else if (diff<0) return -1;
		else return 0;
	}
}
