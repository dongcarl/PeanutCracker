package PeanutCracker;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Message
{
	Object main;
	String message;
	String destination;
	String origin;
	public Message(Object ObjectToPass, String StringToPass, String From, String To)
	{
		main = ObjectToPass;
		message = StringToPass;
		destination = To;
		origin = From;
	}
	public Message getFull()
	{
		//return the message, possibly for copying
		return this;
	}
	public Object getMain() 
	{
		//return the object passed, including an Event, Window or otherwise
		return main;
	}
	public void setMain(Object main) 
	{
		//set the main object passed, including an Even, Window or otherwise
		this.main = main;
	}
	public String getMessage() 
	{
		//get the message string, including which operation might be applied to a function, etc.
		return message;
	}
	public void setMessage(String message) 
	{
		//set the message string, including which operation might be applied to a function, etc.
		this.message = message;
	}
	
}
