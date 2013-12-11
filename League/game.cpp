#include "game.h"

using namespace std;

//game::game (game& g){
//        this->setAwayFinalScore(g.getAwayFinalScore() );
//        this->setAwayGroup( g.getAwayGroup() );
//        this->setAwayMidScore( g.getAwayMidScore() );
//        this->setDate( g.getDate() );
//        this->setHomeFinalScore( g.getHomeFinalScore() );
//}

game::game (int roundNum, Date date){
        this->roundNum = roundNum;
        this->date = Date(date.day, date.month, date.year);
}

game::game(){
}