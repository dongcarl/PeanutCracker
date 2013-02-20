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
	ControlCenter sendToHere;
	public Message(Object ObjectToPass, String StringToPass, String From, String To, ControlCenter sendHere)
	{
		main = ObjectToPass;
		message = StringToPass;
		destination = To;
		origin = From;
		sendToHere = sendHere;
	}
	public Message getFull()
	{
		//return the message, possibly for copying
		return this;
	}
	public void reply(Object ObjectToPass, String StringToPass, Message original, ControlCenter sendToHere)
	{
		Message reply = new Message(ObjectToPass, StringToPass, original.getDestination(), original.getOrigin(), sendToHere);
		sendToHere.sendMessage(reply);
	}
	public void errorReply(Message m)
	{
		reply(m.getMain() , "error", m.getFull(), m.getControlCenter());
	}
	public ControlCenter getControlCenter()
	{
		return sendToHere;
	}
	public String getDestination() 
	{
		return destination;
	}
	public void setDestination(String destination) 
	{
		this.destination = destination;
	}
	public String getOrigin() 
	{
		return origin;
	}
	public void setOrigin(String origin) 
	{
		this.origin = origin;
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
