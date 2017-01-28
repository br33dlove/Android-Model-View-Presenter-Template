package com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.StringHelper;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.errorstringproviders.PostCodeValidationErrorStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostCodeValidatorImpl implements PostCodeValidator {
    private final static String REGEX_VALID_POST_CODE = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
    private final ValidationResultFactory validationResultFactory;

    private PostCodeValidatorImpl(final ValidationResultFactory validationResultFactory) {
        this.validationResultFactory = validationResultFactory;
    }

    public static PostCodeValidator newInstance(final ValidationResultFactory validationResultFactory) {
        return new PostCodeValidatorImpl(validationResultFactory);
    }

    @Override
    public ValidationResult isValid(final String postCode, final boolean canBeEmpty) {
        if (!canBeEmpty && StringHelper.nullOrEmpty(postCode)) {
            return validationResultFactory.errorResult(PostCodeValidationErrorStrings.NO_INPUT);
        }
        if (!postCodeMatchesRegex(postCode)) {
            return validationResultFactory.errorResult(PostCodeValidationErrorStrings.INVALID_POST_CODE);
        }
        return validationResultFactory.okayResult();
    }

    private static boolean postCodeMatchesRegex(final String postCode) {
        final Pattern pattern = Pattern.compile(REGEX_VALID_POST_CODE);
        final Matcher matcher = pattern.matcher(postCode);
        return matcher.matches();
    }
}
