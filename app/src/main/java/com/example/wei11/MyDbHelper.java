package com.example.wei11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.wei11.auxiliary.MyTable;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            Log.v("wei","onCreate()");
            db.execSQL(SQL_create_table);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        //設定表格的屬性
        public static final String DATABASE_NAME="MyDbHelper.db";
        private static final String INT_TYPE="integer";
        private static final String TEXT_TYPE="TEXT";
        private static final String DATE_TYPE="DATE";
        private static final String COMMA_SEP=",";

        private static final String SQL_create_table=
                "CREATE TABLE "+MyTable.TABLE_NAME+"("
                        +MyTable._ID+INT_TYPE+" primary key autoincrement"+COMMA_SEP
                        +MyTable.COLUMN_NAME_NAME+TEXT_TYPE+COMMA_SEP
                        +MyTable.COLUMN_NAME_TEL+TEXT_TYPE+COMMA_SEP
                        +MyTable.COLUMN_NAME_BIRTHDAY+DATE_TYPE+")";
    }
