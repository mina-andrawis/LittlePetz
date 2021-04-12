package edu.fsu.cs.littlepetz;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// ADAPTED FROM CONTENT PROVIDER CLASS EXAMPLE //

import androidx.appcompat.app.AppCompatActivity;

public class FriendsListActivity extends AppCompatActivity {


    Button addFriendButton;

    EditText addFriendEdit;

    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_friends);
        super.onCreate(savedInstanceState);


        addFriendButton = (Button) findViewById(R.id.addFriendButton);
        addFriendEdit = (EditText) findViewById(R.id.addFriendEditText);


    }


    public void onClickAddFriend(View view)
    {

    }
}

