package woowacourse.omok

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OmokDbHelper(context: Context?) :
    SQLiteOpenHelper(context, "${OmokContract.TABLE_NAME}", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE ${OmokContract.TABLE_NAME} (" +
                "${OmokContract.TABLE_COLUMN_COLOR} varchar(2) not null," +
                "${OmokContract.TABLE_COLUMN_X} int not null," +
                "${OmokContract.TABLE_COLUMN_Y} int not null," +
                "UNIQUE (x,y)" +
                ");",
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${OmokContract.TABLE_NAME}")
        onCreate(db)
    }
}
