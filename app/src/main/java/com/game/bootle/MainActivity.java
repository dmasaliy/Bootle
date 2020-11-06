package com.game.bootle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);
    }

    public void spinBottle(View view){
        if(!spinning) {
            int newDir = random.nextInt(1500);

            float pivotX = bottle.getWidth() >> 1;
            float pivotY = bottle.getHeight() >> 1;

            Animation spin = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            spin.setDuration(2200);
            spin.setFillAfter(true);
            spin.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            bottle.startAnimation(spin);
        }


    }
}