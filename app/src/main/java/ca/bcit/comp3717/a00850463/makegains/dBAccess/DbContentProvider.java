package ca.bcit.comp3717.a00850463.makegains.dBAccess;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by kearn on 2016-11-02.
 */

public abstract class DbContentProvider {
    public SQLiteDatabase dB;

    public int delete (String tableName, String selection, String[] selectionArgs) {
        return dB.delete(tableName, selection, selectionArgs);
    }

    public long insert(String tableName, ContentValues values) {
        return dB.insert(tableName, null, values);
    }

    protected abstract <T> T cursorToEntity(Cursor cursor);

    public DbContentProvider(SQLiteDatabase dB) {
        this.dB = dB;
    }

    public Cursor query (String tableName, String[] columns, String selection, String[] selectionArgs, String sortOrder) {
        final Cursor cursor = dB.query(tableName, columns, selection, selectionArgs, null ,null, sortOrder);
        return cursor;
    }

    public Cursor query (String tableName, String[] columns, String selection, String[] selectionArgs, String sortOrder, String limit) {
        return dB.query(tableName, columns, selection, selectionArgs, null ,null, sortOrder, limit);

    }

    public Cursor query (String tableName, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return dB.query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

    }

    public int update(String tableName, ContentValues values, String selection, String[] selectionArgs) {
        return dB.update(tableName, values, selection, selectionArgs);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return dB.rawQuery(sql, selectionArgs);
    }
}
