package com.example.task1_football_teams

import kotlin.random.Random


class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            //Инициализация экземпляров класса MatchResult
            var Zenit_Spartak = MatchResult(
                "Zenit_Spartak", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Zenit_CSKA = MatchResult(
                "Zenit_CSKA", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Krasnodar_CSKA = MatchResult(
                "Krasnodar_CSKA", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Krasnodar_Zenit = MatchResult(
                "Krasnodar_Zenit", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Torpedo_Zenit = MatchResult(
                "Torpedo_Zenit", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Torpedo_CSKA = MatchResult(
                "Torpedo_CSKA", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Rotor_CSKA = MatchResult(
                "Krasnodar_CSKA", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Rotor_Torpedo = MatchResult(
                "Rotor_Torpedo", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Rotor_Spartak = MatchResult(
                "Rotor_Spartak", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            var Rotor_Krasnodar = MatchResult(
                "Rotor_Krasnodar", Random.nextInt(0, 5), Random.nextInt(0, 5)
            )

            //Вводим созданные матчи в массив
            var matches: Array<MatchResult?> = arrayOf(
                Zenit_Spartak,
                Zenit_CSKA,
                Krasnodar_Zenit,
                Krasnodar_CSKA,
                Torpedo_CSKA,
                Torpedo_Zenit,
                Rotor_Torpedo,
                Rotor_CSKA,
                Rotor_Krasnodar,
                Rotor_Spartak
            )


            //Вывод элементов массива
            println("\nВывод элементов массива")
            for (i in 0 until matches.size) {
                println("Match ${matches[i]?.name}, result: ${matches[i]?.team1score}  ${matches[i]?.team2score}")
            }

            println("\nИзменим значение матча Rotor_Krasnodar")
            Rotor_Krasnodar.setMatchScore(3,2)
            println("Match ${Rotor_Krasnodar.name}, result: ${Rotor_Krasnodar.team1score}  ${Rotor_Krasnodar.team2score}")

            //Удаляем элемент из массива если он соответствует условию: у команд равный счет
            for (i in 0 until matches.size) {
                if (matches[i]!!.scoreDifference() == 0) {

                    matches[i] = null
                }
            }



            println("\nВывод элементов массива после удаления команд с равными очками")
            loop@for (i in 0 until matches.size) {
                if(matches[i]==null)
                    continue@loop
                println("Match ${matches[i]!!.name}, result: ${matches[i]!!.team1score}  ${matches[i]!!.team2score}")
            }

            //Сначала ищем значение с наибольшей разницей, затем добавляем записи с такой разницей в Set
            val bigscore: MutableSet<MatchResult> = HashSet()
            var temp = 0
            loop2@for (i in 0 until matches.size) {
                if(matches[i]==null)
                    continue@loop2

                if (temp < matches[i]!!.scoreDifference())
                    temp = matches[i]!!.scoreDifference()
            }

            loop3@for (i in 0 until matches.size) {
                if(matches[i]==null)
                    continue@loop3
                if (matches[i]!!.scoreDifference() == temp)
                    bigscore.add(matches[i]!!)
            }

            println("\nВывод команд с наибольшим разрывом в очках")
            for (i in 0 until bigscore.size) {
                println(
                    "Match with biggest score difference:" +
                            " ${bigscore.elementAt(i).name}, result: " +
                            " ${bigscore.elementAt(i).team1score}" +
                            "  ${bigscore.elementAt(i).team2score}"
                )
            }



        }
    }
}