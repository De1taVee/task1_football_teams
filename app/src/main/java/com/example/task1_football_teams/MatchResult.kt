package com.example.task1_football_teams

//Класс описывает собой структуру, содержащую информацию о футбольном матче
class MatchResult(var name: String, var team1score: Int, var team2score: Int) {

    // Функция позволяет задать одновременно значения очков командам
    fun setMatchScore(team1score: Int, team2score: Int) {
        this.team1score = team1score
        this.team2score = team2score
    }

    //Функция возвращает разницу в очках
    fun scoreDifference(): Int {
        return kotlin.math.abs(team1score - team2score)
    }

}