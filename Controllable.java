package PeanutCracker;

public interface Controllable 
{
	public abstract void read(Message m1);
	public abstract void read(Message m1, Message m2);
	public abstract void read(Message m1, Message m2, Message m3);
	public abstract void read(Message m1, Message m2, Message m3, Message m4);
}
