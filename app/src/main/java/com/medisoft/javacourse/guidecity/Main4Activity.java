package com.medisoft.javacourse.guidecity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity  implements View.OnClickListener{

    TextView textView, textView3, textView4, textView6, textView5, textView8, textView9, textView10;
    Button bt_ratingUp, bt_ratingDn, bt_favorites, bt_response;
    RatingBar ratingBar;

    private String category;
    private int favorites;
    private String name;
    private float rating;
    private String description;
    private String responses;
    private String worktim;
    private String telefon;
    private String adres;
    private String txtDB;
    private float ratingMin;
    private float ratingMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        txtDB = intent.getStringExtra("list");
        ratingMax = Integer.parseInt(intent.getStringExtra("ratingMax"));
        ratingMin = Integer.parseInt(intent.getStringExtra("ratingMin"));

        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);

        bt_ratingDn = (Button) findViewById(R.id.bt_ratingDn);
        bt_ratingUp = (Button) findViewById(R.id.bt_ratingUp);
        bt_favorites = (Button) findViewById(R.id.bt_favorites);
        bt_response = (Button) findViewById(R.id.bt_response);

        bt_ratingDn.setOnClickListener(this);
        bt_ratingUp.setOnClickListener(this);
        bt_favorites.setOnClickListener(this);
        bt_response.setOnClickListener(this);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);



        category = txtDB.split(";;;;")[0];
        favorites = Integer.parseInt(txtDB.split(";;;;")[1]);
        name = txtDB.split(";;;;")[2];
        rating = Integer.parseInt(txtDB.split(";;;;")[3]);
        description = txtDB.split(";;;;")[4];
        responses = txtDB.split(";;;;")[5];
        worktim = txtDB.split(";;;;")[6];
        telefon = txtDB.split(";;;;")[7];
        adres = txtDB.split(";;;;")[8];

        if(favorites > 0){
            bt_favorites.setTextColor(Color.RED);
        }else {
            bt_favorites.setTextColor(Color.rgb(155,155,155));
        }

        textView.setText(category + " - " + name);
        textView3.setText("Описание: " + description);
        textView4.setText("Время работы: c " + worktim.split("_")[0] + " по " + worktim.split("_")[1]);
        textView6.setText("Телефон: " + telefon);
        textView5.setText("Адрес: " + adres);
        textView9.setText("Отзывы:" + favorites);

        //Отрисовка рейтинга звездочками (корректно не работает, но как относительный показатель по категориипойдет)
        ratingBar.setNumStars(5);
        ratingBar.setMax((int) (ratingMax - ratingMin+1));
        ratingBar.setRating(rating - ratingMin);

        //Комментрии
        String otzivLists[] = responses.split("::::");
        String otz = "";
        for (int t = 0; t < otzivLists.length; t++) {
            otz = otz + ">> " + otzivLists[t] + "\n------------------" + "\n";
        }
        textView10.setText(otz);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_favorites:
                favorites = favorites *-1;
                txtDB = category + ";;;;" + favorites + ";;;;" + name + ";;;;" + rating + ";;;;" + description + ";;;;" + responses + ";;;;" + worktim + ";;;;" + telefon + ";;;;" + adres + ";;;;";

                if(favorites > 0){
                    bt_favorites.setTextColor(Color.RED);
                }else {
                    bt_favorites.setTextColor(Color.rgb(155,155,155));
                }
                break;

            case R.id.bt_ratingUp:
                rating = rating + 1;
                ratingBar.setRating(rating - ratingMin);
                break;

            case R.id.bt_ratingDn:
                rating = rating - 1;
                ratingBar.setRating(rating - ratingMin);
                break;
        }
    }
}