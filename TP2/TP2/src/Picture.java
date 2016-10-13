
public class Picture {

	private int height;
	private int width;
	private Color[][] picture;
	
	public Picture(int height, int width){
	
		this.height = height;
		this.width = width;
		this.picture = new Color[height][width];
		
	}
	
	public void setColor(Color color, int x, int y){
		
		this.picture[x][y]= color;
	}
	
	public Color[][] getPicture(){
		
		return this.picture;
	}
		
	public int weightCalculate(Color color){
		
		int weight = 0;
		for(int i = 0; i< this.height; i++){
			for(int j = 0; j<this.width; j++){
				
				if(color.equals(this.picture[i][j])){
					weight++;
				}
			}
		}
		return weight;
	}
	
	public int meilleurGris(int min, int max){
		
		int res = 0;
		int totalWeight = 0;
		int[] tab = new int[max-min];
		for(int i = 0; i< max-min; i++){
			
			tab[i] = this.weightCalculate(new Color(i));
		}
		for(int i = 0; i < max-min; i++){
			
			res += (min + i) * tab[i]; 
			totalWeight += tab[i];
		}
		
		return res/totalWeight;
	}
	
	public int distanceMin(int min, int max){
		
		int res = 0;
		int[] tab = new int[max-min];
		int meilleurGris = this.meilleurGris(min, max);
		for(int i = 0; i<this.height; i++){
			
			for(int j = 0; j< this.height; j++)
			{
				if(this.picture[i][j].getGris()<max && this.picture[i][j].getGris()>=min)
				{
					res += ((this.picture[i][j].getGris() - meilleurGris) * (this.picture[i][j].getGris() - meilleurGris)) * this.weightCalculate(this.picture[i][j]);
				}	
			}
		}
		
		return res;
		
	}

	//Complexité = O(n^k)
	public int[] distanceImage(int colorNbr)
	{
		int min = 0;
		int max = 0;
		int[] tab;
		int distance_min = 9999;

		tab[0] = 0;
		for (int i = 1; i <= colorNbr; i++){
			for (int j = min + 1; j < 256; j++){
				if (distanceMin(min,j) < distance_min){
					distance_min = distanceMin(min,j);
					max = j;
				}
			}
			min = max + 1;
			tab[i] = max;
		}
		return tab;
	}
	
	
}
