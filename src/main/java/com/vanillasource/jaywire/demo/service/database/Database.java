package com.vanillasource.jaywire.demo.service.database;

import javax.sql.DataSource;

public interface Database extends AutoCloseable {
   DataSource getDataSource();
}

