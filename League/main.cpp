#include <vector>
#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
using namespace std;

vector<string> splitStr(string str){
		string buf; // Have a buffer string
		stringstream ss(str); // Insert the string into a stream

		vector<string> tokens; // Create vector to hold our words

		while (ss >> buf)
			tokens.push_back(buf);

		return tokens;
	}


//> Show Maccabbi TA - Galil Elion
//> Show Teams


int check_input(string str)
{
	//int case=-1;
	vector<string> tokenized = splitStr(str);
	//SHOW TEAMS
	if (tokenized[0]=="all" && tokenized[1]=="teams")
	{
		return 0;
	}

	else if (tokenized[0]=="show" && tokenized[1]=="league")
	{
		return 1;
	}
	else if (tokenized[0]=="show" && tokenized[1]=="league")
	{
		return 2;
	}
	else if (tokenized[0]=="login")
	{
		return 4;
	}
	else if (tokenized[0]=="help")
	{
		return 5;
	}
	// Exit
	else if(tokenized[0]=="exit"){
		return 777;
	}

	// command not vaild
	return -1;
}


	void user_menu(){
		//...
	}

	void admin_menu(){
		//...
	}

int main()
{
	string str;
		int caseNum;
	


		//-############--------------
		do {
			cout<<"type command or type 'help' for list of valid commands."<<endl;
			getline(cin,str);
			caseNum = check_input(str);
											cout<<caseNum<<endl;
			if (caseNum != -1) { // vaild command
				switch(caseNum) {
					case(0): { //SHOW TEAMS
					   
							cout<<"show teams identify"<<endl;
							string temp;
							ifstream fileReader;
							fileReader.open("teams.txt");
							while(getline(fileReader,temp)) {
								cout<<temp<<endl;
							}
							break;
					}
					case(1): {
							cout<<"show teams identify"<<endl;
							string temp;
							ifstream fileReader;
							fileReader.open("teams.txt");
							while(getline(fileReader,temp)) {

								cout<<temp<<endl;
							}
							fileReader.close();
							break;
					}
					case(2): {

							break;
					}
					case(3): {

							break;
					}
					case(4): { // ADMIN ADD TEAM
							string username="admin";
							string password="1234";
							string buff;
			
							cout<<"Enter Username:"<<endl;

							while (buff.compare("exit")!=0){
				
								cin>>buff;
								// Check user
								if (buff.compare(username)==0){
									cout<<"Enter Password:"<<endl;
					

									while(buff.compare("exit")!=0){
										cin>>buff;
										if (buff.compare(password)==0){
											cout<<"login success";
											// admin_menu()
										}
										else 
											cout<<"Wrong password, try again:"<<endl;
									}
								}else
									cout<<"Wrong user, try again:"<<endl;
							}	
							break;
						}
					case (5): {
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