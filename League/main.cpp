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
	//In terminal - 'all teams'
	if (tokenized[0]=="all" && tokenized[1]=="teams") {
		return 0;
	}
	//In terminal - 'show league'
	else if (tokenized[0]=="show" && tokenized[1]=="league") {
	
		return 1;
	}

	else if (tokenized[0]=="show" && tokenized[1]=="league") {
		return 2;
	}
	//In terminal - 'login'
	else if (tokenized[0]=="login") {
		return 4;
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


	void user_menu(){
		//...
	}

	void admin_menu(int caseNum){
		switch(caseNum)
		{
		//Case 10 - Admin adds a team. Two things happen next.
		//(1) The team name is appended to th file teams.db.
		//(2) The team is appended to the league.db file and all its league
		//	   parameters are reset to zero.(Points, number of games ..)
		case(10): 
			{
				cout<<"Enter team name:"<<endl;
				ofstream outputToTeamsDb;
				string tmp;
				outputToTeamsDb.open("teams.db", std::ios_base::app);
				getline(cin,tmp);
				outputToTeamsDb<<tmp<<endl;
				cout<<"Team :"<<tmp<<" is added."<<endl;
				outputToTeamsDb.close();
				break;
			}
		default:
			cout<<"Wrong admin command"<<endl;
		}
	}

int main() {
	string str;
	bool loggedIn=false;
	int caseNum;

		do {
			cout<<"type command or type 'help' for list of valid commands."<<endl;
			getline(cin,str);
			caseNum = check_input(str);
			if (caseNum != -1) { // vaild command
				switch(caseNum) {
					case(0): { //SHOW TEAMS
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
							break;
					}
					case(1): {
							
							break;
					}
					case(2): {

							break;
					}
					case(3): {

							break;
					}
					case(4): { // ADMIN LOGIN
							string username="admin";
							string password="1234";
							string buff;
			
							cout<<"Enter Username:"<<endl;

							while (buff.compare("exit")!=0){
				
								cin>>buff;
								// Check user
								if (buff.compare(username)==0){					//check username
									cout<<"Enter Password:"<<endl;
					
									while(buff.compare("exit")!=0){
										if (!loggedIn){
										cin>>buff;
											if (buff.compare(password)==0){		//check password
												loggedIn=true;
												cout<<"login success"<<endl<<"What do you want to do? - type 'help' for list of commands."<<endl;
												do {
													cin.ignore();
													getline(cin,str);					// admin request

													caseNum = check_input(str);
													admin_menu(caseNum);
												}while (str!="exit" );
											}
											else 
												cout<<"Wrong password, try again:"<<endl;
										}
										else
										{
												//cin.ignore();
												cin.clear();
												getline(cin,str);
												caseNum = check_input(str);
												admin_menu(caseNum);
										}
									}
								}else
									cout<<"Wrong user, try again:"<<endl;
							}	
							break;
						}
					case (5): {// help command - shows content of help file
						ifstream fileReader;
						string tmp;
						fileReader.open("help.txt");
						while(getline(fileReader,tmp)) {
							cout<<tmp<<endl;
						}
						fileReader.close();
						break;
					}
					case (777):	{	// exit
						break;
					}
				}
			}else
				cout<<"wrong command."<<endl;
		}while (caseNum != 777);

	system("pause");
	return 0;

}