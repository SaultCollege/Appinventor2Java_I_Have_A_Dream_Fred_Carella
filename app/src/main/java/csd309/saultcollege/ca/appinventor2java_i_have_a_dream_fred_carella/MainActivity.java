package csd309.saultcollege.ca.appinventor2java_i_have_a_dream_fred_carella;
// see http://stackoverflow.com/questions/2969242/problems-with-mediaplayer-raw-resources-stop-and-start
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp=new MediaPlayer();
    private boolean playing;
    private int currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgMlkAndMalcom = (ImageView) findViewById(R.id.imageView_mlk_and_malcom);
        ImageView imgMlk = (ImageView) findViewById(R.id.imageView_mlk152x129);
        ImageView imgMalcom = (ImageView) findViewById(R.id.imageView_malcolm152x129);
        imgMlk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentId=R.raw.king;
                play();
            }
        });
        imgMalcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentId=R.raw.malcolmx;
                play();
            }
        });
    }

    private void play(){
        if(playing){
            mp.stop();
            playing = false;
        }else{
            mp = MediaPlayer.create(getApplicationContext(), currentId);
            mp.start();
            playing = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
