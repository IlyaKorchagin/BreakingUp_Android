package com.example.goodfootbreaking;

import java.io.Serializable;

// Описание класса Pupils
public class Pupils implements Serializable {

    //---------- Personal information -----------
    private String id, name, email;
    private int status;
    //---------- Personal information -----------

    //---------- Rating -----------
    private double rating, frezze_rating, powermove_rating, ofp_rating, streching_rating;
    private int  battle_rating, battle_cur_position, battle_new_position, current_position, new_position;
    //---------- Rating -----------

    //---------- FREZZE -----------
    public int babyfrezze, chairfrezze, elbowfrezze, headfrezze, headhollowbackfrezze;
    public int hollowbackfrezze, invertfrezze, onehandfrezze, shoulderfrezze, turtlefrezze;
    //---------- FREZZE -----------

    //----------- POWER MOVE -------------
    public int airflare, backspin, cricket, elbowairflare, flare, jackhammer, halo, headspin;
    public int munchmill, ninety_nine, swipes, turtle, ufo, web, windmill, wolf;
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
        status = 4;

        rating = 100; frezze_rating = 100; powermove_rating = 100; ofp_rating = 100; streching_rating = 100;
        battle_rating = 100;  battle_cur_position = 0; battle_new_position = 0; current_position = 0; new_position = 0;

        babyfrezze = 100; chairfrezze = 100; elbowfrezze = 100; headfrezze = 100; headhollowbackfrezze = 100;
        hollowbackfrezze = 100; invertfrezze = 100; onehandfrezze = 100; shoulderfrezze = 100; turtlefrezze = 100;

        airflare = 100; backspin = 100; cricket = 100; elbowairflare = 100; flare = 100; jackhammer = 100; halo = 100; headspin = 100;
        munchmill = 100; ninety_nine = 100; swipes = 100; turtle = 100; ufo = 100; web = 100; windmill = 100; wolf = 100;

        angle = 100; bridge = 100; finger = 100; handstand = 100; horizont = 100; pushups = 100;
        butterfly = 100; fold = 100; shoulders = 100; twine = 100;

    }

    public String getId() {
          return id;                        
    }
                                            
    public void setId(String id) {
          this.id = id;                     
    }
                                            
    public String getName() {
          return name;                      
    }
                                            
    public void setName(String name) {
          this.name = name;                 
    }
                                            
     public String getEmail() {
          return email;                     
     }
                                            
     public void setStatus(int status) {
          this.status = status;
     }

      public int getStatus() {
           return status;
      }

      public void setEmail(String email) {
           this.email = email;
      }

     public double getRating() {
         return rating;
     }

     public void setRating(double rating) {
         this.rating = rating;
     }

     public double getFrezze_rating() {
         return frezze_rating;
     }

     public void setFrezze_rating(double frezze_rating) {
         this.frezze_rating = frezze_rating;
     }

     public double getPowermove_rating() {
         return powermove_rating;
     }

     public void setPowermove_rating(double powermove_rating) {
         this.powermove_rating = powermove_rating;
     }

     public double getOfp_rating() {
         return ofp_rating;
     }

     public void setOfp_rating(double ofp_rating) {
         this.ofp_rating = ofp_rating;
     }

     public double getStreching_rating() {
         return streching_rating;
     }

     public void setStreching_rating(double streching_rating) {
         this.streching_rating = streching_rating;
     }

     public int getBattle_rating() {
         return battle_rating;
     }

     public void setBattle_rating(int battle_rating) {
         this.battle_rating = battle_rating;
     }

     public int getBattle_cur_position() {
         return battle_cur_position;
     }

     public void setBattle_cur_position(int battle_cur_position) {
         this.battle_cur_position = battle_cur_position;
     }

     public int getBattle_new_position() {
         return battle_new_position;
     }

     public void setBattle_new_position(int battle_new_position) {
         this.battle_new_position = battle_new_position;
     }

     public int getCurrent_position() {
         return current_position;
     }

     public void setCurrent_position(int current_position) {
         this.current_position = current_position;
     }

     public int getNew_position() {
         return new_position;
     }

     public void setNew_position(int new_position) {
         this.new_position = new_position;
     }                                                                         
}











