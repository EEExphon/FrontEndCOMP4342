package com.example.frontendcomp4342;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    // Friend Name
    private String[] friendName = {"Katou Megumi", "Misaka Mikoto", "Sora Ginko",
            "Katou Megumi", "Misaka Mikoto", "Sora Ginko",
            "Katou Megumi", "Misaka Mikoto", "Sora Ginko",
            "Katou Megumi", "Misaka Mikoto", "Sora Ginko",
            "Katou Megumi", "Misaka Mikoto", "Sora Ginko"};

    // Setter and getter
    public void setFriendName(String[] friendName) {this.friendName = friendName;}
    public String[] getFriendName() {return friendName;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.welcome_page);

        //获取ListView对象
        ListView listView = findViewById(R.id.listView);
        myAdapter myAdapter = new myAdapter();
        listView.setAdapter(myAdapter);
    }

    class myAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return friendName.length;
        }

        @Override
        public Object getItem(int i) {
            return friendName[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            //1. 加载布局
            View view = View.inflate(Main.this, R.layout.item_list, null);

            //2.获取控件
            TextView name = view.findViewById(R.id.name1);
            TextView capN = view.findViewById(R.id.capName);

            //设置数据
            name.setText(friendName[i]);
            capN.setText(friendName[i].substring(0,1));
            return view;
        }
    }
}