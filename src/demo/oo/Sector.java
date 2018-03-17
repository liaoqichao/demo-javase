package demo.oo;
import java.text.DecimalFormat;

public class Sector extends Graph {

	private double radius;
	private double angle;
	private double radian;
	DecimalFormat df =new DecimalFormat("######0.00");
	
	
	Sector(){
		this(1,30);
	}
	
	
	Sector(double angle){
		radius = 1;
		this.angle = angle;
		radian = angle*Math.PI*radius/180;
	}
	
	Sector(double radius , double angle){	
		this.radius = radius;
		this.angle = angle;
		radian = angle*Math.PI*radius/180;	// »¡³¤=n¦Ðr/180;
	}
	@Override
	public String getPerimeter() {
		// TODO Auto-generated method stub
		if(angle == 360)
			return df.format(radian);
		else
			return df.format(2*radius+radian);
	}

	@Override
	public String getArea() {
		// TODO Auto-generated method stub
		return df.format(radius*radian/2);
	}
	public double getRadius(){
		return radius;
	}
	public  double getAngle(){
		return angle;
	}
	public  String getRadian(){
		return df.format(radian);
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public void setAngle(double angle) {
		this.angle = angle;
	}


	public void setRadian(double radian) {
		this.radian = radian;
	}
	

}
