package com.amiibos.model

import java.io.Serializable

data class Release(val eu: String = "",
                   val na: String = "",
                   val au: String = "",
                   val jp: String = "") : Serializable