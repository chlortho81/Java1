private void playWithDates()
    {
    Calendar aDay = new GregorianCalendar();
    aDay.set(2007, Calendar.JANUARY, 25, 0, 0, 0);

    Calendar newYearsDay = new GregorianCalendar();
    newYearsDay.set(2007, Calendar.JANUARY, 1, 0, 0, 0);

    long nyd=newYearsDay.getTimeInMillis();
    long a=aDay.getTimeInMillis();
    long diff =a-nyd;
   
    System.out.println(diff/1000/60/60/24);
    }