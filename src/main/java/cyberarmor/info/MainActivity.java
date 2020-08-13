package cyberarmor.info;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageViewDice;
    private Random rng = new Random();
    long animationDuration = 500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer makeDiceSound = MediaPlayer.create(this, R.raw.dice_sound);

        // Hiding the Top Bar In The App (Making It Full Screen).
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        ImageViewDice = findViewById(R.id.image_view_dice);
        ImageViewDice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rollDice();
                makeDiceSound.start();
            }

        });



    }
    public boolean getSixOnDice(View v) {

        final MediaPlayer makeDiceSound = MediaPlayer.create(this, R.raw.dice_sound);
        makeDiceSound.start();
        ObjectAnimator rotationEffect = ObjectAnimator.ofFloat(ImageViewDice, "rotation", 0f, 360f);
        rotationEffect.setDuration(animationDuration);
        ImageViewDice.setImageResource(R.drawable.dice6);
        AnimatorSet animatorSet  = new AnimatorSet();
        animatorSet.playTogether(rotationEffect);
        animatorSet.start();

        return true;
    }

    private void rollDice(){
        int randomNumber = rng.nextInt(6 ) + 1;
        ObjectAnimator rotationEffect = ObjectAnimator.ofFloat(ImageViewDice, "rotation", 0f, 360f);
        AnimatorSet animatorSet  = new AnimatorSet();

        switch (randomNumber){
            case 1:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice1);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();
                break;
            case 2:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice2);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();
                break;
            case 3:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice3);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();
                break;
            case 4:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice4);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();;
                break;
            case 5:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice5);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();;
                break;
            case 6:
                rotationEffect.setDuration(animationDuration);
                ImageViewDice.setImageResource(R.drawable.dice6);
                animatorSet.playTogether(rotationEffect);
                animatorSet.start();;
                break;
        }
    }

}
