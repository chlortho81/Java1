class ThreeDEC {
  public static void main(String args[]) {
    int list[][][] = new int[3][3][5];

    int i, j, k;
	int l = 0;

    for(i=0; i<3; i++)
	  {
      for(j=0; j<3; j++)
        for(k=0; k<5; k++)
        {
         list[i][j][k] = l;
		 l++;
        }
	   //l = 0; //uncomment to make 0-14 for all 3 buildings
	   }
    for(i=0; i<3; i++)
	  {
	  System.out.println("Building " + i + "\n");
      for(j=0; j<3; j++)
	    {
        for(k=0; k<5; k++) System.out.print(list[i][j][k] + " "); 
		System.out.println("\n");
		}
	  }
	
	//start EC3
	
		int[] divisors = { 7, 11, 13, 17 };
		int[] divisible = new int[divisors.length];
		
		for(i = 1; i<=100000; i++) {
			for( j = 0; j<divisors.length; j++) {
				if((i % divisors[j]) == 0) divisible[j] = i;
			}
		}
		
		for( i = 0; i<divisors.length; i++) {
			System.out.println("The largest number divisible by " + divisors[i] + " is " + divisible[i] + ".");
		}
  }

}
