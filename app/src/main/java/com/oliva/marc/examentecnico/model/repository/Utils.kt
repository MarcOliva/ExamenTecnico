package com.oliva.marc.examentecnico.model.repository

object Utils {

    private const val token =
        "bearer  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vZGVhbGJyYW5kLWFwaS5kZXYtZm9yY2VjbG9zZS5jb20vbW9iaWxlL3YyL2F1dGgvbG9naW4iLCJpYXQiOjE1ODIxNjgyOTIsImV4cCI6MTU4Mjc3MzA5MiwibmJmIjoxNTgyMTY4MjkyLCJqdGkiOiJMZHg2WTVadjNXWGI0YUEzIiwic3ViIjo2NDUsInBydiI6IjdhM2MxNWY4MmMwMWJjNTExOTZhODc2NTk1YTNjNjBmOTFlZGNlY2IifQ.wPeaTzC3U6zoVPi_yqUAkJmEa4ZThI0i6-D9hV1VZ5Q"

    fun getToken(): String {
        return token
    }
}