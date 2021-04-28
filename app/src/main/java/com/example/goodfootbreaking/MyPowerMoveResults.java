package com.example.goodfootbreaking;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MyPowerMoveResults extends Fragment implements View.OnClickListener {

    private ProgressBar myBackspinRating;
    private TextView myBackspinRatingText;
    private ImageButton myBackspinImage;

    private ProgressBar myAirflareRating;
    private TextView myAirflareRatingText;
    private ImageButton myAirflareImage;

    private ProgressBar myCricketRating;
    private TextView myCricketRatingText;
    private ImageButton myCricketImage;

    private ProgressBar myElbowAirflareRating;
    private TextView myElbowAirflareRatingText;
    private ImageButton myElbowAirflareImage;

    private ProgressBar myFlareRating;
    private TextView myFlareRatingText;
    private ImageButton myFlareImage;

    private ProgressBar myJackhammerRating;
    private TextView myJackhammerRatingText;
    private ImageView myJackhammerImage;

    private ProgressBar myHaloRating;
    private TextView myHaloRatingText;
    private ImageButton myHaloImage;

    private ProgressBar myHeadspinRating;
    private TextView myHeadspinRatingText;
    private ImageButton myHeadspinImage;

    private ProgressBar myMunchmillRating;
    private TextView myMunchmillRatingText;
    private ImageButton myMunchmillImage;

    private ProgressBar myNinety_nineRating;
    private TextView myNinety_nineRatingText;
    private ImageButton myNinety_nineImage;

    private ProgressBar mySwipesRating;
    private TextView mySwipesRatingText;
    private ImageButton mySwipesImage;

    private ProgressBar myTurtelMoveRating;
    private TextView myTurtelMoveRatingText;
    private ImageButton myTurtelMoveImage;

    private ProgressBar myUfoRating;
    private TextView myUfoRatingText;
    private ImageButton myUfoImage;

    private ProgressBar myWebRating;
    private TextView myWebRatingText;
    private ImageButton myWebImage;

    private ProgressBar myWindmillRating;
    private TextView myWindmillRatingText;
    private ImageButton myWindmillImage;

    private ProgressBar myWolfRating;
    private TextView myWolfRatingText;
    private ImageButton myWolfImage;

    private static Pupils pupil;



    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    public static MyPowerMoveResults newInstance(int page, Pupils curPupil) {
        MyPowerMoveResults pageFragment = new MyPowerMoveResults();
        pupil = curPupil;
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }


    public MyPowerMoveResults() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String words="";
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_power_move_results, container, false);


        myBackspinRating = (ProgressBar) view.findViewById(R.id.backspinRatingBar);
        myBackspinRatingText = (TextView) view.findViewById(R.id.backspinRatingtext);
        myBackspinImage = (ImageButton) view.findViewById(R.id.imageBackspin);
        myBackspinImage.setOnClickListener(this);

        myAirflareRating = (ProgressBar) view.findViewById(R.id.AirflareRatingBar);
        myAirflareRatingText = (TextView) view.findViewById(R.id.AirflareRatingtext);
        myAirflareImage = (ImageButton) view.findViewById(R.id.imageAirflare);
        myAirflareImage.setOnClickListener(this);

        myCricketRating = (ProgressBar) view.findViewById(R.id.CricketRatingBar);
        myCricketRatingText = (TextView) view.findViewById(R.id.CricketRatingtext);
        myCricketImage = (ImageButton) view.findViewById(R.id.imageCricket);
        myCricketImage.setOnClickListener(this);

        myElbowAirflareRating = (ProgressBar) view.findViewById(R.id.ElbowAirflareRatingBar);
        myElbowAirflareRatingText = (TextView) view.findViewById(R.id.ElbowAirflareRatingtext);
        myElbowAirflareImage = (ImageButton) view.findViewById(R.id.imageElbowAirflare);
        myElbowAirflareImage.setOnClickListener(this);

        myFlareRating = (ProgressBar) view.findViewById(R.id.FlareRatingBar);
        myFlareRatingText = (TextView) view.findViewById(R.id.FlareRatingtext);
        myFlareImage = (ImageButton) view.findViewById(R.id.imageFlare);
        myFlareImage.setOnClickListener(this);

        myJackhammerRating = (ProgressBar) view.findViewById(R.id.JackhammerRatingBar);
        myJackhammerRatingText = (TextView) view.findViewById(R.id.JackhammerRatingtext);
        myJackhammerImage = (ImageButton) view.findViewById(R.id.imageJackhammer);
        myJackhammerImage.setOnClickListener(this);

        myHaloRating = (ProgressBar) view.findViewById(R.id.HaloRatingBar);
        myHaloRatingText = (TextView) view.findViewById(R.id.HaloRatingtext);
        myHaloImage = (ImageButton) view.findViewById(R.id.imageHalo);
        myHaloImage.setOnClickListener(this);

        myHeadspinRating = (ProgressBar) view.findViewById(R.id.HeadspinRatingBar);
        myHeadspinRatingText = (TextView) view.findViewById(R.id.HeadspinRatingtext);
        myHeadspinImage = (ImageButton) view.findViewById(R.id.imageHeadspin);
        myHeadspinImage.setOnClickListener(this);

        myMunchmillRating = (ProgressBar) view.findViewById(R.id.MuchmillRatingBar);
        myMunchmillRatingText = (TextView) view.findViewById(R.id.MuchmillRatingtext);
        myMunchmillImage = (ImageButton) view.findViewById(R.id.imageMunchmill);
        myMunchmillImage.setOnClickListener(this);

        myNinety_nineRating = (ProgressBar) view.findViewById(R.id.NinetynineRatingBar);
        myNinety_nineRatingText = (TextView) view.findViewById(R.id.NinetynineRatingtext);
        myNinety_nineImage = (ImageButton) view.findViewById(R.id.imageNinety);
        myNinety_nineImage.setOnClickListener(this);

        mySwipesRating = (ProgressBar) view.findViewById(R.id.SwipeRatingBar);
        mySwipesRatingText = (TextView) view.findViewById(R.id.SwipeRatingtext);
        mySwipesImage = (ImageButton) view.findViewById(R.id.imageSwipes);
        mySwipesImage.setOnClickListener(this);

        myTurtelMoveRating = (ProgressBar) view.findViewById(R.id.turtelMoveRatingBar);
        myTurtelMoveRatingText = (TextView) view.findViewById(R.id.turtelMoveRatingtext);
        myTurtelMoveImage = (ImageButton) view.findViewById(R.id.imageTurtelMove);
        myTurtelMoveImage.setOnClickListener(this);

        myUfoRating = (ProgressBar) view.findViewById(R.id.UfoRatingBar);
        myUfoRatingText = (TextView) view.findViewById(R.id.UfoRatingtext);
        myUfoImage = (ImageButton) view.findViewById(R.id.imageUfo);
        myUfoImage.setOnClickListener(this);

        myWebRating = (ProgressBar) view.findViewById(R.id.WebRatingBar);
        myWebRatingText = (TextView) view.findViewById(R.id.WebRatingtext);
        myWebImage = (ImageButton) view.findViewById(R.id.imageWeb);
        myWebImage.setOnClickListener(this);

        myWindmillRating = (ProgressBar) view.findViewById(R.id.windmillRatingBar);
        myWindmillRatingText = (TextView) view.findViewById(R.id.windmillRatingtext);
        myWindmillImage = (ImageButton) view.findViewById(R.id.imageWindmill);
        myWindmillImage.setOnClickListener(this);

        myWolfRating = (ProgressBar) view.findViewById(R.id.WolfRatingBar);
        myWolfRatingText = (TextView) view.findViewById(R.id.WolfRatingtext);
        myWolfImage = (ImageButton) view.findViewById(R.id.imageWolf);
        myWolfImage.setOnClickListener(this);

        if((pupil.flare >=80)&(pupil.handstand>=80)) {
            myAirflareRating.setProgress(pupil.airflare);
            myAirflareRatingText.setText(String.valueOf(pupil.airflare)+ "%");
        }
        else {
            myAirflareImage.setImageResource(R.drawable.locked);
            myAirflareRating.setVisibility(View.INVISIBLE);
            myAirflareRatingText.setTextSize(8);
            myAirflareRatingText.setText("Требуется Стойка на руках > 80 и Flare > 80");
        }

        myBackspinRating.setProgress(pupil.backspin);
        myBackspinRatingText.setText(String.valueOf(pupil.backspin)+ "%");

        if(pupil.turtle >=65){
            myCricketRating.setProgress(pupil.cricket);
            myCricketRatingText.setText(String.valueOf(pupil.cricket)+ "%");
        }
        else {
            myCricketImage.setImageResource(R.drawable.locked);
            myCricketRating.setVisibility(View.INVISIBLE);
            myCricketRatingText.setTextSize(10);
            myCricketRatingText.setText("Требуется Turtle > 65");
        }

        if((pupil.elbowfrezze >=80)&(pupil.handstand >=60)){
            myElbowAirflareRating.setProgress(pupil.elbowairflare);
            myElbowAirflareRatingText.setText(String.valueOf(pupil.elbowairflare)+ "%");
        }
        else {
            myElbowAirflareImage.setImageResource(R.drawable.locked);
            myElbowAirflareRating.setVisibility(View.INVISIBLE);
            myElbowAirflareRatingText.setTextSize(8);
            myElbowAirflareRatingText.setText("Требуется ElbowFrezze > 80 и Руки  60");
        }

        if((pupil.handstand >=30)&(pupil.angle > 40)&(pupil.horizont >=45)){
            myFlareRating.setProgress(pupil.flare);
            myFlareRatingText.setText(String.valueOf(pupil.flare)+ "%");
        }
        else {
            myFlareImage.setImageResource(R.drawable.locked);
            myFlareRating.setVisibility(View.INVISIBLE);
            myFlareRatingText.setTextSize(8);
            myFlareRatingText.setText("Требуется Уголок > 40, Горизонт > 45, Руки > 30");
        }

        if(pupil.cricket >=90){
            myJackhammerRating.setProgress(pupil.jackhammer);
            myJackhammerRatingText.setText(String.valueOf(pupil.jackhammer)+ "%");
        }
        else {
            myJackhammerImage.setImageResource(R.drawable.locked);
            myJackhammerRating.setVisibility(View.INVISIBLE);
            myJackhammerRatingText.setTextSize(10);
            myJackhammerRatingText.setText("Требуется Cricket > 90");
        }

        if((pupil.windmill >=80)&(pupil.chairfrezze >=50)){
            myHaloRating.setProgress(pupil.halo);
            myHaloRatingText.setText(String.valueOf(pupil.halo)+ "%");
        }
        else {
            myHaloImage.setImageResource(R.drawable.locked);
            myHaloRating.setVisibility(View.INVISIBLE);
            myHaloRatingText.setTextSize(8);
            myHaloRatingText.setText("Требуется Windmill > 80, ChairFrezze > 50");
        }

        if(pupil.headfrezze >=60){
            myHeadspinRating.setProgress(pupil.headspin);
            myHeadspinRatingText.setText(String.valueOf(pupil.headspin)+ "%");
        }
        else {
            myHeadspinImage.setImageResource(R.drawable.locked);
            myHeadspinRating.setVisibility(View.INVISIBLE);
            myHeadspinRatingText.setTextSize(10);
            myHeadspinRatingText.setText("Требуется HeadFrezze > 60");
        }

        if(pupil.windmill >=80){
            myMunchmillRating.setProgress(pupil.munchmill);
            myMunchmillRatingText.setText(String.valueOf(pupil.munchmill)+ "%");
        }
        else {
            myMunchmillImage.setImageResource(R.drawable.locked);
            myMunchmillRating.setVisibility(View.INVISIBLE);
            myMunchmillRatingText.setTextSize(10);
            myMunchmillRatingText.setText("Требуется Windmill > 80");
        }

        if(pupil.handstand >=80){
            myNinety_nineRating.setProgress(pupil.ninety_nine);
            myNinety_nineRatingText.setText(String.valueOf(pupil.ninety_nine)+ "%");
        }
        else {
            myNinety_nineImage.setImageResource(R.drawable.locked);
            myNinety_nineRating.setVisibility(View.INVISIBLE);
            myNinety_nineRatingText.setTextSize(10);
            myNinety_nineRatingText.setText("Требуется Стойка на руках > 80");
        }

        mySwipesRating.setProgress(pupil.swipes);
        mySwipesRatingText.setText(String.valueOf(pupil.swipes)+ "%");

        if(pupil.turtlefrezze>=40){
            myTurtelMoveRating.setProgress(pupil.turtle);
            myTurtelMoveRatingText.setText(String.valueOf(pupil.turtle)+ "%");
        }
        else {
            myTurtelMoveImage.setImageResource(R.drawable.locked);
            myTurtelMoveRating.setVisibility(View.INVISIBLE);
            myTurtelMoveRatingText.setTextSize(10);
            myTurtelMoveRatingText.setText("Требуется TurtleFrezze > 40");
        }

        if((pupil.wolf >=60)&(pupil.horizont >=70)){
            myUfoRating.setProgress(pupil.ufo);
            myUfoRatingText.setText(String.valueOf(pupil.ufo)+ "%");
        }
        else {
            myUfoImage.setImageResource(R.drawable.locked);
            myUfoRating.setVisibility(View.INVISIBLE);
            myUfoRatingText.setTextSize(10);
            myUfoRatingText.setText("Требуется Wolf > 60, Горизонт > 70");
        }

        if(pupil.windmill >=80){
            myWebRating.setProgress(pupil.web);
            myWebRatingText.setText(String.valueOf(pupil.web)+ "%");
        }
        else {
            myWebImage.setImageResource(R.drawable.locked);
            myWebRating.setVisibility(View.INVISIBLE);
            myWebRatingText.setTextSize(10);
            myWebRatingText.setText("Требуется Windmill > 80");
        }

        if((pupil.babyfrezze >=50)&(pupil.turtlefrezze >=40)){
            myWindmillRating.setProgress(pupil.windmill);
            myWindmillRatingText.setText(String.valueOf(pupil.windmill)+ "%");
        }
        else {
            myWindmillImage.setImageResource(R.drawable.locked);
            myWindmillRating.setVisibility(View.INVISIBLE);
            myWindmillRatingText.setTextSize(8);
            myWindmillRatingText.setText("Требуется TurtleFrezze > 40 и BabyFrezze > 50");
        }

        if(pupil.horizont >=55){
            myWolfRating.setProgress(pupil.wolf);
            myWolfRatingText.setText(String.valueOf(pupil.wolf)+ "%");
        }
        else {
            myWolfImage.setImageResource(R.drawable.locked);
            myWolfRating.setVisibility(View.INVISIBLE);
            myWolfRatingText.setTextSize(10);
            myWolfRatingText.setText("Требуется Горизонт > 55");
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBackspin:
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Backspin");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.backspin);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
             case R.id.imageSwipes:
                intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Swipes");             // передаем параметр "название элемента"
                 intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.swipes);
                 startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageTurtelMove:
                if(pupil.turtlefrezze>=40) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "TurtelMove");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.turtle);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageWindmill:
                if((pupil.babyfrezze>=50)&(pupil.turtlefrezze >=40)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Windmill");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.windmill);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageHeadspin:
                if(pupil.headfrezze>=60) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Headspin");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.headspin);
                    startActivity(intent);                                                          // создаем интент для связи активностью
                }break;
            case R.id.imageCricket:
                if(pupil.turtle>=65) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Cricket");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.cricket);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageWeb:
                if(pupil.windmill>=80) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Web");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.web);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageWolf:
                if(pupil.horizont>=55) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Wolf");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.wolf);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageMunchmill:
                if(pupil.windmill>=80) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Munchmill");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.munchmill);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageFlare:
                if((pupil.handstand>=30)&(pupil.angle>=40)&(pupil.horizont>=45)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Flare");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.flare);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageNinety:
                if(pupil.handstand >=80) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Ninety");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.ninety_nine);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageHalo:
                if((pupil.windmill>=80)&(pupil.chairfrezze>=50)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Halo");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.halo);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageJackhammer:
                if(pupil.cricket>=90) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Jackhammer");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.jackhammer);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageUfo:
                if((pupil.wolf>=60)&(pupil.horizont>=70)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Ufo");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.ufo);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageElbowAirflare:
                if((pupil.elbowfrezze>=80)&(pupil.handstand>=60)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "ElbowAirflare");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.elbowairflare);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageAirflare:
                if((pupil.flare>=80)&(pupil.handstand>=80)) {
                    intent = new Intent(v.getContext(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Airflare");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.airflare);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;

        }
    }


}
