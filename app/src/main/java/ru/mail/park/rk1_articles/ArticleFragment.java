package ru.mail.park.rk1_articles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mail.park.articlelistlib.Article;


public class ArticleFragment extends Fragment {
    Article article;

    public ArticleFragment(Article article) {
        super();
        this.article = article;
    }

    public ArticleFragment() {
        super();
        this.article = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        TextView articleTitleView = (TextView) view.findViewById(R.id.articleTitleTextView);
        TextView articleDateView = (TextView) view.findViewById(R.id.articleDateTextView);
        TextView articleDescriptionView = (TextView) view.findViewById(R.id.articleDescriptionTextView);

        if (article != null) {
            articleTitleView.setText(article.getTitle());
            articleDateView.setText(article.getDate().toString());
            articleDescriptionView.setText(article.getContent());
        }

        return  view;
    }
}
