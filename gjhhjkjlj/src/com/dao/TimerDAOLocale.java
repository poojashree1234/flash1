package com.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Timer;

public interface TimerDAOLocale {

public List<Timer> getQuestions(Connection connection);

public List<String> compare(Connection connection);

}
