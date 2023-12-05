package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityRecipeApplicationEnrollBinding

/*internal interface DBContract {
    companion object {
        const val TABLE_NAME = "RECIPE_APPLICATION"
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

        const val SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + "(" +
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
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME
        const val SQL_LOAD = "SELECT * FROM " + TABLE_NAME


    }
} //DBContract*/

/*internal class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_FILE, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DBContract.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DBContract.SQL_DROP_TABLE)
        onCreate(db)
    }

    companion object {
        const val DB_FILE = "yumyum"
        const val DB_VERSION = 1
    }
    }*/
class RecipeApplicationEnrollActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeApplicationEnrollBinding
    /*private var dbHelper:DBHelper? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeApplicationEnrollBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }





    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRecipeApplicationEnrollBinding.inflate(inflater, container, false)

        val dataList = mutableListOf<MutableMap<String, String>>()  //key, value 필요, key는 NO

    } //onCreateView*/

} //Activity