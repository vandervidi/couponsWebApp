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
	game getGame(string againstTeam, int round) {
		int index=0;
		while(index<games.size())
		{
			if (games.at(index).getAwayGroup().compare(againstTeam) && games.at(index).getRoundNum()==round)
				return games.at(index);
			else
				index++;
		}
		
		cout<<"The game "<<name<<"-"<<againstTeam<<" in round "<<round<<" does not exist"<<endl;
	}
	//game getGame(string againstTeam, int round) {
	//	int index=0;
	//	for each(game g in games)
	//	{
	//		if (g.getAwayGroup().compare(againstTeam) && g.getRoundNum()==round)
	//			return g;
	//		else
	//			index++;
	//	}
	//	cout<<"The game "<<name<<"-"<<againstTeam<<" in round "<<round<<" does not exist"<<endl;
	//}
};
#endif