#ifndef league_h_
#define league_h_
#include "team.h"
#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

class league {
	private:
		vector<team>* teams;

	public:
		vector<team>* getTeams(){return teams;}

		//ctor
		league(vector<team>* teamsToRegister);		
		//dtor
		~league();

		void init(vector<game>* allGames);
		void createLeagueTable();
		//void setTeams(vector<team> teamsToSet);
};


#endif