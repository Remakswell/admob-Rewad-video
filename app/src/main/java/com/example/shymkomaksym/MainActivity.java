package com.example.shymkomaksym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.example.shymkomaksym.Model.Model;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener, MainContract {

    private RewardedVideoAd mAd;
    private List<Model> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainAdapter adapter = new MainAdapter(messageList, this, this);
        recyclerView.setAdapter(adapter);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd(){
        if(!mAd.isLoaded()){
            mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
        }
    }

    private void dataSet(){
        messageList = new ArrayList<>();
        messageList.add(new Model("Hello! My name is Maksym", "05.02.2019", Model.ONE_TYPE));
        messageList.add(new Model("Hi!", "05.02.2019", Model.TWO_TYPE));
        messageList.add(new Model("This is my task", "06.02.2019", Model.ONE_TYPE));
        messageList.add(new Model("Sponsored", "Watch this cool gms ad!", Model.THREE_TYPE));
    }

    public void ShowReward(View view) {
        if(mAd.isLoaded()){
            mAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    protected void onPause() {
        mAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void showMessage(String messageText) {
        Toast.makeText(this, messageText, Toast.LENGTH_LONG).show();
    }
}
