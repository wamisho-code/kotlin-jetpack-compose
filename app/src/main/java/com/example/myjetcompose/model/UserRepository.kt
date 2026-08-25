package com.example.myjetcompose.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun fetchUserData(): UserDate{
        delay(2000)
        return UserDate("John",35)
    }
}