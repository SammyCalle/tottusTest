package com.example.tottustest.data.model.response

import androidx.annotation.Keep

@Keep
data class GetUserOfCertainTeamResponse(
    var id : Int?,
    var nombre: String?,
    var apellido: String?
)