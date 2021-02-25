package com.example.goodfootbreaking;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText edLogin, edPassword, edName;
    private FirebaseAuth mAuth;
    private Button bStart, bSignUp, bSignIn, bSignOut;
    private TextView tvUserEmail;
    private String PUPILS_KEY ="Pupils";    //  идентификатор таблицы в БД
    private DatabaseReference mDataBase;    //  ссылка на БД
    private Boolean registration;           //  признак регистрации, в случае регистрации при первом входе в БД будет добавлен новый пользователь
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }
    @Override

    // Проверка наличия пользователя в системе
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

        FirebaseUser cUser = mAuth.getCurrentUser();
        if ((cUser != null) && ( cUser.getEmail().equals("root@mail.ru") || cUser.isEmailVerified()))
        {
            showSigned();
            String userName = "Вы вошли как: " + cUser.getEmail();
            tvUserEmail.setText(userName);
        }
        else notSigned();


    }

    // Начальная инициализация
    private void init()
    {
        registration = false;                           // сбрасываем флаг регистрации
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);
        edName = findViewById(R.id.edName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        bStart = findViewById(R.id.bStart);
        bSignOut = findViewById(R.id.bSignOut);
        bSignUp = findViewById(R.id.bSignUp);
        bSignIn = findViewById(R.id.bSignIn);

        // Инициализация Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Инициализация Firebase DataBase
        mDataBase = FirebaseDatabase.getInstance().getReference(PUPILS_KEY);
    };

    // Регистрация нового пользователя
    public void onClickSignUp(View view)
    {
        if(isConnected()) {
            if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()) && !registration ) {
                mAuth.createUserWithEmailAndPassword(edLogin.getText().toString().trim().toLowerCase(), edPassword.getText().toString().trim()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //User registered successfully
                            showSigned();
                            sendEmailVer();
                            Toast.makeText(getApplicationContext(), "Вы успешно зарегистрированы", Toast.LENGTH_SHORT).show();
                            registration = true;
                        }else{
                            notSigned();
                            if(edPassword.getText().toString().length()<6)
                            Toast.makeText(getApplicationContext(), "Пароль должен быть более 5 символов", Toast.LENGTH_SHORT).show();
                            else Toast.makeText(getApplicationContext(), "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            else Toast.makeText(getApplicationContext(), "Введите необходимые поля", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this,"Отсутствует подключение к интеренету",Toast.LENGTH_SHORT).show();
    }

    // Вход пользователя в систему
    public void onClickSignIn(View view)
    {

        if(isConnected())
        {
                if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()))
                {

                    mAuth.signInWithEmailAndPassword(edLogin.getText().toString().trim().toLowerCase(), edPassword.getText().toString().trim()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            FirebaseUser cUser = mAuth.getCurrentUser();
                            if (task.isSuccessful() && (edLogin.getText().toString().trim().toLowerCase().equals("root@mail.ru") || cUser.isEmailVerified()))
                            {
                                showSigned();
                                Toast.makeText(getApplicationContext(), "Вход произведен успешно", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                notSigned();
                                Toast.makeText(getApplicationContext(), "Ошибка входа", Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(), "Проверьте Вашу почту и подтвердить свой Email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else Toast.makeText(getApplicationContext(), "Введите необходимые поля", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this,"Отсутствует подключение к интеренету",Toast.LENGTH_SHORT).show();
    }

    // Выход пользователя из своего аккаунта
    public void onClickSignOut(View view)
    {
        FirebaseAuth.getInstance().signOut();
        notSigned();
    }

    // Отрисовка элементов
    private void showSigned()
    {
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        if((user.isEmailVerified())||(user.getEmail().toString().equals("root@mail.ru"))) {
            String userName = "Вы вошли как: " + user.getEmail();
            tvUserEmail.setText(userName);
            bStart.setVisibility(View.VISIBLE);
            bSignOut.setVisibility(View.VISIBLE);
            tvUserEmail.setVisibility(View.VISIBLE);

            edPassword.setVisibility(View.GONE);
            edLogin.setVisibility(View.GONE);
            edName.setVisibility(View.GONE);
            bSignIn.setVisibility(View.GONE);
            bSignUp.setVisibility(View.GONE);
        }
        else Toast.makeText(getApplicationContext(),"Проверьте Вашу почту для подтверждения Email",Toast.LENGTH_SHORT).show();
    }

    private void notSigned()
    {
        bStart.setVisibility(View.GONE);
        bSignOut.setVisibility(View.GONE);
        tvUserEmail.setVisibility(View.GONE);

        edPassword.setVisibility(View.VISIBLE);
        edLogin.setVisibility(View.VISIBLE);
        edName.setVisibility(View.VISIBLE);
        bSignIn.setVisibility(View.VISIBLE);
        bSignUp.setVisibility(View.VISIBLE);
    }

    // Вход на страницу статистики
    public void onClickStart(View view)
    {
        if(isConnected())
        {
            FirebaseUser cUser = mAuth.getCurrentUser();
            assert cUser != null;
            if ((!cUser.getEmail().toString().equals("root@mail.ru")) && registration)
            {
                // Добавляем нового пользователя в случае регистрации и если не root
                Pupils newPupil = new Pupils();
                newPupil.name = edName.getText().toString().trim();
                newPupil.email = edLogin.getText().toString().trim().toLowerCase();
                newPupil.id = mDataBase.getKey();

                mDataBase.push().setValue(newPupil);
                registration = false;
            }

            Intent i = new Intent(LoginActivity.this, StatisticActivity.class);
            String userName = cUser.getEmail();
            i.putExtra(StatisticActivity.CURRENT_EMAIL, userName);
            startActivity(i);
        }
        else Toast.makeText(this,"Отсутствует подключение к интеренету",Toast.LENGTH_SHORT).show();
    }

    // Решение задачи верификации
    private void sendEmailVer()
    {
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(getApplicationContext(),"Проверьте Вашу почту для подтверждения Email",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Ошибка верификации",Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Проверка подключения к интернету
    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        }
        catch (Exception e)
        {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

}
