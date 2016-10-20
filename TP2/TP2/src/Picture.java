
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
	
	public Color meilleurGris(int min, int max){
		
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
		
		return new Color(res/totalWeight);
	}
	
	public int distanceMin(int min, int max){
		
		int res = 0;
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
<<<<<<< HEAD
		int[] tab = new int[colorNbr + 1];
=======
		int[] tab;
>>>>>>> c5d67bc6d382d4777801203db522f302fb8a74fc
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
<<<<<<< HEAD
		}
		return tab;
	}
	
	public Couple[] intervalles(int colorNbr){
		int[] tab = distanceImage(colorNbr);
		Couple[] inter = new Couple[colorNbr];
		for (int i = 0; i < colorNbr-1; i++){
			if (i == 0)
				inter[i].setX(tab[i]);
			else
				inter[i].setX(tab[i] + 1);
			inter[i].setY(tab[i+1]);
		}
		return inter;
	}
	
	public Picture fusionnerIntervalle(int colorNbr){
		Picture pixels = new Picture(this.height, this.width);
		
		Couple[] intervalles = this.intervalles(colorNbr);
		Color[] gris = new Color[colorNbr];
		
		for (int k = 0; k < colorNbr; k++){
			gris[k] = pixels.meilleurGris(intervalles[k].getX(), intervalles[k].getY());
		}
		
		for (int i = 0; i < this.height; i++){
			for (int j = 0; j < this.width; i++){
				int c = 0;
				while (this.picture[i][j].getGris() < intervalles[c].getY()){
					c++;
				}
				pixels.getPicture()[i][j] = gris[c];
			}
		}
		
		return pixels;
=======
		}
		return tab;
>>>>>>> c5d67bc6d382d4777801203db522f302fb8a74fc
	}
	
	
}
