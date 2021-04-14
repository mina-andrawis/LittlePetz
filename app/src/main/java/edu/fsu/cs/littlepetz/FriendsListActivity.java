package edu.fsu.cs.littlepetz;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FriendsListActivity extends AppCompatActivity {


    Button addFriendButton;

    EditText addFriendEdit;

    ListView friendsList;

    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_friends);
        super.onCreate(savedInstanceState);

        addFriendButton = (Button) findViewById(R.id.addFriendButton);
        addFriendEdit = (EditText) findViewById(R.id.addFriendEditText);
        friendsList = (ListView) findViewById(R.id.friendsListView);

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        friendsList.setAdapter(adapter);


        addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCursor = getContentResolver().query(FriendProvider.CONTENT_URI, null, null, null, null);

                if (mCursor != null) {
                    if (mCursor.getCount() > 0) {
                        mCursor.moveToNext();
                        setlistView();
                    }
                }


            }
        });


    }

    private void setlistView() {
        listItems.add(mCursor.getString(1) + ", " + mCursor.getString(2));
        adapter.notifyDataSetChanged();
    }

}

