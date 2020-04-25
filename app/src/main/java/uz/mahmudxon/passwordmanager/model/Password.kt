package uz.mahmudxon.passwordmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Password(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var url: String?,
    var title: String,
    var username: String?,
    var password: String
)