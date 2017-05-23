package com.webkreator.qlue.example_app.pages.util;

import com.webkreator.qlue.Page;
import com.webkreator.qlue.view.View;

public class throwException extends Page {

    @Override
    public View onGet() throws Exception {
        throw new RuntimeException();
    }
}
