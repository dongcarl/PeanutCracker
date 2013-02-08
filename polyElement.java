package PeanutCracker;

public class polyElement extends Element implements Comparable<polyElement>
{
	//this class is equivalent to constant times x to the counting number power power
	double constant = 1;
	int power = 1;
	public polyElement(double constan, int powe)
	{
		name = "polyElement";
		constant = Math.abs(constan);
		power = Math.abs(powe);
		if (constant == 0)
		{
			new constant(0.0);
		}
		else if (power == 0)
		{
			new constant(constan);
		}
	}
	public polyElement()
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
	public polyElement derive()
	{
		double newConstant = constant*(power);
		int newPower = (power-1);
		return new polyElement(newConstant, newPower);
	}
	public polyElement integrate()
	{
		double newConstant = constant/(power+1);
		int newPower = (power+1);
		return new polyElement(newConstant, newPower);
	}
	@Override
	public int compareTo(polyElement p) 
	{
		double diff = this.getPower()-p.getPower();
		if (diff>0) return 1;
		else if (diff<0) return -1;
		else return 0;
	}
 
}
