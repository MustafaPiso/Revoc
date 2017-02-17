package mohammed.revok.backend;

import java.util.List;

/**
 * Created by gmgn on 2/13/2017.
 */

public class wordapi {
    public wordapi(){
    }
    private Pronunciation pronunciation;

    private Syllables syllables;

    private List<Results> results;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private String word;

    private String frequency;

    public Pronunciation getPronunciation ()
    {
        return pronunciation;
    }

    public void setPronunciation (Pronunciation pronunciation)
    {
        this.pronunciation = pronunciation;
    }

    public Syllables getSyllables ()
    {
        return syllables;
    }

    public void setSyllables (Syllables syllables)
    {
        this.syllables = syllables;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getFrequency ()
    {
        return frequency;
    }



    public void setFrequency (String frequency)
    {
        this.frequency = frequency;
    }

}
