package com.float85.demolistv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterContact extends BaseAdapter {
    List<Contact> contactList;

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhoneNumber);
        ImageView img = view.findViewById(R.id.image);

        Contact contact = contactList.get(position);

        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhoneNumber());
        if (contact.isIcon()) {
            img.setVisibility(View.VISIBLE);
        } else img.setVisibility(View.GONE);
        return view;
    }
}
