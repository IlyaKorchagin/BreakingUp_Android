package com.example.goodfootbreaking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FRatingTable extends Fragment {

    private ArrayAdapter adapter;
    private List<Pupils> allpupils;
    private List<Pupils> allpupils_invert;
    private String PUPILS_KEY ="Pupils";
    private DatabaseReference mDataBase;
    private View curView;
    private int sort=0, emojicode; // поле по которому идет сортировка

    public FRatingTable() {
        // Required empty public constructor
    }

    // Расчет динамики прогресса по турнирной таблице (Breaking Up)
    public String din(int i, Pupils pupils, int sort){
       String result;
       int dinamic;
       if (sort==0) {dinamic = pupils.current_position - pupils.new_position;}
       else {dinamic = pupils.battle_cur_position - pupils.battle_new_position;}
       if (dinamic == 0) result="";
       if (dinamic > 0)
       {
           switch (dinamic)
           {
               case 1:
                   emojicode = 128076;              //  смайлик - ок
                   break;
               case 2:
                   emojicode = 128077;              //  смайлик - класс
                   break;
               case 3:
                   emojicode = 128163;              //  смайлик - бомба
                   break;
               case 4:
                   emojicode = 128165;              //  смайлик - взрыв
                   break;
               case 5:
                   emojicode = 128293;              //  смайлик - огонь
                   break;
               case 6:
                   emojicode = 128640;              //  смайлик - ракета
                   break;
               default:
                   emojicode = 128640;              //  смайлик - ракета
           }
           result = " (↑ " + Integer.toString(dinamic)+") " + new String(Character.toChars(emojicode));
       }
       else {
           switch (dinamic)
           {
               case -1:
                   emojicode = 128201;              //  смайлик - график с отрицательной динамикой
                   break;
               case -2:
                   emojicode = 12349;               //  смайлик - график с отрицательной динамикой
                   break;
               case -3:
                   emojicode = 128078;              //  смайлик - very bad
                   break;
               case -4:
                   emojicode = 128545;              //  смайлик - злость
                   break;
               case -5:
                   emojicode = 128561;              //  смайлик - ужас
                   break;
               default:
                   emojicode = 128561;              //  смайлик - ужас
           }
           result = " (↓ " + Integer.toString(Math.abs(dinamic)) + ") "  + new String(Character.toChars(emojicode));
       }
       return result;
    }

    // Выбор цвета текста, в завимости от текущей позиции
    public Integer getBattleColour(int i) {
        Integer res;
        switch (i) {
            case 1:
                res = R.color.one;
                break;
            case 2:
                res = R.color.two;
                break;
            case 3:
                res = R.color.three;
                break;
            case 4:
                res = R.color.four;
                break;
            case 5:
                res = R.color.five;
                break;
            case 6:
                res = R.color.six;
                break;
            case 7:
                res = R.color.seven;
                break;
            case 8:
                res = R.color.eight;
                break;
            default:
                res = R.color.white;
                break;
        }
        return res;
    }

    // Отрисовка таблицы рейтинга
    public void SortTable(List<Pupils> pupilList, int row_count, View view, int position)
    {
        TableLayout tableLayout = new TableLayout(view.getContext());
        tableLayout = (TableLayout) view.findViewById(R.id.RatingTableLayout);
        tableLayout.removeAllViews(); // удалить все View из LinearLayout

        int Count_Columns = 2;

        for (int i = 0; i < row_count; i++) {


            TableRow tableRow = new TableRow(view.getContext());
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            if(i % 2 == 0)tableRow.setBackgroundResource(R.drawable.ratingtabrow11);
            else tableRow.setBackgroundResource(R.drawable.ratingtabrow21);

            Pupils curpupil = pupilList.get(i); // считываем данные с текущего ученика

            for (int j = 0; j < Count_Columns+1; j++) {
                switch (j){
                    case 0:
                        TextView textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(160,LinearLayout.LayoutParams.WRAP_CONTENT));
                        //--> устанавливаем цветовой градиент и размер шрифта с 1 по 8 места в таблице
                        switch (i){
                            case 0:
                                textView.setTextColor(getResources().getColor(R.color.one));
                                textView.setTextSize(18);
                                break;

                            case 1: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.two));
                                    textView.setTextSize(16);break;
                            case 2: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.three));
                                    textView.setTextSize(16);break;
                            case 3: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.four));
                                    textView.setTextSize(16);break;
                            case 4: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.five));
                                    textView.setTextSize(16);break;
                            case 5: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.six));
                                    textView.setTextSize(16);break;
                            case 6: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.seven));
                                    textView.setTextSize(16);break;
                            case 7: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.eight));
                                    textView.setTextSize(16);break;
                            default: {
                                if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                else textView.setTextColor(getResources().getColor(R.color.white));
                                textView.setTextSize(16);
                                break;
                            }
                            //<-- устанавливаем цветовой градиент и размер шрифта с 1 по 8 места в таблице
                        }
                        textView.setPadding(0,8,0,0);
                        textView.setGravity(Gravity.CENTER);

                        // Если мы сортируем по полю "Battles", то выводим места из поля "Battle_new_position"
                        if(sort==1) textView.setText(Integer.toString(curpupil.battle_new_position));
                        // в других случаях - просто счетчик
                        else textView.setText(Integer.toString(i+1));

                        tableRow.addView(textView, j);
                        break;
                    case 1:
                        textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(650,LinearLayout.LayoutParams.WRAP_CONTENT));
                        switch (i){
                            // 1-е место
                            case 0:
                                textView.setTextColor(getResources().getColor(R.color.one));
                                textView.setTextSize(17);
                                // Если сортировка по полю "Breaking"
                                if (sort==0){
                                    if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("♛ "+curpupil.name+" ♛");
                                    else
                                        if (curpupil.battle_cur_position - curpupil.battle_new_position>0)
                                        {
                                            String words = "♛ " + curpupil.name + "<small><font color='#64bf72'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = "♛ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                }
                                // Если сортировка по полю "Battles"
                                else if (sort==1){
                                    if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(new String(Character.toChars(127942))+" "+curpupil.name+" "+new String(Character.toChars(127942)));
                                    else
                                        if (curpupil.battle_cur_position - curpupil.battle_new_position>0)
                                        {
                                            String words = new String(Character.toChars(127942))+" "+ curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    else {
                                        String words = new String(Character.toChars(127942))+" "+ curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                        textView.setText(Html.fromHtml(words));
                                    }
                                }
                                else textView.setText("♛ "+curpupil.name +" ♛");
                                break;

                            case 1: textView.setTextColor(getResources().getColor(R.color.two));
                                textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking" (sort = 0)
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name+" ✯");
                                        else  if (curpupil.current_position - curpupil.new_position>0)
                                            {String words = "✯ "+curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                        }
                                    // Если сортировка по полю "Battles" (sort = 1)
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(new String(Character.toChars(127941))+" "+curpupil.name +" "+new String(Character.toChars(127941)));
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0)
                                        {
                                            String words = new String(Character.toChars(127941))+" "+curpupil.name +"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = new String(Character.toChars(127941))+" "+ curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText("✯ "+curpupil.name +" ✯");
                            break;

                            case 2: textView.setTextColor(getResources().getColor(R.color.three));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name+" ✯");
                                        else    if (curpupil.current_position - curpupil.new_position>0)
                                            {String words = "✯ "+curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                        }
                                    // Если сортировка по полю "Battles"
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(new String(Character.toChars(127941))+" "+curpupil.name +" "+new String(Character.toChars(127941)));
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position >0)
                                        {
                                            String words = new String(Character.toChars(127941))+" "+curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = new String(Character.toChars(127941))+" "+ curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText("✯ "+curpupil.name+" ✯");
                            break;
                            case 3: textView.setTextColor(getResources().getColor(R.color.four));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name+" ✯");
                                        else if (curpupil.current_position - curpupil.new_position>0)
                                            {
                                            String words = "✯ "+curpupil.name +"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                    }
                                    // Если сортировка по полю "Battles"
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0){String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText(curpupil.name);
                                    break;
                            case 4: textView.setTextColor(getResources().getColor(R.color.five));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name +" ✯");
                                        else if (curpupil.current_position - curpupil.new_position>0)
                                            {
                                                String words = "✯ "+curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                    }
                                    // Если сортировка по полю "Battles"
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0){String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText(curpupil.name);
                                    break;
                            case 5: textView.setTextColor(getResources().getColor(R.color.six));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name +" ✯");
                                        else if (curpupil.current_position - curpupil.new_position>0)
                                            {
                                                String words = "✯ "+curpupil.name +"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                    }
                                    // Если сортировка по полю "Battles"
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0){String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText(curpupil.name);
                                    break;
                            case 6: textView.setTextColor(getResources().getColor(R.color.seven));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name+" ✯");
                                        else if (curpupil.current_position - curpupil.new_position>0)
                                        {
                                            String words = "✯ "+curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        // Если сортировка по полю "Battles"
                                        else {
                                            String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0){String words = curpupil.name +"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText(curpupil.name);
                                    break;
                            case 7: textView.setTextColor(getResources().getColor(R.color.eight));
                                    textView.setTextSize(16);
                                    // Если сортировка по полю "Breaking"
                                    if (sort==0){
                                        if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText("✯ "+curpupil.name+" ✯");
                                        else if (curpupil.current_position - curpupil.new_position >0)
                                            {
                                                String words = "✯ "+curpupil.name +"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                            else {
                                                String words = "✯ " + curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                                textView.setText(Html.fromHtml(words));
                                            }
                                    }
                                    // Если сортировка по полю "Battles"
                                    else if (sort==1){
                                        textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                        if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                        else if (curpupil.battle_cur_position - curpupil.battle_new_position>0){String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                    }
                                    else textView.setText(curpupil.name);
                                    break;
                            default: {
                                textView.setTextColor(getResources().getColor(R.color.white));
                                textView.setTextSize(16);
                                // Если сортировка по полю "Breaking"
                                if (sort==0){
                                    if ((curpupil.new_position==0)|(curpupil.current_position - curpupil.new_position==0)) textView.setText(curpupil.name);
                                    else if (curpupil.current_position - curpupil.new_position>0)
                                        {
                                            String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                        else {
                                            String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                            textView.setText(Html.fromHtml(words));
                                        }
                                }
                                // Если сортировка по полю "Battles"
                                else if (sort==1){
                                    textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    if ((curpupil.battle_new_position==0)|(curpupil.battle_cur_position - curpupil.battle_new_position==0)) textView.setText(curpupil.name);
                                    else if (curpupil.battle_cur_position - curpupil.battle_new_position>0)
                                    {String words = curpupil.name+"<small><font color='#64bf72'>"+din(i, curpupil, sort)+"</font></small>";
                                        textView.setText(Html.fromHtml(words));
                                    }
                                    else {
                                        String words = curpupil.name + "<small><font color='#f26450'>" + din(i, curpupil, sort) + "</font></small>";
                                        textView.setText(Html.fromHtml(words));
                                    }
                                }
                                else textView.setText(curpupil.name);
                                break;
                            }
                        }
                        textView.setGravity(Gravity.CENTER);
                        textView.setPadding(0,8,0,0);
                        tableRow.addView(textView, j);
                        break;
                    case 2:
                        textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(250,LinearLayout.LayoutParams.WRAP_CONTENT));
                        switch (i){
                            case 0:
                                textView.setTextColor(getResources().getColor(R.color.one));
                                textView.setTextSize(18);
                                break;

                            case 1: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.two));
                                    textView.setTextSize(16);break;
                            case 2: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.three));
                                    textView.setTextSize(16);break;
                            case 3: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.four));
                                    textView.setTextSize(16);break;
                            case 4: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.five));
                                    textView.setTextSize(16);break;
                            case 5: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.six));
                                    textView.setTextSize(16);break;
                            case 6: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.seven));
                                    textView.setTextSize(16);break;
                            case 7: if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                    else textView.setTextColor(getResources().getColor(R.color.eight));
                                    textView.setTextSize(16);break;
                            default: {
                                if (sort==1) textView.setTextColor(getResources().getColor(getBattleColour(curpupil.battle_new_position)));
                                else textView.setTextColor(getResources().getColor(R.color.white));
                                textView.setTextSize(16);
                                break;
                            }
                        }
                        textView.setGravity(Gravity.CENTER);
                        textView.setPadding(0,8,0,0);
                        switch (position){
                            case 0: textView.setText(Double.toString(curpupil.rating)); break;
                            case 1: textView.setText(Double.toString(curpupil.battle_rating)); break;
                            case 2: textView.setText(Double.toString(curpupil.frezze_rating));break;
                            case 3: textView.setText(Double.toString(curpupil.powermove_rating)); break;
                            case 4: textView.setText(Double.toString(curpupil.ofp_rating)); break;
                            case 5: textView.setText(Double.toString(curpupil.streching_rating));break;
                            case 6: textView.setText(Integer.toString(curpupil.babyfrezze)); break;
                            case 7: textView.setText(Integer.toString(curpupil.chairfrezze)); break;
                            case 8: textView.setText(Integer.toString(curpupil.elbowfrezze));break;
                            case 9: textView.setText(Integer.toString(curpupil.headfrezze)); break;
                            case 10: textView.setText(Integer.toString(curpupil.headhollowbackfrezze));break;
                            case 11: textView.setText(Integer.toString(curpupil.hollowbackfrezze)); break;
                            case 12: textView.setText(Integer.toString(curpupil.invertfrezze)); break;
                            case 13: textView.setText(Integer.toString(curpupil.onehandfrezze));break;
                            case 14: textView.setText(Integer.toString(curpupil.shoulderfrezze)); break;
                            case 15: textView.setText(Integer.toString(curpupil.turtelfrezze)); break;
                            case 16: textView.setText(Integer.toString(curpupil.airflare));break;
                            case 17: textView.setText(Integer.toString(curpupil.backspin)); break;
                            case 18: textView.setText(Integer.toString(curpupil.cricket));break;
                            case 19: textView.setText(Integer.toString(curpupil.elbowairflare)); break;
                            case 20: textView.setText(Integer.toString(curpupil.flare)); break;
                            case 21: textView.setText(Integer.toString(curpupil.jackhammer));break;
                            case 22: textView.setText(Integer.toString(curpupil.halo)); break;
                            case 23: textView.setText(Integer.toString(curpupil.headspin)); break;
                            case 24: textView.setText(Integer.toString(curpupil.munchmill));break;
                            case 25: textView.setText(Integer.toString(curpupil.ninety_nine)); break;
                            case 26: textView.setText(Integer.toString(curpupil.swipes));break;
                            case 27: textView.setText(Integer.toString(curpupil.turtel)); break;
                            case 28: textView.setText(Integer.toString(curpupil.ufo)); break;
                            case 29: textView.setText(Integer.toString(curpupil.web));break;
                            case 30: textView.setText(Integer.toString(curpupil.windmill)); break;
                            case 31: textView.setText(Integer.toString(curpupil.wolf)); break;
                            case 32: textView.setText(Integer.toString(curpupil.angle));break;
                            case 33: textView.setText(Integer.toString(curpupil.bridge)); break;
                            case 34: textView.setText(Integer.toString(curpupil.finger));break;
                            case 35: textView.setText(Integer.toString(curpupil.handstand)); break;
                            case 36: textView.setText(Integer.toString(curpupil.horizont)); break;
                            case 37: textView.setText(Integer.toString(curpupil.pushups));break;
                            case 38: textView.setText(Integer.toString(curpupil.butterfly)); break;
                            case 39: textView.setText(Integer.toString(curpupil.fold)); break;
                            case 40: textView.setText(Integer.toString(curpupil.shoulders));break;
                            case 41: textView.setText(Integer.toString(curpupil.twine)); break;
                            default: textView.setText(Double.toString(curpupil.rating));
                        }
                        tableRow.addView(textView, j);
                        break;
                }

            }

            tableLayout.addView(tableRow, i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_rating_table, container, false);
        curView = view;

        TextView ratingtext = (TextView)getActivity().findViewById(R.id.ratingtext);
        ratingtext.setText("");
        mDataBase = FirebaseDatabase.getInstance().getReference(PUPILS_KEY);
        allpupils = new ArrayList<>();
        allpupils_invert = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, allpupils);

        // Получаем экземпляр элемента Spinner
        final Spinner spinner = (Spinner) view.findViewById(R.id.sortspinner);


        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.sortList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Вызываем адаптер
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                sort = selectedItemPosition; // инициализация поля по которому идет сортировка
                switch (selectedItemPosition)
                {
                    case 0: getDataFromDB("rating"); break;
                    case 1: getDataFromDB("battle_rating"); break;
                    case 2: getDataFromDB("frezze_rating"); break;
                    case 3: getDataFromDB("powermove_rating"); break;
                    case 4: getDataFromDB("ofp_rating"); break;
                    case 5: getDataFromDB("streching_rating"); break;
                    case 6: getDataFromDB("babyfrezze"); break;
                    case 7: getDataFromDB("chairfrezze"); break;
                    case 8: getDataFromDB("elbowfrezze"); break;
                    case 9: getDataFromDB("headfrezze"); break;
                    case 10: getDataFromDB("headhollowbackfrezze");break;
                    case 11: getDataFromDB("hollowbackfrezze"); break;
                    case 12: getDataFromDB("invertfrezze"); break;
                    case 13: getDataFromDB("onehandfrezze"); break;
                    case 14: getDataFromDB("shoulderfrezze"); break;
                    case 15: getDataFromDB("turtelfrezze"); break;
                    case 16: getDataFromDB("airflare"); break;
                    case 17: getDataFromDB("backspin"); break;
                    case 18: getDataFromDB("cricket"); break;
                    case 19: getDataFromDB("elbowairflare"); break;
                    case 20: getDataFromDB("flare"); break;
                    case 21: getDataFromDB("jackhammer"); break;
                    case 22: getDataFromDB("halo"); break;
                    case 23: getDataFromDB("headspin"); break;
                    case 24: getDataFromDB("munchmill"); break;
                    case 25: getDataFromDB("ninety_nine"); break;
                    case 26: getDataFromDB("swipes"); break;
                    case 27: getDataFromDB("turtel"); break;
                    case 28: getDataFromDB("ufo"); break;
                    case 29: getDataFromDB("web"); break;
                    case 30: getDataFromDB("windmill"); break;
                    case 31: getDataFromDB("wolf"); break;
                    case 32: getDataFromDB("angle"); break;
                    case 33: getDataFromDB("bridge"); break;
                    case 34: getDataFromDB("finger"); break;
                    case 35: getDataFromDB("handstand"); break;
                    case 36: getDataFromDB("horizont"); break;
                    case 37: getDataFromDB("pushups"); break;
                    case 38: getDataFromDB("butterfly"); break;
                    case 39: getDataFromDB("fold"); break;
                    case 40: getDataFromDB("shoulders"); break;
                    case 41: getDataFromDB("twine"); break;

                    default:getDataFromDB("rating"); break;

                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }

    private void getDataFromDB(String sortField)
    {

        mDataBase.orderByChild(sortField).addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(allpupils.size()>0) allpupils.clear();
                if(allpupils_invert.size()>0) allpupils_invert.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Pupils pupil = ds.getValue(Pupils.class);
                    assert pupil!= null;
                    allpupils.add(pupil);
                }
                adapter.notifyDataSetChanged();

                // Сортируем полученный массив в порядке убывания
                int i = allpupils.size()-1;
                int j = 0;
                while (i>=0)
                {
                    allpupils_invert.add(j,allpupils.get(i));
                    i-=1;
                    j+=1;
                }
                // Сортируем полученный массив в порядке убывания

                SortTable(allpupils_invert, allpupils_invert.size(), curView, sort);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
