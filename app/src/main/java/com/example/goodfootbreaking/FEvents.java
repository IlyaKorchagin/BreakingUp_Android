package com.example.goodfootbreaking;


import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.VideoView;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FEvents extends Fragment {
    private List<Event> events;
    private ArrayAdapter adapter;
    private String EVENT_KEY ="Events";
    private DatabaseReference mDataBase;
    private View curView;

    private WebView myWebView;

    public FEvents() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fevents, container, false);

        curView = view;

        mDataBase = FirebaseDatabase.getInstance().getReference(EVENT_KEY);
        events = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, events);

        getDataFromDB();

        return view;
    }

    private void getDataFromDB()
    {

        mDataBase.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(events.size()>0) events.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Event event = ds.getValue(Event.class);
                    assert event!= null;
                    events.add(event);
                }
                adapter.notifyDataSetChanged();
                SortTable(events, events.size(), curView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void SortTable(List<Event> eventList, int row_count, View view)
    {
        TableLayout tableLayout = new TableLayout(view.getContext());
        tableLayout = (TableLayout) view.findViewById(R.id.EventTableLayout);
        tableLayout.removeAllViews(); // удалить все View из LinearLayout

        int Count_Columns = 2;

        for (int i = 0; i < row_count; i++) {
            TableRow tableRow = new TableRow(view.getContext());
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            if (i % 2 == 0) tableRow.setBackgroundResource(R.drawable.eventtabrow1);
            else tableRow.setBackgroundResource(R.drawable.eventtabrow2);
            tableRow.setPadding(0,8,0,0);


            Event curevent = eventList.get(i);

            for (int j = 0; j < Count_Columns + 1; j++) {
                switch (j) {
                    case 0:
                        TextView textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(215, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setPadding(0, 2, 0, 0);
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextColor(getResources().getColor(R.color.white));
                        textView.setTextSize(14);
                        textView.setText(curevent.date);
                        tableRow.addView(textView, j);
                        break;
                    case 1:
                        textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(570, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setGravity(Gravity.CENTER);
                        switch (curevent.type){
                            case 0: textView.setTextColor(getResources().getColor(R.color.local)); break;
                            case 1: textView.setTextColor(getResources().getColor(R.color.city)); break;
                            case 2: textView.setTextColor(getResources().getColor(R.color.country)); break;
                        }
                        textView.setPadding(0,0 , 0, 10);
                        textView.setTextSize(12);
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setText(curevent.title);
                        tableRow.addView(textView, j);
                        break;
                    case 2:
                        textView = new TextView(view.getContext());
                        textView.setLayoutParams(new TableRow.LayoutParams(280, LinearLayout.LayoutParams.WRAP_CONTENT));
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextColor(getResources().getColor(R.color.white));
                        textView.setPadding(0, 2, 0, 0);
                        textView.setTextSize(14);
                        textView.setText(curevent.location);
                        tableRow.addView(textView, j);
                        break;
                }

            }

            tableLayout.addView(tableRow, i);
        }

    }

}
