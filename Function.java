package PeanutCracker;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Function
{
	public String operator = "none";
	public String function = "";
	public String name = "def";
	
	public Function(String function)
	{
		this(function, "def");
	}
	public Function(String function, String name)
	{
		this(function, "none", "def");
	}
	public Function(String functio, String operatio, String nam)
	{
		function = functio;
		operator = operatio;
		name = nam;
	}
}
