package com.medisoft.javacourse.guidecity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main3Activity extends AppCompatActivity {

    ListView lvMain2;
    //private ArrayList <String >listName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lvMain2 = (ListView) findViewById(R.id.lvMain2);

        Intent intent = getIntent();
        String txtId = intent.getStringExtra("id");
        final String txtDB = intent.getStringExtra("bd");
        final int viewSort = Integer.parseInt(intent.getStringExtra("sort"));
        final int workNow = Integer.parseInt(intent.getStringExtra("work"));

        String massLists[] = txtDB.split("\n");

        ArrayList<CityPoint> listsPoi = new ArrayList<CityPoint>();

        for (int t = 0; t < massLists.length; t++) {
            if (massLists[t].split(";;;;")[0].contains(txtId)) {
                listsPoi.add(new CityPoint(t, massLists[t].split(";;;;")[0], massLists[t].split(";;;;")[1], massLists[t].split(";;;;")[2],Integer.parseInt(massLists[t].split(";;;;")[3]), massLists[t].split(";;;;")[4], massLists[t].split(";;;;")[5], massLists[t].split(";;;;")[6], massLists[t].split(";;;;")[7], massLists[t].split(";;;;")[8]));
            }
        }

        final ArrayList<String> listId = new ArrayList<String>();

        // Сортировка списка по Алфавиту
        if (viewSort ==  1) {
            for (int t = 0; t < listsPoi.size(); t++) {
                listId.add(listsPoi.get(t).getName() + ";;;;" + listsPoi.get(t).getId());
            }
            Collections.sort(listId, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            ArrayList<String> listName = new ArrayList<String>();
            for (int t = 0; t < listId.size(); t++) {
                listName.add(listId.get(t).split(";;;;")[0]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
            lvMain2.setAdapter(adapter);
            lvMain2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Передача Экран3 параметров выбора категории и переключение на Экран2
                    Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                    intent.putExtra("list", "" + txtDB.split("\n")[Integer.parseInt(listId.get((int) id).split(";;;;")[1])]);
                    startActivity(intent);;
                }
            });
        }


        // Сортировка списка по Рейтингу
        if (viewSort ==  2){
        for (int t = 0; t < listsPoi.size(); t++) {
            listId.add(String.valueOf(listsPoi.get(t).getRating()) + ";;;;" + listsPoi.get(t).getId() + ";;;;" + listsPoi.get(t).getName());
        }
        Collections.sort(listId, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        ArrayList<String> listName = new ArrayList<String>();
        for (int t = 0; t < listId.size(); t++) {
            listName.add(listId.get(t).split(";;;;")[2]);
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
            lvMain2.setAdapter(adapter);
            lvMain2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Передача Экран3 параметров выбора категории и переключение на Экран2
                    Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                    intent.putExtra("list", "" + txtDB.split("\n")[Integer.parseInt(listId.get((int) id).split(";;;;")[1])]);
                    startActivity(intent);;
                }
            });
        }


        // Сортировка списка по колличеству Комментов
        if (viewSort ==  3){
            for (int t = 0; t < listsPoi.size(); t++) {
                String massResponses[] = listsPoi.get(t).getResponses().split("::::");


                listId.add(String.valueOf(massResponses.length + ";;;;" + listsPoi.get(t).getId() + ";;;;" + listsPoi.get(t).getName()));
            }
            Collections.sort(listId, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });
            ArrayList<String> listName = new ArrayList<String>();
            for (int t = 0; t < listId.size(); t++) {
                listName.add(listId.get(t).split(";;;;")[2]);
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
            lvMain2.setAdapter(adapter);
            lvMain2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Передача Экран3 параметров выбора категории и переключение на Экран2
                    Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                    intent.putExtra("list", "" + txtDB.split("\n")[Integer.parseInt(listId.get((int) id).split(";;;;")[1])]);
                    startActivity(intent);;
                }
            });
        }

    }
}
