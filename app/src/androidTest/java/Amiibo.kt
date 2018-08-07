package <default> (/Users/mmarose/Documents/Android/assignments/amiibos/app/src/androidTest/java)

data class Amiibo(val head: String = "",
                  val image: String = "",
                  val character: String = "",
                  val release: Release,
                  val tail: String = "",
                  val name: String = "",
                  val type: String = "",
                  val amiiboSeries: String = "",
                  val gameSeries: String = "")


data class Release(val eu: String = "",
                   val na: String = "",
                   val au: String = "",
                   val jp: String = "")


