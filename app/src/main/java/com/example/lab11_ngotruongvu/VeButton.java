package com.example.lab11_ngotruongvu;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
public class VeButton extends Activity {

    Handler handlerMain;
    AtomicBoolean atomic=null;
    LinearLayout layoutdevebutton;
    Button btnOk;
    EditText edtOk;
    int sizehalf=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ve_button);

        layoutdevebutton=(LinearLayout) findViewById(R.id.layout_draw_button);
        final Random rd=new Random();
        btnOk=(Button) findViewById(R.id.btnDrawButton);
        edtOk=(EditText) findViewById(R.id.editNumber);
        handlerMain=new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                int v=rd.nextInt(100);
                String nhan_button=v+"";
                Button b=new Button(VeButton.this);
                b.setText(nhan_button);
                LayoutParams params=new
                        LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
                if(msg.arg1%2==0)
                    params.gravity=Gravity.LEFT;
                else
                    params.gravity=Gravity.RIGHT;

                b.setWidth(sizehalf);
                b.setLayoutParams(params);
                layoutdevebutton.addView(b);

            }
        };
        btnOk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                doStart();
            }
        });
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sizehalf=size.x/2;
    }
    private void doStart()
    {
        layoutdevebutton.removeAllViews();
        atomic=new AtomicBoolean(false);
        final int sobutton=Integer.parseInt(edtOk.getText()+"");
        Thread thCon=new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                for(int i=0;i<sobutton && atomic.get();i++)
                {

                    SystemClock.sleep(200);
                    Message msg=handlerMain.obtainMessage();
                    msg.arg1=i;
                    handlerMain.sendMessage(msg);
                }
            }
        });
        atomic.set(true);
        thCon.start();
    }

}