package shuffles;

import java.util.Random;

public class KnuthShuffle {

	
	public static void shuffle(Comparable[] items){
		
		for(int i = 0; i < items.length;i++){
			
			Random random = new Random();
			int r = random.nextInt(i+1);
			//System.out.println("Random r is "+r);
			ShuffleUtils.exchange(items, i, r);
		}
	}
}
