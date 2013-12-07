#ifndef team_h_
#define team_h_

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
	team()
	{

	}

	game getGame(string againstTeam, int round)
	{
		int index=0;
		while(index<games.size())
		{
			if (games[index].getAwayGroup.comapre(againstTeam) && games[index].getRoundNum==round)
				return games[index];
			else
				index++;
		}
		
		cout<<"The game "<<name<<"-"<<againstTeam<<" in round "<<round<<" does not exist"<<endl;
	}

};
#endif