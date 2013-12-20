#include "team.h"

using namespace std;

team::team(){
	pointsAgainst=0;
	pointsFor=0;
	leaguePoints=0;
}
team::team(string str){
	name=str;
	pointsAgainst=0;
	pointsFor=0;
	leaguePoints=0;
}

team::~team(){
// Add details
}

void team::print(){
	cout<<name<<endl;
}
