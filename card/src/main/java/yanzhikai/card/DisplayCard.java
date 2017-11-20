package yanzhikai.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yany on 2017/11/20.
 */

public class DisplayCard extends CardView {
    public static final int NO_PICTURE = 0 , PICTURE = 1;
    @IntDef({NO_PICTURE, PICTURE})
    @Retention(RetentionPolicy.SOURCE)
    public  @interface DisplayMode {}
    private @DisplayMode int mDisplayMode = NO_PICTURE;

    private TextView tv_tittle, tv_text;
    private ImageView iv_picture;

    public DisplayCard(Context context) {
        super(context);
        init(context);
    }

    public DisplayCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init(context);
    }

    public DisplayCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        init(context);
    }

    @SuppressWarnings("WrongConstant")
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DisplayCard, 0, 0);
        mDisplayMode = typedArray.getInt(R.styleable.DisplayCard_mode,mDisplayMode);

    }

    private void init(Context context) {
        switch (mDisplayMode){
            case NO_PICTURE:
                LayoutInflater.from(context).inflate(R.layout.card_without_picture, this);
                break;
            case PICTURE:
                LayoutInflater.from(context).inflate(R.layout.card_picture, this);
                break;
        }


        tv_tittle = (TextView) findViewById(R.id.tv_tittle);
        tv_text = (TextView) findViewById(R.id.tv_text);
        iv_picture = (ImageView) findViewById(R.id.iv_picture);

    }

    public void loadPicture(Context context, String url) {
        if (iv_picture != null) {
            RequestOptions options = new RequestOptions();
            Glide.with(context)
                    .load(url)
                    .apply(options.centerCrop())
                    .into(iv_picture);
        }
    }

    public void setText(String text) {
        tv_text.setText(text);
    }

    public void setTittle(String tittle) {
        tv_tittle.setText(tittle);
    }

    public void setTittleSize(int size) {
        tv_tittle.setTextSize(size);
    }

    public void setTextSize(int size) {
        tv_text.setTextSize(size);
    }

    public void setTittleColor(int color) {
        tv_tittle.setTextColor(color);
    }

    public void setTextColor(int color) {
        tv_text.setTextColor(color);
    }
}
