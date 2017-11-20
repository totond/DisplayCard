package yanzhikai.card;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by yany on 2017/11/20.
 */

public class DisplayCard extends CardView{
    private TextView tv_tittle, tv_text;
    private ImageView iv_picture;

    public DisplayCard(Context context) {
        super(context);
        init(context);
    }

    public DisplayCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DisplayCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.card_picture,this);

        tv_tittle = (TextView) findViewById(R.id.tv_tittle);
        tv_text = (TextView) findViewById(R.id.tv_text);
        iv_picture = (ImageView) findViewById(R.id.iv_picture);

    }

    public void loadPicture(Context context, String url){
        RequestOptions options = new RequestOptions();
        Glide.with(context)
                .load(url)
                .apply(options.centerCrop())
                .into(iv_picture);
    }

    public void setText(String text) {
        tv_text.setText(text);
    }

    public void setTittle(String tittle) {
        tv_tittle.setText(tittle);
    }

    public void setTittleSize(int size){
        tv_tittle.setTextSize(size);
    }

    public void setTextSize(int size){
        tv_text.setTextSize(size);
    }
}
