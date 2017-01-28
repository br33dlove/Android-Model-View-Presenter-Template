package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

public interface ValidationResult {
    boolean passed();
    String error();
}
