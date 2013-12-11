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
	vector<game> games;
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

	void setGames();
	vector<game> getGames();
	void setName(string str);
	string getName();
	void setPointsFor(int p);
	int getPointsFor();
	void setPointsAgainst(int p);
	int getPointsAgainst();
	void setLeaguePoints(int p);
	int getLeaguePoints();
	void print();

};
#endif