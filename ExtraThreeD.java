/*	ExtraThreeD
	Tom McManus
	Extra Credit Assignment Week 5
	IT-4286
	August 10, 2009 
*/
class ExtraThreeD 
{
	public static void main(String args[]) 
	{

		int list[][][] = new int[3][5][3];

		// what we have are mailboxes 3 rows by 5 columns
		// they are found in 3 apartment buildings
		int i, j, k;// to address the row, column and apartment bldg
					// of all the mailboxes !!!!
		
		int count = 0;
					
		// load by row,column and apartment bldg.
		for(k=0; k<3; k++) //apartment bldg.
		{
			for(i=0; i<3; i++)//row
			{
				for(j=0; j<5; j++)//column
				{
					list[i][j][k] = count++;
				}// for k
			}// for j
			count = 0;
		}// for i

		for(k=0; k<3; k++) //apartment bldg.
		{
			System.out.println("Building " + k + "\n");
			for(i=0; i<3; i++)//row
			{
				for(j=0; j<5; j++)//column
				{
					System.out.print(list[i][j][k] + " ");
				}// for k
				
				System.out.println("\n");
			}// for j
		}// for i
	}// main
}// ThreeD