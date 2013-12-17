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
<<<<<<< HEAD
		vector<team> getTeams()		{return teams;}
=======
		vector<team>* getTeams(){return teams;}
>>>>>>> 982f6c383a05e9917033a650584dfb26cc2bd170

		//ctor
		league(vector<team>* teamsToRegister);		
		//dtor
		~league();

<<<<<<< HEAD
		void league::init(vector<game> *allGames);
=======
		void init(vector<game>* allGames);
>>>>>>> 982f6c383a05e9917033a650584dfb26cc2bd170
		void createLeagueTable();
		//void setTeams(vector<team> teamsToSet);
};


#endif