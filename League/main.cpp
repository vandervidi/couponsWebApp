#include <vector>
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
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

// from "aab. tr, ew, .sdff" => "aab tr ew sdff"
string delimetersRemover(string str){		
	size_t found1 = str.find_first_of(", ");
	while (found1!= string::npos){
		str[found1]=' ';
		found1=str.find_first_of(", ",found1+1);
	}
	size_t found2 = str.find_first_of(". ");
	while (found2!= string::npos){
		str[found2]=' ';
		found2=str.find_first_of(". ",found2+1);
	}

	//std::cout << str << '\n';
	return str;
}

void user_menu(){
	string str;
	int caseNum;

	do {
		cout<<"type command or type 'help' for list of valid commands."<<endl;
		getline(cin,str);

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

			case 5: {// help command - shows content of help file
				help();
				break;
					}
			case 10:
				addTeam();
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