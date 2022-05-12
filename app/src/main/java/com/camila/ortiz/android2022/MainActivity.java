package com.camila.ortiz.android2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.camila.ortiz.android2022.adapters.ContactAdapter;
import com.camila.ortiz.android2022.adapters.StringAdapter;
import com.camila.ortiz.android2022.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Contact> contacts = getContacts();
        ContactAdapter adapter = new ContactAdapter(contacts,MainActivity.this,MainActivity.this);

        RecyclerView rv = findViewById(R.id.rvContacts);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }

    private List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1,"Alicia Campos","951718281"));
        contacts.add(new Contact(2,"Carlos Cabrera","987895354"));
        contacts.add(new Contact(3,"Lorena Carranza","988504354"));
        contacts.add(new Contact(4,"Luisa Madrigal","985354354"));
        contacts.add(new Contact(5,"Fiorella Ortiz","987654987"));
        contacts.add(new Contact(6,"Sandra Cabrera","987804354"));
        contacts.add(new Contact(7,"Carla Ortiz","987654354"));
        contacts.add(new Contact(8,"Maria Cabrera","987654354"));
        contacts.add(new Contact(9,"Diego Jaramillo","987654354"));
        contacts.add(new Contact(10,"Alan Saenz","987654354"));

        return contacts;
        }
    }


