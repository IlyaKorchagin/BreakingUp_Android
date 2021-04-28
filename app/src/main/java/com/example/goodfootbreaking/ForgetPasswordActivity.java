package com.example.goodfootbreaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ForgetPasswordActivity extends AppCompatActivity {
    private EditText edEmail;
    private Button bResetPassword;
    private String PUPILS_KEY ="Pupils";    //  идентификатор таблицы в БД
    private DatabaseReference mDataBase;    //  ссылка на БД
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        init();
    }

    private void init()
    {
        edEmail = findViewById(R.id.edPasswordEmail);
        bResetPassword = findViewById(R.id.bResetPassword);
        // Инициализация Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Инициализация Firebase DataBase
        mDataBase = FirebaseDatabase.getInstance().getReference(PUPILS_KEY);
    }
    public void onClickResetPassword(View view) {
        if (TextUtils.isEmpty(edEmail.getText().toString())){
            Toast.makeText(getApplicationContext(), "Введите Email", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.sendPasswordResetEmail(edEmail.getText().toString().trim().toLowerCase()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Вам на почту отправленно сообщение о смене пароля", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Ошибка! Сообщение не отправленно.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}