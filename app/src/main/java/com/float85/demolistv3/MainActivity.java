package com.float85.demolistv3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contactList;
    Contact contact1, contact2, contact3, contact4, contact5;

    ListView listView;
    AdapterContact adapterContact;
    int mPosition;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hàm khởi tạo list
        contactList = new ArrayList<>();

        listView = findViewById(R.id.lvContact);
        btnAdd = findViewById(R.id.btnAdd);

        contact1 = new Contact("Devpro", "0123456789", true);
        contact2 = new Contact("Android40", "0166666689", false);
        contact3 = new Contact("Láng Hạ", "0127777777", true);
        contact4 = new Contact("Cầu giấy", "0123333333", false);
        contact5 = new Contact("Ngã tư sở", "2222222789", true);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);

        adapterContact = new AdapterContact(contactList);
        listView.setAdapter(adapterContact);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(getBaseContext(),contactList.get(position).getName(),Toast.LENGTH_LONG)
//                        .show();
                mPosition = position;
                String name = contactList.get(position).getName();

                Intent intent = new Intent(getBaseContext(), DetailListview.class);
                intent.putExtra("keyName", name);
//                startActivity(intent);

                startActivityForResult(intent, 115);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DetailListview.class);
                intent.putExtra("keyName", "");
//                startActivity(intent);

                startActivityForResult(intent, 113);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case RESULT_OK:
                String name = data.getStringExtra("newName");
                if (requestCode == 115) {
                    contactList.set(mPosition, new Contact(name, "1234567890", true));
                    adapterContact.notifyDataSetChanged();
                } else if (requestCode == 113) {
                    contactList.add(new Contact(name, "9876543121", true));
                    adapterContact.notifyDataSetChanged();
                }
                break;
            case RESULT_CANCELED:
        }
    }
}