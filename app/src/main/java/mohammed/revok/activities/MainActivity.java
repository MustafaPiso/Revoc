package mohammed.revok.activities;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import mohammed.revok.R;
import mohammed.revok.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener   {
    MainFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fragment=new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main,fragment).commit();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.menu_searchable));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        fragment.search(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        fragment.search(newText);
        return false;
    }
}
