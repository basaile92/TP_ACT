
public class ColorReduction {

	public static void main (String[] args){

		Picture exemple = createExamplePicture();

	}
	
	public static Picture createExamplePicture(){
		
		Picture exemple = new Picture(5,5);
		for(int i = 0; i<5; i++){
			
			exemple.setColor(new Color(0), i, 0);
		}
		for(int i = 0; i<5; i++){
			
			exemple.setColor(new Color(20), i, 1);
		}
		exemple.setColor(new Color(100), 0, 2);
		exemple.setColor(new Color(132), 1, 2);
		exemple.setColor(new Color(164), 2, 2);
		exemple.setColor(new Color(164), 3, 2);
		exemple.setColor(new Color(180), 4, 2);

		for(int i = 0; i<5; i++){
			
			exemple.setColor(new Color(255), i, 3);
			exemple.setColor(new Color(255), i, 4);

		}
		return exemple;

	}
		
		
		
	
}
