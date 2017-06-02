package com.webkreator.qlue.example_app.pages.packageRouter.subfolder;

import com.webkreator.qlue.Page;
import com.webkreator.qlue.view.View;

import java.io.IOException;

public class index extends Page {

    @Override
    public View onGet() throws IOException {
        context.response.setContentType("text/plain");
        context.response.getWriter().write("packageRouter/subfolder");
        return null;
    }
}
