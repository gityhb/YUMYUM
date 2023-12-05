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
        const val USER_TABLE = "USER_T"
        const val USER_NO = "USER_NO"
        const val USER_NAME = "USER_NAME"
        const val USER_ID = "USER_ID"
        const val USER_NKNAME = "USER_NKNAME"
        const val USER_PWD = "USER_PWD"
        const val USER_PHONE = "USER_PHONE"
        const val USER_EMAIL = "USER_EMAIL"
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
        const val COOK_C11= "COOK_C11"
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
        const val COOK_T11= "COOK_T11"
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
        const val COOK_I11= "COOK_I11"
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
                USER_EMAIL + " TEXT NOT NULL )"
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

        val SQL_CREATE_COOK_TABLE = "CREATE TABLE IF NOT EXISTS " +
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
        db?.execSQL(SQL_CREATE_COOK_TABLE)
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
        val rowId = db.insert(USER_TABLE, null, values)

        db.close()

        return rowId
    }

    // 아이디 중복 확인
    fun isUserIdExists(user_id: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT $USER_ID FROM $USER_TABLE WHERE $USER_ID = ?", arrayOf(user_id))
        val exists = cursor.count > 0

        cursor.close()

        return exists
    }

    //닉네임 중복 확인
    fun isUserNknameExists(user_nkname: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT $USER_NKNAME FROM $USER_TABLE WHERE $USER_NKNAME = ?", arrayOf(user_nkname))
        val exists = cursor.count > 0

        cursor.close()

        return exists
    }

    //로그인
    fun isLogin(user_id: String, user_pwd: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(USER_ID, USER_PWD)
        val cursor = db.query(USER_TABLE, columns, "$USER_ID = ?", arrayOf(user_id), null, null, null)

        if(cursor != null && cursor.moveToFirst()) {
            val pwdIndex = cursor.getColumnIndex(USER_PWD)
            if(pwdIndex != -1) {
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

    //레시피추가
    fun addRecipe(recipe: Recipe) {
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
    }

    fun generateRecipeList(): List<Recipe> {
        return listOf(
            Recipe("동물모양쿠키", "제과", "무염버터 100g, 설탕 60g, 소금 1g, 계란 30g, 바닐라익스트랙, 베이킹파우더 2g, 박력분 200g(초코: 박력분 180g, 코코아가루 20g)",
                "제과제빵용 주걱, 종이호일, 체, 쟁반, 밀대, 믹싱볼(그릇), 쿠키틀(쿠키커터)", "", "", 1, 55,
                "버터가 말랑해지도록 실온에 둔 후 볼에 넣고 풀어준다.", "설탕과 소금을 넣고 버터색이 약간 밝아질 때까지 주걱으로 잘 섞는다.", "계랸을 2번에 나누어 넣으면서 섞어준다.", "박력분과 베이킹파우더를 체 쳐서 넣는다.", "반죽이 뭉쳐질 때까지 주걱을 수직으로 세워 자르듯 섞는다.", "뭉쳐진 반죽을 살살 눌러서 매끈한 상태로 만든다.(너무 많이 치대지 않는다.)",
                "반죽을 종이호일에 넣어 약 0.5cm 두꼐로 균일하게 핀다.(비닐봉지도 가능하다.)", "핀 반죽을 쟁반에 담아 40분간 냉장한다.", "반죽에 모양틀을 찍어낸다.", "오븐 170도 15분 예열 후 170도에서 13-15분간 굽는다.", "오븐에서 꺼낸 후 5분간 식힌다.", "",
                0,0,0,0,0,0,0,2400,0,900,300,0, "", "", "", "", "", "", "", "", "", "", "", ""),
            Recipe("스콘", "제과", "무염버터 100g, 설탕 40g, 소금 2g, 베이킹파우터 2g, 계랸 50g, 우유 50g, 중력분 220g(초코: 중력분 200g, 코코아 가루: 20g)",
                "제과제빵용 주걱, 제과제빵용 붓, 종이호일, 체, 랩, 믹싱볼(그릇)", "", "", 2, 102,
                "설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다.", "버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다.", "계란과 우유를 섞어서 30분간 냉장한다.", "냉장시킨 가루를 체 쳐서 볼에 넣는다.", "차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)", "가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다.",
                "날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)", "사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다.", "반죽을 랩에 싸서 1시간 냉장한다.", "75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다.", "달걀물을 반죽 표면 위에 얇게 바른다.", "오븐 190도 10분 예열 후 180도에서 20분간 굽는다.",
                1800,1800,1800,0,0,0,0,0,3600,0,0,1200, "", "", "", "", "", "", "", "", "", "", "", ""),
            Recipe("닭발", "한식", "무뼈닭발 500g, 통후추 2스푼, 생강 1톨, 고추장 3스푼, 고춧가루 2스푼, 간장 3스푼, 올리고당 1스푼, 다진 마늘 2스푼 ", "프라이팬, 주걱, 냄비, 칼", "", "", 2, 43, "닭발을 해동시켜 깨끗이 씻는다.", "10분정도 삶는다.", "삶은 닭발을 찬물에 깨끗이 씻는다.", "고추장 3스푼과 고춧가루 2스푼, 간장2스푼을 넣고 버물린다.",
                "30분동안 재워둔다. ", "달구워진 팬에 기름을 두르고 재워둔 닭발을 넣고 볶는다.","약한 불에 10분정도 조려준다.","","","","","",200,600,200,2400,1800, 400,600,0,0,0,0,0,"","","","","","","","","","","",
                ""),
            Recipe("머핀", "제과","박력분 340g, 설탕 340g, 바닐라파우더 4g, 계란 4개, 버터 340g, 베이킹파우더 4g, 소금 4g", "믹싱볼, 체, 거품기, 제과제빵용 주걱, 짤주머니, 틀", "","",1, 56, "베이킹에 들어갈 재료들을 계량하여 준비한다."
                , "계란을 풀고 반죽을 한다.", "버터에 설탕을 여러번 나누어 넣으면서 녹인다.", "설탕과 버터를 잘 섞였다면 풀어둔 계란을 세번을 나눠 넣어 섞어준다.", "박력분과 베이킹파우더, 바닐라파우더, 소금을 체에 내려준다.","오븐을 170도-180도에서 예열해준다.", "짤주머니에 주걱으로 잘 넣어서 매듭을 집게로 집어준다.", "틀에 반죽을 넣어주고 위에 토핑을 넣어준다.","170도에서 20분 구워준다.",
                "","","",0,0,0, 0,0,0,0,0,1200, 0,0,0,"","","","","","","","","","","",""),
            Recipe("라멘", "일식", "라멘 생면 1인분, 마늘 1/2t, 생강 1/2t, 설탕, 1t, 참기름 1t, 미소, 1T, 돼지고기 150g", "프라이팬, 냄비, 주걱, 집게", "","",1,23,"생강을 다진다.", "대파는 채썰어서 찬물에 담가둔다.", "숙주를 씻어서 물기를 빼놓는다.",
                "계란은 반으로 잘라 놓는다", "팬에 오일을 살짝만 두르고 돼지고기 간 것과 생강을 주걱으로 볶는다.","두반장, 미소, 설탕을 넣고, 물, 1/4컵을 붓고 조린다.",
                "냄비에 참기를 1t을 두르고 마늘, 생강 1/2t씩 넣고 볶는다.", "물 400ml, 미소 1T도 잘 풀어넣어준다", "면을 2분 삶는다.", "면은 물기를 털고 그륵에 넣어준 뒤 면을 넣어준다.","고기와 숙주로 토핑한다.","",0,0,0,0,300, 300,500,200, 120,0, 0, 0, "","","","","","",
                "","","","","","")
        )
    }
}

data class Recipe(
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
)