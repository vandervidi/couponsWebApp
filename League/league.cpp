#include "league.h"

using namespace std;

league::league(vector<team> teamsToRegister)
{
	teams=teamsToRegister;

}

league::~league(){}


void league::setTeams(vector<team> teamsToSet)
{
teams=teamsToSet;
}

void league::init(vector<game> allGames)
{
	vector<team> tmpVectorOfTeams = getTeams(); 
	for(int i=0; i < tmpVectorOfTeams.size() ; i++)
	{
		for (int j=0; j < allGames.size(); j++)
		{
			if (tmpVectorOfTeams[i].getName().compare(allGames[j].getHomeGroup())==0 
				|| tmpVectorOfTeams[i].getName().compare(allGames[j].getAwayGroup())==0)
			{
				tmpVectorOfTeams[i].getGames().push_back(allGames[j]);
			}
		}

	}
}

void league::createLeagueTable(){
	int totalHomePoints;
	int totalAwayPoints;
	int totalLeaguePoints;
	vector<team> tmpVectorOfTeams= getTeams();

	// Create table
	cout<<"\nTeams"<<"\t\t\tGames"<<"\tTotal"<<"\tHome"<<"\tAway"<<endl;
	for(int g=1; g<=53; g++) cout<<"-";
	cout<<endl;

	for(int i=0; i < tmpVectorOfTeams.size(); i++) {
		totalHomePoints=0;
		totalAwayPoints=0;
		totalLeaguePoints=0;
		vector<game> thisTeamGames = tmpVectorOfTeams[i].getGames();
		int numberOfGames = tmpVectorOfTeams.size();
		for(int j=0 ; j< thisTeamGames.size(); j++)
		{
			if (tmpVectorOfTeams[i].getName().compare(thisTeamGames[j].getHomeGroup())==0)
			{
				//case[1] - This is the home group in the game
				totalHomePoints+=thisTeamGames[j].getHomeFinalScore();
				if (thisTeamGames[j].getHomeFinalScore()>thisTeamGames[j].getAwayFinalScore())
				{
					totalLeaguePoints+=2;
				}
			}
			else
			{
				//case[2] - This is the away group in the game
				totalAwayPoints+=thisTeamGames[j].getAwayFinalScore();
				if (thisTeamGames[j].getHomeFinalScore()<thisTeamGames[j].getAwayFinalScore())
				{
					totalLeaguePoints+=2;
				}
			}
		
		}
		
		cout<<tmpVectorOfTeams[i].getName()<<"\t\t\t"<<numberOfGames<<"\t"
			<<totalLeaguePoints<<"\t"<<totalHomePoints<<"\t"<<totalAwayPoints<<endl;
	}
	for(int g=1; g<=53; g++) cout<<"-";
	cout<<endl<<endl;

}

