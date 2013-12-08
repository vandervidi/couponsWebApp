#ifndef league_h_
#define league_h_

#include "team.h"
#include <vector>
using namespace std;

class league
{
private:
vector<team> teams;

public:
	vector<team> getTeams(){return teams;}
//ctro
league()
{

}

};
#endif