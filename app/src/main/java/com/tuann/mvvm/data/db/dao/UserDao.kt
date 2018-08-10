package com.tuann.mvvm.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.tuann.mvvm.data.db.entity.UserEntity

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: UserEntity)

    @Query("SELECT * FROM user WHERE id == :id LIMIT 1")
    abstract fun getUser(id: String): UserEntity?
}