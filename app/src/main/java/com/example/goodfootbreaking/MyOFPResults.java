package com.example.goodfootbreaking;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MyOFPResults extends Fragment implements View.OnClickListener {

    private ProgressBar myAngleRating;
    private TextView myAngleRatingText;
    private ImageButton myAngleImage;

    private ProgressBar myBridgeRating;
    private TextView myBridgeRatingText;
    private ImageButton myBridgeImage;

    private ProgressBar myFingersRating;
    private TextView myFingersRatingText;
    private ImageButton myFingersImage;

    private ProgressBar myHandstandRating;
    private TextView myHandstandRatingText;
    private ImageButton myHandstandImage;

    private ProgressBar myHorizontRating;
    private TextView myHorizontRatingText;
    private ImageButton myHorizontImage;

    private ProgressBar myPushupsRating;
    private TextView myPushupsRatingText;
    private ImageButton myPushupsImage;

    private static Pupils pupil;


    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    public static MyOFPResults newInstance(int page, Pupils curPupil) {
        MyOFPResults pageFragment = new MyOFPResults();
        pupil = curPupil;
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }



    public MyOFPResults() {
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
        View view =  inflater.inflate(R.layout.fragment_my_ofpresults, container, false);

        myAngleRating = (ProgressBar) view.findViewById(R.id.angelRatingBar);
        myAngleRatingText = (TextView) view.findViewById(R.id.angelRatingtext);
        myAngleImage = (ImageButton) view.findViewById(R.id.imageAngle);
        myAngleImage.setOnClickListener(this);

        myBridgeRating = (ProgressBar) view.findViewById(R.id.BridgeRatingBar);
        myBridgeRatingText = (TextView) view.findViewById(R.id.BridgeRatingtext);
        myBridgeImage = (ImageButton) view.findViewById(R.id.imageBridge);
        myBridgeImage.setOnClickListener(this);

        myFingersRating = (ProgressBar) view.findViewById(R.id.FingersRatingBar);
        myFingersRatingText = (TextView) view.findViewById(R.id.FingersRatingtext);
        myFingersImage = (ImageButton) view.findViewById(R.id.imageFingers);
        myFingersImage.setOnClickListener(this);

        myHandstandRating = (ProgressBar) view.findViewById(R.id.HandStandRatingBar);
        myHandstandRatingText = (TextView) view.findViewById(R.id.HandStandRatingtext);
        myHandstandImage = (ImageButton) view.findViewById(R.id.imageHandstand);
        myHandstandImage.setOnClickListener(this);

        myHorizontRating = (ProgressBar) view.findViewById(R.id.HorizontRatingBar);
        myHorizontRatingText = (TextView) view.findViewById(R.id.HorizontRatingtext);
        myHorizontImage = (ImageButton) view.findViewById(R.id.imageHorizont);
        myHorizontImage.setOnClickListener(this);

        myPushupsRating = (ProgressBar) view.findViewById(R.id.PushUpsRatingBar);
        myPushupsRatingText = (TextView) view.findViewById(R.id.PushUpsRatingtext);
        myPushupsImage = (ImageButton) view.findViewById(R.id.imagePushups);
        myPushupsImage.setOnClickListener(this);

        myAngleRating.setProgress(pupil.angle);
        myAngleRatingText.setText(String.valueOf(pupil.angle)+ "%");

        myBridgeRating.setProgress(pupil.bridge);
        myBridgeRatingText.setText(String.valueOf(pupil.bridge)+ "%");

        myFingersRating.setProgress(pupil.finger);
        myFingersRatingText.setText(String.valueOf(pupil.finger)+ "%");

        myHandstandRating.setProgress(pupil.handstand);
        myHandstandRatingText.setText(String.valueOf(pupil.handstand)+ "%");

        myHorizontRating.setProgress(pupil.horizont);
        myHorizontRatingText.setText(String.valueOf(pupil.horizont)+ "%");

        myPushupsRating.setProgress(pupil.pushups);
        myPushupsRatingText.setText(String.valueOf(pupil.pushups)+ "%");


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageAngle:
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Уголок");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.angle);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageBridge:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Мостик");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.bridge);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageFingers:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Стойка на пальцах");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.finger);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageHandstand:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Стойка на руках");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.handstand);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageHorizont:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Горизонт");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.horizont);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imagePushups:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Отжимания");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.pushups);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;

        }

    }


}
