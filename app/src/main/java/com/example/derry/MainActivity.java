package com.example.derry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    boolean startup = false;
    boolean storyup = false;




    public void fade(View view) throws InterruptedException {

        Log.i("Info", "Imageview tapped");
        ImageView loadingScreen = (ImageView) findViewById(R.id.loadingScreen);
        ImageView selectionbg = (ImageView) findViewById(R.id.selectionbg);

        loadingScreen.animate().alpha(0).setDuration(2000);
        selectionbg.animate().alpha(1).setDuration(2000);

        new Handler().postDelayed(new Runnable() {
           public void run() {
               Button startButton = (Button) findViewById(R.id.startButton);
              startButton.setVisibility(View.VISIBLE);
               Button storyButton = (Button) findViewById(R.id.storyButton);
               storyButton.setVisibility(View.VISIBLE);
               Button creditButton = (Button) findViewById(R.id.creditButton);
               creditButton.setVisibility(View.VISIBLE);
           }
        }, 2000);

          }







    public void clickFunctionStart(View view) {

        Log.i("Info", "PLAYER HAS PRESSED START");

        final ImageView loadingScreen = (ImageView) findViewById(R.id.loadingScreen);
        final ImageView selectionbg = (ImageView) findViewById(R.id.selectionbg);
        Button storyButton = (Button) findViewById(R.id.storyButton);
        Button creditButton = (Button) findViewById(R.id.creditButton);
        Button startButton = (Button) findViewById(R.id.startButton);

        loadingScreen.animate().alpha(0).setDuration(2000);
        selectionbg.animate().alpha(0).setDuration(2000);
        creditButton.setVisibility(View.GONE);
        storyButton.setVisibility(View.GONE);
        startButton.setVisibility(View.GONE);


           new Handler().postDelayed(new Runnable() {
              public void run() {
                  startup = true;
                  selectionbg.setVisibility(View.GONE);
                  loadingScreen.setVisibility(View.GONE);

                  if (startup) {
                      ImageView black = (ImageView) findViewById(R.id.black);
                      final ImageView story = (ImageView) findViewById(R.id.storySc);
                      final TextView wrStory = (TextView) findViewById(R.id.writtenBackstory);
                      final ImageButton next1B = (ImageButton) findViewById(R.id.nextButton1);
                      black.setVisibility(View.VISIBLE);

                      new Handler().postDelayed(new Runnable() {
                          public void run() {
                              story.setVisibility(View.VISIBLE);
                              wrStory.setVisibility(View.VISIBLE);
                              wrStory.setMovementMethod(new ScrollingMovementMethod());
                              new Handler().postDelayed(new Runnable() {
                                  public void run() {
                                    next1B.setVisibility(View.VISIBLE);
                                  }
                              }, 4000);

                          }
                      }, 2000);

                  }
              }
           }, 2000);
    }
    public void nextStartClick(View view)  {
        final TextView wrStory = (TextView) findViewById(R.id.writtenBackstory);
        ImageView black = (ImageView) findViewById(R.id.black);
        final ImageView story = (ImageView) findViewById(R.id.storySc);
        final ImageButton next1B = (ImageButton) findViewById(R.id.nextButton1);
        final ImageView loading1 = (ImageView) findViewById(R.id.loading1);
        final ImageView loading2 = (ImageView) findViewById(R.id.loading2);
        final ImageView loading3 = (ImageView) findViewById(R.id.loading3);
        final ImageView loading4 = (ImageView) findViewById(R.id.loading4);
        final MediaPlayer rain = MediaPlayer.create(this, R.raw.rainsounds);
        wrStory.setVisibility(View.GONE);
        black.setVisibility(View.GONE);
        story.setVisibility(View.GONE);
        next1B.setVisibility(View.GONE);
        loading1.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                loading2.setVisibility(View.VISIBLE);
                loading1.setVisibility(View.GONE);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                loading3.setVisibility(View.VISIBLE);
                loading2.setVisibility(View.GONE);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                loading4.setVisibility(View.VISIBLE);
                loading3.setVisibility(View.GONE);
                rain.start();
                rain.setLooping(true);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                loading4.setVisibility(View.GONE);
                ImageView billsroom = (ImageView) findViewById(R.id.billsroomone);
                billsroom.setImageResource(R.drawable.billsroomanim);
                ImageView georgie = (ImageView) findViewById(R.id.gleftone);
                georgie.setVisibility(View.VISIBLE);
                billsroom.setVisibility(View.VISIBLE);
                AnimationDrawable billsroomanim = (AnimationDrawable)billsroom.getDrawable();
                billsroomanim.isVisible();
                billsroomanim.start();

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                       ImageView speechdots = (ImageView) findViewById(R.id.speechRoomOne);

                       speechdots.setVisibility(View.VISIBLE);
                    }
                }, 2000);


            }
        }, 4000);

    }
    public void  clickSpeechDots(View view) {
                            ImageView speechdots = (ImageView) findViewById(R.id.speechRoomOne);
                            speechdots.setVisibility(View.GONE);

                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    ImageView speechRtwo = (ImageView) findViewById(R.id.speechRoomTwo);
                                    speechRtwo.setVisibility(View.VISIBLE);
                                }
                            }, 800);

                        }
    public void  clickSpeechRtwo(View view) {
                            ImageView speechRtwo = (ImageView) findViewById(R.id.speechRoomTwo);
                            speechRtwo.setVisibility(View.GONE);

                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    ImageView speechRthree = (ImageView) findViewById(R.id.speechRoomThree);
                                    speechRthree.setVisibility(View.VISIBLE);
                                }
                            }, 800);

                        }
    public void  clickSpeechRthree(View view) {
                            ImageView speechRthree = (ImageView) findViewById(R.id.speechRoomThree);
                            speechRthree.setVisibility(View.GONE);

                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    ImageView speechRfour = (ImageView) findViewById(R.id.speechRoomFour);
                                    speechRfour.setVisibility(View.VISIBLE);
                                }
                            }, 800);

                        }
    public void  clickSpeechRfour(View view) {
                    ImageView speechRfour = (ImageView) findViewById(R.id.speechRoomFour);
                    ImageButton ctrlleft = (ImageButton) findViewById(R.id.controlLeft);
                    ImageButton ctrlright = (ImageButton) findViewById(R.id.controlRight);
                    ctrlleft.setVisibility(View.VISIBLE);
                    ctrlright.setVisibility(View.VISIBLE);
                    speechRfour.setVisibility(View.GONE);

        }


    @SuppressLint("ClickableViewAccessibility")
    public void controlLeftView (View view) {
        ImageButton ctrlleft = (ImageButton) findViewById(R.id.controlLeft);
        //gleftanim was never used
//        AnimationDrawable gleftanim = (AnimationDrawable) georgie.getDrawable();
        ctrlleft.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch (View v, MotionEvent event){
//                float x = event.getX();
//                float y = event.getY();
                ImageView georgie = (ImageView) findViewById(R.id.gleftone);
                georgie.setImageResource(R.drawable.gleftanim);

                System.out.println("In the onTouch event listener");
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    System.out.println("Pressed Down");
                    gMoveLeftAnim(true, georgie);

                    return true;
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    System.out.println("Pressed up");
                    gMoveLeftAnim(false, georgie);
                    return true;
                }

//                float pos = georgie.getX();
//                georgie.setX(pos);
                return true;
            }
        });
    }


    public void controlRight(final View view) {
        ImageButton ctrlright = (ImageButton) findViewById(R.id.controlRight);
        ctrlright.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               gMoveRightAnim();
                return true;
            }
        });
    }

    public void gMoveLeftAnim (Boolean move, ImageView v) {
        // TODO: Make animation stop walking after certain amount of time.
//        ImageView georgie = (ImageView) findViewById(R.id.gleftone);
//        georgie.setImageResource(R.drawable.gleftanim);
//        AnimationDrawable gleftanim = (AnimationDrawable) georgie.getDrawable();
        AnimationDrawable gleftanim = (AnimationDrawable) v.getDrawable();
        Animation gleftanimM = new TranslateAnimation(Animation.ABSOLUTE, -150, Animation.ABSOLUTE, Animation.ABSOLUTE);
        gleftanimM.setDuration(1000);
        gleftanimM.setFillAfter(true);


        if (move) {
            gleftanim.start();
//            georgie.startAnimation(gleftanimM);
            v.startAnimation(gleftanimM);
            ConstraintLayout.LayoutParams params  = (ConstraintLayout.LayoutParams) v.getLayoutParams();
//            params.horizontalBias -= .1f;
//            int x = ((ConstraintLayout.LayoutParams) v.getLayoutParams()).leftMargin;
//            params.rightMargin += 50;
            params.horizontalBias -= 0.1f;
            v.setLayoutParams(params);

//            georgie.setX(X);
        }else{
            gleftanim.stop();
        }


    }
    public void gMoveRightAnim () {
        ImageView georgie = (ImageView) findViewById(R.id.grightone);
        georgie.setImageResource(R.drawable.grightanim);
        final AnimationDrawable grightanim = (AnimationDrawable) georgie.getDrawable();
        Animation grightaminM = new TranslateAnimation(Animation.ABSOLUTE, 150, Animation.ABSOLUTE, Animation.ABSOLUTE);
        grightaminM.setDuration(3000);
        grightaminM.setFillAfter(true);
        grightanim.start();
    }










    public void clickFunctionStoryline(View view) {

        Log.i("Info", "PLAYER HAS PRESSED STORYLINE BUTTON");

        final ImageView loadingScreen = (ImageView) findViewById(R.id.loadingScreen);
        final ImageView selectionbg = (ImageView) findViewById(R.id.selectionbg);
        Button storyButton = (Button) findViewById(R.id.storyButton);
        Button creditButton = (Button) findViewById(R.id.creditButton);
        Button startButton = (Button) findViewById(R.id.startButton);

        loadingScreen.setVisibility(View.GONE);
        selectionbg.setVisibility(View.GONE);
        creditButton.setVisibility(View.GONE);
        storyButton.setVisibility(View.GONE);
        startButton.setVisibility(View.GONE);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                storyup = true;
                selectionbg.setVisibility(View.GONE);
                loadingScreen.setVisibility(View.GONE);

                if (storyup) {

                    ImageView storylineBck = (ImageView) findViewById(R.id.storylineBacker);
                    storylineBck.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            TextView actlStoryln = (TextView) findViewById(R.id.actualStoryline);
                            ImageButton backFromStoryline = (ImageButton) findViewById(R.id.goBackFromStoryline);
                            backFromStoryline.setVisibility(View.VISIBLE);
                            actlStoryln.setVisibility(View.VISIBLE);
                            actlStoryln.setMovementMethod(new ScrollingMovementMethod());
                        }
                    }, 500);
                }
            }
        }, 0 );

    }
    public void  clickFunctionBackFromStoryline(View view) {

        ImageView storylineBck = (ImageView) findViewById(R.id.storylineBacker);
        TextView actlStoryln = (TextView) findViewById(R.id.actualStoryline);
        ImageButton backFromStoryline = (ImageButton) findViewById(R.id.goBackFromStoryline);

        storylineBck.setVisibility(View.GONE);
        actlStoryln.setVisibility(View.GONE);
        backFromStoryline.setVisibility(View.GONE);

        ImageView selectionbg = (ImageView) findViewById(R.id.selectionbg);
        selectionbg.setVisibility(View.VISIBLE);
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        Button storyButton = (Button) findViewById(R.id.storyButton);
        storyButton.setVisibility(View.VISIBLE);
        Button creditButton = (Button) findViewById(R.id.creditButton);
        creditButton.setVisibility(View.VISIBLE);



    }



    public void clickFunctionCredits(View view) {

        Log.i("Info", "PLAYER HAS PRESSED CREDITS");

           }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Have to implement custom EventListener for pressing up or down events instead of using XML.
        ImageButton controlLeft = (ImageButton) findViewById(R.id.controlLeft);
        controlLeftView(controlLeft);



    }
}
