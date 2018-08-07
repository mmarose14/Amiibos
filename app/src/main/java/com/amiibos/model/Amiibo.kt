package com.amiibos.model

import java.io.Serializable

data class Amiibo(val head: String = "",
                  val image: String = "",
                  val character: String = "",
                  val release: Release,
                  val tail: String = "",
                  val name: String = "",
                  val type: String = "",
                  val amiiboSeries: String = "",
                  val gameSeries: String = "") : Serializable