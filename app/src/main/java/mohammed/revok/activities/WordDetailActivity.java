package mohammed.revok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mohammed.revok.R;
import mohammed.revok.backend.Pronunciation;
import mohammed.revok.backend.Results;
import mohammed.revok.backend.Syllables;
import mohammed.revok.backend.wordapi;

public class WordDetailActivity extends AppCompatActivity {
    RequestQueue queue;
    wordapi mword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);
        queue= Volley.newRequestQueue(this);
        mword=new wordapi();
        Intent intent = getIntent();
        String Userword = intent.getStringExtra("myword");
        sendJsonRequest("https://wordsapiv1.p.mashape.com/words/"+Userword);

    }
    public void sendJsonRequest(String url) {
        mword=new wordapi();
        Response.Listener<JSONObject> resListener=new Response.Listener<JSONObject>() {
            List<Results> results=new ArrayList<>();
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String word=response.getString("word");

                    mword.setWord(word);

                    JSONArray mResultArray = response.getJSONArray("results");
                    for (int i = 0; i < mResultArray.length(); i++) {
                        JSONObject mResultObject = mResultArray.getJSONObject(i);
                        Results result=new Results();
                        result.setDefinition(mResultObject.getString("definition"));
                        result.setPartOfSpeech(mResultObject.getString("partOfSpeech"));
                        JSONArray mResultArraysynonyms= mResultObject.getJSONArray("synonyms");
                        List<String> synonyms=new ArrayList<>();
                        List<String> typeOf=new ArrayList<>();
                        List<String> hasTypes=new ArrayList<>();
                        List<String> examples=new ArrayList<>();
                        List<String> usageOf=new ArrayList<>();
                        for (int j = 0; j < mResultArraysynonyms.length();j++) {
                            synonyms.add(mResultArraysynonyms.getString(j));
                        }
                        result.setSynonyms(synonyms);
                        JSONArray mResultArraytypeOf= mResultObject.getJSONArray("typeOf");
                        for (int j = 0; j < mResultArraytypeOf.length();j++) {
                            typeOf.add(mResultArraytypeOf.getString(j));
                        }
                        result.setTypeOf(typeOf);
                        JSONArray mResultArrayhasTypes= mResultObject.getJSONArray("hasTypes");
                        for (int j = 0; j < mResultArrayhasTypes.length();j++) {
                            hasTypes.add(mResultArrayhasTypes.getString(j));
                        }
                        result.setHasTypes(hasTypes);

                        if(mResultObject.has("examples"))
                        {
                            JSONArray mResultArrayexamples= mResultObject.getJSONArray("examples");
                            for (int j = 0; j < mResultArrayexamples.length();j++) {
                                examples.add(mResultArrayexamples.getString(j));
                            }
                            result.setExamples(examples);

                        }
                        if(mResultObject.has("usageOf")) {
                            JSONArray mResultArrayusageOf = mResultObject.getJSONArray("usageOf");
                            for (int j = 0; j < mResultArrayusageOf.length(); j++) {
                                usageOf.add(mResultArrayusageOf.getString(j));
                            }
                            result.setUsageOf(usageOf);
                        }
                        results.add(result);

                    }
                    mword.setResults(results);
                    Syllables syllables=new Syllables();

                    JSONObject objectsyllables=response.getJSONObject("syllables");
                    int count = objectsyllables.getInt("count");
                    List<String> list=new ArrayList<>();
                    JSONArray mResultArraylist= objectsyllables.getJSONArray("list");
                    for (int j = 0; j < mResultArraylist.length();j++) {
                        list.add(mResultArraylist.getString(j));
                    }
                    syllables.setCount(count);
                    syllables.setList(list);
                    mword.setSyllables(syllables);
                    Pronunciation pronunciation=new Pronunciation();
                    JSONObject allobject=response.getJSONObject("Pronunciation");
                    pronunciation.setAll(allobject.getString("all"));
                    String frequency=response.getString("frequency");
                    mword.setFrequency(frequency);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        };
        Response.ErrorListener errorListener=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WordDetailActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        };

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, (String) null,resListener,errorListener){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                //connection.setRequestProperty("X-Mashape-Key","Faqa975D9xmshohZovdsdNXFtD32p1TDaJMjsnHdic6VRYtZom");
                //connection.setRequestProperty("Accept","application/json");
                header.put("X-Mashape-Key","Faqa975D9xmshohZovdsdNXFtD32p1TDaJMjsnHdic6VRYtZom");
                header.put("Accept","application/json");
                return header;
            }
        };
        queue.add(request);

    }

}
