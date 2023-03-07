fun main() {
    while(true){
        val time= readln().toInt()
        var result=agoToText(time)
        println(result)
    }
}

fun agoToText(time: Int): String {
    return when(time){
        in Int.MIN_VALUE..0->"Ошибка"
        in 0..59->"был(а) в сети только что"
        in 60 until 60*60 ->"был(а) в сети ${time/60} ${minute(time)} назад"
        in 60*60 until 24 * 60 * 60 ->"был(а) в сети ${time/(60*60)} ${hour(time)} назад"
        in 24 * 60 * 60 until 24 * 60 * 60*2 ->"был(а) в сети вчера"
        in 24 * 60 * 60*2 until 24 * 60 * 60*3 ->"был(а) в сети позавчера"
        else ->"был(а) в сети давно"
    }
}

fun minute(time: Int): String {
    val min = time/60
    return if (min.toString().last() == '1'&&(min.toString().length == 1 || (if (min.toString().length > 1) min.toString()[min.toString().length - 2] != '1' else false))) "минуту"
    else if (min%10 in 2..4&&(min.toString().length == 1 ||(if (min.toString().length > 1) min.toString()[min.toString().length - 2] != '1' else false))) "минуты"
    else "минут"
}

fun hour(time: Int): String{
    return when (time/(60*60)) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        else -> "часов"
    }
}