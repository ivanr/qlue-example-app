package com.webkreator.qlue.example_app.pages;

import com.webkreator.qlue.Page;
import com.webkreator.qlue.ParamSource;
import com.webkreator.qlue.QlueParameter;
import com.webkreator.qlue.view.StatusCodeView;
import com.webkreator.qlue.view.View;

public class urlParamsTest extends Page {

    @QlueParameter(mandatory = false, source = ParamSource.URL)
    public String one;

    @QlueParameter(mandatory = false, source = ParamSource.URL)
    public String two;

    @Override

    public View onGet() {
        System.out.println("# urlParamsTest: one=" + one + "; two=" + two);
        return new StatusCodeView(200);
    }
}
