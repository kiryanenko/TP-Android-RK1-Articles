package ru.mail.park.rk1_articles;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity implements OnArticleClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment main = getSupportFragmentManager().findFragmentById(R.id.main_container);
        Fragment article = getSupportFragmentManager().findFragmentById(R.id.article_container);
        Fragment articleList = getSupportFragmentManager().findFragmentById(R.id.article_list_container);

        ArticleListFragment articleListFragment = new ArticleListFragment();
        ArticleFragment articleFragment = new ArticleFragment();

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (article != null && article.isAdded()) {
                transaction.remove(article);
            }
            if (articleList != null && articleList.isAdded()) {
                transaction.remove(articleList);
            }
            transaction.replace(R.id.main_container, articleListFragment);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (main != null && main.isAdded()) {
                transaction.remove(main);
            }
            transaction.replace(R.id.article_container, articleFragment);
            transaction.replace(R.id.article_list_container, articleListFragment);
        }
        transaction.commit();

        articleListFragment.setOnArticleClickListener(this);
    }


    @Override
    public void onArticleClick(Article article) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ArticleFragment articleFragment = ArticleFragment.newInstance(article);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            transaction.replace(R.id.main_container, articleFragment);
            transaction.addToBackStack(null);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.article_container, articleFragment);
        }

        transaction.commit();
    }


}
