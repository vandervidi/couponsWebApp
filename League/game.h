#ifndef game_h_
#define game_h_

#include "date.h"
#include <iostream>
#include <vector>
#include <string>
using namespace std;

class game
{
private:
	Date date;
	string homeGroup;
	string awayGroup;
	int roundNum;
	int homeMidScore;
	int homeFinalScore;
	int awayMidScore;
	int awayFinalScore;

public:
//ctro
game()
{

}
//Getters and Setters 
 Date getDate() {
		return date;
	}
 void setDate(Date newDate) {
		date = newDate;
	}
 string getHomeGroup() {
		return homeGroup;
	}
void setHomeGroup(string newHomeGroup) {
		homeGroup = newHomeGroup;
	}
string getAwayGroup() {
		return awayGroup;
	}
void setAwayGroup(string newAwayGroup) {
		awayGroup = newAwayGroup;
	}
int getRoundNum() {
		return roundNum;
	}
void setRoundNum(int newRoundNum) {
		roundNum = newRoundNum;
	}
 int getHomeMidScore() {
		return homeMidScore;
	}
void setHomeMidScore(int newHomeMidScore) {
		homeMidScore = newHomeMidScore;
	}
int getHomeFinalScore() {
		return homeFinalScore;
	}
void setHomeFinalScore(int newHomeFinalScore) {
		homeFinalScore = newHomeFinalScore;
	}
int getAwayMidScore() {
		return awayMidScore;
	}
void setAwayMidScore(int newAwayMidScore) {
		awayMidScore = newAwayMidScore;
	}
int getAwayFinalScore() {
		return awayFinalScore;
	}
void setAwayFinalScore(int newAwayFinalScore) {
		awayFinalScore = newAwayFinalScore;
	}

};
#endif