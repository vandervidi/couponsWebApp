#include <vector>
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
#include "team.h"
#include "league.h"
#include "game.h"
using namespace std;

//Team members : Vidran Abdovich - 312064829, Ofir Aghai -
//-----------------------------------------------//
//The methods 'sort' - sorts lexicoraphically	//
//a vector of strings using quick sort algorithm//
//and then prints the vector as an output.		//
//----------------------------------------------	//
void sort(vector<string> v){
	int sz = v.size();
	for (int i = 0; i < sz; i++){
		for (int j = i+1; j < sz; j++){

			if (v[i].compare(v[j]) > 0){

				string tmp;

				tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
	}
	for (int i = 0; i < sz; i++){
		cout<<i+1<<". "<<v[i]<<endl;
	}
}


//------------------------------------------------//
// before sending to splitStr()					  //
// from "aab. tr, ew, .sdff" => "aab tr ew sdff"  //
// for ex. delimetersRemover(str, ",.()\0", ' ' );//			
//will delete "."   ","   "("   ")"				  //
//we need to write '\0' at the end				  //
//------------------------------------------------//
string delimetersRemover(string str, string delimitersVector, char to ){		
	//for (int i=0; i<delimitersVector.size(); i++){
	int i=0;
	while (i < delimitersVector.size()){
		//change from "*" => " "
		size_t found1 = str.find_first_of(delimitersVector[i]);
		while (found1!= string::npos){
			str[found1]=to;
			found1=str.find_first_of(delimitersVector[i], found1+1);
		}
		i++;
	}
	return str;
}

//-----------------------------------------------//
//This methods 'splitStr' recives a string type	//
//and returns a vector of strings where each	//
//index stores a word from the sentence that is //
//splitted.										//
//----------------------------------------------	//
vector<string> splitStr(string str){
	string buf;				
	stringstream ss(str);	
	vector<string> tokens;	// Create vector to hold our words

	while (ss >> buf)
		tokens.push_back(buf);

	return tokens;
}

//-----------------------------------------------//
//This methods 'chck_input' recieces users input//
//and directs it to the correct case in the		//
//Switch/Case menu.								//
//----------------------------------------------	//
int check_input(string str)
{
	// check empty string
	if (str == "" || str == "\n") 
		return -1;

	vector<string> tokenized = splitStr(str);

	//In terminal - 'show teams'
	if (tokenized[0]=="show" && tokenized[1]=="teams") {
		return 1;
	}
	// In terminal - 'show league'
	else if (tokenized[0]=="show" && tokenized[1]=="league") {
		return 2;
	}

	//In terminal - 'help'
	else if (tokenized[0]=="help") {
		return 5;
	}
	//Admin cases are equal to 10+
	//In terminal - 'register teams'
	else if (tokenized[0]=="register" && tokenized[1]=="teams") {
		return 10;
	}

	//In terminal - for ex. 'game 1, oct. 27, 2013'
	else if (tokenized[0]== "game" && tokenized.size()>=5){		//size of words
		return 11;
	}
	// //In terminal - 'exit'
	else if(tokenized[0]=="exit"){
		return 777;
	}

	// return -1 if command is not vaild
	return -1;
}

void addTeam() {
	//Adds a team. Two things happen next.
	//(-) The team name is appended to the file teams.db.
	//(-) The team is appended to the league.db file and all its league
	//	   parameters are reset to zero.(Points, number of games ..)
	cout<<"Enter team name:"<<endl;
	ofstream outputToTeamsDb;
	string tmp;
	outputToTeamsDb.open("teams.db", ios_base::app);
	getline(cin,tmp);
	while(tmp.compare(";")!=0){
		outputToTeamsDb<<tmp<<endl;
		getline(cin,tmp);
	}	

	outputToTeamsDb.close();
}

//A method that writes a string to games.db file//
void writeToGamesDB(string str)
{
	ofstream of;
	of.open("games.db", ios_base::app);
	of<<str<<endl;
	of.close();
}

// This method converts a string containing a	//
// a month name in its shorter version, into an //
// integer type .e.g OCT -> 10					//
int monthToInt(string month)
{
	if (month.compare("JAN")==0) {return 1;}
	else if (month.compare("FEB")==0) {return 2;}
	else if (month.compare("MAR")==0) {return 3;}
	else if (month.compare("APR")==0) {return 4;}
	else if (month.compare("MAY")==0) {return 5;}
	else if (month.compare("JUN")==0) {return 6;}
	else if (month.compare("YUL")==0) {return 7;}
	else if (month.compare("AUG")==0) {return 8;}
	else if (month.compare("SEP")==0) {return 9;}
	else if (month.compare("OCT")==0) {return 10;}
	else if (month.compare("NOV")==0) {return 11;}
	else if (month.compare("DEC")==0) {return 12;}

	else if (month.compare("jan")==0) {return 1;}
	else if (month.compare("feb")==0) {return 2;}
	else if (month.compare("mar")==0) {return 3;}
	else if (month.compare("apr")==0) {return 4;}
	else if (month.compare("may")==0) {return 5;}
	else if (month.compare("jun")==0) {return 6;}
	else if (month.compare("Jul")==0) {return 7;}
	else if (month.compare("aug")==0) {return 8;}
	else if (month.compare("sep")==0) {return 9;}
	else if (month.compare("oct")==0) {return 10;}
	else if (month.compare("nov")==0) {return 11;}
	else if (month.compare("dec")==0) {return 12;}
	else return -1;
}

//This method reads to teams.db file and outputs //
//to the screen a list of all registered games	 //

void showTeams(){
	string teamName;
	ifstream fileReader;
	fileReader.open("teams.db");
	vector<string> tmp;
	while(getline(fileReader,teamName)) {
		tmp.push_back(teamName);
	}
	cout<<"There are "<<tmp.size()<<" teams in this league:"<<endl;
	sort(tmp);
}

void help(){
	ifstream fileReader;
	string tmp;
	fileReader.open("help.txt");
	while(getline(fileReader,tmp)) {
		cout<<tmp<<endl;
	}
	fileReader.close();
}

// create from line "Game x, mon. xx, xxxx" game object
game saveGameDetailsTemp(vector<string> lineVector){
	Date roundDate = Date();
	
	// RoundNumber
	int round = stoi( lineVector[1] ); //convert from string to int

	// Month
	int month = monthToInt( lineVector[2] );					//change from month(string) to (int)
	if (month>=1 && month<=12)
		roundDate.month = month;
	
	// Day
	int day = stoi( lineVector[3] );
	if (day>=1 && day<=31)
		roundDate.day = day;

	// Year
	int year = stoi( lineVector[4] );
	if (year>0)
		roundDate.year = year;

	//save Game temp details
	game tempDetails = game(round, roundDate);
	//..
	return tempDetails;
}

game functionToCreateNewGameObject(string str , game& gameTempDetails, bool writeToFile){
	str = delimetersRemover(str, (".,()\0"), ' ' );			//change from "." and "," to=> ' ' (space)
	vector<string> lineVector = splitStr(str);				//make vector from string

	//save Game temp details
	game newGame = game();
	int index=-1;

	//----(
	// Find and create teamA name
	for each (string s in lineVector) {
		if (s== "-"){
			break;
		}else{
			index++;
		}
	}
	if (index>-1){	//check for valid input
		//vector <string> teamA;
		string teamA_name;
		teamA_name.clear();
		for (int i=0; i<=index; i++){
			if (teamA_name.size()==0)
				teamA_name =lineVector[i];					
			else teamA_name +=" "+lineVector[i];
		}
		delimetersRemover(teamA_name, "-\0", ' ');
		newGame.setHomeGroup(teamA_name);
	}
	//----)

	//----( Way-2
	// Find and create teamB name
	string teamB_name;
	teamB_name.clear();
	//index+=2;	
	
	// remove from vector teamA name and "-"
	lineVector.erase( lineVector.begin(),lineVector.begin()+index+2 );

	//romeve all "-" from the string and create new string from that and split that to vector with splitStr()
	string s="";
	for (index=0; index< lineVector.size(); index++){
		lineVector.at(index) = delimetersRemover(lineVector.at(index), ("-\0"), ' ' );			//change from "." and "," to=> ' ' (space)	
		if (s.size()==0)
				s =lineVector.at(index);					
			else s +=" "+lineVector.at(index);
	}
	lineVector = splitStr(s);

	//identify the nameB
	for (index=0; index<lineVector.size(); index++) {
		if ( atoi(lineVector[index].c_str()) ==0 ) {
			if (teamB_name.size()==0)
				teamB_name =lineVector[index];					
			else teamB_name +=" "+lineVector[index];
		}
		else{
			break;
		}
	}
	newGame.setAwayGroup(teamB_name);
	//----)

	//----(
	// check teams scores & extensions
	newGame.setHomeFinalScore( atoi(lineVector[index].c_str()) );
		
	index++;
	newGame.setAwayFinalScore( atoi(lineVector[index].c_str()) );
		
	index++;
	newGame.setHomeMidScore( atoi(lineVector[index].c_str()) );
		
	index++;
	newGame.setAwayMidScore( atoi(lineVector[index].c_str()) );
	
	// thare is extantion
	//if (lineVector.size()-1-index!=0){	
	if (newGame.getHomeFinalScore()==newGame.getAwayFinalScore()) {
		index++;
		newGame.setHomeExtensionScore( atoi(lineVector[index].c_str()) );
		
		index++;
		newGame.setAwayExtensionScore( atoi(lineVector[index].c_str()) );
	}
	//----)

	// Get Round & Date from temp_game_object (that save the date and round)
	newGame.setRoundNum( gameTempDetails.getRoundNum() );
	newGame.setDate( gameTempDetails.getDate() );

	if (writeToFile==true)
		writeToGamesDB(str);
	//..last
	return newGame;
}

//----------------------------------------------//
//This methods 'readGameAtRound' recieves 'line'//
//input and make all things to add this game to //
//system. 										//
//'typeFile' - to identify witch of function we //
//need to execute on this line.					//
// typeInput=1  for input from keyboard			//
// typeInput=2  for read from db				//
//----------------------------------------------//
vector<game> readGameAtRound(string line, int typeInput, bool writeToFile, int* session) {	
	vector<game> v;
	// type 1 from menu
	if (typeInput==1){
		line = delimetersRemover(line, (",.\0"), ' ' );			//change from "." and "," to=> ' ' (space)
		writeToGamesDB(line);
		vector<string> lineVector = splitStr(line);		//make vector from string

		game gameTempDetails = saveGameDetailsTemp( lineVector );		//create gameTemp object with only this Details: game (round, day, month, year)		
		
		if (&gameTempDetails != NULL){
			//read all games
			//cout<<"create gameTemp\n";
			
			// Add game lines here until ";"
			string str;
			while(str!= ";"){
				str.clear();
				getline(cin,str);
				if (str!= ";"){
					v.push_back( functionToCreateNewGameObject(str, gameTempDetails, writeToFile) );
				}
			}
		}
	}else if(typeInput==2){ // type 2 from file "games.db"
		ifstream fileReader;
		string tmp;
		game gameTempDetails;
		fileReader.clear();
		fileReader.open("games.db");

		while (fileReader.good() ){		
			while(fileReader.good() &&	getline(fileReader,tmp) && splitStr(tmp).at(0)!= ";") {			//delete all spaces in tmp
				if (fileReader!=NULL && tmp.find("session",0) == std::string::npos){
					//read game round & date
					if (tmp.find("game",0) != std::string::npos ){
						tmp = delimetersRemover(tmp, (",.\0"), ' ' );			//change from "." and "," to=> ' ' (space)
						//writeToGamesDB(tmp);
						vector<string> lineVector = splitStr(tmp);		//make vector from string
						gameTempDetails = saveGameDetailsTemp( lineVector );		//create gameTemp object with only this Details: game (round, day, month, year)		
						if ( *session < gameTempDetails.getRoundNum())
							*session = gameTempDetails.getRoundNum();
					}
					//read specific game
					else if(&gameTempDetails != NULL){
						//read all games
						//cout<<"create gameTemp\n";
			
						// Add game lines here until ";"
						v.push_back( functionToCreateNewGameObject(tmp, gameTempDetails, writeToFile) );
					}
				}
			}
		}
		fileReader.close();
	}
	return v;
}


void user_menu(league & league){
	string str;
	int caseNum;

	do {
		cout<<"type command or type 'help' for list of valid commands."<<endl;
		getline(cin,str);
		str = delimetersRemover(str, ",.()\0", ' ' );			//delete "."   ","   "("   ")"
		caseNum = check_input(str);
		if (caseNum != -1) { // vaild command

			switch(caseNum) {
			case 1: 	//SHOW TEAMS
				showTeams();
				break;

			case 2: 
				league.createLeagueTable();		//? print out league in table?
				break;

			case 3: 
				cout<<"case 3";
				break;

			case 5:		// help command - shows content of help file
				help();
				break;

			case 10:
				addTeam();
				break;

			case 11:		//read game
				readGameAtRound(str,1, true, NULL);	//true- write to file
				break;
			}

		}else
			cout<<"wrong command."<<endl;
	}while (caseNum != 777);
}

//int init(){
//
//}

vector<team> readTeamsFile(){
	vector<team> teams;
	ifstream fileReader;
	string tmp;
	team tmpTeam;

	fileReader.open("teams.db");
	while(getline(fileReader,tmp)) {
			tmpTeam=team(tmp);
		if ( tmpTeam.getName()!="\n" && tmpTeam.getName() !="" && tmpTeam.getName() !=" ")
			teams.push_back(tmpTeam);
	}
	fileReader.close();

	return teams;
}

int main() {
	cout<<"\t\t\t- welcome to League tool -"<<endl;
	vector<team> teams = readTeamsFile();
	int lastSession= 0;
	int* lastSessionPTR = &lastSession;
	vector<game> allGames = readGameAtRound("",2, false, lastSessionPTR);	//check the team.name from teamsVector source that created.
	//vector<game>* allGamesPTR = &allGames;	//it's shortcut

<<<<<<< HEAD
	league league(teams); //construct a league with teams objects. teams dont have games yet.
	league.init( &allGames );			// add to every team in the league it's games from vector games
	league.createLeagueTable();		// print out league in table
	user_menu( league );
=======
	league league(&teams); //construct a league with teams objects. teams dont have games yet.
	league.init(&allGames);			//? add to every team in the league it's games from vector games?
	league.createLeagueTable();		//? print out league in table?
	user_menu();
>>>>>>> 982f6c383a05e9917033a650584dfb26cc2bd170
	system("pause");
	return 0;

}