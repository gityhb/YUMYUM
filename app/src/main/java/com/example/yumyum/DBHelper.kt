package com.example.yumyum

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class UserInfo(val name: String,  val nickname: String, val id: String)
class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "YUMYUM_DB"
        const val DB_VERSION = 1

        //회원정보
        const val USER_TABLE = "USER_T"
        const val USER_NO = "USER_NO"
        const val USER_NAME = "USER_NAME"
        const val USER_ID = "USER_ID"
        const val USER_NKNAME = "USER_NKNAME"
        const val USER_PWD = "USER_PWD"
        const val USER_PHONE = "USER_PHONE"
        const val USER_EMAIL = "USER_EMAIL"
        const val IS_LOGIN = "IS_LOGIN"
        //const val USER_IMG = "USER_IMG"

        //const val SQL_DROP_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE
        //const val SQL_USER_LOAD = "SELECT * FROM " + USER_TABLE

        // 요리정보
        const val COOK_TABLE = "COOK_T"
        const val COOK_NO = "COOK_NO"
        const val COOK_NAME = "COOK_NAME"
        const val COOK_TYPE = "COOK_TYPE"
        const val COOK_INGREDIENT = "COOK_INGREDIENT"
        const val COOK_TOOL = "COOK_TOOL"
        const val COOK_IMG = "COOK_IMG"
        const val COOK_USER = "COOK_USER"
        const val COOK_LEVEL = "COOK_LEVEL"
        const val COOK_LIKE = "COOK_LIKE"
        const val COOK_C1 = "COOK_C1"
        const val COOK_C2 = "COOK_C2"
        const val COOK_C3 = "COOK_C3"
        const val COOK_C4 = "COOK_C4"
        const val COOK_C5 = "COOK_C5"
        const val COOK_C6 = "COOK_C6"
        const val COOK_C7 = "COOK_C7"
        const val COOK_C8 = "COOK_C8"
        const val COOK_C9 = "COOK_C9"
        const val COOK_C10 = "COOK_C10"
        const val COOK_C11 = "COOK_C11"
        const val COOK_C12 = "COOK_C12"
        const val COOK_T1 = "COOK_T1"
        const val COOK_T2 = "COOK_T2"
        const val COOK_T3 = "COOK_T3"
        const val COOK_T4 = "COOK_T4"
        const val COOK_T5 = "COOK_T5"
        const val COOK_T6 = "COOK_T6"
        const val COOK_T7 = "COOK_T7"
        const val COOK_T8 = "COOK_T8"
        const val COOK_T9 = "COOK_T9"
        const val COOK_T10 = "COOK_T10"
        const val COOK_T11 = "COOK_T11"
        const val COOK_T12 = "COOK_T12"
        const val COOK_I1 = "COOK_I1"
        const val COOK_I2 = "COOK_I2"
        const val COOK_I3 = "COOK_I3"
        const val COOK_I4 = "COOK_I4"
        const val COOK_I5 = "COOK_I5"
        const val COOK_I6 = "COOK_I6"
        const val COOK_I7 = "COOK_I7"
        const val COOK_I8 = "COOK_I8"
        const val COOK_I9 = "COOK_I9"
        const val COOK_I10 = "COOK_I10"
        const val COOK_I11 = "COOK_I11"
        const val COOK_I12 = "COOK_I12"

        //요리신청
        const val RECIPE_TABLE = "RECIPE_APPLICATION_T"
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
        const val RECIPE_C11 = "RECIPE_C11"
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
        const val RECIPE_I11 = "RECIPE_I11"
        const val RECIPE_I12 = "RECIPE_I12"

        //const val SQL_DROP_USER_TABLE = "DROP TABLE IF EXISTS " + RECIPE_TABLE
        //const val SQL_USER_LOAD = "SELECT * FROM " + RECIPE_TABLE
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " +
                USER_TABLE + "(" +
                USER_NO + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT NOT NULL, " +
                USER_ID + " TEXT NOT NULL, " +
                USER_NKNAME + " TEXT NOT NULL, " +
                USER_PWD + " TEXT NOT NULL, " +
                USER_PHONE + " TEXT NOT NULL, " +
                USER_EMAIL + " TEXT NOT NULL, " +
                IS_LOGIN + " INTEGER DEFAULT 0" + " )"
        db?.execSQL(SQL_CREATE_USER_TABLE)

        val SQL_CREATE_RECIPE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                RECIPE_TABLE + "(" +
                RECIPE_NO + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
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

        /*val SQL_CREATE_COOK_TABLE = "CREATE TABLE IF NOT EXISTS " +
                COOK_TABLE + "(" +
                COOK_NO + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                COOK_NAME + " TEXT NOT NULL, " +
                COOK_TYPE + " TEXT NOT NULL, " +
                COOK_INGREDIENT + " TEXT NOT NULL, " +
                COOK_TOOL + " TEXT NOT NULL, " +
                COOK_IMG + " TEXT NOT NULL, " +
                COOK_USER + " TEXT NOT NULL, " +  //FOREIGN KEY
                COOK_LEVEL + " INTEGER NULL, " +
                COOK_LIKE + " INTEGER NULL, " +
                COOK_C1 + " TEXT NOT NULL, " +
                COOK_C2 + " TEXT NULL, " +
                COOK_C3 + " TEXT NULL, " +
                COOK_C4 + " TEXT NULL, " +
                COOK_C5 + " TEXT NULL, " +
                COOK_C6 + " TEXT NULL, " +
                COOK_C7 + " TEXT NULL, " +
                COOK_C8 + " TEXT NULL, " +
                COOK_C9 + " TEXT NULL, " +
                COOK_C10 + " TEXT NULL, " +
                COOK_C11 + " TEXT NULL, " +
                COOK_C12 + " TEXT NULL " +
                COOK_T1 + " INTEGER NOT NULL, " +
                COOK_T2 + " INTEGER NULL, " +
                COOK_T3 + " INTEGER NULL, " +
                COOK_T4 + " INTEGER NULL, " +
                COOK_T5 + " INTEGER NULL, " +
                COOK_T6 + " INTEGER NULL, " +
                COOK_T7 + " INTEGER NULL, " +
                COOK_T8 + " INTEGER NULL, " +
                COOK_T9 + " INTEGER NULL, " +
                COOK_T10 + " INTEGER NULL, " +
                COOK_T11 + " INTEGER NULL, " +
                COOK_T12 + " INTEGER NULL " +
                COOK_I1 + " TEXT NOT NULL, " +
                COOK_I2 + " TEXT NULL, " +
                COOK_I3 + " TEXT NULL, " +
                COOK_I4 + " TEXT NULL, " +
                COOK_I5 + " TEXT NULL, " +
                COOK_I6 + " TEXT NULL, " +
                COOK_I7 + " TEXT NULL, " +
                COOK_I8 + " TEXT NULL, " +
                COOK_I9 + " TEXT NULL, " +
                COOK_I10 + " TEXT NULL, " +
                COOK_I11 + " TEXT NULL, " +
                COOK_I12 + " TEXT NULL "+ ")"
        db?.execSQL(SQL_CREATE_COOK_TABLE)*/
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    //회원추가
    fun addUser(
        user_name: String,
        user_id: String,
        user_nkname: String,
        user_pwd: String,
        user_phone: String,
        user_email: String
    ): Long {
        val values = ContentValues()
        values.put(USER_NAME, user_name)
        values.put(USER_ID, user_id)
        values.put(USER_NKNAME, user_nkname)
        values.put(USER_PWD, user_pwd)
        values.put(USER_PHONE, user_phone)
        values.put(USER_EMAIL, user_email)

        val db = writableDatabase
        val rowId = db.insert(USER_TABLE, null, values)

        db.close()

        return rowId
    }

    // 아이디 중복 확인
    fun isUserIdExists(user_id: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT $USER_ID FROM $USER_TABLE WHERE $USER_ID = ?", arrayOf(user_id))
        val exists = cursor.count > 0

        cursor.close()

        return exists
    }

    //닉네임 중복 확인
    fun isUserNknameExists(user_nkname: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $USER_NKNAME FROM $USER_TABLE WHERE $USER_NKNAME = ?",
            arrayOf(user_nkname)
        )
        val exists = cursor.count > 0

        cursor.close()

        return exists
    }

    //로그인
    fun isLogin(user_id: String, user_pwd: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(USER_ID, USER_PWD)
        val cursor =
            db.query(USER_TABLE, columns, "$USER_ID = ?", arrayOf(user_id), null, null, null)

        if (cursor != null && cursor.moveToFirst()) {
            val pwdIndex = cursor.getColumnIndex(USER_PWD)
            if (pwdIndex != -1) {
                val storedPwd = cursor.getString(pwdIndex)

                cursor.close()
                db.close()

                return user_pwd == storedPwd
            }
        }

        cursor?.close()
        db.close()

        return false
    }

    //로그인상태 업데이트
    fun updateIsLogin(user_id: String, is_login: Int) {
        val db = this.readableDatabase
        val values = ContentValues()

        values.put(IS_LOGIN, is_login)

        db.update(USER_TABLE, values, "$USER_ID = ?", arrayOf(user_id))
        db.close()
    }

    //로그인여부
    fun isUserLoggedIn(): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(IS_LOGIN)
        val cursor = db.query(USER_TABLE, columns, "$IS_LOGIN = ?", arrayOf("1"), null, null, null)

        val isLoggedIn = cursor.moveToFirst()
        cursor.close()
        db.close()

        return isLoggedIn
    }

    //로그아웃
    fun isUserLogout(user_nkname: String) {
        val db = this.readableDatabase
        val values = ContentValues()
        values.put(IS_LOGIN, 0)

        db.update(USER_TABLE, values, "$USER_NKNAME = ?", arrayOf(user_nkname))
        db.close()
    }

    //사용자 정보
    fun getUserInfo(db: SQLiteDatabase): UserInfo? {
        val db = this.readableDatabase
        val columns = arrayOf(USER_NAME, USER_NKNAME, USER_ID)
        val cursor = db.query(USER_TABLE, columns, "$IS_LOGIN = ?", arrayOf("1"), null, null, null)

        if (cursor != null && cursor.moveToFirst()) {
            val nameIndex = cursor.getColumnIndex(USER_NAME)
            val nknameIndex = cursor.getColumnIndex(USER_NKNAME)
            val idIndex = cursor.getColumnIndex(USER_ID)


            if (nknameIndex != -1 && idIndex != -1 && nameIndex != -1) {
                val name = cursor.getString(nameIndex)
                val nkname = cursor.getString(nknameIndex)
                val id = cursor.getString(idIndex)

                cursor.close()
                return UserInfo(name, nkname, id)
            }
        }
        cursor?.close()
        return null
    }

    //레시피추가 (이후 구현 예정)
    /*fun addRecipe(recipe: Recipe) {
        val values = ContentValues()
        values.put(COOK_NAME, recipe.cook_name)
        values.put(COOK_TYPE, recipe.cook_type)
        values.put(COOK_INGREDIENT, recipe.cook_ingredient)
        values.put(COOK_TOOL, recipe.cook_tool)
        values.put(COOK_IMG, recipe.cook_img)
        values.put(COOK_USER, recipe.cook_user)
        values.put(COOK_LEVEL, recipe.cook_level)
        values.put(COOK_LIKE, recipe.cook_like)
        values.put(COOK_C1, recipe.cook_c1)
        values.put(COOK_C2, recipe.cook_c2)
        values.put(COOK_C3, recipe.cook_c3)
        values.put(COOK_C4, recipe.cook_c4)
        values.put(COOK_C5, recipe.cook_c5)
        values.put(COOK_C6, recipe.cook_c6)
        values.put(COOK_C7, recipe.cook_c7)
        values.put(COOK_C8, recipe.cook_c8)
        values.put(COOK_C9, recipe.cook_c9)
        values.put(COOK_C10, recipe.cook_c10)
        values.put(COOK_C11, recipe.cook_c11)
        values.put(COOK_C12, recipe.cook_c12)
        values.put(COOK_T1, recipe.cook_t1)
        values.put(COOK_T2, recipe.cook_t2)
        values.put(COOK_T3, recipe.cook_t3)
        values.put(COOK_T4, recipe.cook_t4)
        values.put(COOK_T5, recipe.cook_t5)
        values.put(COOK_T6, recipe.cook_t6)
        values.put(COOK_T7, recipe.cook_t7)
        values.put(COOK_T8, recipe.cook_t8)
        values.put(COOK_T9, recipe.cook_t9)
        values.put(COOK_T10, recipe.cook_t10)
        values.put(COOK_T11, recipe.cook_t11)
        values.put(COOK_T12, recipe.cook_t12)
        values.put(COOK_I1, recipe.cook_i1)
        values.put(COOK_I2, recipe.cook_i2)
        values.put(COOK_I3, recipe.cook_i3)
        values.put(COOK_I4, recipe.cook_i4)
        values.put(COOK_I5, recipe.cook_i5)
        values.put(COOK_I6, recipe.cook_i6)
        values.put(COOK_I7, recipe.cook_i7)
        values.put(COOK_I8, recipe.cook_i8)
        values.put(COOK_I9, recipe.cook_i9)
        values.put(COOK_I10, recipe.cook_i10)
        values.put(COOK_I11, recipe.cook_i11)
        values.put(COOK_I12, recipe.cook_i12)

        writableDatabase.insert(COOK_TABLE, null, values)
    }*/
}

/*data class Recipe(
    val cook_name: String,
    val cook_type: String,
    val cook_ingredient: String,
    val cook_tool: String,
    val cook_img: String,
    val cook_user: String,
    val cook_level: Int,
    val cook_like: Int,
    val cook_c1: String,
    val cook_c2: String,
    val cook_c3: String,
    val cook_c4: String,
    val cook_c5: String,
    val cook_c6: String,
    val cook_c7: String,
    val cook_c8: String,
    val cook_c9: String,
    val cook_c10: String,
    val cook_c11: String,
    val cook_c12: String,
    *//*val cook_steps: List<String>,*//*
    val cook_t1: Int,
    val cook_t2: Int,
    val cook_t3: Int,
    val cook_t4: Int,
    val cook_t5: Int,
    val cook_t6: Int,
    val cook_t7: Int,
    val cook_t8: Int,
    val cook_t9: Int,
    val cook_t10: Int,
    val cook_t11: Int,
    val cook_t12: Int,
    val cook_i1: String,
    val cook_i2: String,
    val cook_i3: String,
    val cook_i4: String,
    val cook_i5: String,
    val cook_i6: String,
    val cook_i7: String,
    val cook_i8: String,
    val cook_i9: String,
    val cook_i10: String,
    val cook_i11: String,
    val cook_i12: String
)*/
