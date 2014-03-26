package com.google.gdg.bcn.juguete.framework;

import android.app.Application;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp extends Application {
    private static MainApp singleton;
    private String packageName;
    private MVPActivity actualView;

    public static MainApp getInstance() {
        return singleton;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        singleton = this;

        // TODO:
        // EL SUFIJO .debug Y .staging DE GADLE ME PROVOCA ERRORES (MIRAR)
        //packageName = getApplicationContext().getPackageName();
        packageName = "com.google.gdg.bcn.juguete";

    }

    public void setActualView(MVPActivity view) {
        actualView = view;
    }

    public void execute(String classname, String function, Object[] params) {
        String[] parts = classname.split("_");
        if (parts.length > 1) {
            Log.d("MVPFramework",
                    "Launching presenter: " + parts[0] + "_Presenter. " +
                    "Function: " + function);

            Class<?> presenterClass;
            try {
                presenterClass = Class.forName(
                        packageName + ".presenters." + parts[0] + "_Presenter");

                Class[] types = {MVPActivity.class};
                Constructor constructor = presenterClass.getConstructor(types);

                Object[] parameters = {actualView};
                Object instanceOfPresenter = constructor.newInstance(parameters);

                Method method;
//                if (params != null) {
//                    method = presenterClass.getDeclaredMethod(function, params);
//                    method.invoke(params);
//                } else {
                    method = presenterClass.getDeclaredMethod(function);
                    method.invoke(instanceOfPresenter);
//                }

            // NO PRESENTER FOUND
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            // CANNOT INSTANTIATE PRESENTER
            } catch (InstantiationException e) {
                e.printStackTrace();

            // NOT METHOD AVALIABLE IN PRESENTER
            } catch (NoSuchMethodException e) {
                e.printStackTrace();

            // CANNOT CALL METHOD IN PRESENTER (MAYBE PARAMETERS FAILURE)
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}