package forfun.good.a2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> aryy;
    Spinner sp,sp2;
    TextView tv;
    TextView tv2, tv3;
    EditText ed;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        ed = findViewById(R.id.editText);
        aryy = new ArrayList <>();
        aryy.add("第一關");
        aryy.add("第二關");
        aryy.add("第三關");



      adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,aryy);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //當被選取時候所觸發的機制
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(aryy.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String aryy[] = getResources().getStringArray(R.array.cities);
                tv3.setText(aryy[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        /*
        ary = new String[]{"第一關", "第二關", "第三關", "第四關"};
        Spinner sp = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                ary
        );
        sp.setAdapter(adapter);
        */
        /*sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ary[position], Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    public void CL1(View v)
    {
        //getSelectedItemPosition是取得選取選單內的位置
        int pos = sp.getSelectedItemPosition();
        tv2.setText(aryy.get(pos));
    }
    public void CL2(View v)
    {
        aryy.add(ed.getText().toString());
        adapter.notifyDataSetChanged();
    }
    public void CLdelete(View v)
    {
        aryy.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }
}
