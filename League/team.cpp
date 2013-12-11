#include "team.h"

using namespace std;

team::team()
{
	pointsAgainst=0;
	pointsFor=0;
	leaguePoints=0;
}
team::team(string str)
{
	name=str;
	pointsAgainst=0;
	pointsFor=0;
	leaguePoints=0;
}

team::~team(){}

void team::print()
{
	cout<<name<<endl;
}
	void team::setName(string str){
		name=str;
	}
	string team::getName(){
		return name;
	}
	void team::setPointsFor(int p){
		pointsFor=p;
	}
	int team::getPointsFor(){
		return pointsFor;
	}
	void team::setPointsAgainst(int p){
		pointsAgainst=p;
	}
	int team::getPointsAgainst(){
		return pointsAgainst;
	}
	void team::setLeaguePoints(int p){
		leaguePoints=p;
	}
	int team::getLeaguePoints(){
		return leaguePoints;
	}

