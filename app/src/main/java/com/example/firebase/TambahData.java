package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.database.Barang;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahData extends AppCompatActivity {

    private DatabaseReference database;
    private Button btnsubmit;
    private EditText edKode;
    private EditText edNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        edKode =(EditText) findViewById(R.id.edkode);
        edNama =(EditText) findViewById(R.id.ednama);
        btnsubmit = (Button) findViewById(R.id.Btnsubmit);

        database = FirebaseDatabase.getInstance().getReference();
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(edKode.getText().toString().isEmpty()) && !(edNama.getText().toString().isEmpty()))
                    SubmitData(new Barang(edKode.getText().toString(),edNama.getText().toString()));
                //edKode.getText().toString(),edNama.getText().toString()));
                else
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edKode.getWindowToken(),0);



            }
        });
    }
    public void SubmitData(Barang brg){
        database.child("Barang").push().setValue(brg).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                edKode.setText("");
                edNama.setText("");
                Toast.makeText(getApplicationContext(),"Data berhasil ditambahkan", Toast.LENGTH_LONG).show();
            }
        });
    }
    public static Intent getActIntent(Activity activity){
        return new Intent(activity, TambahData.class);
    }

}
