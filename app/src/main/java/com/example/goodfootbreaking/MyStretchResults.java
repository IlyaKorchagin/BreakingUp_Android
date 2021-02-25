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

public class MyStretchResults extends Fragment implements View.OnClickListener {

    private ProgressBar myButterflyRating;
    private TextView myButterflyRatingText;
    private ImageButton myButterflyImage;

    private ProgressBar myFoldRating;
    private TextView myFoldRatingText;
    private ImageButton myFoldImage;

    private ProgressBar myShouldersRating;
    private TextView myShouldersRatingText;
    private ImageButton myShouldersImage;

    private ProgressBar myTwineRating;
    private TextView myTwineRatingText;
    private ImageButton myTwineImage;

    private static Pupils pupil;


    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    public static MyStretchResults newInstance(int page, Pupils curPupil) {
        MyStretchResults pageFragment = new MyStretchResults();
        pupil = curPupil;
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }


    public MyStretchResults() {
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
        // Inflate the layout for this fragment
        String words="";
        View view =  inflater.inflate(R.layout.fragment_my_stretch_results, container, false);

        myButterflyRating = (ProgressBar) view.findViewById(R.id.ButerflyRatingBar);
        myButterflyRatingText = (TextView) view.findViewById(R.id.ButerflyRatingtext);
        myButterflyImage = (ImageButton) view.findViewById(R.id.imageButterfly);
        myButterflyImage.setOnClickListener(this);

        myFoldRating = (ProgressBar) view.findViewById(R.id.FoldRatingBar);
        myFoldRatingText = (TextView) view.findViewById(R.id.FoldRatingtext);
        myFoldImage = (ImageButton) view.findViewById(R.id.imageFold);
        myFoldImage.setOnClickListener(this);

        myShouldersRating = (ProgressBar) view.findViewById(R.id.ShouldersRatingBar);
        myShouldersRatingText = (TextView) view.findViewById(R.id.ShouldersRatingtext);
        myShouldersImage = (ImageButton) view.findViewById(R.id.imageShoulders);
        myShouldersImage.setOnClickListener(this);

        myTwineRating = (ProgressBar) view.findViewById(R.id.TwineRatingBar);
        myTwineRatingText = (TextView) view.findViewById(R.id.TwineRatingtext);
        myTwineImage = (ImageButton) view.findViewById(R.id.imageTwine);
        myTwineImage.setOnClickListener(this);

        myButterflyRating.setProgress(pupil.butterfly);
        myButterflyRatingText.setText(String.valueOf(pupil.butterfly)+ "%");

        myFoldRating.setProgress(pupil.fold);
        myFoldRatingText.setText(String.valueOf(pupil.fold)+ "%");

        myShouldersRating.setProgress(pupil.shoulders);
        myShouldersRatingText.setText(String.valueOf(pupil.shoulders)+ "%");

        myTwineRating.setProgress(pupil.twine);
        myTwineRatingText.setText(String.valueOf(pupil.twine)+ "%");

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageButterfly:
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Бабочка");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.butterfly);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageFold:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Складка");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.fold);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageShoulders:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Плечи");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.shoulders);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageTwine:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Шпагат");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.twine);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;


        }
    }

}
