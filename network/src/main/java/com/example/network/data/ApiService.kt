package com.example.network.data

import com.example.shared.Gender

class ApiService {
    fun getUser(): List<Gender> {
        return duhList();
    }

    private fun duhList(): List<Gender>{
        val list = ArrayList<Gender>();
        var x =0;
        while(x < 10){
            list.add(Gender((0..1000000).random(), getRandomString(10)))
            x ++;
        }
        return list;
    }

    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}