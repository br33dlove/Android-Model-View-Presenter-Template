package com.davidcryer.mvpandroid.android.view.ui.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;

import com.davidcryer.mvpandroid.R;

public class CompleteTextInputLayout extends TextInputLayout {
    private TextInputEditText textInputEditText;

    public CompleteTextInputLayout(Context context) {
        super(context);
        initialise(null);
    }

    public CompleteTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public CompleteTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(final AttributeSet attrs) {
        inflate(getContext(), R.layout.complete_text_input_layout, this);
        initialiseViewReferences();
        if (attrs != null) {
            inflateAttributes(attrs);
        }
    }

    private void initialiseViewReferences() {
        textInputEditText = (TextInputEditText) findViewById(R.id.text_input_edit_text);
    }

    private void inflateAttributes(final AttributeSet attrs) {
        final TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CompleteTextInputLayout);
        final String hint = array.getString(R.styleable.CompleteTextInputLayout_hint);
        textInputEditText.setHint(hint);
        array.recycle();
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        textInputEditText.setOnFocusChangeListener(l);
    }

    public String text() {
        return textInputEditText.getText().toString();
    }

    public void text(final String text) {
        textInputEditText.setText(text);
    }

    public void add(final TextWatcher textWatcher) {
        textInputEditText.addTextChangedListener(textWatcher);
    }

    public void remove(final TextWatcher textWatcher) {
        textInputEditText.removeTextChangedListener(textWatcher);
    }
}
