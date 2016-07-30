package bd.com.card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import bd.com.card.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cards_panel)
    FlexboxLayout mFlexboxLayout;
    @BindView(R.id.word)
    TextView mWordView;
    @BindView(R.id.picture)
    ImageView mPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mCards = new ArrayList<>();
        mWords = getResources().getStringArray(R.array.array_words);
        mImgUrls = getResources().getStringArray(R.array.array_imgUrls);
        mSpace = Utils.dp2px(this, 5);
        generateCards(20);
    }

    private List<Card> mCards;

    private int mSpace;

    private final int columnNum = 5;

    private static final int[] colorRes = {R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark};

    private  String[] mWords ;

    private String[] mImgUrls;

    public void generateCards(int number) {
        FancyButton child;
        int sideLength = (Utils.screenWidth(this) - Utils.dp2px(this, mSpace) * (columnNum + 1)) / columnNum;
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(sideLength, sideLength);
        lp.leftMargin = Utils.dp2px(this, mSpace);
        lp.topMargin = Utils.dp2px(this, mSpace);
        for (int index = 0; index < number; index++) {
            child = (FancyButton) getLayoutInflater().inflate(R.layout.grid_item, null);
            child.setBackgroundColor(getResources().getColor(colorRes[index % colorRes.length]));
            child.setFocusBackgroundColor(getResources().getColor(R.color.colorGray));
            child.setText(String.valueOf(index));
            child.setLayoutParams(lp);
            setOnClick(child, index);
            mFlexboxLayout.addView(child);
            mCards.add(new Card(index,mWords[index],mImgUrls[index]));
        }
        notifyDataSetChanged(0);
    }

    private void setOnClick(FancyButton child, final int index) {
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged(index);
            }
        });
    }

    public void notifyDataSetChanged(int code){
        Card card = mCards.get(code);
        mWordView.setText(card.getWord());
        Glide.with(this).load(card.getImgUrl()).into(mPicture);
    }




}
