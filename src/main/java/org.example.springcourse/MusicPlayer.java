package org.example.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private List<Music> musics;

    public MusicPlayer(List<Music> musics) {
        this.musics = musics;
    }

    public String playMusic() {
        String playList = "Playing: \n";

        for (Music music : musics) {
            playList += music.getSong() + "\n";
        }
        return playList;
    }

    public String playMusicRandom() {
        Random random = new Random();
        return "Playing:" + musics.get(random.nextInt(musics.size())).getSong()
                + " with volume " + this.volume;
    }
}
