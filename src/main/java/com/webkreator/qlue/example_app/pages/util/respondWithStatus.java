package com.webkreator.qlue.example_app.pages.util;

import com.webkreator.qlue.Page;
import com.webkreator.qlue.QlueParameter;
import com.webkreator.qlue.view.View;

public class respondWithStatus extends Page {

    @QlueParameter(mandatory = true)
    public Integer status;

    @Override
    public View onGet() throws Exception {
        if (hasErrors()) {
            throw new IllegalArgumentException();
        }

        context.response.sendError(status);

        return null;
    }
}
