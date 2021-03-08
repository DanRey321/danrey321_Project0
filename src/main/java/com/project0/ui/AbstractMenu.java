package com.project0.ui;

import java.util.Scanner;

import com.project0.Util.jdbcConnection;
import com.project0.model.User;

public abstract class AbstractMenu {
    protected jdbcConnection ui;

    public abstract User Login(Scanner scan);
}
