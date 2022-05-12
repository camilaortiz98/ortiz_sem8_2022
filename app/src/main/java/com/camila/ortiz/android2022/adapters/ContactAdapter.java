package com.camila.ortiz.android2022.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.camila.ortiz.android2022.MainActivity;
import com.camila.ortiz.android2022.R;
import com.camila.ortiz.android2022.entities.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<Contact> contacts;
    MainActivity mainActivity;
    Context context;

    public ContactAdapter(List<Contact> contacts, MainActivity mainActivity,Context context) {
        this.contacts = contacts;
        this.mainActivity = mainActivity;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ContactViewHolder vh = new ContactViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {
        Contact contact = contacts.get(position);
        TextView tvContactName = vh.itemView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = vh.itemView.findViewById(R.id.tvContactNumber);
        Button tvCall = vh.itemView.findViewById(R.id.bt_call);
        Button tvSMS = vh.itemView.findViewById(R.id.bt_sms);
        tvContactName.setText(contact.name);
        tvContactNumber.setText(contact.number);


        tvCall.setOnClickListener(v -> {
            Log.e("LLAMAR ", "btn");
            Log.e("Nombre: ", contact.name);
            Log.e("Numero: ", contact.number);

            if(!vfCallPermission()){

                String phone = "+51" + contact.number;
                Intent intent = new Intent(android.content.Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
                context.startActivity(intent);
            }else {
                ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.CALL_PHONE}, 101);
            }

        });


        tvSMS.setOnClickListener(v -> {
            Log.e("MENSAJE ", "btn");
            Log.e("Nombre: ", contact.name);
            Log.e("Numero: ", contact.number);


            if(!vfSMSPermission()){
                String phone = contact.number;

                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.fromParts("sms",phone,null));
                smsIntent.putExtra("sms_body", "Hola ");
                context.startActivity(smsIntent);
            }else {
                ActivityCompat.requestPermissions(mainActivity, new String[]{Manifest.permission.SEND_SMS}, 102);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    boolean vfCallPermission() {
        return ActivityCompat.checkSelfPermission(mainActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED;
    }

    boolean vfSMSPermission() {
        return ActivityCompat.checkSelfPermission(mainActivity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
