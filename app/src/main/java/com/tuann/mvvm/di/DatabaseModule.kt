package com.tuann.mvvm.di

import android.app.Application
import android.arch.persistence.room.Room
import com.tuann.mvvm.data.db.*
import com.tuann.mvvm.data.db.dao.ImageDao
import com.tuann.mvvm.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton @Provides
    fun provideDb(app: Application) : AppDatabase =
            Room.databaseBuilder(app, AppDatabase::class.java, "image.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

    @Singleton @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Singleton @Provides
    fun provideImageDao(db: AppDatabase): ImageDao = db.imageDao()

    @Singleton @Provides
    fun provideUserDatabase(db: AppDatabase, userDao: UserDao): UserDatabase =
            UserRoomDatabase(db, userDao)

    @Singleton @Provides
    fun provideImageDatabase(db: AppDatabase, imageDao: ImageDao, userDao: UserDao) : ImageDatabase =
            ImageRoomDatabase(db, imageDao, userDao)
}