package ru.mail.park.rk1_articles;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment main = getSupportFragmentManager().findFragmentById(R.id.main_container);
        Fragment article = getSupportFragmentManager().findFragmentById(R.id.article_container);
        Fragment articleList = getSupportFragmentManager().findFragmentById(R.id.article_list_container);

        int orientation = getResources().getConfiguration().orientation;
        Log.i("orientation", Integer.valueOf(orientation).toString());
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (article != null && article.isAdded()) {
                transaction.remove(article);
            }
            if (articleList != null && articleList.isAdded()) {
                transaction.remove(articleList);
            }
            transaction.replace(R.id.main_container, new ArticleListFragment());
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (main != null && main.isAdded()) {
                transaction.remove(main);
            }
            transaction.replace(R.id.article_container, new ArticleFragment());
            transaction.replace(R.id.article_list_container, new ArticleListFragment());
        }
        transaction.commit();
    }


}
