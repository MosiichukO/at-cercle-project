package admin;

import java.util.UUID;

public class TestData extends Credentials {

    // Messages (Error / Success)

    public final String NON_REGISTERED_CREDENTIALS_ERROR = "Invalid email or password.";
    public final String AUTHORIZATION_SUCCESS_MESSAGE = "Logged in successfully";
    public final String LOGOUT_SUCCESS_MESSAGE = "Signed out successfully.";
    public final String NAME_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Name can't be blank.";
    public final String ADDRESS_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Address can't be blank.";
    public final String NAME_ADDRESS_BLANK_ERROR_EDIT_DC = "Can not update Dry Cleaner: Name can't be blank, Address can't be blank.";
    public final String NAME_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Name can't be blank.";
    public final String ADDRESS_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Address can't be blank.";
    public final String NAME_ADDRESS_BLANK_ERROR_CREATE_DC = "Can not create Dry Cleaner: Validation failed: Name can't be blank, Address can't be blank.";
    public final String DRY_CLEANER_CREATED_SUCCESS_MESSAGE = "Dry Cleaner was successfully created.";
    public final String DRY_CLEANER_UPDATE_SUCCESS_MESSAGE = "Dry Cleaner was successfully updated.";
    public final String EMAIL_BLANK_ERROR_CREATE_USER = "Email can't be blank";
    public final String PASSWORD_BLANK_ERROR_CREATE_USER = "Password can't be blank";
    public final String EMAIL_ALREADY_TAKEN_ERROR = "Email has already been taken";
    public final String EMAIL_WITHOUT_AMPERSAND_ERROR = "Please include an '@' in the email address. '%s' is missing an '@'.";
    public final String EMAIL_WITHOUT_PART_BEFORE_AMPERSAND_ERROR = "Please enter a part followed by '@'. '%s' is incomplete.";
    public final String EMAIL_WITHOUT_PART_AFTER_AMPERSAND_ERROR = "Please enter a part following '@'. '%s' is incomplete.";
    public final String EMAIL_DOT_RIGHT_AFTER_AMPERSAND_ERROR = "'.' is used at a wrong position in '%s'.";


    // Page's titles

    public final String DRY_CLEANERS_PAGE_TITLE = "Dry Cleaners";
    public final String NEW_USER_PAGE_TITLE = "New User - Users";
    public final String USERS_PAGE_TITLE = "Users";

    // Dropdowns' options

    public final String STATUS_DROPDOWN_FIRST_OPTION = "Active";
    public final String STATUS_DROPDOWN_SECOND_OPTION = "Non active";

    // Validation

    public final int PASSWORD_MIN_LENGTH = 6;

    public final String RANDOM_EMAIL_WITHOUT_AMPERSAND = UUID.randomUUID().toString().substring(0, (int) ((Math.random() * 36)));
    public final String RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND = "@" + UUID.randomUUID().toString().substring(0, (int) ((Math.random() * 36)));
    public final String RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND = UUID.randomUUID().toString().substring(0, (int) ((Math.random() * 36))) + "@";
    public final String RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND =
            UUID.randomUUID().toString().substring(0, (int) ((Math.random() * 36))) + "@."
            + UUID.randomUUID().toString().substring(0, (int) ((Math.random() * 36)));

    public final String ERROR_FIELD_BORDER_COLOR = "rgb(206, 69, 42)";



    public final String NON_REGISTERED_EMAIL = "qa@invalid.com";
    public final String NON_REGISTERED_PASSWORD = "invalid12";

    public final String DRY_CLEANER_ADDRESS = "qa_auto_address";
    public final String DRY_CLEANER_NAME = "1-qa_auto_name";
    public final String DRY_CLEANER_ADDRESS_UPDATED = "qa_auto_address_updated";
    public final String DRY_CLEANER_NAME_UPDATED = "1-qa_auto_name_updated";

    public final String MEMBER_SINCE_START_DATE = "2022-02-17";
    public final String PART_OF_EMAIL_FOR_FILTERING = "@support";

}
