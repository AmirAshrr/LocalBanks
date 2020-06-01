package sg.edu.rp.c346.id19029023.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ocbc;
    TextView dbs;
    TextView uob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ocbc = findViewById(R.id.OCBC);
        uob = findViewById(R.id.UOB);
        dbs = findViewById(R.id.DBS);
        registerForContextMenu(dbs);
        registerForContextMenu(uob);
        registerForContextMenu(ocbc);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v,menuInfo);
        if(v == dbs ){
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }else if(v == ocbc){
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Contact the bank");
        }else if(v == uob ){
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Contact the bank");
        }



}
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https//www.dbs.com.sg"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 1) {
            String number = "18001111111";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);

        } else if (item.getItemId() == 2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https//www.ocbc.com.sg"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 3) {
            String number = "18003633333";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);

        } else if (item.getItemId() == 4) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https//www.uob.com.sg"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 5) {
            String number = "18002222121";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);

        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreaeOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.EnglishSelection){
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        }
        else if(id == R.id.ChineseSelection){
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
