package com.example.goodfootbreaking;


import java.io.Serializable;

// Описание класса Pupils
public class Pupils implements Serializable {

    //---------- Personal information -----------
    public String id, name, email;
    //---------- Personal information -----------

    //---------- Rating -----------
    public double rating, frezze_rating, powermove_rating, ofp_rating, streching_rating;
    public int  battle_rating, battle_cur_position, battle_new_position, current_position, new_position;
    //---------- Rating -----------

    //---------- FREZZE -----------
    public int babyfrezze, chairfrezze, elbowfrezze, headfrezze, headhollowbackfrezze;
    public int hollowbackfrezze, invertfrezze, onehandfrezze, shoulderfrezze, turtelfrezze;
    //---------- FREZZE -----------

    //----------- POWER MOVE -------------
    public int airflare, backspin, cricket, elbowairflare, flare, jackhammer, halo, headspin;
    public int munchmill, ninety_nine, swipes, turtel, ufo, web, windmill, wolf;
    //----------- POWER MOVE -------------

    //----------- OFP -------------
    public int angle, bridge, finger, handstand, horizont, pushups;
    //----------- OFP -------------

    //----------- stretching -------------
    public int butterfly, fold, shoulders, twine;
    //----------- stretching -------------

    // Инициализатор
    public Pupils(){}

    // Инициализатор root
    public Pupils(String name)
    {
        id = "Pupils";
        this.name = name;
        email = name;

        rating = 100; frezze_rating = 100; powermove_rating = 100; ofp_rating = 100; streching_rating = 100;
        battle_rating = 100;  battle_cur_position = 0; battle_new_position = 0; current_position = 0; new_position = 0;

        babyfrezze = 100; chairfrezze = 100; elbowfrezze = 100; headfrezze = 100; headhollowbackfrezze = 100;
        hollowbackfrezze = 100; invertfrezze = 100; onehandfrezze = 100; shoulderfrezze = 100; turtelfrezze = 100;

        airflare = 100; backspin = 100; cricket = 100; elbowairflare = 100; flare = 100; jackhammer = 100; halo = 100; headspin = 100;
        munchmill = 100; ninety_nine = 100; swipes = 100; turtel = 100; ufo = 100; web = 100; windmill = 100; wolf = 100;

        angle = 100; bridge = 100; finger = 100; handstand = 100; horizont = 100; pushups = 100;
        butterfly = 100; fold = 100; shoulders = 100; twine = 100;

    }

}
