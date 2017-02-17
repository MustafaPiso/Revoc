package mohammed.revok.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mohammed.revok.R;
import mohammed.revok.activities.WordDetailActivity;
import mohammed.revok.adapter.WordAdapter;


public class MainFragment extends Fragment implements SearchView.OnQueryTextListener  {
    ArrayList<String> search_filter;
    ArrayList<String> words;
    WordAdapter adapter;
    RecyclerView recyclerView;    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_main, container, false);
       // startActivity(new Intent(getContext(), WordDetailActivity.class));
        setHasOptionsMenu(true);
        words = new ArrayList<>();
        search_filter = new ArrayList<>();
        words.add("cat");
        words.add("apple");
        words.add("cow");
        words.add("orange");
        words.add("man");
        words.add("woman");
        words.add("boy");
        words.add("girl");
        words.add("lady");
        words.add("chicken");
        recyclerView = (RecyclerView) root.findViewById(R.id.recycleView);


        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        adapter = new WordAdapter(getContext(), words, new WordAdapter.RecyclerViewClickListener() {
            @Override
            public void recyclerViewListClicked(View v, int position) {
             //   Toast.makeText(getContext(),""+position,Toast.LENGTH_LONG).show();
                Intent i=new Intent(getContext(), WordDetailActivity.class);
                i.putExtra("myword",words.get(position));
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        search(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        search(newText);
        return false;
    }

    public void search(String search_word) {

        search_filter.clear();
        for (int i = 0; i < words.size(); i++) {
            String name = words.get(i);
            if (name.startsWith(search_word)) {
                search_filter.add(name);
            }
        }
        adapter = new WordAdapter(getContext(), search_filter);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
