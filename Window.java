package PeanutCracker;

public class Window 
{
	double xmin;
	double xmax;
	double xres = 1;
	double ymin;
	double ymax;
	double yres = 1;
	public Window()
	{
		this(-10, 10, -10, 10);
	}
	public Window(double xmin, double xmax)
	{
		this(xmin, xmax, -10, 10);
	}
	public Window(double xmin, double xmax, double ymin, double ymax)
	{
		this(xmin, xmax, 1, ymin, ymax, 1);
	}
	public Window(double xmi, double xma, double xre, double ymi, double yma, double yre)
	{
		reSizeWindow(xmi, xma, xre, ymi, yma, yre);
	}
	public void reSizeWindow(double xmi, double xma, double xre, double ymi, double yma, double yre)
	{
		xmin = xmi;
		xmax = xma;
		xres = xre;
		ymin = ymi;
		ymax = yma;
		yres = yre;
	}
	public void reSizeWindow(boolean XorY, double min, double max, double res)
	{
		if (XorY)
		{
			xmin = min;
			xmax = max;
			xres = res;
		}
		else
		{
			ymin = min;
			ymax = max;
			yres = res;
		}
	}
	public double getXmin() 
	{
		return xmin;
	}
	public void setXmin(double xmin) 
	{
		this.xmin = xmin;
	}
	public double getXres() 
	{
		return xres;
	}
	public void setXres(double xres) 
	{
		this.xres = xres;
	}
	public double getYmin() 
	{
		return ymin;
	}
	public void setYmin(double ymin) 
	{
		this.ymin = ymin;
	}
	public double getYmax() 
	{
		return ymax;
	}
	public void setYmax(double ymax) 
	{
		this.ymax = ymax;
	}
	public double getYres() 
	{
		return yres;
	}
	public void setYres(double yres) 
	{
		this.yres = yres;
	}
	public double getXmax() 
	{
		return xmax;
	}
}
