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

    private int friendID = 0; //"Katou Megumi"
    private String[] testChatContent = {"hello", "hello", "bababoey", "aptaptaptapt", "megumi suki"};
    private int[] orderChat = {2,1,1,2,2};

    private String selfName = "Exphon";

    // Setter and getter
    public void setFriendName(String[] friendName) {this.friendName = friendName;}
    public String[] getFriendName() {return friendName;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox_page);

        TextView friend = findViewById(R.id.friendName);
        friend.setText(friendName[friendID]);
        //获取ListView对象
        ListView chatlistView = findViewById(R.id.chatting);
        myAdapter myAdapter = new myAdapter();
        chatlistView.setAdapter(myAdapter);
    }

    class myAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return testChatContent.length;
        }

        @Override
        public Object getItem(int i) {
            return testChatContent[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            //1. 加载布局
            View view = View.inflate(Main.this, R.layout.chat_layout, null);

            //2.获取控件
            TextView chat = view.findViewById(R.id.sentence);
            TextView capN = view.findViewById(R.id.capName);

            //设置数据
            chat.setText(testChatContent[i]);
            if (orderChat[i] == 1) {
                capN.setText(friendName[friendID].substring(0, 1));
            } else if (orderChat[i] == 2) {
                capN.setText(selfName.substring(0, 1));
            }

            return view;
        }
    }
}