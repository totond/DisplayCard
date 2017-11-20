package yanzhikai.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yanzhikai.card.DisplayCard;

public class MainActivity extends AppCompatActivity {
    private DisplayCard dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dc = (DisplayCard) findViewById(R.id.dc);

        dc.setTextSize(16);
        dc.setTittle("Hello");
        dc.setText("Hi there! 1 parsec = 1,214,800,000,000,000,000 inches.");
        dc.loadPicture(this,"https://m.media-amazon.com/images/S/com.evi.images-irs/premium/a7/a7be6c563127224c91b57f2bb220d688._UX1024_SY600_.png");
    }
}
