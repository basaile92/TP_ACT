package ressources;

import java.util.ArrayList;

public class Rectangle {
	
	private ArrayList<Point> pointList;
	private int hauteurMax;
	private int largeurMax;
	
	public Rectangle(ArrayList<Point> pointList, int hauteurMax, int largeuxMax){
		 
		this.pointList = pointList;
		this.hauteurMax = hauteurMax;
		this.largeurMax = largeurMax;
	}
	
	public int getBiggestAreaRectangle(){
		boolean verif;
		int area = 0;
		Point x, y;
		int h, l, z;
		int n = pointList.size();
		for(int i = 0; i < n - 1; i++){
			
			for(int j = i + 1; j < n; j++){
				
				verif = true;
				x = pointList.get(i);
				y = pointList.get(j);
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
	
	private int max(int i, int j){
		
		if(i<=j){
			return j;
		}else
			return i;
	}
	
}
