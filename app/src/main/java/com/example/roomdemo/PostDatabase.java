package com.example.roomdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Post.class,version = 1)
public abstract class PostDatabase extends RoomDatabase {
    private static PostDatabase instance;
    public abstract PostDao postDao();

    public static synchronized PostDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    PostDatabase.class,"posts-database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
