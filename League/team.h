#ifndef team_h_
#define team_h_

#include "game.h"
#include <iostream>
#include <vector>
#include <string>

using namespace std;

class team
{
private:
	vector<game*> games;
	string name;
	int pointsFor;
	int pointsAgainst;
	int leaguePoints;
public:
	//ctor
	team();
	team(string str);
	//dtor
	~team();

	void setGames(vector<game*> gamesVector) {games=gamesVector;}
	vector<game*>* getGames()						{return &games;}
	void setName(string str)				{name=str;}
	string getName()							 {return name;}
	void setPointsFor(int p)				{pointsFor=p;}
	int getPointsFor()							 {return pointsFor;}
	void setPointsAgainst(int p)			{pointsAgainst=p;}
	int getPointsAgainst()						 {return pointsAgainst;}
	void setLeaguePoints(int p)				{leaguePoints=p;}
	int getLeaguePoints()						 {return leaguePoints;}
	void print();

};
#endif