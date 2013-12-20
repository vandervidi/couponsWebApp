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
        date = Date(0,0,0);
		homeGroup="";
        awayGroup="";
        roundNum = 0;
        homeMidScore=0;
        homeFinalScore=0;
        homeExtensionScore=0;
        awayMidScore=0;
        awayFinalScore=0;
        awayExtensionScore=0;
}