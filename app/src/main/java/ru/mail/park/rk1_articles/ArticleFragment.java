package ru.mail.park.rk1_articles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mail.park.articlelistlib.Article;


public class ArticleFragment extends Fragment {
    private Article article;

    public static ArticleFragment newInstance(Article article) {
        ArticleFragment articleFragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putSerializable("article", article);
        articleFragment.setArguments(args);
        return articleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        article = getArguments() != null ? (Article) getArguments().getSerializable("article") : null;
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

        return view;
    }
}
