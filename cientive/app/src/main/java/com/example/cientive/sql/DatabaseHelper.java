package com.example.cientive.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cientive.model.Coachee;
import com.example.cientive.model.LoginCoach;
import com.example.cientive.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 9/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_COACH = "Coach";
    private static final String TABLE_COACHEE = "Coachee";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    // coach columns for coach
    private static final String COLUMN_COACH_ID = "coach_id";
    private static final String COLUMN_COACH_NAME = "coach_name";
    private static final String COLUMN_COACH_EMAIL = "coach_email";
    private static final String COLUMN_COACH_PASSWORD = "coach_password";
    private static final String COLUMN_COACH_PRICE = "coach_price";
    private static final String COLUMN_COACH_ASSOCIATION = "coach_association";
    private static final String COLUMN_COACH_ADDRESS = "coach_address";
    private static final String COLUMN_COACH_CELLPHONE = "coach_cellphone";

    // coach columns
    private static final String COLUMN_COACHEE_ID = "coachee_id";
    private static final String COLUMN_COACHEE_NAME = "coachee_name";
    private static final String COLUMN_COACHEE_EMAIL = "coachee_email";
    private static final String COLUMN_COACHEE_PASSWORD = "coachee_password";
    private static final String COLUMN_COACHEE_CELLPHONE = "coachee_cellphone";


    // create table sql query for coach
    private String CREATE_COACH_TABLE = "CREATE TABLE " + TABLE_COACH + "("
            + COLUMN_COACH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COACH_NAME + " TEXT,"
            + COLUMN_COACH_EMAIL + " TEXT," + COLUMN_COACH_PASSWORD + " TEXT" + COLUMN_COACH_PRICE + "TEXT" + COLUMN_COACH_ASSOCIATION + "TEXT" + COLUMN_COACH_ADDRESS + "TEXT" + COLUMN_COACH_CELLPHONE + "TEXT" + ")";

    // create table sql query for coachee
    private String CREATE_COACHEE_TABLE = "CREATE TABLE " + TABLE_COACHEE + "("
            + COLUMN_COACHEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COACHEE_NAME + " TEXT,"
            + COLUMN_COACHEE_EMAIL + " TEXT," + COLUMN_COACHEE_PASSWORD + " TEXT" + COLUMN_COACHEE_CELLPHONE + "TEXT" + ")";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query for coach
    private String DROP_COACH_TABLE = "DROP TABLE IF EXISTS " + TABLE_COACH;

    // drop table sql query for coachee
    private String DROP_COACHEE_TABLE = "DROP TABLE IF EXISTS " + TABLE_COACHEE;

    // drop table sql query for booking


    /**
     * Constructor
     * 
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_COACH_TABLE);
        db.execSQL(CREATE_COACHEE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_COACH_TABLE);
        db.execSQL(DROP_COACHEE_TABLE);

        // Create tables again
        onCreate(db);

    }





    /**
     * This method is to create coach record
     *
     * @param coach
     */

    public void addCoach(LoginCoach coach) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COACH_NAME, coach.getCoachName());
        values.put(COLUMN_COACH_EMAIL, coach.getCoachEmail());
        values.put(COLUMN_COACH_PASSWORD, coach.getCoachPassword());

        // Inserting Row
        db.insert(TABLE_COACH, null, values);
        db.close();
    }

    /**
     * This method is to create coachee record
     *
     * @param coachee
     */

    public void addCoachee(Coachee coachee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COACHEE_NAME, coachee.getCoacheeName());
        values.put(COLUMN_COACHEE_EMAIL, coachee.getCoacheeEmail());
        values.put(COLUMN_COACHEE_PASSWORD, coachee.getCoacheePassword());

        // Inserting Row
        db.insert(TABLE_COACHEE, null, values);
        db.close();
    }

    /**
     * This method to update coach record
     *
     * @param coach
     */
    public void updateCoach(LoginCoach coach) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COACH_NAME, coach.getCoachName());
        values.put(COLUMN_COACH_EMAIL, coach.getCoachEmail());
        values.put(COLUMN_COACH_PASSWORD, coach.getCoachPassword());

        // updating row
        db.update(TABLE_COACH, values, COLUMN_COACH_ID + " = ?",
                new String[]{String.valueOf(coach.getCoachId())});
        db.close();
    }

    /**
     * This method to update coachee record
     *
     * @param coachee
     */
    public void updateCoachee(Coachee coachee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COACHEE_NAME, coachee.getCoacheeName());
        values.put(COLUMN_COACHEE_EMAIL, coachee.getCoacheeEmail());
        values.put(COLUMN_COACHEE_PASSWORD, coachee.getCoacheePassword());

        // updating row
        db.update(TABLE_COACHEE, values, COLUMN_COACHEE_ID + " = ?",
                new String[]{String.valueOf(coachee.getCoacheeId())});
        db.close();
    }
    /**
     * This method is to delete coach record
     *
     * @param coach
     */
    public void deleteCoach(LoginCoach coach) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_COACH, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(coach.getCoachId())});
        db.close();
    }

    /**
     * This method is to delete coachee record
     *
     * @param coachee
     */
    public void deleteCoachee(Coachee coachee) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_COACHEE, COLUMN_COACHEE_ID + " = ?",
                new String[]{String.valueOf(coachee.getCoacheeId())});
        db.close();
    }




    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }




    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
