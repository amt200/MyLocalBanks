package c346.rp.edu.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvDBS, tvOCBC, tvUOB;
String bank = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(v.getId() == R.id.textViewDBS){
            bank = "DBS";
        }
        else if(v.getId() == R.id.textViewOCBC){
            bank = "OCBC";
        }
        else{
            bank = "UOB";
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.

        if (item.getItemId() == R.id.chinese) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        else  {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.web) {
            if(bank.equals("DBS")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            }
            else if(bank.equals("OCBC")){

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            }
            else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
        }else  {
            if(bank.equals("DBS")){
                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intent);
                return true;
            }
            else if(bank.equals("OCBC")){

                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intent);
                return true;
            }
            else {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                startActivity(intent);
            }

        }
        return super.onContextItemSelected(item);
    }

}
