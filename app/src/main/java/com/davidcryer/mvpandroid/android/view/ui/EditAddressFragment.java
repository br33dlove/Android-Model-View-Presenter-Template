package com.davidcryer.mvpandroid.android.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.davidcryer.mvpandroid.R;
import com.davidcryer.mvpandroid.android.framework.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.framework.repositories.ViewBindingFragment;
import com.davidcryer.mvpandroid.android.view.ui.components.CompleteTextInputLayout;

public class EditAddressFragment extends ViewBindingFragment<EditAddressAndroidView.EventsListener> implements EditAddressAndroidView {
    private CompleteTextInputLayout houseView;
    private CompleteTextInputLayout streetView;
    private CompleteTextInputLayout townView;
    private CompleteTextInputLayout cityView;
    private CompleteTextInputLayout postCodeView;

    public static EditAddressFragment newInstance() {
        return new EditAddressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_edit_address, container, false);
        initialiseViewReferences(view);
        return view;
    }

    private void initialiseViewReferences(final View root) {
        houseView = (CompleteTextInputLayout) root.findViewById(R.id.house);
        streetView = (CompleteTextInputLayout) root.findViewById(R.id.street);
        townView = (CompleteTextInputLayout) root.findViewById(R.id.town);
        cityView = (CompleteTextInputLayout) root.findViewById(R.id.city);
        postCodeView = (CompleteTextInputLayout) root.findViewById(R.id.postCode);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.edit_address_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done: {
                giveFocusToRoot();
                eventsListener.onClickDone();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void giveFocusToRoot() {
        if (getView() != null) {
            getView().requestFocus();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupTextInputLayouts();
        setupViewClickHandlers();
    }

    private void setupTextInputLayouts() {
        houseView.setErrorEnabled(true);
        streetView.setErrorEnabled(true);
        townView.setErrorEnabled(true);
        cityView.setErrorEnabled(true);
        postCodeView.setErrorEnabled(true);
    }

    private void setupViewClickHandlers() {
        houseView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    eventsListener.onFocusHouseField();
                }
            }
        });
        streetView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    eventsListener.onFocusStreetField();
                }
            }
        });
        townView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    eventsListener.onFocusTownField();
                }
            }
        });
        cityView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    eventsListener.onFocusCityField();
                }
            }
        });
        postCodeView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    eventsListener.onFocusPostCodeField();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateEventsListenerWithCurrentInputs();
        addTextWatchers();
    }

    private void updateEventsListenerWithCurrentInputs() {
        eventsListener.onUpdateHouse(houseView.text());
        eventsListener.onUpdateStreet(streetView.text());
        eventsListener.onUpdateTown(townView.text());
        eventsListener.onUpdateCity(cityView.text());
        eventsListener.onUpdatePostCode(postCodeView.text());
    }

    private void addTextWatchers() {
        houseView.add(houseTextWatcher);
        streetView.add(streetTextWatcher);
        townView.add(townTextWatcher);
        cityView.add(cityTextWatcher);
        postCodeView.add(postCodeTextWatcher);
    }

    private final TextWatcher houseTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            eventsListener.onUpdateHouse(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher streetTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            eventsListener.onUpdateStreet(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher townTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            eventsListener.onUpdateTown(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher cityTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            eventsListener.onUpdateCity(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher postCodeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            eventsListener.onUpdatePostCode(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onPause() {
        super.onPause();
        removeTextWatchers();
    }

    private void removeTextWatchers() {
        houseView.remove(houseTextWatcher);
        streetView.remove(streetTextWatcher);
        townView.remove(townTextWatcher);
        cityView.remove(cityTextWatcher);
        postCodeView.remove(postCodeTextWatcher);
    }

    @Override
    public Intent intent() {
        return getActivity().getIntent();
    }

    @Override
    public String house() {
        return houseView.text();
    }

    @Override
    public String street() {
        return streetView.text();
    }

    @Override
    public String town() {
        return townView.text();
    }

    @Override
    public String city() {
        return cityView.text();
    }

    @Override
    public String postCode() {
        return postCodeView.text();
    }

    @Override
    public void showHouse(String house) {
        houseView.text(house);
    }

    @Override
    public void showStreet(String street) {
        streetView.text(street);
    }

    @Override
    public void showTown(String town) {
        townView.text(town);
    }

    @Override
    public void showCity(String city) {
        cityView.text(city);
    }

    @Override
    public void showPostCode(String postCode) {
        postCodeView.text(postCode);
    }

    @Override
    public void showHouseError(final String errorText) {
        houseView.setError(errorText);
    }

    @Override
    public void showStreetError(final String errorText) {
        streetView.setError(errorText);
    }

    @Override
    public void showTownError(final String errorText) {
        townView.setError(errorText);
    }

    @Override
    public void showCityError(final String errorText) {
        cityView.setError(errorText);
    }

    @Override
    public void showPostCodeError(final String errorText) {
        postCodeView.setError(errorText);
    }

    @Override
    public void returnAddressForCode(Intent intent, int code) {
        final Activity activity = getActivity();
        activity.setResult(code, intent);
        activity.finish();
    }

    @Override
    protected EditAddressAndroidView.EventsListener bind(ViewWrapperRepository viewWrapperRepository, Bundle savedState) {
        return viewWrapperRepository.bind(this, savedState);
    }

    @Override
    protected void unbind(ViewWrapperRepository viewWrapperRepository, boolean isLeaving) {
        viewWrapperRepository.unbind(this, isLeaving);
    }

    @Override
    public Activity activity() {
        return getActivity();
    }
}
