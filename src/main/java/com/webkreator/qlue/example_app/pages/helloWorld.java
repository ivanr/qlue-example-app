package com.webkreator.qlue.example_app.pages;

import com.webkreator.qlue.Page;
import com.webkreator.qlue.view.DefaultView;
import com.webkreator.qlue.view.View;

public class helloWorld extends Page {

    @Override
    public View onGet() {
        return new DefaultView();
    }
}
