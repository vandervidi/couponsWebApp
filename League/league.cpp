#include "league.h"

using namespace std;
//ctor
league::league(vector<team>* teamsToRegister)
{
	teams=teamsToRegister;

}
//dtor
league::~league(){}


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
			}
		}

	}
}

void league::createLeagueTable(){
	vector<team>* tmpVectorOfTeams = getTeams(); 

	//sort teams vector
	int sz = tmpVectorOfTeams->size();
	for (int i = 0; i < sz; i++){
		for (int j = i+1; j < sz; j++){
			if (tmpVectorOfTeams->at(i).getLeaguePoints() < tmpVectorOfTeams->at(j).getLeaguePoints()){
				team tmp;
				tmp = tmpVectorOfTeams->at(i);
				tmpVectorOfTeams->at(i) = tmpVectorOfTeams->at(j);
				tmpVectorOfTeams->at(j) = tmp;
			}
		}
	}
	// Create table head
	//cout<<"\nTeams"<<"\t\t\tGames"<<"\tTotal"<<"\tHome"<<"\tAway"<<endl;
	//for(int g=1; g<=53; g++) cout<<"-";
	//cout<<endl;
	cout<<left<<setw(20)<<"Team"<<setw(10)<<"Games"<<setw(10)<<"Points"<<setw(10)<<"Total"<<setw(10)<<"Score"<<endl;
	cout<<setfill('-')<<setw(60)<<'-'<<setfill(' ')<<endl;
	for(int i=0; i < tmpVectorOfTeams->size(); i++) {
		cout << left << setw(20) <<tmpVectorOfTeams->at(i).getName()
					 << setw(10) <<tmpVectorOfTeams->at(i).getGames()->size()
					 << setw(10) <<tmpVectorOfTeams->at(i).getLeaguePoints()
					 << setw(10) <<tmpVectorOfTeams->at(i).getPointsFor()
					 << setw(10) <<tmpVectorOfTeams->at(i).getPointsAgainst()<<endl;



		/*cout<<tmpVectorOfTeams->at(i).getName()<<"\t\t\t"<<tmpVectorOfTeams->at(i).getGames()->size()<<"\t"
			<<tmpVectorOfTeams->at(i).getLeaguePoints()<<"\t"<<tmpVectorOfTeams->at(i).getPointsFor()
			<<"\t"<<tmpVectorOfTeams->at(i).getPointsAgainst()<<endl;*/
	}
}

