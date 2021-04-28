package com.example.goodfootbreaking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StatisticActivity extends AppCompatActivity {

    FRatingTable fragRatingTable;
    FEvents fragEvents;
    FMainRezults fragMainRez;
    FragmentTransaction fTrans;
    public static final String CURRENT_EMAIL = "current_email";
    private String curEmail;
    private String PUPILS_KEY ="Pupils";
    private DatabaseReference mDataBase;
    private static Pupils curPupil;
    private ProgressBar ratingBar;
    private TextView name, pupil_name, ratingtext, tvStatus, tvStatusTitle;
    private ImageView photo;
    private Toolbar toolbar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        init();
        Intent intent = getIntent();
        curEmail = intent.getStringExtra(CURRENT_EMAIL);

        fragRatingTable = new FRatingTable();
        fragEvents = new FEvents();

        getDataFromDB();
    }



    private void init()
    {
        toolbar =  findViewById(R.id.toolBarUser);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.message);        // связываем переменную с компонентом
        pupil_name = findViewById(R.id.pupil_name);
        tvStatus = findViewById(R.id.pupil_status);
        tvStatusTitle = findViewById(R.id.status);
        ratingtext = findViewById(R.id.ratingtext);
        ratingBar = findViewById(R.id.ratingBar);
        photo = findViewById(R.id.avatar);
        mDataBase = FirebaseDatabase.getInstance().getReference(PUPILS_KEY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Заполнение меню; элементы действий добавляются на панель приложения
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Обработка нажатия кнопок на панели приложения
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       fTrans = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.MyRoomMenuBtn:
                TextView ratingtext = (TextView)findViewById(R.id.ratingtext);
                ratingtext.setText(String.valueOf(" FREZZE RATING - " + curPupil.getFrezze_rating()) + "%");
                fTrans.replace(R.id.userFragment,fragMainRez);
                LinearLayout head = (LinearLayout) findViewById(R.id.headlayout);
                this.setTitle(Html.fromHtml("<small>Личный кабинет</small>"));
                head.setVisibility(View.VISIBLE);
                break;

            case R.id.RatingMenuBtn:
                Bundle fmyrezbundle = new Bundle();
                fmyrezbundle.putSerializable("curPupil", curPupil);
                fragRatingTable.setArguments(fmyrezbundle);
                fTrans.replace(R.id.userFragment, fragRatingTable);
                head = (LinearLayout) findViewById(R.id.headlayout);
                this.setTitle(Html.fromHtml("<small>Рейтинговая таблица</small>"));
                head.setVisibility(View.GONE);
                break;

            case R.id.EventsBtn:
                fTrans.replace(R.id.userFragment, fragEvents);
                head = (LinearLayout) findViewById(R.id.headlayout);
                this.setTitle(Html.fromHtml("<small>Календарь событий</small>"));
                head.setVisibility(View.GONE);
                break;


            default:
                return super.onOptionsItemSelected(item);

        }
        fTrans.commit();
        return true;

    }

    private void getDataFromDB()
    {
        if (curEmail.equals("root@mail.ru"))
        {
            Pupils newPupil = new Pupils(curEmail);
            curPupil = newPupil;
            FillScreen(curPupil);
        }
        else
        {
            mDataBase.orderByChild("email").equalTo(curEmail).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Pupils pupil = ds.getValue(Pupils.class);
                        if (pupil != null) {
                            curPupil = pupil;
                            FillScreen(curPupil);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }

            });
        }

    }

    @SuppressLint("ResourceAsColor")
    private void FillScreen(Pupils curPupil)
    {
        Bundle fmyrezbundle = new Bundle();
        fmyrezbundle.putSerializable("curPupil", curPupil);
        fragMainRez = new FMainRezults();
        fragMainRez.setArguments(fmyrezbundle);
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.userFragment, fragMainRez);
        fTrans.commit();

        ratingBar.setProgress((int) curPupil.getRating());
        name.setTextSize(14);
        pupil_name.setTextSize(16);
        pupil_name.setText(curPupil.getName());
        tvStatusTitle.setTextSize(12);
        tvStatusTitle.setText("Номинация: ");
        tvStatus.setTextSize(12);
        tvStatus.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
        switch (curPupil.getStatus()) {
            case 0:
                tvStatus.setText("не указана");
            break;

            case 1:
                tvStatus.setTextColor(getResources().getColor(R.color.baby));
                tvStatus.setText("Дети до 7 лет");
            break;

            case 2:
                tvStatus.setTextColor(getResources().getColor(R.color.logo_green));
                tvStatus.setText("Начинающие");
            break;

            case 3:
                tvStatus.setTextColor(getResources().getColor(R.color.logo_sea));
                tvStatus.setText("Второгодки");
            break;

            case 4:
                tvStatus.setTextColor(getResources().getColor(R.color.logo_orange));
                tvStatus.setText("Продолжающие");
            break;

            case 5:
                tvStatus.setTextColor(getResources().getColor(R.color.logo_red));
                tvStatus.setText("Kids Pro");
            break;

            default: tvStatus.setText("Номинация: не указана");
            break;
        }


        if (ratingBar.getProgress() <= 10) {
            photo.setImageResource(R.drawable.level1);
            name.setText(String.valueOf("LEVEL 1. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 20) {
            photo.setImageResource(R.drawable.level2);
            name.setText(String.valueOf("LEVEL 2. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 30) {
            photo.setImageResource(R.drawable.level3);
            name.setText(String.valueOf("LEVEL 3. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 40) {
            photo.setImageResource(R.drawable.level4);
            name.setText(String.valueOf("LEVEL 4. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 50) {
            photo.setImageResource(R.drawable.level5);
            name.setText(String.valueOf("LEVEL 5. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 60) {
            photo.setImageResource(R.drawable.level6);
            name.setText(String.valueOf("LEVEL 6. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 70) {
            photo.setImageResource(R.drawable.level7);
            name.setText(String.valueOf("LEVEL 7. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 80) {
            photo.setImageResource(R.drawable.level8);
            name.setText(String.valueOf("LEVEL 8. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 90) {
            photo.setImageResource(R.drawable.level9);
            name.setText(String.valueOf("LEVEL 9. Rating - " + curPupil.getRating()) + "%");
        } else if (ratingBar.getProgress() <= 100) {
            photo.setImageResource(R.drawable.level10);
            name.setText(String.valueOf("LEVEL 10. Rating - " + curPupil.getRating()) + "%");
        }

        ratingtext.setText(String.valueOf(" FREZZE RATING - " + curPupil.getFrezze_rating()) + "%");
    }


}

