package com.example.roomdatabase.model.local

import com.example.roomdatabase.model.entity.User

interface LocalRepository {           //3mltha 34an tb2a zy m5zn ll local kolha w at3aml m3aha bdl ma at3aml m3
                                       // m3 al data base directly
    suspend fun getUsers(): List<User>
    suspend fun deleteUser(user: User)
    suspend fun insertOrUpdateUser(user: User)
}