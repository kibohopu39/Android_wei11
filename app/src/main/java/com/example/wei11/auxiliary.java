package com.example.wei11;
import android.provider.BaseColumns;
public class auxiliary {
    public auxiliary() {
    }
    public static abstract class MyTable implements BaseColumns{
        public static final String TABLE_NAME="cust";
        public static final String COLUMN_NAME_NAME="name";
        public static final String COLUMN_NAME_TEL="tel";
        public static final String COLUMN_NAME_BIRTHDAY="birthday";
    }
}
