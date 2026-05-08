package com.mahdi.practice_3;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MusicAdaptor adaptor;
    private ArrayList<MusicItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items.add(new MusicItem("Music 1", R.raw.music01));
        items.add(new MusicItem("Music 2", R.raw.music02));
        items.add(new MusicItem("Music 3", R.raw.music03));
        items.add(new MusicItem("Music 4", R.raw.music04));
        items.add(new MusicItem("Music 5", R.raw.music05));
        items.add(new MusicItem("Music 6", R.raw.music06));
        items.add(new MusicItem("Music 7", R.raw.music07));
        items.add(new MusicItem("Music 8", R.raw.music08));
        items.add(new MusicItem("Music 9", R.raw.music09));
        items.add(new MusicItem("Music 10", R.raw.music10));
        items.add(new MusicItem("Music 11", R.raw.music11));
        items.add(new MusicItem("Music 12", R.raw.music12));

        adaptor = new MusicAdaptor(items, item -> showMusicDialog(item));
        recyclerView.setAdapter(adaptor);
    }

    private void showMusicDialog(MusicItem item){
        var dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_music_player);

        Button btnPlayerPause = dialog.findViewById(R.id.btnPlayPause);
        SeekBar seekBar = dialog.findViewById(R.id.seekBar);

        var mediaPlayer = MediaPlayer.create(this, item.getResId());
        seekBar.setMax(mediaPlayer.getDuration());

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable updateSeek = new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null && mediaPlayer.isPlaying())
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());

                handler.postDelayed(this, 300);
            }
        };

        btnPlayerPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                btnPlayerPause.setText("Play");
            }else {
                mediaPlayer.start();
                btnPlayerPause.setText("Pause");
                handler.post(updateSeek);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        dialog.setOnDismissListener(d -> {
            handler.removeCallbacks(updateSeek);
            mediaPlayer.stop();
            mediaPlayer.release();
        });

        dialog.show();
    }
}