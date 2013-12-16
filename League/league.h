#ifndef league_h_
#define league_h_
#include "team.h"
#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

class league {
	private:
		vector<team> teams;

	public:
		vector<team> getTeams(){return teams;}

		//ctor
		league(vector<team> teamsToRegister);		
		//dtor
		~league();



		void league::init(vector<game> &allGames)
		{
			vector<team> tmpVectorOfTeams = getTeams(); 
			for(int i=0; i < tmpVectorOfTeams.size() ; i++)
			{
				for (int j=0; j < allGames.size(); j++)
				{
					if (tmpVectorOfTeams[i].getName().compare( allGames[j].getHomeGroup())==0 
						|| tmpVectorOfTeams[i].getName().compare(allGames[j].getAwayGroup())==0)
					{
						tmpVectorOfTeams[i].getGames().push_back(&allGames[j]);
					}
				}
		
			}
		}




		void createLeagueTable();
		void setTeams(vector<team> teamsToSet);
};


#endif