#include <stdio.h>
#include <stdlib.h>

int main() {
    
    int day,month,year,nextDay,nextMonth,nextYear;
    
    printf("Enter a date (0 0 0 to quit) : ");
    scanf("%d %d %d",&day,&month,&year);
    
    printf("\nYour date is : \t%d.%d.%d\n",day,month,year);
    
    if (month % 2!=0 && month>1 && month<=7 && day==31)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if(month % 2==0 && month>=8 && month<=12 && day==31)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if(month % 2==0 && month>=4 && month<=6 && day==30)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if (month % 2!=0 && month>=9 && month<=11 && day==30)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if (month==2 && year % 4==0 && day==29)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if (month==2 && year % 4!=0 && day==28)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if (month==12 && day==31)
    {
        nextDay = 1;
        nextMonth = month+1;
        nextYear = year;
    }else if (day==0 && month==0 && year==0){
        printf("\nThis is not a valid date!\n");
        exit(0);
    }else{
        nextDay = day+1;
        nextMonth = month;
        nextYear = year;
    }
    
    printf("\nThe next day of %d.%d.%d is %d.%d.%d\n",day,month,year,nextDay,nextMonth,nextYear);
    
    return 0;
}
