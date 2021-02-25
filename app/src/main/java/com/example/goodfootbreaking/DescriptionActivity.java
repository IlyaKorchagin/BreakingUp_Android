package com.example.goodfootbreaking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

//public class DescriptionActivity extends AppCompatActivity {
public class DescriptionActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyBCk98WrUeAmbme_GslF3Ex6TziiwwfHRk";

    //  Ниже перечислены id видео (11 символов, располагающихся в конце ссылки на видео) с элементами
    // Например, https://www.youtube.com/watch?v=sVG4NQz4DJg - для обучалки по Baby Frezze.
    public static final String BABY_FREZZE_VIDEO_ID = "Hr5Ft0dQmtw";
    public static final String TURTLE_FREZZE_VIDEO_ID = "OMGPAqrSkyI";
    public static final String SHOULDER_FREZZE_VIDEO_ID = "nDJ5z-6ARxg";
    public static final String HEAD_FREZZE_VIDEO_ID = "LmZ3F373kGs";
    public static final String CHAIR_FREZZE_VIDEO_ID = "n7V7VAMsFGM";
    public static final String ELBOW_FREZZE_VIDEO_ID = "NWvzyqIpcSQ";
    public static final String HEADHOLLOWBACK_FREZZE_VIDEO_ID = "wq3QyjqABok";
    public static final String HOLLOWBACK_FREZZE_VIDEO_ID = "SE6Ko-OfnmA";
    public static final String INVERT_FREZZE_VIDEO_ID = "zU1NLgNXk1g";
    public static final String ONEHAND_FREZZE_VIDEO_ID = "emWWy8PcRAM";

    public static final String AIRFLARE_VIDEO_ID = "QZRmvool75U";
    public static final String BACKSPIN_VIDEO_ID = "VG5ABmzoe9w";
    public static final String CRICKET_VIDEO_ID = "Yn96WeJsUEk";
    public static final String ELBOWAIRFLARE_VIDEO_ID = "QZRmvool75U";
    public static final String FLARE_VIDEO_ID = "RNfeUYyYDK8";
    public static final String JACKHAMMER_VIDEO_ID = "4FwOffyb5Q8";
    public static final String HALO_VIDEO_ID = "jZTZjX7-R0I";
    public static final String HEADSPIN_VIDEO_ID = "LmZ3F373kGs";
    public static final String MUNCHMILL_VIDEO_ID = "IcJj4wKg-zc";
    public static final String NINETY_NINE_VIDEO_ID = "1keyrVS_yZI";
    public static final String SWIPES_VIDEO_ID = "QTiBa0lkooU";
    public static final String TURTLE_VIDEO_ID = "3SLoKvioGuM";
    public static final String UFO_VIDEO_ID = "JIpnq6CiC9c";
    public static final String WEB_VIDEO_ID = "dnlMuhDkc9g";
    public static final String WINDMILL_VIDEO_ID = "G9M2deEYljQ";
    public static final String WOLF_VIDEO_ID = "pLFHvNbYqQw";

    public static final String ANGLE_VIDEO_ID = "_rGXdZNFEb4";
    public static final String BRIDGE_VIDEO_ID = "";
    public static final String FINGER_VIDEO_ID = "wT1Xxq1oO-k";
    public static final String HANDSTAND_VIDEO_ID = "IrEo7qjlO7M";
    public static final String HORIZONT_VIDEO_ID = "c9s6hw1XRmw";
    public static final String PUSHUPS_VIDEO_ID = "xvTwFWYMzhA";

    public static final String BUTTERFLY_VIDEO_ID = "";
    public static final String FOLD_VIDEO_ID = "";
    public static final String SHOULDERS_VIDEO_ID = "";
    public static final String TWINE_VIDEO_ID = "";


    public static final String DESCRIPTION_MESSAGE = "element";
    public static final String DESCRIPTION_RATING = "rating";
    private TextView title;
    private TextView title10;
    private TextView title20;
    private TextView title30;
    private TextView title40;
    private TextView title50;
    private TextView title60;
    private TextView title70;
    private TextView title80;
    private TextView title90;
    private TextView title100;


    Integer rating;
    String element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        title = (TextView) findViewById(R.id.element_title);
        title.setText(intent.getStringExtra(DESCRIPTION_MESSAGE));
        element = title.getText().toString();

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);

        title10  = (TextView) findViewById(R.id.title10);
        title20  = (TextView) findViewById(R.id.title20);
        title30  = (TextView) findViewById(R.id.title30);
        title40  = (TextView) findViewById(R.id.title40);
        title50  = (TextView) findViewById(R.id.title50);
        title60  = (TextView) findViewById(R.id.title60);
        title70  = (TextView) findViewById(R.id.title70);
        title80  = (TextView) findViewById(R.id.title80);
        title90  = (TextView) findViewById(R.id.title90);
        title100 = (TextView) findViewById(R.id.title100);


        rating = intent.getIntExtra(DESCRIPTION_RATING,0);
        if(rating < 10) title10.setBackgroundResource(R.drawable.redboldcorner);
        else if (rating < 20)
            {
            title10.setBackgroundResource(R.drawable.greencorner);
            title20.setBackgroundResource(R.drawable.redboldcorner);
            }
            else if (rating < 30)
                {
                    title10.setBackgroundResource(R.drawable.greencorner);
                    title20.setBackgroundResource(R.drawable.greencorner);
                    title30.setBackgroundResource(R.drawable.redboldcorner);
                }
                else if (rating < 40)
                    {
                        title10.setBackgroundResource(R.drawable.greencorner);
                        title20.setBackgroundResource(R.drawable.greencorner);
                        title30.setBackgroundResource(R.drawable.greencorner);
                        title40.setBackgroundResource(R.drawable.redboldcorner);
                    }
                    else if (rating < 50)
                        {
                            title10.setBackgroundResource(R.drawable.greencorner);
                            title20.setBackgroundResource(R.drawable.greencorner);
                            title30.setBackgroundResource(R.drawable.greencorner);
                            title40.setBackgroundResource(R.drawable.greencorner);
                            title50.setBackgroundResource(R.drawable.redboldcorner);
                        }
                        else if (rating < 60)
                            {
                                title10.setBackgroundResource(R.drawable.greencorner);
                                title20.setBackgroundResource(R.drawable.greencorner);
                                title30.setBackgroundResource(R.drawable.greencorner);
                                title40.setBackgroundResource(R.drawable.greencorner);
                                title50.setBackgroundResource(R.drawable.greencorner);
                                title60.setBackgroundResource(R.drawable.redboldcorner);
                            }
                            else if (rating < 70)
                                {
                                    title10.setBackgroundResource(R.drawable.greencorner);
                                    title20.setBackgroundResource(R.drawable.greencorner);
                                    title30.setBackgroundResource(R.drawable.greencorner);
                                    title40.setBackgroundResource(R.drawable.greencorner);
                                    title50.setBackgroundResource(R.drawable.greencorner);
                                    title60.setBackgroundResource(R.drawable.greencorner);
                                    title70.setBackgroundResource(R.drawable.redboldcorner);
                                }
                                else if (rating < 80)
                                    {
                                        title10.setBackgroundResource(R.drawable.greencorner);
                                        title20.setBackgroundResource(R.drawable.greencorner);
                                        title30.setBackgroundResource(R.drawable.greencorner);
                                        title40.setBackgroundResource(R.drawable.greencorner);
                                        title50.setBackgroundResource(R.drawable.greencorner);
                                        title60.setBackgroundResource(R.drawable.greencorner);
                                        title70.setBackgroundResource(R.drawable.greencorner);
                                        title80.setBackgroundResource(R.drawable.redboldcorner);
                                    }
                                    else if (rating < 90)
                                        {
                                            title10.setBackgroundResource(R.drawable.greencorner);
                                            title20.setBackgroundResource(R.drawable.greencorner);
                                            title30.setBackgroundResource(R.drawable.greencorner);
                                            title40.setBackgroundResource(R.drawable.greencorner);
                                            title50.setBackgroundResource(R.drawable.greencorner);
                                            title60.setBackgroundResource(R.drawable.greencorner);
                                            title70.setBackgroundResource(R.drawable.greencorner);
                                            title80.setBackgroundResource(R.drawable.greencorner);
                                            title90.setBackgroundResource(R.drawable.redboldcorner);
                                        }
                                        else if (rating < 100)
                                            {
                                                title10.setBackgroundResource(R.drawable.greencorner);
                                                title20.setBackgroundResource(R.drawable.greencorner);
                                                title30.setBackgroundResource(R.drawable.greencorner);
                                                title40.setBackgroundResource(R.drawable.greencorner);
                                                title50.setBackgroundResource(R.drawable.greencorner);
                                                title60.setBackgroundResource(R.drawable.greencorner);
                                                title70.setBackgroundResource(R.drawable.greencorner);
                                                title80.setBackgroundResource(R.drawable.greencorner);
                                                title90.setBackgroundResource(R.drawable.greencorner);
                                                title100.setBackgroundResource(R.drawable.redboldcorner);
                                            }
                                            if (rating == 100)
                                            {
                                                title10.setBackgroundResource(R.drawable.greencorner);
                                                title20.setBackgroundResource(R.drawable.greencorner);
                                                title30.setBackgroundResource(R.drawable.greencorner);
                                                title40.setBackgroundResource(R.drawable.greencorner);
                                                title50.setBackgroundResource(R.drawable.greencorner);
                                                title60.setBackgroundResource(R.drawable.greencorner);
                                                title70.setBackgroundResource(R.drawable.greencorner);
                                                title80.setBackgroundResource(R.drawable.greencorner);
                                                title90.setBackgroundResource(R.drawable.greencorner);
                                                title100.setBackgroundResource(R.drawable.greencorner);
                                            }
        switch (element){
            case "Baby Frezze":
                title10.setText(R.string.baby10percent);
                title20.setText(R.string.baby20percent);
                title30.setText(R.string.baby30percent);
                title40.setText(R.string.baby40percent);
                title50.setText(R.string.baby50percent);
                title60.setText(R.string.baby60percent);
                title70.setText(R.string.baby70percent);
                title80.setText(R.string.baby80percent);
                title90.setText(R.string.baby90percent);
                title100.setText(R.string.baby100percent);
                break;
            case "Chair Frezze":
                title10.setText(R.string.chair10percent);
                title20.setText(R.string.chair20percent);
                title30.setText(R.string.chair30percent);
                title40.setText(R.string.chair40percent);
                title50.setText(R.string.chair50percent);
                title60.setText(R.string.chair60percent);
                title70.setText(R.string.chair70percent);
                title80.setText(R.string.chair80percent);
                title90.setText(R.string.chair90percent);
                title100.setText(R.string.chair100percent);
                break;
            case "Turtel Frezze":
                title10.setText(R.string.turtelfrezze10percent);
                title20.setText(R.string.turtelfrezze20percent);
                title30.setText(R.string.turtelfrezze30percent);
                title40.setText(R.string.turtelfrezze40percent);
                title50.setText(R.string.turtelfrezze50percent);
                title60.setText(R.string.turtelfrezze60percent);
                title70.setText(R.string.turtelfrezze70percent);
                title80.setText(R.string.turtelfrezze80percent);
                title90.setText(R.string.turtelfrezze90percent);
                title100.setText(R.string.turtelfrezze100percent);
                break;
            case "Shoulder Frezze":
                title10.setText(R.string.shoulderfrezze10percent);
                title20.setText(R.string.shoulderfrezze20percent);
                title30.setText(R.string.shoulderfrezze30percent);
                title40.setText(R.string.shoulderfrezze40percent);
                title50.setText(R.string.shoulderfrezze50percent);
                title60.setText(R.string.shoulderfrezze60percent);
                title70.setText(R.string.shoulderfrezze70percent);
                title80.setText(R.string.shoulderfrezze80percent);
                title90.setText(R.string.shoulderfrezze90percent);
                title100.setText(R.string.shoulderfrezze100percent);
                break;
            case "Head Frezze":
                title10.setText(R.string.headfrezze10percent);
                title20.setText(R.string.headfrezze20percent);
                title30.setText(R.string.headfrezze30percent);
                title40.setText(R.string.headfrezze40percent);
                title50.setText(R.string.headfrezze50percent);
                title60.setText(R.string.headfrezze60percent);
                title70.setText(R.string.headfrezze70percent);
                title80.setText(R.string.headfrezze80percent);
                title90.setText(R.string.headfrezze90percent);
                title100.setText(R.string.headfrezze100percent);
                break;
            case "Elbow Frezze":
                title10.setText(R.string.elbow10percent);
                title20.setText(R.string.elbow20percent);
                title30.setText(R.string.elbow30percent);
                title40.setText(R.string.elbow40percent);
                title50.setText(R.string.elbow50percent);
                title60.setText(R.string.elbow60percent);
                title70.setText(R.string.elbow70percent);
                title80.setText(R.string.elbow80percent);
                title90.setText(R.string.elbow90percent);
                title100.setText(R.string.elbow100percent);
                break;
            case "HeadHollowback Frezze":
                title10.setText(R.string.headhollowback10percent);
                title20.setText(R.string.headhollowback20percent);
                title30.setText(R.string.headhollowback30percent);
                title40.setText(R.string.headhollowback40percent);
                title50.setText(R.string.headhollowback50percent);
                title60.setText(R.string.headhollowback60percent);
                title70.setText(R.string.headhollowback70percent);
                title80.setText(R.string.headhollowback80percent);
                title90.setText(R.string.headhollowback90percent);
                title100.setText(R.string.headhollowback100percent);
                break;
            case "Onehand Frezze":
                title10.setText(R.string.onehand10percent);
                title20.setText(R.string.onehand20percent);
                title30.setText(R.string.onehand30percent);
                title40.setText(R.string.onehand40percent);
                title50.setText(R.string.onehand50percent);
                title60.setText(R.string.onehand60percent);
                title70.setText(R.string.onehand70percent);
                title80.setText(R.string.onehand80percent);
                title90.setText(R.string.onehand90percent);
                title100.setText(R.string.onehand100percent);
                break;
            case "Invert Frezze":
                title10.setText(R.string.invert10percent);
                title20.setText(R.string.invert20percent);
                title30.setText(R.string.invert30percent);
                title40.setText(R.string.invert40percent);
                title50.setText(R.string.invert50percent);
                title60.setText(R.string.invert60percent);
                title70.setText(R.string.invert70percent);
                title80.setText(R.string.invert80percent);
                title90.setText(R.string.invert90percent);
                title100.setText(R.string.invert100percent);
                break;
            case "Hollowback Frezze":
                title10.setText(R.string.hollowback10percent);
                title20.setText(R.string.hollowback20percent);
                title30.setText(R.string.hollowback30percent);
                title40.setText(R.string.hollowback40percent);
                title50.setText(R.string.hollowback50percent);
                title60.setText(R.string.hollowback60percent);
                title70.setText(R.string.hollowback70percent);
                title80.setText(R.string.hollowback80percent);
                title90.setText(R.string.hollowback90percent);
                title100.setText(R.string.hollowback100percent);
                break;
            case "Backspin":
                title10.setText(R.string.backspin10percent);
                title20.setText(R.string.backspin20percent);
                title30.setText(R.string.backspin30percent);
                title40.setText(R.string.backspin40percent);
                title50.setText(R.string.backspin50percent);
                title60.setText(R.string.backspin60percent);
                title70.setText(R.string.backspin70percent);
                title80.setText(R.string.backspin80percent);
                title90.setText(R.string.backspin90percent);
                title100.setText(R.string.backspin100percent);
                break;
            case "Swipes":
                title10.setText(R.string.swipes10percent);
                title20.setText(R.string.swipes20percent);
                title30.setText(R.string.swipes30percent);
                title40.setText(R.string.swipes40percent);
                title50.setText(R.string.swipes50percent);
                title60.setText(R.string.swipes60percent);
                title70.setText(R.string.swipes70percent);
                title80.setText(R.string.swipes80percent);
                title90.setText(R.string.swipes90percent);
                title100.setText(R.string.swipes100percent);
                break;
            case "TurtelMove":
                title10.setText(R.string.turtel10percent);
                title20.setText(R.string.turtel20percent);
                title30.setText(R.string.turtel30percent);
                title40.setText(R.string.turtel40percent);
                title50.setText(R.string.turtel50percent);
                title60.setText(R.string.turtel60percent);
                title70.setText(R.string.turtel70percent);
                title80.setText(R.string.turtel80percent);
                title90.setText(R.string.turtel90percent);
                title100.setText(R.string.turtel100percent);
                break;
            case "Windmill":
                title10.setText(R.string.windmill10percent);
                title20.setText(R.string.windmill20percent);
                title30.setText(R.string.windmill30percent);
                title40.setText(R.string.windmill40percent);
                title50.setText(R.string.windmill50percent);
                title60.setText(R.string.windmill60percent);
                title70.setText(R.string.windmill70percent);
                title80.setText(R.string.windmill80percent);
                title90.setText(R.string.windmill90percent);
                title100.setText(R.string.windmill100percent);
                break;
            case "Headspin":
                title10.setText(R.string.headspin10percent);
                title20.setText(R.string.headspin20percent);
                title30.setText(R.string.headspin30percent);
                title40.setText(R.string.headspin40percent);
                title50.setText(R.string.headspin50percent);
                title60.setText(R.string.headspin60percent);
                title70.setText(R.string.headspin70percent);
                title80.setText(R.string.headspin80percent);
                title90.setText(R.string.headspin90percent);
                title100.setText(R.string.headspin100percent);
                break;
            case "Cricket":
                title10.setText(R.string.cricket10percent);
                title20.setText(R.string.cricket20percent);
                title30.setText(R.string.cricket30percent);
                title40.setText(R.string.cricket40percent);
                title50.setText(R.string.cricket50percent);
                title60.setText(R.string.cricket60percent);
                title70.setText(R.string.cricket70percent);
                title80.setText(R.string.cricket80percent);
                title90.setText(R.string.cricket90percent);
                title100.setText(R.string.cricket100percent);
                break;
            case "Web":
                title10.setText(R.string.web10percent);
                title20.setText(R.string.web20percent);
                title30.setText(R.string.web30percent);
                title40.setText(R.string.web40percent);
                title50.setText(R.string.web50percent);
                title60.setText(R.string.web60percent);
                title70.setText(R.string.web70percent);
                title80.setText(R.string.web80percent);
                title90.setText(R.string.web90percent);
                title100.setText(R.string.web100percent);
                break;
            case "Wolf":
                title10.setText(R.string.wolf10percent);
                title20.setText(R.string.wolf20percent);
                title30.setText(R.string.wolf30percent);
                title40.setText(R.string.wolf40percent);
                title50.setText(R.string.wolf50percent);
                title60.setText(R.string.wolf60percent);
                title70.setText(R.string.wolf70percent);
                title80.setText(R.string.wolf80percent);
                title90.setText(R.string.wolf90percent);
                title100.setText(R.string.wolf100percent);
                break;
            case "Munchmill":
                title10.setText(R.string.munchmill10percent);
                title20.setText(R.string.munchmill20percent);
                title30.setText(R.string.munchmill30percent);
                title40.setText(R.string.munchmill40percent);
                title50.setText(R.string.munchmill50percent);
                title60.setText(R.string.munchmill60percent);
                title70.setText(R.string.munchmill70percent);
                title80.setText(R.string.munchmill80percent);
                title90.setText(R.string.munchmill90percent);
                title100.setText(R.string.munchmill100percent);
                break;
            case "Flare":
                title10.setText(R.string.flare10percent);
                title20.setText(R.string.flare20percent);
                title30.setText(R.string.flare30percent);
                title40.setText(R.string.flare40percent);
                title50.setText(R.string.flare50percent);
                title60.setText(R.string.flare60percent);
                title70.setText(R.string.flare70percent);
                title80.setText(R.string.flare80percent);
                title90.setText(R.string.flare90percent);
                title100.setText(R.string.flare100percent);
                break;
            case "Ninety":
                title10.setText(R.string.ninety10percent);
                title20.setText(R.string.ninety20percent);
                title30.setText(R.string.ninety30percent);
                title40.setText(R.string.ninety40percent);
                title50.setText(R.string.ninety50percent);
                title60.setText(R.string.ninety60percent);
                title70.setText(R.string.ninety70percent);
                title80.setText(R.string.ninety80percent);
                title90.setText(R.string.ninety90percent);
                title100.setText(R.string.ninety100percent);
                break;
            case "Halo":
                title10.setText(R.string.halo10percent);
                title20.setText(R.string.halo20percent);
                title30.setText(R.string.halo30percent);
                title40.setText(R.string.halo40percent);
                title50.setText(R.string.halo50percent);
                title60.setText(R.string.halo60percent);
                title70.setText(R.string.halo70percent);
                title80.setText(R.string.halo80percent);
                title90.setText(R.string.halo90percent);
                title100.setText(R.string.halo100percent);
                break;
            case "Jackhammer":
                title10.setText(R.string.jackhammer10percent);
                title20.setText(R.string.jackhammer20percent);
                title30.setText(R.string.jackhammer30percent);
                title40.setText(R.string.jackhammer40percent);
                title50.setText(R.string.jackhammer50percent);
                title60.setText(R.string.jackhammer60percent);
                title70.setText(R.string.jackhammer70percent);
                title80.setText(R.string.jackhammer80percent);
                title90.setText(R.string.jackhammer90percent);
                title100.setText(R.string.jackhammer100percent);
                break;
            case "Ufo":
                title10.setText(R.string.ufo10percent);
                title20.setText(R.string.ufo20percent);
                title30.setText(R.string.ufo30percent);
                title40.setText(R.string.ufo40percent);
                title50.setText(R.string.ufo50percent);
                title60.setText(R.string.ufo60percent);
                title70.setText(R.string.ufo70percent);
                title80.setText(R.string.ufo80percent);
                title90.setText(R.string.ufo90percent);
                title100.setText(R.string.ufo100percent);
                break;
            case "ElbowAirflare":
                title10.setText(R.string.elbowairflare10percent);
                title20.setText(R.string.elbowairflare20percent);
                title30.setText(R.string.elbowairflare30percent);
                title40.setText(R.string.elbowairflare40percent);
                title50.setText(R.string.elbowairflare50percent);
                title60.setText(R.string.elbowairflare60percent);
                title70.setText(R.string.elbowairflare70percent);
                title80.setText(R.string.elbowairflare80percent);
                title90.setText(R.string.elbowairflare90percent);
                title100.setText(R.string.elbowairflare100percent);
                break;
            case "Airflare":
                title10.setText(R.string.airflare10percent);
                title20.setText(R.string.airflare20percent);
                title30.setText(R.string.airflare30percent);
                title40.setText(R.string.airflare40percent);
                title50.setText(R.string.airflare50percent);
                title60.setText(R.string.airflare60percent);
                title70.setText(R.string.airflare70percent);
                title80.setText(R.string.airflare80percent);
                title90.setText(R.string.airflare90percent);
                title100.setText(R.string.airflare100percent);
                break;
            case "Уголок":
                title10.setText(R.string.angle10percent);
                title20.setText(R.string.angle20percent);
                title30.setText(R.string.angle30percent);
                title40.setText(R.string.angle40percent);
                title50.setText(R.string.angle50percent);
                title60.setText(R.string.angle60percent);
                title70.setText(R.string.angle70percent);
                title80.setText(R.string.angle80percent);
                title90.setText(R.string.angle90percent);
                title100.setText(R.string.angle100percent);
                break;
            case "Мостик":
                title10.setText(R.string.bridge10percent);
                title20.setText(R.string.bridge20percent);
                title30.setText(R.string.bridge30percent);
                title40.setText(R.string.bridge40percent);
                title50.setText(R.string.bridge50percent);
                title60.setText(R.string.bridge60percent);
                title70.setText(R.string.bridge70percent);
                title80.setText(R.string.bridge80percent);
                title90.setText(R.string.bridge90percent);
                title100.setText(R.string.bridge100percent);
                break;
            case "Стойка на пальцах":
                title10.setText(R.string.fingers10percent);
                title20.setText(R.string.fingers20percent);
                title30.setText(R.string.fingers30percent);
                title40.setText(R.string.fingers40percent);
                title50.setText(R.string.fingers50percent);
                title60.setText(R.string.fingers60percent);
                title70.setText(R.string.fingers70percent);
                title80.setText(R.string.fingers80percent);
                title90.setText(R.string.fingers90percent);
                title100.setText(R.string.fingers100percent);
                break;
            case "Стойка на руках":
                title10.setText(R.string.handstand10percent);
                title20.setText(R.string.handstand20percent);
                title30.setText(R.string.handstand30percent);
                title40.setText(R.string.handstand40percent);
                title50.setText(R.string.handstand50percent);
                title60.setText(R.string.handstand60percent);
                title70.setText(R.string.handstand70percent);
                title80.setText(R.string.handstand80percent);
                title90.setText(R.string.handstand90percent);
                title100.setText(R.string.handstand100percent);
                break;
            case "Горизонт":
                title10.setText(R.string.horizont10percent);
                title20.setText(R.string.horizont20percent);
                title30.setText(R.string.horizont30percent);
                title40.setText(R.string.horizont40percent);
                title50.setText(R.string.horizont50percent);
                title60.setText(R.string.horizont60percent);
                title70.setText(R.string.horizont70percent);
                title80.setText(R.string.horizont80percent);
                title90.setText(R.string.horizont90percent);
                title100.setText(R.string.horizont100percent);
                break;
            case "Отжимания":
                title10.setText(R.string.pushups10percent);
                title20.setText(R.string.pushups20percent);
                title30.setText(R.string.pushups30percent);
                title40.setText(R.string.pushups40percent);
                title50.setText(R.string.pushups50percent);
                title60.setText(R.string.pushups60percent);
                title70.setText(R.string.pushups70percent);
                title80.setText(R.string.pushups80percent);
                title90.setText(R.string.pushups90percent);
                title100.setText(R.string.pushups100percent);
                break;
            case "Шпагат":
                title10.setText(R.string.twine10percent);
                title20.setText(R.string.twine20percent);
                title30.setText(R.string.twine30percent);
                title40.setText(R.string.twine40percent);
                title50.setText(R.string.twine50percent);
                title60.setText(R.string.twine60percent);
                title70.setText(R.string.twine70percent);
                title80.setText(R.string.twine80percent);
                title90.setText(R.string.twine90percent);
                title100.setText(R.string.twine100percent);
                break;
            case "Складка":
                title10.setText(R.string.fold10percent);
                title20.setText(R.string.fold20percent);
                title30.setText(R.string.fold30percent);
                title40.setText(R.string.fold40percent);
                title50.setText(R.string.fold50percent);
                title60.setText(R.string.fold60percent);
                title70.setText(R.string.fold70percent);
                title80.setText(R.string.fold80percent);
                title90.setText(R.string.fold90percent);
                title100.setText(R.string.fold100percent);
                break;
            case "Бабочка":
                title10.setText(R.string.butterfly10percent);
                title20.setText(R.string.butterfly20percent);
                title30.setText(R.string.butterfly30percent);
                title40.setText(R.string.butterfly40percent);
                title50.setText(R.string.butterfly50percent);
                title60.setText(R.string.butterfly60percent);
                title70.setText(R.string.butterfly70percent);
                title80.setText(R.string.butterfly80percent);
                title90.setText(R.string.butterfly90percent);
                title100.setText(R.string.butterfly100percent);
                break;
            case "Плечи":
                title10.setText(R.string.shoulders10percent);
                title20.setText(R.string.shoulders20percent);
                title30.setText(R.string.shoulders30percent);
                title40.setText(R.string.shoulders40percent);
                title50.setText(R.string.shoulders50percent);
                title60.setText(R.string.shoulders60percent);
                title70.setText(R.string.shoulders70percent);
                title80.setText(R.string.shoulders80percent);
                title90.setText(R.string.shoulders90percent);
                title100.setText(R.string.shoulders100percent);
                break;

        }

    }
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored) {
            switch (element){
                case "Baby Frezze":
                    player.cueVideo(BABY_FREZZE_VIDEO_ID);
                    break;
                case "Turtel Frezze":
                    player.cueVideo(TURTLE_FREZZE_VIDEO_ID);
                    break;
                case "Shoulder Frezze":
                    player.cueVideo(SHOULDER_FREZZE_VIDEO_ID);
                    break;
                case "Head Frezze":
                    player.cueVideo(HEAD_FREZZE_VIDEO_ID);
                    break;
                case "Chair Frezze":
                    player.cueVideo(CHAIR_FREZZE_VIDEO_ID);
                    break;
                case "Elbow Frezze":
                    player.cueVideo(ELBOW_FREZZE_VIDEO_ID);
                    break;
                case "HeadHollowback Frezze":
                    player.cueVideo(HEADHOLLOWBACK_FREZZE_VIDEO_ID);
                    break;
                case "Onehand Frezze":
                    player.cueVideo(ONEHAND_FREZZE_VIDEO_ID);
                    break;
                case "Invert Frezze":
                    player.cueVideo(INVERT_FREZZE_VIDEO_ID);
                    break;
                case "Hollowback Frezze":
                    player.cueVideo(HOLLOWBACK_FREZZE_VIDEO_ID);
                    break;
                case "Backspin":
                    player.cueVideo(BACKSPIN_VIDEO_ID);
                    break;
                case "Swipes":
                    player.cueVideo(SWIPES_VIDEO_ID);
                    break;
                case "TurtelMove":
                    player.cueVideo(TURTLE_VIDEO_ID);
                    break;
                case "Windmill":
                    player.cueVideo(WINDMILL_VIDEO_ID);
                    break;
                case "Headspin":
                    player.cueVideo(HEADSPIN_VIDEO_ID);
                    break;
                case "Cricket":
                    player.cueVideo(CRICKET_VIDEO_ID);
                    break;
                case "Web":
                    player.cueVideo(WEB_VIDEO_ID);
                    break;
                case "Wolf":
                    player.cueVideo(WOLF_VIDEO_ID);
                    break;
                case "Munchmill":
                    player.cueVideo(MUNCHMILL_VIDEO_ID);
                    break;
                case "Flare":
                    player.cueVideo(FLARE_VIDEO_ID);
                    break;
                case "Ninety":
                    player.cueVideo(NINETY_NINE_VIDEO_ID);
                    break;
                case "Halo":
                    player.cueVideo(HALO_VIDEO_ID);
                    break;
                case "Jackhammer":
                    player.cueVideo(JACKHAMMER_VIDEO_ID);
                    break;
                case "Ufo":
                    player.cueVideo(UFO_VIDEO_ID);
                    break;
                case "ElbowAirflare":
                    player.cueVideo(ELBOWAIRFLARE_VIDEO_ID);
                    break;
                case "Airflare":
                    player.cueVideo(AIRFLARE_VIDEO_ID);
                    break;
                case "Уголок":
                    player.cueVideo(ANGLE_VIDEO_ID);
                    break;
                case "Мостик":

                    break;
                case "Стойка на пальцах":
                    player.cueVideo(FINGER_VIDEO_ID);
                    break;
                case "Стойка на руках":
                    player.cueVideo(HANDSTAND_VIDEO_ID);
                    break;
                case "Горизонт":
                    player.cueVideo(HORIZONT_VIDEO_ID);
                    break;
                case "Отжимания":
                    player.cueVideo(PUSHUPS_VIDEO_ID);
                    break;
                case "Шпагат":

                    break;
                case "Складка":

                    break;
                case "Бабочка":

                    break;
                case "Плечи":

                    break;

                default: player.cueVideo(BABY_FREZZE_VIDEO_ID);

            }
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}
