package com.example.memoryleakdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class EnumDemoActivity extends AppCompatActivity {
    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum_demo);
        handler = new MyHandler(this);
        findViewById(R.id.btn_sendmessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(HandlerType.CHANGE_ADDRESS.ordinal());
                finish();
            }
        });
    }

    public enum HandlerType {
        SET_ORDER_TIME, GET_ORDER_DATA_SUCCESS,
        SET_ARRIVAL_TIME, CHANGE_ADDRESS, UPDATE_ORDER_DATA
    }

    class MyHandler extends Handler {
        private EnumDemoActivity activity;

        public MyHandler(EnumDemoActivity activity) {
            this.activity = activity;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            HandlerType handlerType = HandlerType.values()[msg.what];
            switch (handlerType) {
                case CHANGE_ADDRESS:
                    break;
                case SET_ORDER_TIME:
                    break;
                case SET_ARRIVAL_TIME:
                    break;
                case UPDATE_ORDER_DATA:
                    break;
                case GET_ORDER_DATA_SUCCESS:
                    break;
                default:
                    break;
            }
        }
    }
}
