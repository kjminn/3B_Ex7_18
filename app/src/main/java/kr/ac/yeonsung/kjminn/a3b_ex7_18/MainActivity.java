package kr.ac.yeonsung.kjminn.a3b_ex7_18;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnItem, btnItemSingle;
    String[] items = {"사과", "포도", "복숭아"};
    String[] itemsSingle = {"박세리", "남현희", "유현주"};
    int[] imgResIds = {R.drawable.apple, R.drawable.grapes, R.drawable.peach};
    int[] imgResIds2 = {R.drawable.seri, R.drawable.nam, R.drawable.ryu};
    ImageView imgv;
    int checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnItem = findViewById(R.id.btn_item);
        btnItem.setOnClickListener(btnListener);
        imgv = findViewById(R.id.imgv);
        btnItemSingle = findViewById(R.id.btn_item_single);
        btnItemSingle.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_item:
                    AlertDialog.Builder d1 = new AlertDialog.Builder(MainActivity.this);
                    d1.setTitle("과일목록");
                    d1.setIcon(R.drawable.blueberry_icon);
                    d1.setItems(items, itemListener);
                    d1.setNegativeButton("close", null);
                    d1.show();
                    break;
                case R.id.btn_item_single:
                    AlertDialog.Builder d2 = new AlertDialog.Builder(MainActivity.this);
                    d2.setTitle("좋아하는 운동선수");
                    d2.setIcon(R.drawable.prize);
                    d2.setSingleChoiceItems(itemsSingle, checked, itemListener2);
                    d2.setNegativeButton("close", null);
                    d2.show();
                    break;
            }

        }
    };

    DialogInterface.OnClickListener itemListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnItem.setText(items[which]);
            imgv.setImageResource(imgResIds[which]);
        }
    };

    DialogInterface.OnClickListener itemListener2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnItemSingle.setText(itemsSingle[which]);
            imgv.setImageResource(imgResIds2[which]);
            checked = which;
            dialog.cancel();
        }
    };
}