package com.example.yumyum

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "YUMYUM_DB"
        const val DB_VERSION = 1

        //회원정보
        const val USER_TABLE_NAME = "USER_T"
        const val USER_NO = "USER_NO"
        const val USER_NAME = "USER_NAME"
        const val USER_ID = "USER_ID"
        const val USER_NKNAME = "USER_NKNAME"
        const val USER_PWD = "USER_PWD"
        const val USER_PHONE = "USER_PHONE"
        const val USER_EMAIL = "USER_EMAIL"
        //const val USER_IMG = "USER_IMG"

        //const val SQL_DROP_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE_NAME
        //const val SQL_USER_LOAD = "SELECT * FROM " + USER_TABLE_NAME

        //요리정보
        const val RECIPE_TABLE_NAME = "RECIPE_APPLICATION_T"
        const val RECIPE_NO = "RECIPE_NO"
        const val RECIPE_NAME = "RECIPE_NAME"
        const val RECIPE_TYPE = "RECIPE_TYPE"
        const val RECIPE_INGREDIENT = "RECIPE_INGREDIENT"
        const val RECIPE_TOOL = "RECIPE_TOOL"
        const val RECIPE_IMG = "RECIPE_IMG"
        const val RECIPE_USER = "RECIPE_USER"
        const val RECIPE_LEVEL = "RECIPE_LEVEL"
        const val RECIPE_LIKE = "RECIPE_LIKE"
        const val RECIPE_C1 = "RECIPE_C1"
        const val RECIPE_C2 = "RECIPE_C2"
        const val RECIPE_C3 = "RECIPE_C3"
        const val RECIPE_C4 = "RECIPE_C4"
        const val RECIPE_C5 = "RECIPE_C5"
        const val RECIPE_C6 = "RECIPE_C6"
        const val RECIPE_C7 = "RECIPE_C7"
        const val RECIPE_C8 = "RECIPE_C8"
        const val RECIPE_C9 = "RECIPE_C9"
        const val RECIPE_C10 = "RECIPE_C10"
        const val RECIPE_C11= "RECIPE_C11"
        const val RECIPE_C12 = "RECIPE_C12"
        const val RECIPE_I1 = "RECIPE_I1"
        const val RECIPE_I2 = "RECIPE_I2"
        const val RECIPE_I3 = "RECIPE_I3"
        const val RECIPE_I4 = "RECIPE_I4"
        const val RECIPE_I5 = "RECIPE_I5"
        const val RECIPE_I6 = "RECIPE_I6"
        const val RECIPE_I7 = "RECIPE_I7"
        const val RECIPE_I8 = "RECIPE_I8"
        const val RECIPE_I9 = "RECIPE_I9"
        const val RECIPE_I10 = "RECIPE_I10"
        const val RECIPE_I11= "RECIPE_I11"
        const val RECIPE_I12 = "RECIPE_I12"

        //const val SQL_DROP_USER_TABLE = "DROP TABLE IF EXISTS " + RECIPE_TABLE_NAME
        //const val SQL_USER_LOAD = "SELECT * FROM " + RECIPE_TABLE_NAME

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_USER_TABLE = "CREATE TABLE IF NO EXISTS " +
                USER_TABLE_NAME + "(" +
                USER_NO + "INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                USER_NAME + "TEXT NOT NULL, " +
                USER_ID + "TEXT NOT NULL, " +
                USER_NKNAME + "TEXT NOT NULL, " +
                USER_PWD + "TEXT NOT NULL, " +
                USER_PHONE + "TEXT NOT NULL, " +
                USER_EMAIL + "TEXT NOT NULL)"
        db?.execSQL(SQL_CREATE_USER_TABLE)

        val SQL_CREATE_RECIPE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                RECIPE_TABLE_NAME + "(" +
                RECIPE_NO + " INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                RECIPE_NAME + " TEXT NOT NULL, " +
                RECIPE_TYPE + " TEXT NOT NULL, " +
                RECIPE_INGREDIENT + " TEXT NOT NULL, " +
                RECIPE_TOOL + " TEXT NOT NULL, " +
                RECIPE_IMG + " INTEGER NOT NULL, " +
                RECIPE_USER + " TEXT NOT NULL, " +  //FOREIGN KEY
                RECIPE_LEVEL + " INTEGER NULL, " +
                RECIPE_LIKE + " INTEGER NULL, " +
                RECIPE_C1 + " TEXT NOT NULL, " +
                RECIPE_C2 + " TEXT NULL, " +
                RECIPE_C3 + " TEXT NULL, " +
                RECIPE_C4 + " TEXT NULL, " +
                RECIPE_C5 + " TEXT NULL, " +
                RECIPE_C6 + " TEXT NULL, " +
                RECIPE_C7 + " TEXT NULL, " +
                RECIPE_C8 + " TEXT NULL, " +
                RECIPE_C9 + " TEXT NULL, " +
                RECIPE_C10 + " TEXT NULL, " +
                RECIPE_C11 + " TEXT NULL, " +
                RECIPE_C12 + " TEXT NULL, " +
                RECIPE_I1 + "INTEGER DEFAULT 0, " +  //이후 만약 사진이 삽입 되었을 경우 숫자 1...12 삽입되어 숫자에 맞는 사진 출력
                RECIPE_I2 + "INTEGER DEFAULT 0, " +  //아닐 경우 0으로 삽입되어 기본 사진 출력
                RECIPE_I3 + "INTEGER DEFAULT 0, " +
                RECIPE_I4 + "INTEGER DEFAULT 0, " +
                RECIPE_I5 + "INTEGER DEFAULT 0, " +
                RECIPE_I6 + "INTEGER DEFAULT 0, " +
                RECIPE_I7 + "INTEGER DEFAULT 0, " +
                RECIPE_I8 + "INTEGER DEFAULT 0, " +
                RECIPE_I9 + "INTEGER DEFAULT 0, " +
                RECIPE_I10 + "INTEGER DEFAULT 0, " +
                RECIPE_I11 + "INTEGER DEFAULT 0, " +
                RECIPE_I12 + "INTEGER DEFAULT 0" + ")"
        db?.execSQL(SQL_CREATE_RECIPE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    //회원추가
    fun addUser(user_name: String, user_id: String, user_nkname: String, user_pwd: String, user_phone: String, user_email: String):Long {
        val values = ContentValues()
        values.put(USER_NAME, user_name)
        values.put(USER_ID, user_id)
        values.put(USER_NKNAME, user_nkname)
        values.put(USER_PWD, user_pwd)
        values.put(USER_PHONE, user_phone)
        values.put(USER_EMAIL, user_email)

        val db = writableDatabase
        val rowId = db.insert(USER_TABLE_NAME, null, values)

        db.close()

        return rowId
    }

    // 아이디 중복 확인

}