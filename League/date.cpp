#include "date.h"
using namespace std;

Date::Date(){
        year=0;
        month=0;
        day=0;
}

//Date::Date(Date& date){
//        year=date.year;
//        month=date.month;
//        day=date.day;
//}

Date::Date(int d, int m, int y){
        year=y;
        month=m;
        day=d;
}

void Date::operator+=(int pInMonth){
        month += pInMonth;
        if (month>12) {
                year += (month-1)/12;
                month = (month-1)%12+1;
        }
}

Date & Date::operator+=(const Date & ddd){
        day += ddd.day;
        month+= ddd.month;
        year+= ddd.year;
        if (day>30){
                month += (day-1)/30;
                day = (day-1)%30+1;
        }
        if (month>12) {
                year += (month-1)/12;
                month = (month-1)%12+1;
        }
        return *this;
}

Date & Date::operator=(const Date & ddd){
        year=ddd.year;
        month=ddd.month;
        day=ddd.day;
        return *this;
}

int Date::operator==(const Date & ddd){
        if (year==ddd.year && month==ddd.month && day==ddd.day)
                return 1;
        else
                return 0;
}

bool Date::operator>(const Date &d) const
{
	
		if (year>d.year)
		{
			return true;
		}

		else if((year>d.year && month>d.month)|| (year==d.year && month>d.month))
		{
			return true;
		}

		else if((year>d.year && month>d.month && day>d.day)||((year==d.year && month==d.month && day>d.day)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


bool Date::operator>=(const Date &d) const
{
	if (year==d.year && month==d.month && day==d.day )
		return true;
	else
	{
		if (year>d.year)
		{
			return true;
		}

		else if(year==d.year && month>d.month)
		{
			return true;
		}

		else if(year==d.year && month==d.month && day>d.day)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
ofstream & operator<< (ofstream & Fout, Date & d){
        Fout<<d.day<<"."<<d.month<<"."<<d.year<<endl;
        return Fout;
}