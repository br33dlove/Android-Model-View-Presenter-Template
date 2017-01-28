package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.StringHelper;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.errorstringproviders.AddressLineValidationErrorStrings;

public class AddressLineValidatorImpl implements AddressLineValidator {
    private final ValidationResultFactory validationResultFactory;

    private AddressLineValidatorImpl(final ValidationResultFactory validationResultFactory) {
        this.validationResultFactory = validationResultFactory;
    }

    public static AddressLineValidatorImpl newInstance(final ValidationResultFactory validationResultFactory) {
        return new AddressLineValidatorImpl(validationResultFactory);
    }

    @Override
    public ValidationResult isValid(final String addressLine, final boolean canBeEmpty) {
        if (!canBeEmpty && StringHelper.nullOrEmpty(addressLine)) {
            return validationResultFactory.errorResult(AddressLineValidationErrorStrings.NO_INPUT);
        }
        return validationResultFactory.okayResult();
    }
}
