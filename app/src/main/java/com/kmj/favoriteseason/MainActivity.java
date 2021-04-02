package com.kmj.favoriteseason;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    TextView text1,text2,result;
    EditText userId;
    RadioGroup RG;
    RadioButton spring,summer,autumn,winter;
    Button select;
    ImageView seasonImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id 가져오기
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        result = (TextView)findViewById(R.id.result);

        userId =(EditText)findViewById(R.id.id);
        RG = (RadioGroup)findViewById(R.id.RadioGroup1);

        spring = (RadioButton)findViewById(R.id.spring);
        summer = (RadioButton)findViewById(R.id.summer);
        autumn = (RadioButton)findViewById(R.id.autumn);
        winter = (RadioButton)findViewById(R.id.winter);

        select = (Button)findViewById(R.id.select);
        seasonImg = (ImageView)findViewById(R.id.seasonImg);


        // 선택 버튼 눌렀을때 반응
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(select.isClickable()==true){
                    seasonImg.setVisibility(View.VISIBLE);
                    result.setVisibility(View.VISIBLE);
                }
                else {
                    seasonImg.setVisibility(View.INVISIBLE);
                    result.setVisibility(View.INVISIBLE);
                }

                String id = userId.getText().toString();
                String favSeason="";

                //선택된 라디오버튼 사진 띄우기
                switch (RG.getCheckedRadioButtonId()){
                    case R.id.spring:
                        favSeason="봄";
                        seasonImg.setImageResource(R.drawable.spring);
                        break;
                    case R.id.summer:
                        favSeason="여름";
                        seasonImg.setImageResource(R.drawable.summer);
                        break;
                    case R.id.autumn:
                        favSeason="가을";
                        seasonImg.setImageResource(R.drawable.autumn);
                        break;
                    case R.id.winter:
                        favSeason="겨울";
                        seasonImg.setImageResource(R.drawable.winter);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"선택하세요",
                                Toast.LENGTH_SHORT).show();

                }

                //결과 문장
                result.setText(id+"님의 최애 계절 "+favSeason);

            }
        });

    }

}