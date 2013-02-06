package PeanutCracker;

import JasymcaSourceGit2.Algebraic;

public class Function
{
	//testing to see if my IDE and GitHub are back working after a crash
	private String operator = "none";
	private String name = "def";
	private Algebraic function;
	
	public Function(Algebraic function)
	{
		this(function, "def");
	}
	public Function(Algebraic function, String name)
	{
		this(function, "none", "def");
	}
	public Function(Algebraic functio, String operatio, String nam)
	{
		function = functio;
		operator = operatio;
		name = nam;
	}

	public Algebraic getFunction()
	{
		return function;
	}

	public void setAlgebraic(Algebraic function)
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
		//add the function to the searchPath
	}
}
