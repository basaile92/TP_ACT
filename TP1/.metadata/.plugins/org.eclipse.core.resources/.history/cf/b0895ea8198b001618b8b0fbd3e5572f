package ressources;

import java.util.ArrayList;
import java.util.Comparator;

public class Rectangle {
	
	private ArrayList<Point> pointList;
	private int hauteurMax;
	private int largeurMax;
	
	public Rectangle(ArrayList<Point> pointList, int hauteurMax, int largeurMax){
		 
		this.pointList = pointList;
		pointList.sort(new Comparator<Point>(){

			@Override
			public int compare(Point o1, Point o2) {

				if(o1.getX()<o2.getX())
				{
					return -1;
				}else if(o1.getX()==o2.getX())
				{
					return 0;
				}else
					return 1;
			}
		});
		this.hauteurMax = hauteurMax;
		this.largeurMax = largeurMax;
		this.pointList.add(0, new Point(0, 0));
		this.pointList.add(this.pointList.size(), new Point(this.largeurMax, 0));
	}
	
	public int getBiggestAreaRectangle(){
		boolean verif;
		int area = 0;
		int h, l, z;
		int n = pointList.size();
		for(int i = 0; i < n - 1; i++){
			
			for(int j = i + 1; j < n; j++){
				
				verif = true;
				l = pointList.get(j).getX()-pointList.get(i).getX();
				h = max(pointList.get(i).getY(), pointList.get(j).getY());
				if(i + 1 < j){
					
					z = this.hauteurMax;
					for(int k = i + 1; k < j; k++)
					{
						
						if(pointList.get(k).getY() > h){
							if(pointList.get(k).getY() < z){
								
								z = pointList.get(k).getY();
							}
						}else
							verif = false;
					}
					
					h = z;
				}else
				{
					h = this.hauteurMax;
				}
				if( area < l * h && verif){
					
					area = l * h;
				}
			}
		}
		
		return area;
	}
	
	public int getBiggestAreaRectangleRec(){
		
		return auxGetBiggestAreaRectangleRec(0, this.pointList.size()-1);
	}
	
	private int auxGetBiggestAreaRectangleRec(int beginX, int endX){
				
		if(beginX == endX-1){
			
			return (this.hauteurMax * (this.pointList.get(endX).getX() - this.pointList.get(beginX).getX()));
		}else
		{
			int lowestY = this.pointList.get(beginX + 1).getY();
			int xOfLowestY = this.pointList.get(beginX + 1).getX();
			int area;
			for(int i = beginX + 1; i< endX; i++){
			
				if(this.pointList.get(i).getY() <= lowestY){
					
					lowestY = this.pointList.get(i).getY();
					xOfLowestY = i;
				}
			}
			
			area = (this.pointList.get(endX).getX() - this.pointList.get(beginX).getX()) * lowestY;
			return (biggest(auxGetBiggestAreaRectangleRec(beginX, xOfLowestY), auxGetBiggestAreaRectangleRec(xOfLowestY, endX), area));
			
		}
}
	
	private int biggest(int a, int b, int c){
		
		if(a >= b && a >= c) return a;
		else if(b >= a && b >= c) return b;
		else if(c >= a && c >= b) return c;
		else return (-1);
	}
	
	
	private int max(int i, int j){
		
		if(i<=j){
			return j;
		}else
			return i;
	}
	
	
	
}
