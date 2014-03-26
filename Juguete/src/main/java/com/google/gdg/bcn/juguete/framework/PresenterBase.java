package com.google.gdg.bcn.juguete.framework;

public class PresenterBase {
    protected MVPActivity view;

    public PresenterBase(MVPActivity view) {
        this.view = view;
    }
}
