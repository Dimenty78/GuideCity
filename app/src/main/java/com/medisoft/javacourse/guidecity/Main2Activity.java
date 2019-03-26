package com.medisoft.javacourse.guidecity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2Activity extends AppCompatActivity {

    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvMain = (ListView) findViewById(R.id.lvMain);

        Intent intent = getIntent();
        final String txtDB = intent.getStringExtra("bd");
        final int viewSort = Integer.parseInt(intent.getStringExtra("sort"));
        final int workNow = Integer.parseInt(intent.getStringExtra("work"));

        String massLists[] = txtDB.split("\n");

        //Создания списка категорий из базы
        ArrayList<String> listCategory = null;
        listCategory = new ArrayList<String>();

        for (int t = 0; t < massLists.length; t++) {
            if (listCategory.contains(massLists[t].split(";;;;")[0])) {
            } else {
                listCategory.add(massLists[t].split(";;;;")[0]);
            }
        }

        // Сортировка по алфавиту
        Collections.sort(listCategory, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    // формирование на Экране1 списка категорий, и обработка нажатия
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listCategory);

        lvMain.setAdapter(adapter);

    final ArrayList<String> finalListCategory = listCategory;
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Передача Экран2 параметров выбора категории и переключение на Экран2
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("id", "" + finalListCategory.get((int)id));
            intent.putExtra("sort", "" + viewSort);
            intent.putExtra("work", "" + workNow);
            intent.putExtra("bd", "" + txtDB);
            startActivity(intent);
            }
        });
    }
}