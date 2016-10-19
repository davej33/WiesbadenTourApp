package com.example.android.wiesbadentourapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dnj on 10/14/16.
 */

public class PhrasesFragment extends Fragment {

    // create MediaPlayer, AudioManager, FocusListener and Completion Callback
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mMediaPlayer.stop();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    // empty constructor
    public PhrasesFragment() {}

    // create view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // initialize audioManager
        mAudioManager = (AudioManager) getActivity().getSystemService(getContext().AUDIO_SERVICE);

        // create and initialize array list
        final ArrayList<TourInfoItem> items = new ArrayList<TourInfoItem>();
        items.add(new TourInfoItem("My name is Miller.","Mein Name ist Müller.",
                R.raw.name, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("How are you?","Wie geht's?",
                R.raw.how_are_you, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("Excuse me.","Entschuldigen Sie",
                R.raw.excuse_me, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("Where is the markt","Wo ist der Markt?",
                R.raw.market, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("I would like to go to the city center.","Ich möchte ins Stadtzentrum.",
                R.raw.city_center, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("I would like to go to the train station.","Ich möchte zum Bahnhof.",
                R.raw.train_station, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("How much is the entrance fee?","Wie viel kostet der Eintritt?",
                R.raw.entrance_fee, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("Do you have a vacant room?","Haben Sie ein Zimmer frei?",
                R.raw.vacancy, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("What time do you serve breakfast?","Um wie viel Uhr gibt es Frühstück?",
                R.raw.breakfast, R.mipmap.us_flag, R.mipmap.german_flag));
        items.add(new TourInfoItem("Bye!","Tschüs!",
                R.raw.bye, R.mipmap.us_flag, R.mipmap.german_flag));

        // create adapter and set to list view
        TourInfoItemAdapter adapter = new TourInfoItemAdapter(getActivity(), items, R.color.primaryLight);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_id);
        listView.setAdapter(adapter);

        // create onclick and set to list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                TourInfoItem item = items.get(position);

                // request audioFocus. start audio and set callback if granted.
                int requestFocus = mAudioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (requestFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getActivity(), item.getmAudioClip());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    // clear mediaPlayer resources
    private void releaseMediaPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    // clear mediaPlayer resources when stopped
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
