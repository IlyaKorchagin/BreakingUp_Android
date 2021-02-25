package com.example.goodfootbreaking;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


public class FMyFrezzesResults extends Fragment implements View.OnClickListener{


    private ProgressBar myBabyRating;
    private TextView myBabyRatingText;
    private ImageButton myBabyImage;

    private ProgressBar myTurtelRating;
    private TextView myTurtelRatingText;
    private ImageButton myTurtelImage;

    private ProgressBar myChairRating;
    private TextView myChairRatingText;
    private ImageButton myChairImage;

    private ProgressBar myShoulderRating;
    private TextView myShoulderRatingText;
    private ImageButton myShoulderImage;

    private ProgressBar myHeadRating;
    private TextView myHeadRatingText;
    private ImageButton myHeadImage;

    private ProgressBar myHeadHollowbackRating;
    private TextView myHeadHollowbackRatingText;
    private ImageButton myHeadHollowbackImage;

    private ProgressBar myHollowbackRating;
    private TextView myHollowbackRatingText;
    private ImageButton myHollowbackImage;

    private ProgressBar myOneHandRating;
    private TextView myOneHandRatingText;
    private ImageButton myOneHandImage;

    private ProgressBar myElbowRating;
    private TextView myElbowRatingText;
    private ImageButton myElbowImage;

    private ProgressBar myInvertRating;
    private TextView myInvertRatingText;
    private ImageButton myInvertImage;

    private static Pupils pupil;


    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    public static FMyFrezzesResults newInstance(int page, Pupils curPupil) {
        FMyFrezzesResults pageFragment = new FMyFrezzesResults();
        pupil = curPupil;
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    /*
    // Масштабирование картинок
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Начальная высота и ширина изображения
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Рассчитываем наибольшее значение inSampleSize, которое равно степени двойки
            // и сохраняем высоту и ширину, когда они больше необходимых
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // Сначала вызываем декодер с опцией inJustDecodeBounds=true для проверки разрешения
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Подсчитываем inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Теперь вызываем декодер с установленной опцией inSampleSize
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
     */



    public FMyFrezzesResults() {
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
        View view = inflater.inflate(R.layout.fragment_fmy_frezzes_results, container, false);

        myBabyRating = (ProgressBar) view.findViewById(R.id.babyRatingBar);
        myBabyRatingText = (TextView) view.findViewById(R.id.babyRatingtext);
        myBabyImage = (ImageButton) view.findViewById(R.id.imageBabyButton);
        myBabyImage.setOnClickListener(this);

        myTurtelRating = (ProgressBar) view.findViewById(R.id.turtelRatingBar);
        myTurtelRatingText = (TextView) view.findViewById(R.id.turtelRatingtext);
        myTurtelImage = (ImageButton) view.findViewById(R.id.imageTurtel);
        myTurtelImage.setOnClickListener(this);

        myChairRating = (ProgressBar) view.findViewById(R.id.chairRatingBar);
        myChairRatingText = (TextView) view.findViewById(R.id.chairRatingtext);
        myChairImage = (ImageButton) view.findViewById(R.id.imageChair);
        myChairImage.setOnClickListener(this);

        myShoulderRating = (ProgressBar) view.findViewById(R.id.ShoulderRatingBar);
        myShoulderRatingText = (TextView) view.findViewById(R.id.ShoulderRatingtext);
        myShoulderImage = (ImageButton) view.findViewById(R.id.imageShoulder);
        myShoulderImage.setOnClickListener(this);

        myElbowRating = (ProgressBar) view.findViewById(R.id.elbowRatingBar);
        myElbowRatingText = (TextView) view.findViewById(R.id.elbowRatingtext);
        myElbowImage = (ImageButton) view.findViewById(R.id.imageElbow);
        myElbowImage.setOnClickListener(this);

        myHeadRating = (ProgressBar) view.findViewById(R.id.headRatingBar);
        myHeadRatingText = (TextView) view.findViewById(R.id.headRatingtext);
        myHeadImage = (ImageButton) view.findViewById(R.id.imageHead);
        myHeadImage.setOnClickListener(this);

        myHeadHollowbackRating = (ProgressBar) view.findViewById(R.id.Head_HollowbackRatingBar);
        myHeadHollowbackRatingText = (TextView) view.findViewById(R.id.Head_HollowbackRatingtext);
        myHeadHollowbackImage = (ImageButton) view.findViewById(R.id.imageHeadHollowbac);
        myHeadHollowbackImage.setOnClickListener(this);

        myHollowbackRating = (ProgressBar) view.findViewById(R.id.HollowbackRatingBar);
        myHollowbackRatingText = (TextView) view.findViewById(R.id.HollowbackRatingtext);
        myHollowbackImage = (ImageButton) view.findViewById(R.id.imageHollowback);
        myHollowbackImage.setOnClickListener(this);

        myOneHandRating = (ProgressBar) view.findViewById(R.id.OneHandRatingBar);
        myOneHandRatingText = (TextView) view.findViewById(R.id.OneHandRatingtext);
        myOneHandImage = (ImageButton) view.findViewById(R.id.imageOnehand);
        myOneHandImage.setOnClickListener(this);

        myInvertRating = (ProgressBar) view.findViewById(R.id.InvertRatingBar);
        myInvertRatingText = (TextView) view.findViewById(R.id.InvertRatingtext);
        myInvertImage = (ImageButton) view.findViewById(R.id.imageInvert);
        myInvertImage.setOnClickListener(this);

        myBabyRating.setProgress(pupil.babyfrezze);
        myBabyRatingText.setText(String.valueOf(pupil.babyfrezze)+ "%");

        myTurtelRating.setProgress(pupil.turtelfrezze);
        myTurtelRatingText.setText(String.valueOf(pupil.turtelfrezze)+ "%");

        myHeadRating.setProgress(pupil.headfrezze);
        myHeadRatingText.setText(String.valueOf(pupil.headfrezze)+ "%");

        myShoulderRating.setProgress(pupil.shoulderfrezze);
        myShoulderRatingText.setText(String.valueOf(pupil.shoulderfrezze)+ "%");

        if((myBabyRating.getProgress()>=20)&(myTurtelRating.getProgress()>=20))
        {
            myChairRating.setProgress(pupil.chairfrezze);
            myChairRatingText.setText(String.valueOf(pupil.chairfrezze)+ "%");
        }
        else {
            myChairImage.setImageResource(R.drawable.locked);
            myChairRating.setVisibility(View.INVISIBLE);
            myChairRatingText.setTextSize(10);
            myChairRatingText.setText("Требуется Baby > 20 и Turtle > 20");
        }

        if((myBabyRating.getProgress()>=50)&(myTurtelRating.getProgress()>=40)) {
            myElbowRating.setProgress(pupil.elbowfrezze);
            myElbowRatingText.setText(String.valueOf(pupil.elbowfrezze)+ "%");
        }
        else {
            myElbowImage.setImageResource(R.drawable.locked);
            myElbowRating.setVisibility(View.INVISIBLE);
            myElbowRatingText.setTextSize(10);
            myElbowRatingText.setText("Требуется Baby > 50 и Turtle > 40");
        }

        if(pupil.headfrezze >= 70){
            myHeadHollowbackRating.setProgress(pupil.headhollowbackfrezze);
            myHeadHollowbackRatingText.setText(String.valueOf(pupil.headhollowbackfrezze)+ "%");
        }
        else {
            myHeadHollowbackImage.setImageResource(R.drawable.locked);
            myHeadHollowbackRating.setVisibility(View.INVISIBLE);
            myHeadHollowbackRatingText.setTextSize(10);
            myHeadHollowbackRatingText.setText("Требуется Head > 70");
        }

        if((pupil.handstand >=50)&(pupil.bridge>=90)&(pupil.headhollowbackfrezze >=60)) {
            myHollowbackRating.setProgress(pupil.hollowbackfrezze);
            myHollowbackRatingText.setText(String.valueOf(pupil.hollowbackfrezze)+ "%");
        }
        else {
            myHollowbackImage.setImageResource(R.drawable.locked);
            myHollowbackRating.setVisibility(View.INVISIBLE);
            myHollowbackRatingText.setTextSize(8);
            myHollowbackRatingText.setText("Требуется Cтойка на руках > 50 и Мостик > 90");
        }

        if(pupil.handstand >=50) {
            myOneHandRating.setProgress(pupil.onehandfrezze);
            myOneHandRatingText.setText(String.valueOf(pupil.onehandfrezze)+ "%");
        }
        else {
            myOneHandImage.setImageResource(R.drawable.locked);
            myOneHandRating.setVisibility(View.INVISIBLE);
            myOneHandRatingText.setTextSize(10);
            myOneHandRatingText.setText("Требуется Стойка на руках > 50");
        }

        if(pupil.handstand >=40) {
            myInvertRating.setProgress(pupil.invertfrezze);
            myInvertRatingText.setText(String.valueOf(pupil.invertfrezze)+ "%");
        }
        else {
            myInvertImage.setImageResource(R.drawable.locked);
            myInvertRating.setVisibility(View.INVISIBLE);
            myInvertRatingText.setTextSize(10);
            myInvertRatingText.setText("Требуется Стойка на руках > 40");
        }

        return view;
    }

    // Переход на страницу описания элемента
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageBabyButton:
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Baby Frezze");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.babyfrezze);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageTurtel:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Turtel Frezze");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.turtelfrezze);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageShoulder:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Shoulder Frezze");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.shoulderfrezze);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageHead:
                intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Head Frezze");             // передаем параметр "название элемента"
                intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.headfrezze);
                startActivity(intent);                                                     // создаем интент для связи активностью
                break;
            case R.id.imageChair:
                if((pupil.babyfrezze >=20)&(pupil.turtelfrezze>=20)){
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Chair Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.chairfrezze);
                    startActivity(intent);                                                     // создаем интент для связи активностью

                }break;
            case R.id.imageHeadHollowbac:
                if(pupil.headfrezze>=90) {
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "HeadHollowback Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.headhollowbackfrezze);
                    startActivity(intent);                                                                      // создаем интент для связи активностью
                }
                break;
            case R.id.imageOnehand:
                if(pupil.handstand >=50) {
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Onehand Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.onehandfrezze);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageInvert:
                if(pupil.handstand>=40) {
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Invert Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.invertfrezze);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                break;
            case R.id.imageHollowback:
                if((pupil.handstand>=50)&(pupil.bridge>=90)&(pupil.headhollowbackfrezze>=60)) {
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Hollowback Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.hollowbackfrezze);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                    break;
            case R.id.imageElbow:
                if((myBabyRating.getProgress()>=50)&(myTurtelRating.getProgress()>=40)) {
                    intent = new Intent(getActivity(), DescriptionActivity.class);     // создаем интент для связи активностью для редактирования БД
                    intent.putExtra(DescriptionActivity.DESCRIPTION_MESSAGE, "Elbow Frezze");             // передаем параметр "название элемента"
                    intent.putExtra(DescriptionActivity.DESCRIPTION_RATING, pupil.elbowfrezze);
                    startActivity(intent);                                                     // создаем интент для связи активностью
                }
                    break;

        }
    }


}
