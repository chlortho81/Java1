
// An improved version of the season program.
class Switch_Ex {
    public static void main(String args[]) {
        int month;
        String season =""; //notice I initialized the String variable
		String month_name[]={"","Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec","",""};
        
		for(month = 1;month <=14;++month)
		switch (month) {
          case 12: 
          case 1: 
          case 2:
            season = "Winter";
			System.out.println(month_name[month] +" is in the " + season + ".");    
            break;
          case 3: 
          case 4: 
          case 5:
            season = "Spring";
			System.out.println(month_name[month] +" is in the " + season + ".");    
            break;
          case 6: 
          case 7: 
          case 8:
            season = "Summer";
			System.out.println(month_name[month] +" is in the " + season + ".");    
           break;
          case 9: 
          case 10: 
          case 11:
            season = "Autumn";
			System.out.println(month_name[month]+" is in the " + season + ".");    
            break;
          default:
            season = "Bogus Month";
System.out.println(month_name[month]+" is in the " + season + ".");
break;
        }
//System.out.println("April is in the " + season + ".");        
    }
}
