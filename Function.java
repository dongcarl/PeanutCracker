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
	//testing to see if my IDE and GitHub are back working after a crash
	private String operator = "none";
	private String function = "";
	private String name = "def";
	
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

	public String getFunction()
	{
		return function;
	}

	public void setFunction(String function)
	{
		this.function = function;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}
	public void setNewFunctionPath(String funcPath)
	{
		addPath("funcPath"); //add the function to the searchPath
	}
}
