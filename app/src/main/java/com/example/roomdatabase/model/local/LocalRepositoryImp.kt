package com.example.roomdatabase.model.local

import com.example.roomdatabase.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepositoryImp(private val db:UserDatabase):LocalRepository {


    override suspend fun getUsers()= withContext(Dispatchers.IO) {
           db.userDAO().getUsers()
       }


    override suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO){
            db.userDAO().deleteUser(user)
        }
    }

    override suspend fun insertOrUpdateUser(user: User) {
        withContext(Dispatchers.IO){
            db.userDAO().insertOrUpdateUser(user)
        }

    }
}