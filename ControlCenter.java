package PeanutCracker;

/**
 * Created with IntelliJ IDEA.
 * User: dongcarl
 * Date: 2/1/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ControlCenter
{
	Runner a;
	MasterMind b;
	GraphFrame c;
	public static void main(String[] args)
	{
		ControlCenter main = new ControlCenter();
	}
	public ControlCenter()
	{
		b = new MasterMind(this); //each brain should instantiate with control center info, so that messages can be passed
		c = new GraphFrame();
		a = new Runner();
	}
	public ControlCenter(Runner alpha, MasterMind beta, GraphFrame cappa)
	{
		a = alpha;
		b = beta;
		c = cappa;
	}
	public void sendMessage(Message m)
	{
		if (m.getMessage().equalsIgnoreCase("error"))
		{
			//do nothing if it returns an error
		}
		else if (m.getDestination().length() < 2)
		{
			//if the message destination is of improper length, return to sender with an error message
			m.errorReply(m);
		}
		else if (m.getDestination().substring(0,2).equalsIgnoreCase("Co"))
		{
			//the message is sent to [co]ntrolcenter
			read(m);
		}
//		else if (m.getDestination().substring(0, 2).equalsIgnoreCase("Me"))
//		{
//			//the message is sent to [me]nu brain
//			a.read(m);
//		}
//		else if (m.getDestination().substring(0,2).equalsIgnoreCase("Di"))
//		{
//			//the message is sent to [di]play brain
//			c.read(m);
//		}
		else
		{
			this.read(m);
		}
	}
	public void sendMessage(Message m1, Message m2)
	{
		//if there are two messages sent, check 
		if (m1.getMessage().equalsIgnoreCase("error"))
		{
			//do nothing if it returns an error
		}
		else if (m1.getDestination().length() < 2)
		{
			//if the message destination is of improper length, return to sender with an error message
			m1.errorReply(m1);
		}
		else if (m1.getDestination().substring(0, 2).equalsIgnoreCase("Ma"))
		{
			//the message is sent to [ma]stermind
			b.read(m1, m2);
		}
		else
		{
			m1.errorReply(m1);
		}
	}
	public void read(Message m)
	{
		//if message is addressed to Control Center
	}
}
