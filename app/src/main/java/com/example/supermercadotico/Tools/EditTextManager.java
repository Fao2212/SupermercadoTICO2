package com.example.supermercadotico.Tools;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class EditTextManager {

    private EditText editText;
    boolean cleared;

    public EditTextManager(EditText editText) {
        this.editText = editText;
        this.cleared = false;
        //addListener();
    }

    public String getText() {
        return editText.getText().toString();
    }

    private void addListener()
    {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!cleared) {
                    editText.setText("");
                    setCleared();

                }
                return true;
            }
        });
    }

    private void setCleared()
    {
        this.cleared = true;
        this.editText.setFocusable(true);
        this.editText.setFocusableInTouchMode(true);
    }


}
