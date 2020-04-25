package uz.mahmudxon.passwordmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true) val id : Int = 0, var fullname : String, var img : String)