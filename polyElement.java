package PeanutCracker;

public class polyElement extends Element 
{
	//this class is equivalent to x to power multiplied by constant
	double constant = 1;
	double power = 1;
	String variable = "x"; //semantic, not used
	
	public polyElement(double constan, double powe)
	{
		name = "polyElement";
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
	public polyElement()
	{
		this(1.0,1.0);
	}
	public Element derive()
	{
		double newConstant = constant*(power);
		double newPower = (power-1);
		return new polyElement(newConstant, newPower);
	}
	public Element integrate()
	{
		if (power != -1)
		{
			double newConstant = constant/(power+1);
			double newPower = (power+1);
			return new polyElement(newConstant, newPower);
		}
		else
		{
			//return logElement
		}
	}
	public Element substitute(double d)
	{
		return new constant((Math.pow(d, power)*constant));
	}
}
