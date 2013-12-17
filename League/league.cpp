#include "league.h"

using namespace std;

league::league(vector<team>* teamsToRegister)
{
	teams=teamsToRegister;

}

league::~league(){}



<<<<<<< HEAD
void league::init(vector<game> *allGames) {
	vector<team> tmpVectorOfTeams = getTeams(); 
	for(int i=0; i < tmpVectorOfTeams.size() ; i++)
	{
		for (int j=0; j < allGames->size(); j++)
		{
			if (tmpVectorOfTeams[i].getName().compare( allGames->at(j). getHomeGroup())==0 
				|| tmpVectorOfTeams[i].getName().compare( allGames->at(j).getAwayGroup())==0)
			{
				tmpVectorOfTeams.at(i).getGames().push_back( &allGames->at(j) );
=======

void league::init(vector<game>* allGames)
{
	int tmp;
	vector<team>* tmpVectorOfTeams = getTeams(); 
	for(int i=0; i < tmpVectorOfTeams->size() ; i++)
	{
		for (int j=0; j < allGames->size(); j++)
		{
			if (tmpVectorOfTeams->at(i).getName().compare(allGames->at(j).getHomeGroup())==0 
				|| tmpVectorOfTeams->at(i).getName().compare(allGames->at(j).getAwayGroup())==0)
			{
				tmpVectorOfTeams->at(i).getGames()->push_back(&allGames->at(j));
				//if this team is the host
				if (tmpVectorOfTeams->at(i).getName().compare(allGames->at(j).getHomeGroup())==0 )
				{   
					//updating points For this team:
					tmp=tmpVectorOfTeams->at(i).getPointsFor();
					tmp+=allGames->at(j).getHomeFinalScore();
					tmpVectorOfTeams->at(i).setPointsFor(tmp);
					//updating points agains this team:
					tmp=tmpVectorOfTeams->at(i).getPointsAgainst();
					tmp+=allGames->at(j).getAwayFinalScore();
					tmpVectorOfTeams->at(i).setPointsAgainst(tmp);
					if(allGames->at(j).getHomeFinalScore() > allGames->at(j).getAwayFinalScore())
					{
						tmp=tmpVectorOfTeams->at(i).getLeaguePoints();
						tmp+=2;
						tmpVectorOfTeams->at(i).setLeaguePoints(tmp);
					}
					else
					{
						tmp=tmpVectorOfTeams->at(i).getLeaguePoints();
						tmp+=0;
						tmpVectorOfTeams->at(i).setLeaguePoints(tmp);
					}
				}
				else
				{
				// in cas this team is the away team:
					//updating points For this team:
					tmp=tmpVectorOfTeams->at(i).getPointsFor();
					tmp+=allGames->at(j).getAwayFinalScore();
					tmpVectorOfTeams->at(i).setPointsFor(tmp);
					//updating points agains this team:
					tmp=tmpVectorOfTeams->at(i).getPointsAgainst();
					tmp+=allGames->at(j).getHomeFinalScore();
					tmpVectorOfTeams->at(i).setPointsAgainst(tmp);
					if(allGames->at(j).getHomeFinalScore() < allGames->at(j).getAwayFinalScore())
					{
						tmp=tmpVectorOfTeams->at(i).getLeaguePoints();
						tmp+=2;
						tmpVectorOfTeams->at(i).setLeaguePoints(tmp);
					}
					else
					{
						tmp=tmpVectorOfTeams->at(i).getLeaguePoints();
						tmp+=0;
						tmpVectorOfTeams->at(i).setLeaguePoints(tmp);
					}

				}
>>>>>>> 982f6c383a05e9917033a650584dfb26cc2bd170
			}
		}
		
	}
}

void league::createLeagueTable(){
	vector<team>* tmpVectorOfTeams = getTeams(); 
	// Create table head
	cout<<"\nTeams"<<"\t\t\tGames"<<"\tTotal"<<"\tHome"<<"\tAway"<<endl;
<<<<<<< HEAD
	for(int g=1; g<=53; g++) cout<<"-";
	cout<<endl;

	for(int i=0; i < tmpVectorOfTeams.size(); i++) {
		totalHomePoints=0;
		totalAwayPoints=0;
		totalLeaguePoints=0;
		vector<game*> thisTeamGames = tmpVectorOfTeams[i].getGames();
		int numberOfGames = tmpVectorOfTeams.size();
		for(int j=0 ; j< thisTeamGames.size(); j++)
		{
			if (tmpVectorOfTeams[i].getName().compare(thisTeamGames[j]->getHomeGroup())==0)
			{
				//case[1] - This is the home group in the game
				totalHomePoints+=thisTeamGames[j]->getHomeFinalScore();
				if (thisTeamGames[j]->getHomeFinalScore() > thisTeamGames[j]->getAwayFinalScore())
				{
					totalLeaguePoints+=2;
				}
			}
			else
			{
				//case[2] - This is the away group in the game
				totalAwayPoints+=thisTeamGames[j]->getAwayFinalScore();
				if (thisTeamGames[j]->getHomeFinalScore()<thisTeamGames[j]->getAwayFinalScore())
				{
					totalLeaguePoints+=2;
				}
			}
		
		}
		
		cout<<tmpVectorOfTeams[i].getName()<<"\t\t\t"<<numberOfGames<<"\t"
			<<totalLeaguePoints<<"\t"<<totalHomePoints<<"\t"<<totalAwayPoints<<endl;
=======
	//for(int g=1; g<=53; g++) cout<<"-";
	//cout<<endl;
	for(int i=0; i < tmpVectorOfTeams->size(); i++) {
		cout<<tmpVectorOfTeams->at(i).getName()<<"\t\t\t"<<tmpVectorOfTeams->at(i).getGames()->size()<<"\t"
			<<tmpVectorOfTeams->at(i).getLeaguePoints()<<"\t"<<tmpVectorOfTeams->at(i).getPointsFor()
			<<"\t"<<tmpVectorOfTeams->at(i).getPointsAgainst()<<endl;
>>>>>>> 982f6c383a05e9917033a650584dfb26cc2bd170
	}
}

