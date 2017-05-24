package com.webkreator.qlue.example_app;

import com.webkreator.qlue.QlueApplication;
import com.webkreator.qlue.view.closure.SoyViewFactory;

public class ExampleApplication extends QlueApplication {

    public ExampleApplication() {
        setViewFactory(new SoyViewFactory());
    }
}
