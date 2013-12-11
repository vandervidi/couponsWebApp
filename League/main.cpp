#include <vector>
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
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
//------------------------------------------------//
string delimetersRemover(string str){		
	
	//change from "," => " "
	size_t found1 = str.find_first_of(", ");
	while (found1!= string::npos){
		str[found1]=' ';
		found1=str.find_first_of(", ",found1+1);
	}

	//change from "." => " "
	size_t found2 = str.find_first_of(". ");
	while (found2!= string::npos){
		str[found2]=' ';
		found2=str.find_first_of(". ",found2+1);
	}

	//change from "(" => " "
	size_t found3 = str.find_first_of("( ");
	while (found3!= string::npos){
		str[found3]=' ';
		found3=str.find_first_of("( ",found3+1);
	}

	//change from ")" => " "
	size_t found4 = str.find_first_of(") ");
	while (found4!= string::npos){
		str[found4]=' ';
		found4=str.find_first_of(") ",found4+1);
	}

	//std::cout << str << '\n';
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
	//
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
	//(-) The team name is appended to th file teams.db.
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

void showTeams(){
	system("CLS"); // clears the screen before 
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
	//int month = chengeMonthToNumber( lineVector[2] );					//change from month(string) to (int)
	int month = 9;
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

game functionToCreateNewGameObject(vector<string> lineVector, game& gameTempDetails){

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
		newGame.setHomeGroup(teamA_name);
	}
	//----)
	
	////----( Way-1
	//// Find and create teamB name
	//string teamB=NULL;
	//index+=2;	//jump to the index of the first word after "-"
	//int teamB_nameSize = lineVector.size()-index-4;		///all the words after the "-" (lineVector.size()-index) minus 4 numbers
	//for (index; index<(index+teamB_nameSize); index++){	//check for valid input
	//	if (teamB.size()==0)
	//		teamB =lineVector[index];					
	//	else teamB +=" "+lineVector[index];
	//}
	//newGame.setAwayGroup(teamB);
	////----)

	//----( Way-2
	// Find and create teamB name
	string teamB_name;
	teamB_name.clear();
	index+=2;	//jump to the index of the first word after "-"
	for (index; index<lineVector.size(); index++) {
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
	if (lineVector.size()-1-index!=0){	// thare is extantion
		index++;
		newGame.setHomeExtensionScore( atoi(lineVector[index].c_str()) );
		
		index++;
		newGame.setAwayExtensionScore( atoi(lineVector[index].c_str()) );
	}
	//----)

	// Get Round & Date from temp_game_object (that save the date and round)
	newGame.setRoundNum( gameTempDetails.getRoundNum() );
	newGame.setDate( gameTempDetails.getDate() );

	//..last
	return newGame;
}

//----------------------------------------------//
//This methods 'readGameAtRound' recieves 'line'//
//input and make all things to add this game to //
//system. 										//
//'typeFile' - to identify witch of function we //
//need to execute on this line.					//
// typeFile=1 for initialize at the first		//
//typeFile=2 for read from db					//
//----------------------------------------------//
void readGameAtRound(string line, int typeFile) {	
	vector<game> v;
	if (typeFile==1){
		line = delimetersRemover(line);			//delete "."   ","   "("   ")"
		//writeToDbFile(line);
		vector<string> lineVector = splitStr(line);		//make vector from string

		game gameTempDetails = saveGameDetailsTemp( lineVector );		//create gameTemp object with only this Details: game (round, day, month, year)		
		
		if (&gameTempDetails != NULL){
			//read all games
			cout<<"create gameTemp\n";
			
			// Add game lines here until ";"
			string str;
			while(str!= ";"){
				str.clear();
				getline(cin,str);
				if (str!= ";"){
					str = delimetersRemover(str);			//delete "."   ","   "("   ")"
					vector<string> strVector = splitStr(str);		//make vector from string
					v.push_back( functionToCreateNewGameObject(strVector, gameTempDetails) );
				}
			}
		}
	}else if(typeFile==2){

	}
}


void user_menu(){
	string str;
	int caseNum;

	do {
		cout<<"type command or type 'help' for list of valid commands."<<endl;
		getline(cin,str);

		str = delimetersRemover(str);		// delete '.' and ',' from input
		caseNum = check_input(str);
		if (caseNum != -1) { // vaild command

			switch(caseNum) {
			case 1: 	//SHOW TEAMS
				showTeams();
				break;

			case 2: 
				cout<<"case 2";
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
				readGameAtRound(str,1);
				break;
			}

		}else
			cout<<"wrong command."<<endl;
	}while (caseNum != 777);
}




int main() {
	user_menu();
	system("pause");
	return 0;

}